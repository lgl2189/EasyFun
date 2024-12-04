package com.easyfun.pojo;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Video {
    private Long vid;

    private String videoPath;

    private String title;

    private Long publisherId;

    private String publisherName;

    private Integer likeNum;

    private Integer coinNum;

    private Integer favoriteNum;

    private Integer shareNum;

    private Integer viewNum;

    private Integer danmakuNum;

    private Integer commentNum;

    private LocalDateTime publishDatetime;

    private Boolean isOriginal;

    private String description;

    private LocalTime videoDuration;

    private String coverUuid;

    private JsonArray tagList;

    private Long commentAid;

    private JsonArray danmakuList;

    public Long getVid() {
        return vid;
    }

    public void setVid(Long vid) {
        this.vid = vid;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public Integer getCoinNum() {
        return coinNum;
    }

    public void setCoinNum(Integer coinNum) {
        this.coinNum = coinNum;
    }

    public Integer getFavoriteNum() {
        return favoriteNum;
    }

    public void setFavoriteNum(Integer favoriteNum) {
        this.favoriteNum = favoriteNum;
    }

    public Integer getShareNum() {
        return shareNum;
    }

    public void setShareNum(Integer shareNum) {
        this.shareNum = shareNum;
    }

    public Integer getViewNum() {
        return viewNum;
    }

    public void setViewNum(Integer viewNum) {
        this.viewNum = viewNum;
    }

    public Integer getDanmakuNum() {
        return danmakuNum;
    }

    public void setDanmakuNum(Integer danmakuNum) {
        this.danmakuNum = danmakuNum;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public LocalDateTime getPublishDatetime() {
        return publishDatetime;
    }

    public void setPublishDatetime(LocalDateTime publishDatetime) {
        this.publishDatetime = publishDatetime;
    }

    public Boolean getIsOriginal() {
        return isOriginal;
    }

    public void setIsOriginal(Boolean isOriginal) {
        this.isOriginal = isOriginal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalTime getVideoDuration() {
        return videoDuration;
    }

    public void setVideoDuration(LocalTime videoDuration) {
        this.videoDuration = videoDuration;
    }

    public String getCoverUuid() {
        return coverUuid;
    }

    public void setCoverUuid(String coverUuid) {
        this.coverUuid = coverUuid;
    }

    public JsonArray getTagList() {
        return tagList;
    }

    public void setTagList(JsonArray tagList) {
        this.tagList = tagList;
    }

    public Long getCommentAid() {
        return commentAid;
    }

    public void setCommentAid(Long commentAid) {
        this.commentAid = commentAid;
    }

    public JsonArray getDanmakuList() {
        return danmakuList;
    }

    public void setDanmakuList(JsonArray danmakuList) {
        this.danmakuList = danmakuList;
    }

    @Override
    public String toString() {
        return "Video{" +
                "vid=" + vid +
                ", videoPath='" + videoPath + '\'' +
                ", title='" + title + '\'' +
                ", publisherId=" + publisherId +
                ", publisherName='" + publisherName + '\'' +
                ", likeNum=" + likeNum +
                ", coinNum=" + coinNum +
                ", favoriteNum=" + favoriteNum +
                ", shareNum=" + shareNum +
                ", viewNum=" + viewNum +
                ", danmakuNum=" + danmakuNum +
                ", commentNum=" + commentNum +
                ", publishDatetime=" + publishDatetime +
                ", isOriginal=" + isOriginal +
                ", introduction='" + description + '\'' +
                ", videoDuration=" + videoDuration +
                ", coverPath='" + coverUuid + '\'' +
                ", tagList='" + tagList + '\'' +
                ", commentList='" + commentAid + '\'' +
                ", danmakuList='" + danmakuList + '\'' +
                '}';
    }
}