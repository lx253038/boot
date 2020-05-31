package com.mybatis.boot.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Author LX
 * @Date 2020/2/20 15:15
 * @Description
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
    @Autowired
    UserArgumentResolver userArgumentResolver; //�Զ����û�����������

    @Autowired
    LoginHandler loginHandler;  //��¼������

    /**
     * �Զ������������
     *
     * @param argumentResolvers
     */
    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(userArgumentResolver);
    }

    /**
     * �Զ���������
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptor = registry.addInterceptor(loginHandler);
        interceptor.excludePathPatterns("/static/**");
        interceptor.excludePathPatterns("/error");
        interceptor.excludePathPatterns("/login");
        interceptor.excludePathPatterns("/loginCheck");
        interceptor.excludePathPatterns("/getCode");
        interceptor.excludePathPatterns("/user/**");
        interceptor.excludePathPatterns("/miaosha");
        interceptor.excludePathPatterns("/miaosha2");

        interceptor.addPathPatterns("/**");
    }
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }

}
