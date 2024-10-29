package com.easyfun.service;

import com.easyfun.entity.PhonePrefix;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.*;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/10/27 下午3:29
 */

@Service
public class CommonService {

    private final PhoneNumberUtil phoneNumberUtil;

    @Autowired
    public CommonService(PhoneNumberUtil phoneNumberUtil) {
        Assert.notNull(phoneNumberUtil, "phoneNumberUtil must not be null");
        this.phoneNumberUtil = phoneNumberUtil;
    }

    public ArrayList<PhonePrefix> getPhonePrefixAreaList(){
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
        return phonePrefixes;
    }
}