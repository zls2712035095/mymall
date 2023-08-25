package com.zls.mall.consumer.config;

import com.zls.mall.consumer.aop.AuthenticationInterceptor;
import com.zls.mall.consumer.aop.SystemLogAspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private SystemLogAspect systemLogAspect;
    @Autowired
    private AuthenticationInterceptor authenticationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {//加入到整体mvc中的拦截器链中
        //拦截所有请求
        registry.addInterceptor(systemLogAspect).addPathPatterns("/**");
        registry.addInterceptor(authenticationInterceptor).addPathPatterns("/**");
    }
}
