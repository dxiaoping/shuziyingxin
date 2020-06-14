package com.ccsu.shuziyingxin.service;

import com.ccsu.shuziyingxin.pojo.Speciality;
import com.ccsu.shuziyingxin.pojo.Student;

import java.util.List;

public interface ISpecialityService {
    int createSpeciality(Student student);
    int modifySpeciality(Speciality speciality);
    Speciality querySpeciality(int specialityId);
    Speciality querySpeciality(String name);
    List<Speciality> querySpecialityList();
}
