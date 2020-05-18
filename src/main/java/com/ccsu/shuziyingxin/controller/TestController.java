package com.ccsu.shuziyingxin.controller;

import com.ccsu.shuziyingxin.common.ResultInfo;
import com.ccsu.shuziyingxin.common.ResultMsg;
import com.ccsu.shuziyingxin.dao.BusiDao;
import com.ccsu.shuziyingxin.dao.CollegeDao;
import com.ccsu.shuziyingxin.dao.JxjhDao;
import com.ccsu.shuziyingxin.pojo.Business;
import com.ccsu.shuziyingxin.pojo.College;
import com.ccsu.shuziyingxin.pojo.Jxjh;
import com.ccsu.shuziyingxin.pojo.Speciality;
import com.ccsu.shuziyingxin.pojo.request.BusiParam;
import com.ccsu.shuziyingxin.util.ReptileCollege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-03-06 8:59
 */
@Controller
public class TestController {

    @Autowired
    JxjhDao jxjhDao;

    @Autowired
    BusiDao busiDao;

    @Autowired
    CollegeDao collegeDao;

    @RequestMapping("test")
    @ResponseBody
    public String test() {
        return "success";
    }

//    @RequestMapping("jxjh_test")
////    @ResponseBody
////    public List<Jxjh> getAllJxjh() {
////        List<Jxjh> jxjhs = jxjhDao.queryAllJxjh();
////        return jxjhs;
////    }

    @RequestMapping("busi_test")
    @ResponseBody
    public List<Business> getAllBusi() {
        List<Business> busiList = busiDao.queryBusiRela(1);
        return busiList;
    }

    @RequestMapping(value = "add_busi_test", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public String addBusi(@RequestBody(required = false) BusiParam busiParam) {
        System.out.println("测试");
        Business business = busiParam.getBusiness();
        busiDao.createBusi(business);
        return "SUCCESS";
    }

    @RequestMapping(value = "jso_request_test", method = RequestMethod.GET, consumes = "application/json")
    @ResponseBody
//    public ResultInfo jsonRequest(@RequestBody HashMap<String, String> map) {
    public ResultInfo jsonRequest(@RequestParam("busiId") int busiId) {
        System.out.println("json 请求测试");
//        int busiId = Integer.valueOf(map.get("busiId"));
        List<Business> busiList = busiDao.queryBusiRela(busiId);
        return ResultInfo.success(ResultMsg.SUCCESS, busiList);
    }

    @RequestMapping(value = "relation_test", method = RequestMethod.GET, consumes = "application/json")
    @ResponseBody
    public ResultInfo jsonRequest(@RequestBody HashMap<String, String> map) {
//    public ResultInfo relationTest(@RequestParam("busiId1") int busiId,@RequestParam("busiId2") int busiId2) {
        System.out.println("json 请求测试");
        int busiId = Integer.valueOf(map.get("busiId1"));
        int busiId2 = Integer.valueOf(map.get("busiId2"));
        busiDao.addRelation(busiId, busiId2);
        return ResultInfo.success(ResultMsg.SUCCESS, "success");
    }

    @RequestMapping(value = "addCollege", method = RequestMethod.GET)
    @ResponseBody
    public ResultInfo addCollege() throws IOException {
//    public ResultInfo relationTest(@RequestParam("busiId1") int busiId,@RequestParam("busiId2") int busiId2) {
        System.out.println("添加学院介绍");
        Map<String, String> map = ReptileCollege.getCollegeDetail();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            College college = new College();
            college.setCollegeName(entry.getKey());
            college.setDescription(entry.getValue());
            collegeDao.createCollege(college);
        }
        return ResultInfo.success(ResultMsg.SUCCESS, "success");
    }

    @RequestMapping(value = "addSpeciality", method = RequestMethod.GET)
    @ResponseBody
    public ResultInfo addSpeciality(@RequestBody Speciality speciality) throws IOException {
//    public ResultInfo relationTest(@RequestParam("busiId1") int busiId,@RequestParam("busiId2") int busiId2) {
        System.out.println("添加专业");

        return ResultInfo.success(ResultMsg.SUCCESS, "success");
    }

    @RequestMapping(value = "entrance",method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo entrance(@RequestBody HashMap<String,String> map){
        String classId = map.get("classId");
        int realClassId = Integer.valueOf(classId);
        List<Business> businessList = busiDao.queryBusiByClass(realClassId);
        return ResultInfo.success(ResultMsg.SUCCESS,businessList);
    }

    @RequestMapping(value = "createAddr",method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo createAddr(@RequestBody HashMap<String,String> map){
        String classId = map.get("classId");
        int realClassId = Integer.valueOf(classId);
        List<Business> businessList = busiDao.queryBusiByClass(realClassId);
        return ResultInfo.success(ResultMsg.SUCCESS,businessList);
    }
}
