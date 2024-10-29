package com.easyfun.controller;

import com.easyfun.entity.JsonDataWrapper;
import com.easyfun.entity.PhonePrefix;
import com.easyfun.service.CommonService;
import com.easyfun.util.JsonDataWrapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：李冠良
 * @description： 负责处理所有不归属于某个特定页面且具有复用性的功能
 * @date ：2024/10/23 下午11:50
 */

@Controller
@RequestMapping("/common")
public class CommonController {

    private final CommonService commonService;

    @Autowired
    public CommonController(CommonService commonService) {
        Assert.notNull(commonService, "commonService must not be null");
        this.commonService = commonService;
    }

    @GetMapping("/phonePrefixAreaList")
    @ResponseBody
    public JsonDataWrapper phonePrefixAreaList(){
        List<PhonePrefix> phonePrefixes = commonService.getPhonePrefixAreaList();
        Map<String, List<PhonePrefix>> map = new HashMap<>();
        map.put("phonePrefixAreaList", phonePrefixes);
        return JsonDataWrapperUtil.success(map);
    }

}