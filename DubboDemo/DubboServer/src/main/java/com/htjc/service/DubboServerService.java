package com.htjc.service;

import com.htjc.function.ServiceHandle;
import com.htjc.vo.DubboServerReqVo;
import com.htjc.vo.DubboServerRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author heath
 * @Date 2018/5/26
 * @describe
 */
@Service
@com.alibaba.dubbo.config.annotation.Service
public class DubboServerService implements IDubboServerService {
    @Autowired
    private ServiceHandle handle;
    @Override
    public DubboServerRespVo invoke(DubboServerReqVo reqVo) {
        DubboServerRespVo respVo = new DubboServerRespVo();
        respVo = handle.invokeHandle(reqVo);
        return respVo;
    }
}
