package com.easyfun.config;

import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.SessionTrackingMode;
import java.util.EnumSet;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/11/7 上午10:06
 */


public class WebApplicationInitializer implements org.springframework.web.WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // 注册 ServletContextListener
        servletContext.addListener(new CleanServletContextListener());
    }
}