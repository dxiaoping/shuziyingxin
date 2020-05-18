package com.ccsu.shuziyingxin.dao;

import com.ccsu.shuziyingxin.pojo.Address;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-03-22 17:21
 */
@Repository
public interface AddrDao {
    int createAddr(Address address);
    boolean deleteAddr(int addrId);
    boolean modifyAddr(Address address);
    Address queryAddr(int addrId);
    List<Address> queryAddrListByBusi(int busiId);
    List<Address> queryAllAddr();
    boolean addRelation(@Param("busiId") int busiId,@Param("addrId") int addrId);
    boolean deleteRelation(@Param("busiId") int busiId);
}
