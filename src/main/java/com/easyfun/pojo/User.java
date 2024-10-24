package com.easyfun.pojo;

import java.util.Date;

public class User {

    public User(String phone, String password) {
        this.phone = phone;
        this.password = password;
    }

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.uid
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    private Long uid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.name
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.password
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.phone
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    private String phone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.gender
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    private Integer gender;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.birthday
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    private Date birthday;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.school_name
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    private String schoolName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.signature
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    private String signature;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.vip_status
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    private Boolean vipStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.level
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    private Integer level;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.exp
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    private Integer exp;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.coin
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    private Integer coin;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.follower
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    private Integer follower;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.attention
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    private Integer attention;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.post_number
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    private Integer postNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.now_tag
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    private Long nowTag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.like_number
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    private Integer likeNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.view_number
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    private Integer viewNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.avatar_path
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    private String avatarPath;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.ip_pos
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    private String ipPos;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.uid
     *
     * @return the value of user.uid
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    public Long getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.uid
     *
     * @param uid the value for user.uid
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.name
     *
     * @return the value of user.name
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.name
     *
     * @param name the value for user.name
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.password
     *
     * @return the value of user.password
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.password
     *
     * @param password the value for user.password
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.phone
     *
     * @return the value of user.phone
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.phone
     *
     * @param phone the value for user.phone
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.gender
     *
     * @return the value of user.gender
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.gender
     *
     * @param gender the value for user.gender
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.birthday
     *
     * @return the value of user.birthday
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.birthday
     *
     * @param birthday the value for user.birthday
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.school_name
     *
     * @return the value of user.school_name
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    public String getSchoolName() {
        return schoolName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.school_name
     *
     * @param schoolName the value for user.school_name
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.signature
     *
     * @return the value of user.signature
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    public String getSignature() {
        return signature;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.signature
     *
     * @param signature the value for user.signature
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    public void setSignature(String signature) {
        this.signature = signature;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.vip_status
     *
     * @return the value of user.vip_status
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    public Boolean getVipStatus() {
        return vipStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.vip_status
     *
     * @param vipStatus the value for user.vip_status
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    public void setVipStatus(Boolean vipStatus) {
        this.vipStatus = vipStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.level
     *
     * @return the value of user.level
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.level
     *
     * @param level the value for user.level
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.exp
     *
     * @return the value of user.exp
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    public Integer getExp() {
        return exp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.exp
     *
     * @param exp the value for user.exp
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    public void setExp(Integer exp) {
        this.exp = exp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.coin
     *
     * @return the value of user.coin
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    public Integer getCoin() {
        return coin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.coin
     *
     * @param coin the value for user.coin
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    public void setCoin(Integer coin) {
        this.coin = coin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.follower
     *
     * @return the value of user.follower
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    public Integer getFollower() {
        return follower;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.follower
     *
     * @param follower the value for user.follower
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    public void setFollower(Integer follower) {
        this.follower = follower;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.attention
     *
     * @return the value of user.attention
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    public Integer getAttention() {
        return attention;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.attention
     *
     * @param attention the value for user.attention
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    public void setAttention(Integer attention) {
        this.attention = attention;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.post_number
     *
     * @return the value of user.post_number
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    public Integer getPostNumber() {
        return postNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.post_number
     *
     * @param postNumber the value for user.post_number
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    public void setPostNumber(Integer postNumber) {
        this.postNumber = postNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.now_tag
     *
     * @return the value of user.now_tag
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    public Long getNowTag() {
        return nowTag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.now_tag
     *
     * @param nowTag the value for user.now_tag
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    public void setNowTag(Long nowTag) {
        this.nowTag = nowTag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.like_number
     *
     * @return the value of user.like_number
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    public Integer getLikeNumber() {
        return likeNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.like_number
     *
     * @param likeNumber the value for user.like_number
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    public void setLikeNumber(Integer likeNumber) {
        this.likeNumber = likeNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.view_number
     *
     * @return the value of user.view_number
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    public Integer getViewNumber() {
        return viewNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.view_number
     *
     * @param viewNumber the value for user.view_number
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    public void setViewNumber(Integer viewNumber) {
        this.viewNumber = viewNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.avatar_path
     *
     * @return the value of user.avatar_path
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    public String getAvatarPath() {
        return avatarPath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.avatar_path
     *
     * @param avatarPath the value for user.avatar_path
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.ip_pos
     *
     * @return the value of user.ip_pos
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    public String getIpPos() {
        return ipPos;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.ip_pos
     *
     * @param ipPos the value for user.ip_pos
     *
     * @mbg.generated Wed Oct 23 16:55:01 CST 2024
     */
    public void setIpPos(String ipPos) {
        this.ipPos = ipPos;
    }
}