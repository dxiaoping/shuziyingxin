package com.ccsu.shuziyingxin.controller;

import com.ccsu.shuziyingxin.common.ResultInfo;
import com.ccsu.shuziyingxin.common.ResultMsg;
import com.ccsu.shuziyingxin.pojo.Business;
import com.ccsu.shuziyingxin.pojo.response.BusiEditPage;
import com.ccsu.shuziyingxin.pojo.response.BusinessPage;
import com.ccsu.shuziyingxin.service.IBusiService;
import com.ccsu.shuziyingxin.pojo.request.BusiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-03-22 16:58
 */
@Controller
@RequestMapping("busi")
public class BusiController {

    @Autowired
    IBusiService busiService;

    @RequestMapping(value = "save", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ResultInfo saveBusi(@RequestBody(required = false) BusiParam busiParam) {
        System.out.println(busiParam);
        Business business = busiService.saveBusiness(busiParam);
        return ResultInfo.success(ResultMsg.SUCCESS, business);
    }

    @RequestMapping(value = "queryBusi", method = RequestMethod.GET)
    @ResponseBody
    public ResultInfo queryBusi(
            @RequestParam(value = "busiId", required = false) Integer busiId,
            @RequestParam(value = "busiName", required = false) String busiName) {
        if (busiId != null) {
            BusinessPage businessPage = busiService.queryBusiness(busiId);
            return ResultInfo.success(ResultMsg.SUCCESS, businessPage);
        }else if (busiName != null){
            BusinessPage businessPage = busiService.queryBusiness(busiName);
            return ResultInfo.success(ResultMsg.SUCCESS, businessPage);
        }
        else {
            List<Business> busiList = busiService.queryAllBusi();
            return ResultInfo.success(ResultMsg.SUCCESS, busiList);
        }
    }

    @RequestMapping(value = "queryOne", method = RequestMethod.GET)
    @ResponseBody
    public ResultInfo queryOne(@RequestParam(value = "busiName") String busiName){
        Business business = busiService.queryBusi(busiName);
        return ResultInfo.success(ResultMsg.SUCCESS,business);
    }
//    @RequestMapping(value = "queryBusi", method = RequestMethod.GET)
//    @ResponseBody
//    public ResultInfo queryBusi(
//            @RequestParam(value = "busiName") String busiName) {
//
//        BusinessPage businessPage = busiService.queryBusiness(busiName);
//        return ResultInfo.success(ResultMsg.SUCCESS, businessPage);
//
//    }

    @RequestMapping(value = "queryBusiByClass", method = RequestMethod.GET)
    @ResponseBody
    public ResultInfo queryBusiByClass(@RequestParam("classId") int classId) {
        List<Business> businessList = busiService.queryBusinessByClass(classId);
        return ResultInfo.success(ResultMsg.SUCCESS, businessList);
    }

    @RequestMapping(value = "operationPage", method = RequestMethod.GET)
    @ResponseBody
    public ResultInfo operationPage(@RequestParam(value = "busiId", required = false) Integer busiId) {
        BusiEditPage busiEditPage = busiService.getOperatPage(busiId);
        return ResultInfo.success(ResultMsg.SUCCESS, busiEditPage);
    }
}
