package com.htjc.vo;

import java.io.Serializable;

/**
 * @Author heath
 * @Date 2018/5/26
 * @describe  dubbo server (服务端) 请求实体
 */
public class DubboServerReqVo implements Serializable {
    private String name;
    private String info;

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
}
