package com.htjc;

import com.htjc.dubbo.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @Author heath
 * @Date 2018/5/26
 * @describe
 */
@SpringBootApplication
@EnableDubboConfiguration
@EnableWebMvc
public class DubboClientStarter {
    public static void main(String[] args) {
        SpringApplication.run(DubboClientStarter.class,args);
    }
}
