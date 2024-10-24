package com.easyfun.controller;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/10/23 下午2:32
 */

@Component
public class WebMvcConfigurer implements org.springframework.web.servlet.config.annotation.WebMvcConfigurer {
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        //开启默认的Servlet处理器
        configurer.enable();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        org.springframework.web.servlet.config.annotation.WebMvcConfigurer.super.addInterceptors(registry);
    }
}