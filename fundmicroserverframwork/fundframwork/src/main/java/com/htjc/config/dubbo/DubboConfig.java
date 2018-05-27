package com.htjc.config.dubbo;

import com.htjc.dubbo.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Profile;

/**
 * @Author heath
 * @Date 2018/5/26
 * @describe
 */
@Profile("dubbo")
@SpringBootConfiguration
@EnableDubboConfiguration
public class DubboConfig {
}
