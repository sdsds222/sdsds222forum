package org.sdsds222.testtlias.config;

import org.sdsds222.testtlias.interceptor.LoginCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration//配置类，用于配置拦截器
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginCheckInterceptor loginCheckInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器，设置拦截所有资源
        registry.addInterceptor(loginCheckInterceptor)
                .addPathPatterns("/**")
               .excludePathPatterns("/login");
    }
}
