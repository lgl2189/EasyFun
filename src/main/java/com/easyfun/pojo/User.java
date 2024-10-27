package com.easyfun.pojo;

import java.util.Date;

public class User {
    private Long uid;

    private String name;

    private String password;

    private String phone;

    private Integer gender;

    private Date birthday;

    private String schoolName;

    private String signature;

    private Boolean vipStatus;

    private Integer level;

    private Integer exp;

    private Integer coin;

    private Integer follower;

    private Integer attention;

    private Integer postNumber;

    private Long nowTag;

    private Integer likeNumber;

    private Integer viewNumber;

    private String avatarPath;

    private String ipPos;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Boolean getVipStatus() {
        return vipStatus;
    }

    public void setVipStatus(Boolean vipStatus) {
        this.vipStatus = vipStatus;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public Integer getCoin() {
        return coin;
    }

    public void setCoin(Integer coin) {
        this.coin = coin;
    }

    public Integer getFollower() {
        return follower;
    }

    public void setFollower(Integer follower) {
        this.follower = follower;
    }

    public Integer getAttention() {
        return attention;
    }

    public void setAttention(Integer attention) {
        this.attention = attention;
    }

    public Integer getPostNumber() {
        return postNumber;
    }

    public void setPostNumber(Integer postNumber) {
        this.postNumber = postNumber;
    }

    public Long getNowTag() {
        return nowTag;
    }

    public void setNowTag(Long nowTag) {
        this.nowTag = nowTag;
    }

    public Integer getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(Integer likeNumber) {
        this.likeNumber = likeNumber;
    }

    public Integer getViewNumber() {
        return viewNumber;
    }

    public void setViewNumber(Integer viewNumber) {
        this.viewNumber = viewNumber;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    public String getIpPos() {
        return ipPos;
    }

    public void setIpPos(String ipPos) {
        this.ipPos = ipPos;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", schoolName='" + schoolName + '\'' +
                ", signature='" + signature + '\'' +
                ", vipStatus=" + vipStatus +
                ", level=" + level +
                ", exp=" + exp +
                ", coin=" + coin +
                ", follower=" + follower +
                ", attention=" + attention +
                ", postNumber=" + postNumber +
                ", nowTag=" + nowTag +
                ", likeNumber=" + likeNumber +
                ", viewNumber=" + viewNumber +
                ", avatarPath='" + avatarPath + '\'' +
                ", ipPos='" + ipPos + '\'' +
                '}';
    }
}