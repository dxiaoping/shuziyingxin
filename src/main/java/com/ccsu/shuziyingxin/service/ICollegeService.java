package com.ccsu.shuziyingxin.service;

import com.ccsu.shuziyingxin.pojo.College;
import com.ccsu.shuziyingxin.pojo.Speciality;
import com.ccsu.shuziyingxin.pojo.response.CollegeDetailPage;

import java.util.List;

public interface ICollegeService {
    List<College> getAllCollege();
    CollegeDetailPage getCollegeDetail(int collegeId);
    Speciality getSpecialityDetail(int specialityId);
}
