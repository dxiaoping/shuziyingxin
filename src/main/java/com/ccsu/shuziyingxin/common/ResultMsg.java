package com.ccsu.shuziyingxin.common;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-03-23 8:46
 */
public enum ResultMsg {

    SUCCESS(0, "请求成功"),
    ERROR(40, "请求失败"),

    LOGIN_PSD_ERR(10010,"账号或密码错误"),
    LOGIN_FAIL(10011,"登陆失败"),
    LOGIN_SCHOOL_FAIL(10013,"学校网站挂了"),
    LOGIN_SUCCESS(10012,"登陆成功"),
    CHECK_SUCCESS(10020,"管理员验证失败"),
    CHECK_FAIL(10021,"管理员验证失败");

    private int code;
    private String msg;

    ResultMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
