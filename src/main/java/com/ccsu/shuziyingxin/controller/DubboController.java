package com.ccsu.shuziyingxin.controller;

//import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Reference;
import com.ccsu.shuziyingxin.dubbo.ICodeService;
import com.ccsu.shuziyingxin.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-04-22 11:15
 */
@Controller
@RequestMapping("dubbo")
public class DubboController {

    @Reference
    TestService testService;

    @RequestMapping("test")
    public void dubboTest() {
        System.out.println(99999999);
        System.out.println(testService.add(5,9));
    }
}
