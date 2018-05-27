package com.htjc.config.memcached;

import com.htjc.memcached.annotation.EnableMemcachedConfiguration;
import net.rubyeye.xmemcached.XMemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.utils.XMemcachedClientFactoryBean;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

/**
 * @Author heath
 * @Date 2018/5/26
 * @describe
 */

@SpringBootConfiguration
@EnableMemcachedConfiguration
public class MemcachedConfig {
/*    @Bean
    public XMemcachedClient memcachedClient(){
        XMemcachedClientBuilder xMemcachedClientBuilder = new XMemcachedClientBuilder("192.168.0.107:11211");
        XMemcachedClient xMemcachedClient = null;
        try {
            xMemcachedClient = (XMemcachedClient)xMemcachedClientBuilder.build();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return xMemcachedClient;
    }*/
}
