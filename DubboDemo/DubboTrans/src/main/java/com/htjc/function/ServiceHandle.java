package com.htjc.function;

import com.htjc.service.IDubboServerService;
import com.htjc.vo.DubboServerReqVo;
import com.htjc.vo.DubboServerRespVo;
import com.htjc.vo.DubboTransReqVo;
import com.htjc.vo.DubboTransRespVo;
import org.springframework.stereotype.Service;

/**
 * @Author heath
 * @Date 2018/5/26
 * @describe
 */
@Service
public class ServiceHandle {
    @com.alibaba.dubbo.config.annotation.Reference
    private IDubboServerService service;
    public DubboTransRespVo invokeHandle(DubboTransReqVo reqVo){
        DubboTransRespVo transRespVo = new DubboTransRespVo();
        DubboServerRespVo serverRespVo = new DubboServerRespVo();
        DubboServerReqVo serverReqVo = new DubboServerReqVo();
        serverReqVo.setInfo("sex:male age:10000 type:alien");
        serverReqVo.setName(reqVo.getName());
        serverRespVo = service.invoke(serverReqVo);
        transRespVo.setName(reqVo.getName());
        transRespVo.setInfo(serverReqVo.getInfo());
        transRespVo.setDescription(serverRespVo.getDescription());
        return transRespVo;
    }
}
