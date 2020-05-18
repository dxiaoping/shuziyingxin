package com.ccsu.shuziyingxin.controller;

//import com.alibaba.dubbo.config.annotation.Reference;
import com.ccsu.shuziyingxin.dubbo.ICodeService;
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

//    @Reference(url = "dubbo://127.0.0.1:8888")
//    ICodeService codeService;

    @RequestMapping("test")
    public void dubboTest() {
//        codeService.getCode();
        System.out.println("dubbo");
    }
}
