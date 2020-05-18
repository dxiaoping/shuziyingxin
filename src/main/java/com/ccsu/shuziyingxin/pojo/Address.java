package com.ccsu.shuziyingxin.pojo;

/**
 * @Description 地点
 * @auther DuanXiaoping
 * @create 2020-03-24 21:31
 */
public class Address {

    private int addrId;//地点id
    private String addrName;//地点名
    private String description;//地点描述
    private double latitude;//纬度
    private double longitude;//精度
    public int getAddrId() {
        return addrId;
    }

    public void setAddrId(int addrId) {
        this.addrId = addrId;
    }

    public String getAddrName() {
        return addrName;
    }

    public void setAddrName(String addrName) {
        this.addrName = addrName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
