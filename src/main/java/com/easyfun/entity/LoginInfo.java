package com.easyfun.entity;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/10/24 下午5:40
 */


public class LoginInfo {
    private String account;
    private String phone;
    private String password;
    private String verificationCode;

    public LoginInfo(String account, String phone, String password, String verificationCode) {
        this.account = account;
        this.phone = phone;
        this.password = password;
        this.verificationCode = verificationCode;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }
}