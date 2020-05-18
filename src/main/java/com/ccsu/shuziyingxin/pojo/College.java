package com.ccsu.shuziyingxin.pojo;

/**
 * @Description 学院
 * @auther DuanXiaoping
 * @create 2020-03-31 9:25
 */
public class College {
    private int collegeId;//学院id
    private String collegeName;//学院名称

    private String description;//学院描述
    private String simpleDesc = "";//学院简述

    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSimpleDesc() {
        return simpleDesc;
    }

    public void setSimpleDesc(String simpleDesc) {
        this.simpleDesc = simpleDesc;
    }
}
