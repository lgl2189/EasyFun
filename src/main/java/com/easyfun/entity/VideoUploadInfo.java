package com.easyfun.entity;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/12/4 下午6:12
 */


public class VideoUploadInfo {

    private String name;
    private String uuid;
    private byte[] videoFile;
    private byte[] coverFile;

    public VideoUploadInfo() {
    }

    public VideoUploadInfo(String name, String uuid, byte[] videoFile, byte[] coverFile) {
        this.name = name;
        this.uuid = uuid;
        this.videoFile = videoFile;
        this.coverFile = coverFile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public byte[] getVideoFile() {
        return videoFile;
    }

    public void setVideoFile(byte[] videoFile) {
        this.videoFile = videoFile;
    }

    public byte[] getCoverFile() {
        return coverFile;
    }

    public void setCoverFile(byte[] coverFile) {
        this.coverFile = coverFile;
    }
}