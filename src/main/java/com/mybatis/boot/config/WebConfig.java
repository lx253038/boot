package com.mybatis.boot.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @Author LX
 * @Date 2020/2/20 15:15
 * @Description
 */
@Configuration
//public class WebConfig extends WebMvcConfigurationSupport
public class WebConfig implements WebMvcConfigurer
{
    @Autowired
    UserArgumentResolver userArgumentResolver; //自定义用户参数解析器

    @Autowired
    LoginHandler loginHandler;  //登录拦截器

    /**
     * 自定义参数解析器
     *
     * @param argumentResolvers
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(userArgumentResolver);
    }

    /**
     * 自定义拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
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
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    /**
     * 添加跨域支持
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        CorsRegistration corsRegistration = registry.addMapping("/**");
        corsRegistration.allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }

}
