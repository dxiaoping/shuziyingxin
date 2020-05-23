package com.ccsu.shuziyingxin.dao;

import com.ccsu.shuziyingxin.pojo.Association;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-04-18 14:14
 */
@Repository
public interface AssociationDao {
    Association queryOne(int id);
    List<Association> queryAll();
    List<Association> queryByOrganization(String organization);
    int insertOne(Association association);
    int update(Association association);
}
