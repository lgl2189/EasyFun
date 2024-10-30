package com.easyfun.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.google.gson.Gson;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import org.apache.commons.text.RandomStringGenerator;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/10/23 下午2:32
 */

@Configuration
@ComponentScan({"com.easyfun.service","com.easyfun.util","com.easyfun.task"})
@MapperScan("com.easyfun.mapper")
@PropertySource("classpath:jdbc.properties")
public class SpringConfig {
    @Bean
    public DataSource dataSource(
            @Value("${jdbc.url}") String url,
            @Value("${jdbc.username}") String username,
            @Value("${jdbc.password}") String password
    ) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }

    @Bean
    public Gson gson(){
        return new Gson();
    }

    @Bean
    public PhoneNumberUtil phoneNumberUtil(){
        return PhoneNumberUtil.getInstance();
    }

    @Bean
    public RandomStringGenerator randomStringGenerator(){
        return new RandomStringGenerator.Builder().withinRange('a', 'z').build();
    }
}