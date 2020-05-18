package com.ccsu.shuziyingxin.service;

import com.ccsu.shuziyingxin.common.ResultInfo;
import com.ccsu.shuziyingxin.pojo.request.LoginParam;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-03-20 17:44
 */
public interface IUserService {
    ResultInfo login(LoginParam loginParam) throws Exception;
}
