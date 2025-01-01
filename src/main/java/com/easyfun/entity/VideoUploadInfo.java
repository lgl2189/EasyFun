package com.easyfun.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/12/4 下午6:12
 */


public class VideoUploadInfo {

    /**
     * 上传文件的原文件名，冗余字段
     */
    private String name;
    private String uuid;
    /**
     * 视频的标题
     */
    private String title;
    private boolean type;
    private List<String> tagList;
    private String description;
    private byte[] videoFile;
    private byte[] coverFile;
    private long publisherUid;
    private String publisherName;
    private String duration;

    public VideoUploadInfo() {
    }

    public VideoUploadInfo(String name, String uuid, String title, boolean type, List<String> tagList, String description, byte[] videoFile, byte[] coverFile, long publisherUid, String publisherName, String duration) {
        this.name = name;
        this.uuid = uuid;
        this.title = title;
        this.type = type;
        this.tagList = tagList;
        this.description = description;
        this.videoFile = videoFile;
        this.coverFile = coverFile;
        this.publisherUid = publisherUid;
        this.publisherName = publisherName;
        this.duration = duration;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public List<String> getTagList() {
        return tagList;
    }

    public void setTagList(List<String> tagList) {
        this.tagList = tagList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public long getPublisherUid() {
        return publisherUid;
    }

    public void setPublisherUid(long publisherUid) {
        this.publisherUid = publisherUid;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "VideoUploadInfo{" +
                "name='" + name + '\'' +
                ", uuid='" + uuid + '\'' +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", tagList=" + tagList +
                ", description='" + description + '\'' +
                ", videoFile=" + Arrays.toString(videoFile) +
                ", coverFile=" + Arrays.toString(coverFile) +
                ", publisherUid=" + publisherUid +
                ", publisherName='" + publisherName + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}