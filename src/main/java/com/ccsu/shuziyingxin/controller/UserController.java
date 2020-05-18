package com.ccsu.shuziyingxin.controller;

import com.ccsu.shuziyingxin.common.ResultInfo;
import com.ccsu.shuziyingxin.pojo.request.LoginParam;
import com.ccsu.shuziyingxin.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-03-17 21:21
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    IUserService userService;


    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo login(@RequestBody LoginParam loginParam) throws Exception {
        return userService.login(loginParam);
    }
}
