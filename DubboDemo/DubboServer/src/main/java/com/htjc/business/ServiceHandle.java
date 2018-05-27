package com.htjc.business;

import com.htjc.vo.DubboServerReqVo;
import com.htjc.vo.DubboServerRespVo;
import org.springframework.stereotype.Service;

/**
 * @Author heath
 * @Date 2018/5/26
 * @describe
 */
@Service
public class ServiceHandle {
    public DubboServerRespVo invokeHandle(DubboServerReqVo reqVo) {
        DubboServerRespVo respVo = new DubboServerRespVo();
        respVo.setName(reqVo.getName());
        respVo.setDescription(reqVo.getName()+ " is an handsome and outstanding man!!");
        return respVo;
    }
}
