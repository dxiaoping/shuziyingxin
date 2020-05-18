package com.ccsu.shuziyingxin.pojo;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-04-25 21:46
 */
public class Laboratory {
    private int id;                       //实验室id
    private String name;                     //实验室名称
    private String organization;             //所属组织
    private String relatedPerson;            //相关人物
    private String contactInfo;              //联系信息
    private String description;              //实验室描述
    private String address;                  //实验室详细地址

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getRelatedPerson() {
        return relatedPerson;
    }

    public void setRelatedPerson(String relatedPerson) {
        this.relatedPerson = relatedPerson;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
