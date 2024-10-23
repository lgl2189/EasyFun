package com.easyfun.controller;

import com.easyfun.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/10/23 下午4:49
 */

@Controller
public class TestController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/hello")
    public String hello(){
        System.out.println(userMapper);
        System.out.println("hello");
        return "hello";
    }

}