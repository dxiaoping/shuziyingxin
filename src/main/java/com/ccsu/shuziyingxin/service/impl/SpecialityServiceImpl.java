package com.ccsu.shuziyingxin.service.impl;

import com.ccsu.shuziyingxin.dao.CollegeDao;
import com.ccsu.shuziyingxin.dao.JxjhDao;
import com.ccsu.shuziyingxin.dao.SpecialityDao;
import com.ccsu.shuziyingxin.pojo.Jxjh;
import com.ccsu.shuziyingxin.pojo.Speciality;
import com.ccsu.shuziyingxin.pojo.Student;
import com.ccsu.shuziyingxin.service.ISpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-04-04 8:47
 */
@Service
public class SpecialityServiceImpl implements ISpecialityService {

    @Autowired
    SpecialityDao specialityDao;

    @Autowired
    CollegeDao collegeDao;

    @Autowired
    JxjhDao jxjhDao;

    @Override
    public int createSpeciality(Student student) {
        String specialityName = student.getSpeciality();
        Speciality speciality = null;
        speciality = specialityDao.querySpecialityByName(specialityName);
        if (speciality == null) {
            speciality = new Speciality();
//        判断专业是否已经创建
            String college = student.getCollege();
//             从数据库获取collegeId
            Integer collegeId = collegeDao.getCollegeIdByName(college);
//             从数据库获取必修专业课拼接成字符串
            List<Jxjh> jxjhList = jxjhDao.getMajorClass(specialityName);
            StringBuffer majorClass = new StringBuffer();
            for (Jxjh jxjh:jxjhList) {
                majorClass.append(jxjh.getCourseName())
                .append("|");
            }


            speciality.setCollegeId(collegeId);
            speciality.setSpecialityName(student.getSpeciality());
            speciality.setDescription("input");
            speciality.setMajorClass(majorClass.toString());
            int result = specialityDao.createSpeciality(speciality);

        }
        return 0;
    }

    @Override
    public int modifySpeciality(Speciality speciality) {
        specialityDao.modifySpeciality(speciality);
        return 0;
    }

    @Override
    public Speciality querySpeciality(int specialityId) {
        Speciality speciality = specialityDao.querySpeciality(specialityId);
        return speciality;
    }

    @Override
    public Speciality querySpeciality(String name) {
        Speciality speciality = specialityDao.querySpecialityByName(name);
        return speciality;
    }

    @Override
    public List<Speciality> querySpecialityList() {
        List<Speciality> specialityList = specialityDao.querySpecialityList();
        return specialityList;
    }
}
