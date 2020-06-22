package com.ccsu.shuziyingxin.controller;

import com.ccsu.shuziyingxin.common.ResultInfo;
import com.ccsu.shuziyingxin.common.ResultMsg;
import com.ccsu.shuziyingxin.pojo.Address;
import com.ccsu.shuziyingxin.service.IAddrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description 地点操作
 * @auther DuanXiaoping
 * @create 2020-03-25 19:59
 */
@Controller
@RequestMapping("addr")
public class AddrController {

    @Autowired
    IAddrService addrService;

    @RequestMapping(value = "save", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ResultInfo saveAddress(@RequestBody Address address) {
        if (address.getAddrId() == 0) {
            int count = addrService.createAddr(address);
        } else {
            addrService.updateAddr(address);
        }
        return ResultInfo.success(ResultMsg.SUCCESS, address);
    }

    @RequestMapping(value = "queryOne", method = RequestMethod.GET)
    @ResponseBody
    public ResultInfo queryOne(
            @RequestParam(value = "addrId", required = false) Integer addrId,
            @RequestParam(value = "addrName", required = false) String addrName) {
        Address address = null;
        if (addrId == null) {
            address = addrService.queryAddr(addrName);
        } else {
            address = addrService.queryAddr(addrId);
        }
        return ResultInfo.success(ResultMsg.SUCCESS, address);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo deleteAddr(@RequestParam("addrId") int addrId) {
        addrService.deleteAddr(addrId);
        return ResultInfo.success(ResultMsg.SUCCESS);
    }

    @RequestMapping(value = "queryAllAddr", method = RequestMethod.GET)
    @ResponseBody
    public ResultInfo queryAllAddr() {
        List<Address> addrList = addrService.queryAllAddr();
        return ResultInfo.success(ResultMsg.SUCCESS, addrList);
    }
}
