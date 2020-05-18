package com.ccsu.shuziyingxin.pojo.request;

import com.ccsu.shuziyingxin.pojo.Laboratory;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-05-03 16:29
 */
public class LaboratoryParam {
    private Laboratory laboratory;
    private String optionType;

    public Laboratory getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(Laboratory laboratory) {
        this.laboratory = laboratory;
    }

    public String getOptionType() {
        return optionType;
    }

    public void setOptionType(String optionType) {
        this.optionType = optionType;
    }
}
