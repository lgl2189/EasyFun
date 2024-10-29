package com.easyfun.pojo;

import java.time.LocalDateTime;

public class Token {

    private String tokenValue;

    private Long uid;

    private LocalDateTime expireDatetime;

    /**
     * Constructor，生成一个Token对象，默认有效期为1天
     * @param tokenValue token值
     * @param uid 所属用户的uid
     */
    public Token(String tokenValue, Long uid) {
        this.tokenValue = tokenValue;
        this.uid = uid;
        this.expireDatetime = LocalDateTime.now().plusDays(1);
    }

    public String getTokenValue() {
        return tokenValue;
    }

    public void setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public LocalDateTime getExpireDatetime() {
        return expireDatetime;
    }

    public void setExpireDatetime(LocalDateTime expireDatetime) {
        this.expireDatetime = expireDatetime;
    }

    @Override
    public String toString() {
        return "Token{" +
                "token='" + tokenValue + '\'' +
                ", uid=" + uid +
                ", expireDate=" + expireDatetime +
                '}';
    }
}