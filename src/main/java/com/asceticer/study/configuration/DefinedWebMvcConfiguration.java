package com.asceticer.study.configuration;

import com.asceticer.study.component.resolver.DefinedLocaleResolver;
import com.asceticer.study.component.interceptor.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description: 自定义拓展WebMvc相关配置
 * @Author: Administrator
 * @Date: 2020/3/18 10:16
 * @Version: 1.0
 */
@Configuration
public class DefinedWebMvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/index").setViewName("index");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index", "/", "/error", "/hello/**", "/user/login");
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new DefinedLocaleResolver();
    }
}
