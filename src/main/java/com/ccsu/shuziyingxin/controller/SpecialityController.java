package com.ccsu.shuziyingxin.controller;

import com.ccsu.shuziyingxin.common.ResultInfo;
import com.ccsu.shuziyingxin.common.ResultMsg;
import com.ccsu.shuziyingxin.pojo.Speciality;
import com.ccsu.shuziyingxin.service.ISpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-04-04 8:40
 */
@Controller
@RequestMapping("speciality")
public class SpecialityController {

    @Autowired
    ISpecialityService specialityService;

    @RequestMapping(value = "save", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ResultInfo save(@RequestBody Speciality speciality) {
        specialityService.modifySpeciality(speciality);
        return ResultInfo.success(ResultMsg.SUCCESS, "SUCCESS");
    }

    @RequestMapping(value = "queryOne", method = RequestMethod.GET)
    @ResponseBody
    public ResultInfo queryOne(
            @RequestParam(value = "specialityId",required = false) String specialityId,
            @RequestParam(value = "specialityName",required = false) String specialityName) {
        Speciality speciality = null;
        if (specialityId == null) {

            speciality = specialityService.querySpeciality(specialityName);
        } else {
            speciality = specialityService.querySpeciality(Integer.valueOf(specialityId));
        }
        return ResultInfo.success(ResultMsg.SUCCESS, speciality);
    }

    @RequestMapping(value = "queryAll", method = RequestMethod.GET)
    @ResponseBody
    public ResultInfo queryAll() {
        List<Speciality> specialityList = specialityService.querySpecialityList();
        return ResultInfo.success(ResultMsg.SUCCESS, specialityList);
    }
}
