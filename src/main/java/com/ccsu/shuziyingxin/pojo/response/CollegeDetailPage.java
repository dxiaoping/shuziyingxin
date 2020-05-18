package com.ccsu.shuziyingxin.pojo.response;

import com.ccsu.shuziyingxin.pojo.College;
import com.ccsu.shuziyingxin.pojo.Speciality;

import java.util.List;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-04-03 23:03
 */
public class CollegeDetailPage {
    private College college;
    private List<Speciality> specialityList;

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public List<Speciality> getSpecialityList() {
        return specialityList;
    }

    public void setSpecialityList(List<Speciality> specialityList) {
        this.specialityList = specialityList;
    }
}
