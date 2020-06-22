package com.ccsu.shuziyingxin.controller;

import com.ccsu.shuziyingxin.common.ResultInfo;
import com.ccsu.shuziyingxin.common.ResultMsg;
import com.ccsu.shuziyingxin.pojo.Config;
import com.ccsu.shuziyingxin.pojo.Jxjh;
import com.ccsu.shuziyingxin.pojo.Search;
import com.ccsu.shuziyingxin.pojo.Student;
import com.ccsu.shuziyingxin.service.IBaseService;
import com.ccsu.shuziyingxin.service.IVoiceService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-03-26 11:12
 */
@Controller
@RequestMapping("base")
public class BaseController {

    @Autowired
    IBaseService baseService;

    @Autowired
    IVoiceService voiceService;

    @RequestMapping(value = "queryJxjh")
    @ResponseBody
    public ResultInfo queryJxjh(@RequestParam("speciality") String speciality){
        List<Jxjh> jxjhList = baseService.getJxjh(speciality);
        return ResultInfo.success(ResultMsg.SUCCESS,jxjhList);
    }

    @RequestMapping(value = "querySearchKey")
    @ResponseBody
    public ResultInfo querySearch(){
        List<Search> keyWord = baseService.getSearchKey();
        return ResultInfo.success(ResultMsg.SUCCESS,keyWord);
    }

    @RequestMapping(value = "voice")
    @ResponseBody
    public ResultInfo voice(@Param("str") String str,@Param("secondConfirm") boolean secondConfirm){

        System.out.println(str);
        System.out.println(secondConfirm);
        List<Search> searchList = voiceService.parse(str,secondConfirm);
        return ResultInfo.success(ResultMsg.SUCCESS,searchList);
    }

    @RequestMapping(value = "queryConfig")
    @ResponseBody
    public ResultInfo queryConfig(@Param("class1") String class1){
        List<Config> configs = baseService.getConfigList(class1);
        return ResultInfo.success(ResultMsg.SUCCESS,configs);
    }
}
