package com.htjc;

import com.htjc.mybatis.annotation.EnableMybatisConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @Author heath
 * @Date 2018/5/26
 * @describe
 */
@SpringBootApplication
@EnableMybatisConfiguration
@EnableWebMvc
public class MybatisDemoStarter {
    public static void main(String[] args) {
        SpringApplication.run(MybatisDemoStarter.class,args);

    }
}
