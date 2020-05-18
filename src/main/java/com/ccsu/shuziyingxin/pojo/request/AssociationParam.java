package com.ccsu.shuziyingxin.pojo.request;

import com.ccsu.shuziyingxin.pojo.Association;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-04-18 16:59
 */
public class AssociationParam {
    private Association association;
    private String optionType;

    public Association getAssociation() {
        return association;
    }

    public void setAssociation(Association association) {
        this.association = association;
    }

    public String getOptionType() {
        return optionType;
    }

    public void setOptionType(String optionType) {
        this.optionType = optionType;
    }
}
