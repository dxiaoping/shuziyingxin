package com.ccsu.shuziyingxin.pojo.request;

import com.ccsu.shuziyingxin.pojo.Business;

import java.util.List;

/**
 * @Description 该对象用于创建业务对象时封装业务对象的关联关系
 * @auther DuanXiaoping
 * @create 2020-03-23 8:04
 */
public class BusiParam {
    private Business business;
    private List<Integer> relationBusi;
    private List<Integer> relationAddr;
    private String optionType;

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public List<Integer> getRelationBusi() {
        return relationBusi;
    }

    public void setRelationBusi(List<Integer> relationBusi) {
        this.relationBusi = relationBusi;
    }

    public List<Integer> getRelationAddr() {
        return relationAddr;
    }

    public void setRelationAddr(List<Integer> relationAddr) {
        this.relationAddr = relationAddr;
    }

    public String getOptionType() {
        return optionType;
    }

    public void setOptionType(String optionType) {
        this.optionType = optionType;
    }
}
