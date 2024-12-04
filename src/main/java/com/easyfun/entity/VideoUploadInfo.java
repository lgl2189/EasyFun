package com.easyfun.entity;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/12/4 下午6:12
 */


public class VideoUploadInfo {

    private String fileName;
    private String uuid;

    public VideoUploadInfo() {
    }

    public VideoUploadInfo(String fileName, String uuid) {
        this.fileName = fileName;
        this.uuid = uuid;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}