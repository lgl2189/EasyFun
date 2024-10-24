package com.easyfun.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：李冠良
 * @description： 负责处理所有不归属于某个特定页面且具有复用性的功能
 * @date ：2024/10/23 下午11:50
 */

@Controller
@RequestMapping("/common")
public class CommonController {

    @Autowired
    private Gson gson;

    @RequestMapping("/phonePrefixAreaList")
    @ResponseBody
    public String phonePrefixAreaList(){
        Map<String, String> map = new HashMap<>();
        map.put("86", "中国大陆");
        map.put("852", "中国香港特别行政区");
        Map<String, Map<String, String>> map1 = new HashMap<>();
        map1.put("data", map);
        return gson.toJson(map1);
    }

}