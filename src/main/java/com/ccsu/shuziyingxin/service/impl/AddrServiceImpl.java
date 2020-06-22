package com.ccsu.shuziyingxin.service.impl;

import com.ccsu.shuziyingxin.dao.AddrDao;
import com.ccsu.shuziyingxin.dao.SearchDao;
import com.ccsu.shuziyingxin.pojo.Address;
import com.ccsu.shuziyingxin.service.IAddrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-03-26 7:50
 */
@Service
public class AddrServiceImpl implements IAddrService {

    DecimalFormat df = new DecimalFormat("#.0000");

    @Autowired
    AddrDao addrDao;

    @Autowired
    SearchDao searchDao;

    @Override
    public int createAddr(Address address) {
        int count = addrDao.createAddr(address);
        searchDao.addKeyWord(address.getAddrName(), "address");
        return count;
    }

    @Override
    public boolean deleteAddr(int addrId) {
        Address address = addrDao.queryAddr(addrId);
        addrDao.deleteAddr(addrId);
        searchDao.delete(address.getAddrName());
        return false;
    }

    @Override
    public boolean updateAddr(Address address) {
        addrDao.modifyAddr(address);
        return false;
    }

    @Override
    public boolean addRelation(int busiId, int addrId) {
        return addrDao.addRelation(busiId, addrId);
    }

    @Override
    public boolean deleteRelation(int busiId) {
        return addrDao.deleteRelation(busiId);
    }

    @Override
    public Address queryAddr(int addrId) {
        Address address = addrDao.queryAddr(addrId);
        return address;
    }
    @Override
    public Address queryAddr(String addrName) {
        Address address = addrDao.queryAddrByName(addrName);
        return address;
    }

    @Override
    public List<Address> queryAddrListByBusi(int busiId) {
        return addrDao.queryAddrListByBusi(busiId);
    }

    @Override
    public List<Address> queryAllAddr() {
        List<Address> addressList = addrDao.queryAllAddr();
        for (Address address : addressList) {
            double longitude = address.getLongitude();
            double latitude = address.getLatitude();
            address.setLatitude(new Double(df.format(latitude)));
            address.setLongitude(new Double(df.format(longitude)));
        }
        return addressList;
    }
}
