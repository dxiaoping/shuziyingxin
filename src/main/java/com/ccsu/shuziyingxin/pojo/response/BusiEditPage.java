package com.ccsu.shuziyingxin.pojo.response;

import com.ccsu.shuziyingxin.pojo.Address;
import com.ccsu.shuziyingxin.pojo.BusiClass;
import com.ccsu.shuziyingxin.pojo.Business;

import java.util.List;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-04-12 12:16
 */
public class BusiEditPage {
    private Business business;

    private List<Integer> busiRefIdList;
    private List<Integer> addrRefIdList;

    private List<Business> busiRefBean;
    private List<Address> addrRefBean;

    private List<Business> businessList;
    private List<Address> addressList;
    private List<BusiClass> classList;

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public List<Integer> getBusiRefIdList() {
        return busiRefIdList;
    }

    public void setBusiRefIdList(List<Integer> busiRefIdList) {
        this.busiRefIdList = busiRefIdList;
    }

    public List<Integer> getAddrRefIdList() {
        return addrRefIdList;
    }

    public void setAddrRefIdList(List<Integer> addrRefIdList) {
        this.addrRefIdList = addrRefIdList;
    }

    public List<Business> getBusinessList() {
        return businessList;
    }

    public void setBusinessList(List<Business> businessList) {
        this.businessList = businessList;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public List<Business> getBusiRefBean() {
        return busiRefBean;
    }

    public void setBusiRefBean(List<Business> busiRefBean) {
        this.busiRefBean = busiRefBean;
    }

    public List<Address> getAddrRefBean() {
        return addrRefBean;
    }

    public void setAddrRefBean(List<Address> addrRefBean) {
        this.addrRefBean = addrRefBean;
    }

    public List<BusiClass> getClassList() {
        return classList;
    }

    public void setClassList(List<BusiClass> classList) {
        this.classList = classList;
    }
}
