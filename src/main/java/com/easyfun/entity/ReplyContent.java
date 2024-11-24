package com.easyfun.entity;

import com.easyfun.pojo.User;

import java.util.List;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/11/24 下午12:42
 */


public class ReplyContent {

    private String message;
    private List<User> memberList;
    private List<String> emoteList;

    public ReplyContent() {
    }

    public ReplyContent(String message, List<User> memberList, List<String> emoteList) {
        this.message = message;
        this.memberList = memberList;
        this.emoteList = emoteList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<User> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<User> memberList) {
        this.memberList = memberList;
    }

    public List<String> getEmoteList() {
        return emoteList;
    }

    public void setEmoteList(List<String> emoteList) {
        this.emoteList = emoteList;
    }

    @Override
    public String toString() {
        return "ReplyContent{" +
                "message='" + message + '\'' +
                ", memberList=" + memberList +
                ", emoteList=" + emoteList +
                '}';
    }
}