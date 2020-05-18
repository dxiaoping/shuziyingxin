package com.ccsu.shuziyingxin.dao;

import com.ccsu.shuziyingxin.pojo.BusiClass;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusiClassDao {
    List<BusiClass> queryAllClass();
}
