package com.ccsu.shuziyingxin.controller;

import com.ccsu.shuziyingxin.common.ResultInfo;
import com.ccsu.shuziyingxin.common.ResultMsg;
import com.ccsu.shuziyingxin.pojo.Laboratory;
import com.ccsu.shuziyingxin.pojo.request.LaboratoryParam;
import com.ccsu.shuziyingxin.service.ILaboratoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-04-24 10:53
 */
@Controller
@RequestMapping("laboratory")
public class LaboratoryController {

    @Autowired
    ILaboratoryService laboratoryService;

    @RequestMapping(value = "queryAll",method = RequestMethod.GET)
    @ResponseBody
    public ResultInfo queryAll() {
        List<Laboratory> laboratoryList = laboratoryService.queryAll();
        return ResultInfo.success(ResultMsg.SUCCESS,laboratoryList);
    }

    @RequestMapping(value = "queryOne",method = RequestMethod.GET)
    @ResponseBody
    public ResultInfo queryOne(Integer id) {
        Laboratory laboratory = laboratoryService.queryOne(id);
        return ResultInfo.success(ResultMsg.SUCCESS,laboratory);
    }

    @RequestMapping(value = "save",method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public ResultInfo save(@RequestBody LaboratoryParam laboratoryParam) {

        Laboratory laboratory = laboratoryService.saveLaboratory(laboratoryParam);
        return ResultInfo.success(ResultMsg.SUCCESS,laboratory);
    }

}
