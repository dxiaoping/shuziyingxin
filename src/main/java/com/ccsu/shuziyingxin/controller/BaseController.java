package com.ccsu.shuziyingxin.controller;

import com.ccsu.shuziyingxin.common.ResultInfo;
import com.ccsu.shuziyingxin.common.ResultMsg;
import com.ccsu.shuziyingxin.pojo.Jxjh;
import com.ccsu.shuziyingxin.pojo.Search;
import com.ccsu.shuziyingxin.pojo.Student;
import com.ccsu.shuziyingxin.service.IBaseService;
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


//    @RequestMapping(value = "queryJxjh")
//    @ResponseBody
//    public ResultInfo search(@RequestParam(value = "keyWord") String keyWord){
//
//
//
//        return ResultInfo.success(ResultMsg.SUCCESS);
//    }
}
