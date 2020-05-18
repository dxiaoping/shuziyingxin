package com.ccsu.shuziyingxin.dao;

import com.ccsu.shuziyingxin.pojo.Business;
import com.ccsu.shuziyingxin.pojo.College;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-03-22 17:21
 */
@Repository
public interface CollegeDao {
    int createCollege(College college);
    boolean deleteCollege(int collegeId);
    boolean modifyCollege(College college);
    College queryCollege(int collegeId);
    Integer getCollegeIdByName(String collegeName);
    List<College> queryAllCollege();
}
