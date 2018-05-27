package com.htjc;

import com.htjc.dubbo.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author heath
 * @Date 2018/5/26
 * @describe
 */
@SpringBootApplication
@EnableDubboConfiguration
public class DubboTransStarter {
    public static void main(String[] args) {
        SpringApplication.run(DubboTransStarter.class,args);
        while(true){}
    }

}
