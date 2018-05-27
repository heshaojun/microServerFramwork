package com.htjc.service;

import com.htjc.function.ServiceHandle;
import com.htjc.vo.DubboTransReqVo;
import com.htjc.vo.DubboTransRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author heath
 * @Date 2018/5/26
 * @describe
 */
@Service
@com.alibaba.dubbo.config.annotation.Service
public class DubboTransService implements IDubboTransService{
    @Autowired
    private ServiceHandle handle;
    @Override
    public DubboTransRespVo invoke(DubboTransReqVo reqVo) {
        DubboTransRespVo respVo = new DubboTransRespVo();
        respVo = handle.invokeHandle(reqVo);
        return respVo;
    }
}
