package com.easyfun.enumeration;

public enum ImageFormatEnum {
    AVIF("avif"),
    WEBP("webp"),
    JPG("jpg"),
    PNG("png");

    private String formatStr;

    ImageFormatEnum(String formatStr) {
        this.formatStr = formatStr;
    }

    public String getFormatStr() {
        return formatStr;
    }

    public void setFormatStr(String formatStr) {
        this.formatStr = formatStr;
    }
}
