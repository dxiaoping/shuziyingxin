package com.ccsu.shuziyingxin.controller;

import com.ccsu.shuziyingxin.common.ResultInfo;
import com.ccsu.shuziyingxin.common.ResultMsg;
import com.ccsu.shuziyingxin.pojo.Laboratory;
import com.ccsu.shuziyingxin.pojo.request.LaboratoryParam;
import com.ccsu.shuziyingxin.service.ILaboratoryService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "queryByOrganization",method = RequestMethod.GET)
    @ResponseBody
    public ResultInfo queryByOrganization(@RequestParam(value = "organization",required = false) String organization) {
        List<Laboratory> laboratoryList = laboratoryService.queryAll(organization);
        return ResultInfo.success(ResultMsg.SUCCESS,laboratoryList);
    }

    @RequestMapping(value = "queryOne",method = RequestMethod.GET)
    @ResponseBody
    public ResultInfo queryOne(
            @RequestParam(value = "id",required = false) Integer id,
            @RequestParam(value = "laboratoryName",required = false) String laboratoryName) {
        Laboratory laboratory = null;
        if (id == null) {
            laboratory = laboratoryService.queryOne(laboratoryName);
        } else {
            laboratory = laboratoryService.queryOne(id);
        }
        return ResultInfo.success(ResultMsg.SUCCESS,laboratory);
    }

    @RequestMapping(value = "save",method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public ResultInfo save(@RequestBody LaboratoryParam laboratoryParam) {
        Laboratory laboratory = laboratoryService.saveLaboratory(laboratoryParam);
        return ResultInfo.success(ResultMsg.SUCCESS,laboratory);
    }

    @RequestMapping(value = "delete")
    @ResponseBody
    public ResultInfo delete(@RequestParam("id") int id) {
        laboratoryService.delete(id);
        return ResultInfo.success(ResultMsg.SUCCESS);
    }
}
