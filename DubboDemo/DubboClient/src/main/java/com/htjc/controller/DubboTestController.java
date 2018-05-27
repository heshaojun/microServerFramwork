package com.htjc.controller;

import com.htjc.service.ServiceHandle;
import com.htjc.vo.DubboTransReqVo;
import com.htjc.vo.DubboTransRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author heath
 * @Date 2018/5/26
 * @describe
 */
@RestController
@RequestMapping("/test")
public class DubboTestController {
    @Autowired
    private ServiceHandle handle;
    @RequestMapping("dubbo")
    public DubboTransRespVo test(@RequestParam("name") String name){
        DubboTransReqVo reqVo = new DubboTransReqVo();
        reqVo.setName(name);
        return  handle.invokeHandle(reqVo);
    }
}
