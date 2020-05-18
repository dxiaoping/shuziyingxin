package com.ccsu.shuziyingxin.pojo;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-01-28 9:32
 */
public class WxInfo {
    /**昵称*/private String openid;
    /**昵称*/private String nickName;
    /**头像地址*/private String avatarUrl;
    /**城市*/private String city;
    /**国家*/private String country;
    /**性别 1表示男*/private int gender;
    /**语言*/private String language;
    /**省份*/private String province;

    public WxInfo() {
    }

    public WxInfo(String nickName, String avatarUrl, String city, String country, int gender, String language, String province) {

        this.openid = openid;
        this.nickName = nickName;
        this.avatarUrl = avatarUrl;
        this.city = city;
        this.country = country;
        this.gender = gender;
        this.language = language;
        this.province = province;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
