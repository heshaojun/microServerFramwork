package com.htjc.vo;

import java.io.Serializable;

/**
 * @Author heath
 * @Date 2018/5/26
 * @describe
 */
public class DubboTransRespVo implements Serializable{
    private String name;
    private String info;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
