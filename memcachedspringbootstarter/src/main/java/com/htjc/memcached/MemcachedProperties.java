package com.htjc.memcached;

import com.htjc.memcached.enums.CommandFactoryEnum;
import com.htjc.memcached.enums.SessionLocatorEnum;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @Author heath
 * @Date 2018/5/26
 * @describe
 */
@ConfigurationProperties(prefix = MemcachedProperties.PRO_FIX)
public class MemcachedProperties {
    public static final String PRO_FIX = "spring.memcached";
    private String servers;  //服务 HOST:PORT HOST:PORT
    private List<Integer> weights; //权重配置每个服务器的权重
    private Integer  connectionPoolSize; //连接池大小
    private CommandFactoryEnum commandFactory; //协议工厂
    private SessionLocatorEnum sessionLocator; //分布策略
    private boolean failureMode; //是否启用failure模式

    public String getServers() {
        return servers;
    }

    public void setServers(String servers) {
        this.servers = servers;
    }

    public List<Integer> getWeights() {
        return weights;
    }

    public void setWeights(List<Integer> weights) {
        this.weights = weights;
    }

    public Integer getConnectionPoolSize() {
        return connectionPoolSize;
    }

    public void setConnectionPoolSize(Integer connectionPoolSize) {
        this.connectionPoolSize = connectionPoolSize;
    }

    public CommandFactoryEnum getCommandFactory() {
        return commandFactory;
    }

    public void setCommandFactory(CommandFactoryEnum commandFactory) {
        this.commandFactory = commandFactory;
    }

    public SessionLocatorEnum getSessionLocator() {
        return sessionLocator;
    }

    public void setSessionLocator(SessionLocatorEnum sessionLocator) {
        this.sessionLocator = sessionLocator;
    }

    public boolean isFailureMode() {
        return failureMode;
    }

    public void setFailureMode(boolean failureMode) {
        this.failureMode = failureMode;
    }
}
