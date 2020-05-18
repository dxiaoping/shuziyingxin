package com.ccsu.shuziyingxin.service.impl;

import com.ccsu.shuziyingxin.dao.JxjhDao;
import com.ccsu.shuziyingxin.dao.SearchDao;
import com.ccsu.shuziyingxin.pojo.Jxjh;
import com.ccsu.shuziyingxin.pojo.Search;
import com.ccsu.shuziyingxin.pojo.Student;
import com.ccsu.shuziyingxin.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-03-26 11:28
 */
@Service
public class BaseServiceImpl implements IBaseService {

    @Autowired
    JxjhDao jxjhDao;

    @Autowired
    SearchDao searchDao;
    @Override
    public List<Jxjh> getJxjh(String speciality) {
        return jxjhDao.queryAllJxjh(speciality);
    }

    @Override
    public List<Search> getSearchKey() {

        List<Search> searchList = searchDao.queryAll();
        return searchList;
    }
}
