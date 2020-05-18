package com.ccsu.shuziyingxin.dao;

import com.ccsu.shuziyingxin.pojo.Search;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-05-03 21:14
 */
@Repository
public interface SearchDao {
    List<Search> queryAll();
}
