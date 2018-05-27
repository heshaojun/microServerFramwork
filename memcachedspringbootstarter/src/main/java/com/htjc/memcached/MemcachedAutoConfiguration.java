package com.htjc.memcached;

import com.htjc.memcached.annotation.EnableMemcachedConfiguration;
import net.rubyeye.xmemcached.XMemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.command.BinaryCommandFactory;
import net.rubyeye.xmemcached.command.KestrelCommandFactory;
import net.rubyeye.xmemcached.command.TextCommandFactory;
import net.rubyeye.xmemcached.impl.ArrayMemcachedSessionLocator;
import net.rubyeye.xmemcached.impl.KetamaMemcachedSessionLocator;
import net.rubyeye.xmemcached.utils.AddrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.List;

/**
 * @Author heath
 * @Date 2018/5/26
 * @describe
 */
@Configuration
@EnableConfigurationProperties(MemcachedProperties.class)
@AutoConfigureAfter(value = {EnableAutoConfiguration.class,EnableMemcachedConfiguration.class})
public class MemcachedAutoConfiguration {
    @Autowired
    private MemcachedProperties memcachedProperties;

    @Bean
    @ConditionalOnClass(EnableMemcachedConfiguration.class)
    @ConditionalOnProperty(name = MemcachedProperties.PRO_FIX+".servers")
    public XMemcachedClientBuilder xMemcachedClientBuilder() {
        List<InetSocketAddress> addressList = AddrUtil.getAddresses(memcachedProperties.getServers());
        List<Integer> weightList = memcachedProperties.getWeights();
        int[] weights = new int[weightList.size()];
        for (int i=0;i<weightList.size();i++){
            weights[i] = weightList.get(i);
        }
        XMemcachedClientBuilder xMemcachedClientBuilder = new XMemcachedClientBuilder(addressList,weights);

        int poolSize = memcachedProperties.getConnectionPoolSize() > 0 ? memcachedProperties.getConnectionPoolSize() : 1;

        xMemcachedClientBuilder.setConnectionPoolSize(poolSize);
        switch (memcachedProperties.getCommandFactory()) {
            case TEXT:
                xMemcachedClientBuilder.setCommandFactory(new TextCommandFactory());
                break;
            case BINARY:
                xMemcachedClientBuilder.setCommandFactory(new BinaryCommandFactory());
                break;
            case KESTREL:
                xMemcachedClientBuilder.setCommandFactory(new KestrelCommandFactory());
                break;
            default:
                break;
        }
        switch (memcachedProperties.getSessionLocator()) {
            case KETAMA:
                xMemcachedClientBuilder.setSessionLocator(new KetamaMemcachedSessionLocator());
                break;
            case ARRAY:
                xMemcachedClientBuilder.setSessionLocator(new ArrayMemcachedSessionLocator());
                break;
            default:
                break;
        }
        if (memcachedProperties.isFailureMode()) {
            xMemcachedClientBuilder.setFailureMode(true);
        }
        return xMemcachedClientBuilder;
    }
    @Bean
    @ConditionalOnClass(MemcachedProperties.class)
    @ConditionalOnBean(XMemcachedClientBuilder.class)
    public XMemcachedClient xMemcachedClient(XMemcachedClientBuilder xMemcachedClientBuilder){
        XMemcachedClient xMemcachedClient = null;
        try {
            xMemcachedClient = (XMemcachedClient)xMemcachedClientBuilder.build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return xMemcachedClient;
    }
}
