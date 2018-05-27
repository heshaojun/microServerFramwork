package com.htjc.test;

import com.htjc.service.IDubboTransService;
import com.htjc.vo.DubboTransReqVo;
import com.htjc.vo.DubboTransRespVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest("spring.profiles.active = dubbo")
public class DubboTestCase {
    @com.alibaba.dubbo.config.annotation.Reference
    private IDubboTransService dubboTransService;
    @Test
    public void test(){
        DubboTransReqVo reqVo = new DubboTransReqVo();
        DubboTransRespVo respVo = new DubboTransRespVo();
        reqVo.setName("heshaojun");
        respVo = dubboTransService.invoke(reqVo);
        System.out.println("=================================");
        System.out.println("name:"+respVo.getName());
        System.out.println("info:"+respVo.getInfo());
        System.out.println("Description:"+respVo.getDescription());
    }

}
