package com.easyfun.controller;

import com.easyfun.entity.DataWrapper;
import com.easyfun.entity.PhonePrefix;
import com.easyfun.util.JsonDataWrapperUtil;
import com.google.gson.Gson;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

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

    @Autowired
    private PhoneNumberUtil phoneNumberUtil;

    @GetMapping("/phonePrefixAreaList")
    @ResponseBody
    public DataWrapper phonePrefixAreaList(){
        List<String> regionsCodes = new ArrayList<>();
        regionsCodes.add("CN");
        regionsCodes.add("HK");
        regionsCodes.add("MO");
        regionsCodes.add("TW");
        //HashSet加入重复值不会覆盖
        Set<String> supportedRegions = new HashSet<>(phoneNumberUtil.getSupportedRegions());
        supportedRegions.remove("CN");
        supportedRegions.remove("HK");
        supportedRegions.remove("MO");
        supportedRegions.remove("TW");
        regionsCodes.addAll(supportedRegions);
        ArrayList<PhonePrefix> phonePrefixes = new ArrayList<>();
        for(String regionCode : regionsCodes){
            Locale locale = new Locale("", regionCode);
            String regionName =null;
            if(regionCode.equals("TW")){
                regionName = "中国台湾";
            }
            else{
                regionName = locale.getDisplayCountry();
            }
            String regionPhoneCode = "+ "+String.valueOf(phoneNumberUtil.getCountryCodeForRegion(regionCode));
            PhonePrefix phonePrefix = new PhonePrefix(regionPhoneCode, regionName);
            phonePrefixes.add(phonePrefix);
        }
        return JsonDataWrapperUtil.success(phonePrefixes);
    }

}