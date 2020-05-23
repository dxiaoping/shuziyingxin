package com.ccsu.shuziyingxin.service;

import com.ccsu.shuziyingxin.pojo.Config;
import com.ccsu.shuziyingxin.pojo.Jxjh;
import com.ccsu.shuziyingxin.pojo.Search;
import com.ccsu.shuziyingxin.pojo.Student;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-03-26 11:20
 */
public interface IBaseService {
    List<Jxjh> getJxjh(String speciality);
    List<Search> getSearchKey();
    List<Config> getConfigList(String class1);
}
