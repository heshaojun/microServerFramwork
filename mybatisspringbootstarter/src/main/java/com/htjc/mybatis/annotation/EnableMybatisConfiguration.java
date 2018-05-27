package com.htjc.mybatis.annotation;

import java.lang.annotation.*;

/**
 * @Author heath
 * @Date 2018/5/26
 * @describe 使能redis自動配置
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EnableMybatisConfiguration {
}
