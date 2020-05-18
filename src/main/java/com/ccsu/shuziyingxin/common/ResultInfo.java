package com.ccsu.shuziyingxin.common;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-03-23 8:21
 */
public class ResultInfo<T> {
    private int code;
    private String msg;
    private T data;

    public ResultInfo(T data) {
        this.data = data;
    }
    private ResultInfo(ResultMsg resultMsg) {
        this.code = resultMsg.getCode();
        this.msg = resultMsg.getMsg();
    }

    public ResultInfo(ResultMsg resultMsg, T data) {
        this.code = resultMsg.getCode();
        this.msg = resultMsg.getMsg();
        this.data = data;
    }

    //    返回数据data
    public static <T> ResultInfo<T> success(T data){
        return new ResultInfo<>(data);
    }

    public static <T> ResultInfo<T> success(ResultMsg resultMsg){
        return new ResultInfo<>(resultMsg);
    }

    public static <T> ResultInfo<T> success(ResultMsg resultMsg, T data) {
        return new ResultInfo<T>(resultMsg, data);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
