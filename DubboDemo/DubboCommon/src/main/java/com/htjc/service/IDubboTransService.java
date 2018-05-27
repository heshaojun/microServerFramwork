package com.htjc.service;

import com.htjc.vo.DubboTransReqVo;
import com.htjc.vo.DubboTransRespVo;

/**
 * @Author heath
 * @Date 2018/5/26
 * @describe
 */
public interface IDubboTransService {
    public DubboTransRespVo invoke(DubboTransReqVo reqVo);
}
