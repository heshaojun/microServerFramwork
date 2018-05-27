package com.htjc.memcached.annotation;

import java.lang.annotation.*;

/**
 * @Author heath
 * @Date 2018/5/26
 * @describe
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EnableMemcachedConfiguration {
}
