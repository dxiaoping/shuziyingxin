package com.ccsu.shuziyingxin.dao;

import com.ccsu.shuziyingxin.pojo.College;
import com.ccsu.shuziyingxin.pojo.Speciality;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-03-22 17:21
 */
@Repository
public interface SpecialityDao {
    int createSpeciality(Speciality speciality);
    boolean deleteSpeciality(int specialityId);
    boolean modifySpeciality(Speciality speciality);
    Speciality querySpeciality(int specialityId);
    Speciality querySpecialityByName(String specialityName);
    List<Speciality> querySpeciByCollege(int collegeId);
    List<Speciality> querySpecialityList();
}
