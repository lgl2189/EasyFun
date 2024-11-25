package com.easyfun.pojo;

import com.google.gson.JsonArray;

import java.util.Date;

public class User {
    private Long uid;

    private String name;

    private String password;

    private String phone;

    private String email;

    private Integer gender;

    private Date birthday;

    private String schoolName;

    private String signature;

    private Boolean vipStatus;

    private Integer level;

    private Integer exp;

    private Integer coin;

    private Integer followerNum;

    private Integer attentionNum;

    private Integer postNum;

    private Long nowTag;

    private Integer likeNum;

    private Integer viewNum;

    private String avatarUuid;

    private String ipPos;

    public JsonArray tagList;

    public JsonArray followList;

    public JsonArray attentionList;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Integer getFollowerNum() {
        return followerNum;
    }

    public void setFollowerNum(Integer followerNum) {
        this.followerNum = followerNum;
    }

    public Integer getAttentionNum() {
        return attentionNum;
    }

    public void setAttentionNum(Integer attentionNum) {
        this.attentionNum = attentionNum;
    }

    public Integer getPostNum() {
        return postNum;
    }

    public void setPostNum(Integer postNum) {
        this.postNum = postNum;
    }

    public Long getNowTag() {
        return nowTag;
    }

    public void setNowTag(Long nowTag) {
        this.nowTag = nowTag;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public Integer getViewNum() {
        return viewNum;
    }

    public void setViewNum(Integer viewNum) {
        this.viewNum = viewNum;
    }

    public String getAvatarUuid() {
        return avatarUuid;
    }

    public void setAvatarUuid(String avatarUuid) {
        this.avatarUuid = avatarUuid;
    }

    public String getIpPos() {
        return ipPos;
    }

    public void setIpPos(String ipPos) {
        this.ipPos = ipPos;
    }

    public JsonArray getTagList() {
        return tagList;
    }

    public void setTagList(JsonArray tagList) {
        this.tagList = tagList;
    }

    public JsonArray getFollowList() {
        return followList;
    }

    public void setFollowList(JsonArray followList) {
        this.followList = followList;
    }

    public JsonArray getAttentionList() {
        return attentionList;
    }

    public void setAttentionList(JsonArray attentionList) {
        this.attentionList = attentionList;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", schoolName='" + schoolName + '\'' +
                ", signature='" + signature + '\'' +
                ", vipStatus=" + vipStatus +
                ", level=" + level +
                ", exp=" + exp +
                ", coin=" + coin +
                ", followerNum=" + followerNum +
                ", attentionNum=" + attentionNum +
                ", postNum=" + postNum +
                ", nowTag=" + nowTag +
                ", likeNum=" + likeNum +
                ", viewNum=" + viewNum +
                ", avatarUuid='" + avatarUuid + '\'' +
                ", ipPos='" + ipPos + '\'' +
                ", tagList=" + tagList +
                ", followList=" + followList +
                ", attentionList=" + attentionList +
                '}';
    }
}