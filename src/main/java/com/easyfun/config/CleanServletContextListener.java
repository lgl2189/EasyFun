package com.easyfun.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Driver;
import java.sql.DriverManager;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/11/7 上午10:02
 */


public class CleanServletContextListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //应用启动时的操作

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //应用销毁时的操作
        try {
            Class.forName("com.alibaba.druid.proxy.DruidDriver").asSubclass(Driver.class);
            Driver driver = (Driver) Class.forName("com.alibaba.druid.proxy.DruidDriver").newInstance();
            DriverManager.deregisterDriver(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").asSubclass(Driver.class);
            Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            DriverManager.deregisterDriver(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}