package com.ccsu.shuziyingxin.pojo.response;

import com.ccsu.shuziyingxin.pojo.Business;
import com.ccsu.shuziyingxin.pojo.Address;

import java.util.List;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-03-26 9:36
 */
public class BusinessPage {
    private Business business;//查询的具体业务对象
    private List<Business> busiList;//业务对象携带的关联对象
    private List<Address> addressList;//业务对象联的地点

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public List<Business> getBusiList() {
        return busiList;
    }

    public void setBusiList(List<Business> busiList) {
        this.busiList = busiList;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }
}
