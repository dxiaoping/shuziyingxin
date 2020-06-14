package com.ccsu.shuziyingxin.dao;

import com.ccsu.shuziyingxin.pojo.Search;
import org.apache.ibatis.annotations.Param;
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
    List<String> queryKeyName();
    Search querySearch(@Param("key") String key);
    int addKeyWord(@Param("keyWord") String keyWord,@Param("class1") String class1);
    int delete(@Param("keyWord") String keyWord);
}
