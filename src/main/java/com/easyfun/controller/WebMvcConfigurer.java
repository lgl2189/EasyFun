package com.easyfun.controller;

import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import java.util.Collections;
import java.util.List;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/10/23 下午2:32
 */

@Component
public class WebMvcConfigurer implements org.springframework.web.servlet.config.annotation.WebMvcConfigurer {

    private final GsonHttpMessageConverter gsonHttpMessageConverter;

    public WebMvcConfigurer(GsonHttpMessageConverter gsonHttpMessageConverter) {
        Assert.notNull(gsonHttpMessageConverter, "gsonHttpMessageConverter must not be null");
        this.gsonHttpMessageConverter = gsonHttpMessageConverter;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        //开启默认的Servlet处理器
        configurer.enable();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        org.springframework.web.servlet.config.annotation.WebMvcConfigurer.super.addInterceptors(registry);
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //添加自定义的 GsonHttpMessageConverter
        converters.add(gsonHttpMessageConverter);
        //添加默认的 ResourceHttpMessageConverter
        ResourceHttpMessageConverter resourceConverter = new ResourceHttpMessageConverter();
        resourceConverter.setSupportedMediaTypes(Collections.singletonList(MediaType.parseMediaType("video/mp4")));
        converters.add(resourceConverter);
    }

}