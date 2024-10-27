package com.easyfun.entity;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/10/24 上午11:32
 */


public class PhonePrefix {

    private String prefixCode;
    private String regionName;

    public PhonePrefix(String prefixCode, String regionName) {
        this.prefixCode = prefixCode;
        this.regionName = regionName;
    }

    public String getPrefixCode() {
        return prefixCode;
    }

    public void setPrefixCode(String prefixCode) {
        this.prefixCode = prefixCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
}