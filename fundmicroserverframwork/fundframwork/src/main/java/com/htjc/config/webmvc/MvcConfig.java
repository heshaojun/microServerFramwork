package com.htjc.config.webmvc;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcRegistrationsAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@SpringBootConfiguration
public class MvcConfig extends WebMvcRegistrationsAdapter {
    @Bean
    @Override
    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
        RequestMappingHandlerMapping requestMappingHandlerMapping = new RequestMappingHandlerMapping();
        requestMappingHandlerMapping.setInterceptors();
        return super.getRequestMappingHandlerMapping();
    }
    @Bean
    @Override
    public RequestMappingHandlerAdapter getRequestMappingHandlerAdapter() {
        return super.getRequestMappingHandlerAdapter();
    }
    @Bean
    @Override
    public ExceptionHandlerExceptionResolver getExceptionHandlerExceptionResolver() {
        return super.getExceptionHandlerExceptionResolver();
    }
}
