package com.htjc.test;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.exception.MemcachedException;
import net.rubyeye.xmemcached.utils.XMemcachedClientFactoryBean;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeoutException;

@RunWith(SpringRunner.class)
@SpringBootTest("spring.profiles.active = memcached")

public class MemcachedTestCase {

    @Autowired
    private XMemcachedClient xMemcachedClient;

    @Test
    public void test(){
        try {
            xMemcachedClient.set("testvalue",600,"sdfdfddsfdsf");
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        }
    }
    @After
    public void after(){
        try {
            String result =  xMemcachedClient.get("testvalue");
            System.out.println("==================================");
            System.out.println(result);
            System.out.println("==================================");
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        }
    }
}
