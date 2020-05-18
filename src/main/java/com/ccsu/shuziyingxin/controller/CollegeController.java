package com.ccsu.shuziyingxin.controller;

import com.ccsu.shuziyingxin.common.ResultInfo;
import com.ccsu.shuziyingxin.common.ResultMsg;
import com.ccsu.shuziyingxin.pojo.College;
import com.ccsu.shuziyingxin.pojo.Speciality;
import com.ccsu.shuziyingxin.pojo.response.CollegeDetailPage;
import com.ccsu.shuziyingxin.service.ICollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-04-03 17:37
 */
@Controller
@RequestMapping("college")
public class CollegeController {

    @Autowired
    ICollegeService collegeService;

    @RequestMapping("queryAllCollege")
    @ResponseBody
    public ResultInfo queryAllCollege() {
        List<College> collegeList = collegeService.getAllCollege();
        return ResultInfo.success(ResultMsg.SUCCESS,collegeList);
    }

    @RequestMapping("detail")
    @ResponseBody
    public ResultInfo collegeDetail(@RequestParam("collegeId") int collegeId) {
        CollegeDetailPage collegeDetailPage = collegeService.getCollegeDetail(collegeId);
        return ResultInfo.success(ResultMsg.SUCCESS,collegeDetailPage);
    }

//    @RequestMapping("speciality")
//    @ResponseBody
//    public ResultInfo specialityDetail(@RequestParam("specialityId") int specialityId) {
//        Speciality speciality = collegeService.getSpecialityDetail(specialityId);
//        return ResultInfo.success(ResultMsg.SUCCESS,speciality);
//    }
}
