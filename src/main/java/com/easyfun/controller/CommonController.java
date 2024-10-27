package com.easyfun.controller;

import com.easyfun.entity.DataWrapper;
import com.easyfun.entity.PhonePrefix;
import com.easyfun.service.CommonService;
import com.easyfun.util.JsonDataWrapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author ：李冠良
 * @description： 负责处理所有不归属于某个特定页面且具有复用性的功能
 * @date ：2024/10/23 下午11:50
 */

@Controller
@RequestMapping("/common")
public class CommonController {

    @Autowired
    private CommonService commonService;

    @GetMapping("/phonePrefixAreaList")
    @ResponseBody
    public DataWrapper phonePrefixAreaList(){
        List<PhonePrefix> phonePrefixes = commonService.getPhonePrefixAreaList();
        return JsonDataWrapperUtil.success(phonePrefixes);
    }

}