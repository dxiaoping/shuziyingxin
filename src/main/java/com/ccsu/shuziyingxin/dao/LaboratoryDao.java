package com.ccsu.shuziyingxin.dao;

import com.ccsu.shuziyingxin.pojo.Laboratory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-04-25 22:02
 */
@Repository
public interface LaboratoryDao {
    List<Laboratory> queryAll();
    List<Laboratory> queryByOrganization(String organization);
    Laboratory queryOne(int id);
    Laboratory queryOneByName(String name);
    int update(Laboratory laboratory);
    int insert(Laboratory laboratory);
    boolean delete(int id);

}
