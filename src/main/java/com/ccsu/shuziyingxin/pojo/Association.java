package com.ccsu.shuziyingxin.pojo;

/**
 * @Description '社团/协会/学生会组织'
 * @auther DuanXiaoping
 * @create 2020-03-29 20:11
 */
public class Association {
    private String id; //'社团id'
    private String name; //'社团名称'
    private String organization;
    private String relatedPerson; //'相关人物'
    private String contactInfo; //'联系信息'
    private String description; //'社团描述'

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
