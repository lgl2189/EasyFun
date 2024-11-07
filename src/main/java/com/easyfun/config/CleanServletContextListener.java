package com.easyfun.config;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/11/7 上午10:02
 */


public class CleanServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //应用启动时的操作

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //应用销毁时的操作
        try {
            System.out.println("注销JDBC驱动");
            Enumeration<Driver> drivers = DriverManager.getDrivers();
            while (drivers.hasMoreElements()) {
                Driver driver = (Driver) drivers.nextElement();
                DriverManager.deregisterDriver(driver);
                System.out.println("注销JDBC驱动: " + driver);
            }
            AbandonedConnectionCleanupThread.uncheckedShutdown();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("注销JDBC驱动异常");
        }
    }
}