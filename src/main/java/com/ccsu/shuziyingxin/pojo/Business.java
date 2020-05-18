package com.ccsu.shuziyingxin.pojo;

/**
 * @Description 业务对象（报到业务，校园卡充值问题等均属于一项业务）
 * @auther DuanXiaoping
 * @create 2020-03-22 7:29
 */
public class Business {
    private int busiId;                     //业务id
    private String busiName;                //业务名
    private int busiClassId;               //业务类别
    private String solution;                //业务解决方案

    public int getBusiId() {
        return busiId;
    }

    public void setBusiId(int busiId) {
        this.busiId = busiId;
    }

    public String getBusiName() {
        return busiName;
    }

    public void setBusiName(String busiName) {
        this.busiName = busiName;
    }

    public int getBusiClassId() {
        return busiClassId;
    }

    public void setBusiClassId(int busiClassId) {
        this.busiClassId = busiClassId;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }
}
