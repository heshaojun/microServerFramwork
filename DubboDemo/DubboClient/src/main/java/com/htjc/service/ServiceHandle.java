package com.htjc.service;

import com.htjc.vo.DubboTransReqVo;
import com.htjc.vo.DubboTransRespVo;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.stereotype.Service;

/**
 * @Author heath
 * @Date 2018/5/26
 * @describe
 */
@Service
public class ServiceHandle {
    @com.alibaba.dubbo.config.annotation.Reference
    private IDubboTransService transService;
    public DubboTransRespVo invokeHandle(DubboTransReqVo reqVo){
        DubboTransRespVo respVo = new DubboTransRespVo();
        respVo = transService.invoke(reqVo);
        return respVo;
    }
}
