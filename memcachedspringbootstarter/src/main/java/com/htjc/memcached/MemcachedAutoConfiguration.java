package com.htjc.memcached;

import com.htjc.memcached.annotation.EnableMemcachedConfiguration;
import net.rubyeye.xmemcached.command.BinaryCommandFactory;
import net.rubyeye.xmemcached.command.KestrelCommandFactory;
import net.rubyeye.xmemcached.command.TextCommandFactory;
import net.rubyeye.xmemcached.impl.ArrayMemcachedSessionLocator;
import net.rubyeye.xmemcached.impl.KetamaMemcachedSessionLocator;
import net.rubyeye.xmemcached.utils.XMemcachedClientFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author heath
 * @Date 2018/5/26
 * @describe
 */
@Configuration
@EnableConfigurationProperties(MemcachedProperties.class)
@AutoConfigureAfter(EnableAutoConfiguration.class)
@ConditionalOnBean(annotation = EnableMemcachedConfiguration.class)
public class MemcachedAutoConfiguration {
    @Autowired
    private MemcachedProperties memcachedProperties;

    @Bean(destroyMethod = "shutdown")
    @ConditionalOnBean
    @ConditionalOnClass(MemcachedProperties.class)
    public XMemcachedClientFactoryBean memcachedClient() {
        XMemcachedClientFactoryBean memcachedClient = new XMemcachedClientFactoryBean();
        if (memcachedProperties.getServers() != null) {
            memcachedClient.setServers(memcachedProperties.getServers());
        }
        if (memcachedProperties.getWeights() != null) {
            if (memcachedProperties.getWeights().size() > 0) {
                memcachedClient.setWeights(memcachedProperties.getWeights());
            }
        }
        int poolSize = memcachedProperties.getConnectionPoolSize() > 0 ? memcachedProperties.getConnectionPoolSize() : 1;

        memcachedClient.setConnectionPoolSize(poolSize);
        switch (memcachedProperties.getCommandFactory()) {
            case TEXT:
                memcachedClient.setCommandFactory(new TextCommandFactory());
                break;
            case BINARY:
                memcachedClient.setCommandFactory(new BinaryCommandFactory());
                break;
            case KESTREL:
                memcachedClient.setCommandFactory(new KestrelCommandFactory());
                break;
            default:
                break;
        }
        switch (memcachedProperties.getSessionLocator()) {
            case KETAMA:
                memcachedClient.setSessionLocator(new KetamaMemcachedSessionLocator());
                break;
            case ARRAY:
                memcachedClient.setSessionLocator(new ArrayMemcachedSessionLocator());
                break;
            default:
                break;
        }
        if (memcachedProperties.isFailureMode()) {
            memcachedClient.setFailureMode(true);
        }
        return memcachedClient;
    }
}
