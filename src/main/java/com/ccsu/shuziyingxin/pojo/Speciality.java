package com.ccsu.shuziyingxin.pojo;

/**
 * @Description 专业信息
 * @auther DuanXiaoping
 * @create 2020-03-31 16:01
 */
public class Speciality {
    private int specialityId;//专业id
    private int collegeId;//学院id
    private String specialityName;//专业名称
    private String description;//培养目标
    private String majorClass;//主修课程

    public int getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(int specialityId) {
        this.specialityId = specialityId;
    }

    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }

    public String getSpecialityName() {
        return specialityName;
    }

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMajorClass() {
        return majorClass;
    }

    public void setMajorClass(String majorClass) {
        this.majorClass = majorClass;
    }
}
