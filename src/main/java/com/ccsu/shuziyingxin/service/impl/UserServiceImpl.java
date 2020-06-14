package com.ccsu.shuziyingxin.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccsu.shuziyingxin.common.Const;
import com.ccsu.shuziyingxin.common.ResultInfo;
import com.ccsu.shuziyingxin.common.ResultMsg;
import com.ccsu.shuziyingxin.dao.ConfigDao;
import com.ccsu.shuziyingxin.dao.JxjhDao;
import com.ccsu.shuziyingxin.dao.SpecialityDao;
import com.ccsu.shuziyingxin.dao.StudentDao;
import com.ccsu.shuziyingxin.pojo.Config;
import com.ccsu.shuziyingxin.pojo.Jxjh;
import com.ccsu.shuziyingxin.pojo.Speciality;
import com.ccsu.shuziyingxin.pojo.Student;
import com.ccsu.shuziyingxin.pojo.request.LoginParam;
import com.ccsu.shuziyingxin.service.ICodeService;
import com.ccsu.shuziyingxin.service.ISpecialityService;
import com.ccsu.shuziyingxin.service.IUserService;
import com.ccsu.shuziyingxin.util.ReptileJxjh;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.jsoup.Connection;
import org.jsoup.helper.HttpConnection;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-03-20 17:47
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    JxjhDao jxjhDao;

    @Autowired
    StudentDao studentDao;

    @Autowired
    ISpecialityService specialityService;

    @Autowired
    ConfigDao configDao;

    @Autowired
    ExecutorService pool;

    @Reference
    ICodeService codeService;

    @Override
    @Transactional
    public ResultInfo login(LoginParam loginParam) throws Exception {
        Student student = studentDao.queryByStuNo(loginParam.getAccount());

        ReptileJxjh reptile = new ReptileJxjh();
        Map<String, String> map = login2jwc(loginParam.getAccount(), loginParam.getPassword());
        String state = map.get(Const.LOGIN.STATE);
        if (Const.LOGIN_STATE.SUCCESS.equals(state)) {
            System.out.println("登陆成功");
            Student studentInfoDoor = codeService.getUserInfo(loginParam.getAccount(), loginParam.getPassword());
            if (student != null) {
                studentDao.update(studentInfoDoor);
                return ResultInfo.success(ResultMsg.LOGIN_SUCCESS, student);
            } else {
                studentDao.insert(studentInfoDoor);
                String cookie = map.get(Const.LOGIN.COOKIE);

//            异步爬取并存储
                Student finalStudent = studentInfoDoor;
                if (specialityService.querySpeciality(finalStudent.getSpeciality()) == null) {

                    pool.execute(new Runnable() {
                        @Override
                        public void run() {
                            List<List<Jxjh>> jxjhs = null;
                            try {
                                jxjhs = reptile.getJxjhFromJwc(cookie);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            for (List<Jxjh> jxjh : jxjhs) {
                                jxjhDao.saveJxjh(jxjh);
                            }
                            specialityService.createSpeciality(finalStudent);
                        }
                    });
                }
            }
//            specialityService.createSpeciality(student);
            return ResultInfo.success(ResultMsg.LOGIN_SUCCESS, studentInfoDoor);
        } else if (Const.LOGIN_STATE.PSD_ERR.equals(state)) {
            System.out.println("账户或密码错误");
            return ResultInfo.success(ResultMsg.LOGIN_PSD_ERR);
        } else {
            System.out.println("登陆失败");
            return ResultInfo.success(ResultMsg.LOGIN_FAIL);
        }
    }

    @Override
    public ResultInfo check(String secret) {
        Config config = configDao.select("admin_key", secret);
        if (config == null) {
            return ResultInfo.success(ResultMsg.CHECK_FAIL);
        }
        return ResultInfo.success(ResultMsg.CHECK_SUCCESS, config);
    }

    public static Map<String, String> login2jwc(String username, String password) throws Exception {

        // 教务处登录第一步
        String url = "http://jwcxxcx.ccsu.cn/jwxt/Logon.do?method=logon";
        Map<String, String> map = new HashMap<String, String>();
        String[] cookieAndCode = getCookieAndCode();
        if (cookieAndCode == null) {
            map.put(Const.LOGIN.STATE, Const.LOGIN_STATE.FAIL);
            map.put(Const.LOGIN.MSG, "login to jwxt failed");
        } else {
            Connection conn = HttpConnection.connect(url)
                    .method(Connection.Method.POST).header("Cookie", cookieAndCode[0])
                    .data("USERNAME", username).data("PASSWORD", password)
                    .data("RANDOMCODE", cookieAndCode[1]);
            Connection.Response response = conn.execute();
            String body = response.body();
            Document document = response.parse();
            /**********************************页面调试***********************************/
//            System.out.println(body);
            /*********************************************************************/
            if (body.indexOf("html") != -1) {
//                账号或密码错误
                String errmsg = document.select("#errorinfo").text();
                map.put(Const.LOGIN.STATE, Const.LOGIN_STATE.PSD_ERR);
                map.put(Const.LOGIN.MSG, errmsg);
            } else if (body.indexOf("script") != -1) {
                //密码正确
                url = "http://jwcxxcx.ccsu.cn/jwxt/Logon.do?method=logonBySSO";
                HttpConnection.connect(url)
                        .header("Cookie", cookieAndCode[0]).get();
                map.put(Const.LOGIN.STATE, Const.LOGIN_STATE.SUCCESS);
                map.put(Const.LOGIN.MSG, "login2jwc:ok");
            } else {
                map.put(Const.LOGIN.STATE, Const.LOGIN_STATE.FAIL);
                map.put(Const.LOGIN.MSG, body);
            }
            map.put(Const.LOGIN.COOKIE, cookieAndCode[0]);
        }
        return map;
    }

    /**
     * 登录至长沙学院教务系统(获取cookie和验证码)
     *
     * @return cookie , code
     * @throws Exception 第一步(获取cookie和验证码 )
     *                   http://jwcxxcx.ccsu.cn/jwxt/verifycode.servlet
     */
    private static String[] getCookieAndCode() throws Exception {

        String url = "http://jwcxxcx.ccsu.cn/jwxt/verifycode.servlet";
        String cookie = null;
        String code = null;
        byte[] image = null;

        HttpGet httpGet = new HttpGet(url);
//        此处可能出现网络异常
        HttpResponse httpResponse = HttpClients.createDefault()
                .execute(httpGet);
        cookie = httpResponse.getFirstHeader("Set-Cookie").getValue();
        return new String[]{cookie, ""};
    }
}
