package com.ccsu.shuziyingxin.dao;

import com.ccsu.shuziyingxin.pojo.Config;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-05-23 9:20
 */
@Repository
public interface ConfigDao {
    Config select(@Param("class1") String class1, @Param("value") String value);
    List<Config> selectListByClass(@Param("class1") String class1);
}
