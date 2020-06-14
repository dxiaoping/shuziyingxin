package com.ccsu.shuziyingxin.service;


import com.ccsu.shuziyingxin.pojo.Student;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-04-21 20:55
 */
public interface ICodeService {
    Student getUserInfo(String username, String password);
}
