package com.ccsu.shuziyingxin.service.impl;

import com.ccsu.shuziyingxin.dao.CollegeDao;
import com.ccsu.shuziyingxin.dao.SpecialityDao;
import com.ccsu.shuziyingxin.pojo.College;
import com.ccsu.shuziyingxin.pojo.Speciality;
import com.ccsu.shuziyingxin.pojo.response.CollegeDetailPage;
import com.ccsu.shuziyingxin.service.ICollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-04-03 17:42
 */
@Service
public class CollegeServiceImpl implements ICollegeService {

    @Autowired
    CollegeDao collegeDao;

    @Autowired
    SpecialityDao specialityDao;

    @Override
    public List<College> getAllCollege() {
        List<College> collegeList = collegeDao.queryAllCollege();
        return collegeList;
    }

    @Override
    public CollegeDetailPage getCollegeDetail(Integer collegeId, String collegeName) {
        CollegeDetailPage collegeDetailPage = new CollegeDetailPage();
        College college = null;
        if (collegeId == null) {
            college = collegeDao.queryCollegeByName(collegeName);
            collegeId = college.getCollegeId();
        } else {
            college = collegeDao.queryCollege(collegeId);
        }
        List<Speciality> specialityList = specialityDao.querySpeciByCollege(collegeId);
        collegeDetailPage.setCollege(college);
        collegeDetailPage.setSpecialityList(specialityList);
        return collegeDetailPage;
    }

    @Override
    public Speciality getSpecialityDetail(int specialityId) {
        Speciality speciality = specialityDao.querySpeciality(specialityId);
        return null;
    }
}
