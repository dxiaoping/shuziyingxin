package com.ccsu.shuziyingxin.pojo.request;

/**
 * @Description 用户登录信息
 * @auther DuanXiaoping
 * @create 2020-03-26 10:34
 */
public class LoginParam {
    String account;
    String password;
//因信息门户服务器宕机手动模拟确定专业
//    String speciality;

//    public String getSpeciality() {
//        return speciality;
//    }
//
//    public void setSpeciality(String speciality) {
//        this.speciality = speciality;
//    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
