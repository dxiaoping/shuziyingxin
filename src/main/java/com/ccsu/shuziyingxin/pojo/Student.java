package com.ccsu.shuziyingxin.pojo;

import java.io.Serializable;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-03-26 10:31
 */
public class Student implements Serializable {
    private String studentNo;//学号
    private String password;//密码
    private String studentName;//姓名
    private String college;//学院
    private String speciality;//专业
    private String class1;//班级
    private String dormitory;//宿舍

    public Student() {
    }

    public Student(String studentNo, String password, String studentName, String college, String speciality, String class1, String dormitory) {
        this.studentNo = studentNo;
        this.password = password;
        this.studentName = studentName;
        this.college = college;
        this.speciality = speciality;
        this.class1 = class1;
        this.dormitory = dormitory;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    public String getDormitory() {
        return dormitory;
    }

    public void setDormitory(String dormitory) {
        this.dormitory = dormitory;
    }
}
