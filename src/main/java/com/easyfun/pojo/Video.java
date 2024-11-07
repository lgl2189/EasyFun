package com.easyfun.pojo;

import java.util.Date;
import java.util.Map;

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

    private Date publishDatetime;

    private Boolean isOriginal;

    private String introduction;

    private Date videoDuration;

    private String coverPath;

    private Map<String, String> tagList;

    private String commentList;

    private String danmakuList;

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

    public Date getPublishDatetime() {
        return publishDatetime;
    }

    public void setPublishDatetime(Date publishDatetime) {
        this.publishDatetime = publishDatetime;
    }

    public Boolean getIsOriginal() {
        return isOriginal;
    }

    public void setIsOriginal(Boolean isOriginal) {
        this.isOriginal = isOriginal;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Date getVideoDuration() {
        return videoDuration;
    }

    public void setVideoDuration(Date videoDuration) {
        this.videoDuration = videoDuration;
    }

    public String getCoverPath() {
        return coverPath;
    }

    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath;
    }

    public Map<String, String> getTagList() {
        return tagList;
    }

    public void setTagList(Map<String, String> tagList) {
        this.tagList = tagList;
    }

    public String getCommentList() {
        return commentList;
    }

    public void setCommentList(String commentList) {
        this.commentList = commentList;
    }

    public String getDanmakuList() {
        return danmakuList;
    }

    public void setDanmakuList(String danmakuList) {
        this.danmakuList = danmakuList;
    }
}