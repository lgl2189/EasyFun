package com.easyfun.pojo;

import java.time.LocalDateTime;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/10/27 下午2:36
 */


public class Token {

    private String token;
    private Long uid;
    private LocalDateTime expireDate;

    public Token(String token, Long uid) {
        this.token = token;
        this.uid = uid;
        this.expireDate = LocalDateTime.now().plusDays(1);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public LocalDateTime getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDateTime expireDate) {
        this.expireDate = expireDate;
    }
}