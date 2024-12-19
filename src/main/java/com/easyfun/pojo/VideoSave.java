package com.easyfun.pojo;

public class VideoSave {
    private Long vid;

    private Long uid;

    private Boolean isLike = false;

    private Integer coinNum = 0;

    private Boolean isFav =false;

    private Boolean isShare = false;

    public VideoSave() {
    }

    public VideoSave(Long vid, Long uid, Boolean isLike, Integer coinNum, Boolean isFav, Boolean isShare) {
        this.vid = vid;
        this.uid = uid;
        this.isLike = isLike;
        this.coinNum = coinNum;
        this.isFav = isFav;
        this.isShare = isShare;
    }

    public Long getVid() {
        return vid;
    }

    public void setVid(Long vid) {
        this.vid = vid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Boolean getIsLike() {
        return isLike;
    }

    public void setIsLike(Boolean isLike) {
        this.isLike = isLike;
    }

    public Integer getCoinNum() {
        return coinNum;
    }

    public void setCoinNum(Integer coinNum) {
        this.coinNum = coinNum;
    }

    public Boolean getIsFav() {
        return isFav;
    }

    public void setIsFav(Boolean isFav) {
        this.isFav = isFav;
    }

    public Boolean getIsShare() {
        return isShare;
    }

    public void setIsShare(Boolean isShare) {
        this.isShare = isShare;
    }

    @Override
    public String toString() {
        return "VideoSave{" +
                "vid=" + vid +
                ", uid=" + uid +
                ", isLike=" + isLike +
                ", coinNum=" + coinNum +
                ", isFav=" + isFav +
                ", isShare=" + isShare +
                '}';
    }
}