package com.ccsu.shuziyingxin.dao;

import com.ccsu.shuziyingxin.pojo.Jxjh;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-03-20 13:26
 */
@Repository
public interface JxjhDao {
    List<Jxjh> queryAllJxjh(String speciality);
    List<Jxjh> getMajorClass(String speciality);
    Jxjh queryJxjhBySpeciality(String speciality);
    int saveJxjh(List<Jxjh> list);
}
