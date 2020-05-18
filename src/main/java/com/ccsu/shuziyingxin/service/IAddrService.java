package com.ccsu.shuziyingxin.service;

import com.ccsu.shuziyingxin.pojo.Address;

import java.util.List;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-03-26 7:45
 */
public interface IAddrService {
    int createAddr(Address address);
    boolean deleteAddr(int addrId);
    boolean updateAddr(Address address);
    boolean addRelation(int busiId,int addrId);
    boolean deleteRelation(int busiId);
    Address queryAddr(int addrId);
    List<Address> queryAddrListByBusi(int busiId);
    List<Address> queryAllAddr();
}

