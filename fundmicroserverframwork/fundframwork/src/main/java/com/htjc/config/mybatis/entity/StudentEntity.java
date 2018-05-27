package com.htjc.config.mybatis.entity;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias("student")
public class StudentEntity implements Serializable {
    private String idNo;
    private String name;
    private String sex;
    private Float age;
    private String guarderId;

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
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

    public Float getAge() {
        return age;
    }

    public void setAge(Float age) {
        this.age = age;
    }

    public String getGuarderId() {
        return guarderId;
    }

    public void setGuarderId(String guarderId) {
        this.guarderId = guarderId;
    }
}
