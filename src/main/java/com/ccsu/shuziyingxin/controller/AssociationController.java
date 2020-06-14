package com.ccsu.shuziyingxin.controller;

import com.ccsu.shuziyingxin.common.ResultInfo;
import com.ccsu.shuziyingxin.common.ResultMsg;
import com.ccsu.shuziyingxin.pojo.Association;
import com.ccsu.shuziyingxin.pojo.request.AssociationParam;
import com.ccsu.shuziyingxin.service.IAssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-04-18 14:36
 */
@Controller
@RequestMapping("association")
public class AssociationController {

    @Autowired
    IAssociationService associationService;

    @RequestMapping(value = "save", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ResultInfo save(@RequestBody AssociationParam associationParam) {
        String optionType = associationParam.getOptionType();
        Association association = associationParam.getAssociation();
        if ("modify".equals(optionType)) {
            associationService.modify(association);
        } else {
            associationService.add(association);
        }
        return ResultInfo.success(ResultMsg.SUCCESS,association);
    }

    @RequestMapping(value = "queryOne", method = RequestMethod.GET)
    @ResponseBody
    public ResultInfo queryOne(@RequestParam("id") Integer id) {
        Association association = associationService.queryOne(id);
        return ResultInfo.success(ResultMsg.SUCCESS, association);
    }

    @RequestMapping(value = "queryByOrganization", method = RequestMethod.GET, consumes = "application/json")
    @ResponseBody
    public ResultInfo queryByOrganization(@RequestParam(value = "organization",required = false) String organization) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Association> associationList = associationService.queryAll(organization);
        return ResultInfo.success(ResultMsg.SUCCESS, associationList);
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    @ResponseBody
    public ResultInfo deleteAsso(@RequestParam("assoId") int addrId) {
        associationService.delete(addrId);
        return ResultInfo.success(ResultMsg.SUCCESS);
    }
}
