package com.ccsu.shuziyingxin.common;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-03-29 17:45
 */
public interface Const {
    interface LOGIN{
        String STATE = "state";
        String MSG = "msg";
        String COOKIE = "cookie";
    }
    interface LOGIN_STATE{
        String FAIL = "-1";
        String SUCCESS = "1";
        String PSD_ERR = "0";
    }
}
