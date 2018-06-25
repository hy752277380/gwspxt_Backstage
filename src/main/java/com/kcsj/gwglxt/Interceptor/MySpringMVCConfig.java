package com.kcsj.gwglxt.Interceptor;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@SpringBootConfiguration
public class MySpringMVCConfig implements WebMvcConfigurer {

    @Resource
    private UserConfig userConfig;

    private final String[] notLoginInterceptPaths = {
            "/",
            "/login",
            "/login/**",
            "/page-login/**",
            "/page-login/**",
            "/error",
            "/login.html",
            "/page-login.html",
            "/css/**",
            "/js/**",
            "/img/**",
            "/assets/**",};

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 自定义拦截器，添加拦截路径和排除拦截路径
        registry.addInterceptor(userConfig).addPathPatterns("/**").excludePathPatterns(notLoginInterceptPaths);
    }
}
