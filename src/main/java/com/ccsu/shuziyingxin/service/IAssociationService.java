package com.ccsu.shuziyingxin.service;

import com.ccsu.shuziyingxin.pojo.Association;

import java.util.List;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-04-18 15:39
 */
public interface IAssociationService {
    boolean add(Association association);
    boolean modify(Association association);
    Association queryOne(int associationId);
    List<Association> queryAll();
}
