package com.htjc.config.mybatis.entity;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias("guarder")
public class GuarderEntity implements Serializable {
    private String id;
    private String name;
    private String sex;
    private String relation;
    private String phone;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
