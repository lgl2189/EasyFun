package com.easyfun.pojo;

public class CommentSave {
    private Long rpid;

    private Long uid;

    private Long caid;

    private Boolean isLike;

    private Boolean isDislike;

    public Long getRpid() {
        return rpid;
    }

    public void setRpid(Long rpid) {
        this.rpid = rpid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getCaid() {
        return caid;
    }

    public void setCaid(Long caid) {
        this.caid = caid;
    }

    public Boolean getIsLike() {
        return isLike;
    }

    public void setIsLike(Boolean isLike) {
        this.isLike = isLike;
    }

    public Boolean getIsDislike() {
        return isDislike;
    }

    public void setIsDislike(Boolean isDislike) {
        this.isDislike = isDislike;
    }
}