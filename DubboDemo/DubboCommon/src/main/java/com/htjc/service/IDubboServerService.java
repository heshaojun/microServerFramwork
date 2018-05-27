package com.htjc.service;

import com.htjc.vo.DubboServerReqVo;
import com.htjc.vo.DubboServerRespVo;

/**
 * @Author heath
 * @Date 2018/5/26
 * @describe
 */
public interface IDubboServerService {
    public DubboServerRespVo invoke(DubboServerReqVo reqVo);
}
