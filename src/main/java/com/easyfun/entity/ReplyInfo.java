package com.easyfun.entity;

import com.easyfun.pojo.Reply;
import com.easyfun.pojo.User;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/11/24 上午10:23
 */


public class ReplyInfo {
    private Long rpid;

    private Long oid;

    private String status;

    private Long mid;

    private Long root;

    private Long parent;

    private LocalDateTime ctime;

    private Integer likeNum;

    private Integer dislikeNum;

    private ReplyContent content;

    private String type;

    private int replyNum;

    User member;

    List<ReplyInfo> replyList;

    public ReplyInfo() {
    }

    public ReplyInfo(Reply reply, User member, List<ReplyInfo> replyList) {
        this.rpid = reply.getRpid();
        this.oid = reply.getOid();
        this.status = reply.getStatus();
        this.mid = reply.getMid();
        this.root = reply.getRoot();
        this.parent = reply.getParent();
        this.ctime = reply.getCtime();
        this.likeNum = reply.getLikeNum();
        this.dislikeNum = reply.getDislikeNum();
        this.content = new ReplyContent();
        this.content.setMessage(reply.getContent());
        this.type = reply.getType();
        this.replyNum = reply.getReplyNum();
        this.member = member;
        this.replyList = replyList;
    }

    public Long getRpid() {
        return rpid;
    }

    public void setRpid(Long rpid) {
        this.rpid = rpid;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public Long getRoot() {
        return root;
    }

    public void setRoot(Long root) {
        this.root = root;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public LocalDateTime getCtime() {
        return ctime;
    }

    public void setCtime(LocalDateTime ctime) {
        this.ctime = ctime;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public Integer getDislikeNum() {
        return dislikeNum;
    }

    public void setDislikeNum(Integer dislikeNum) {
        this.dislikeNum = dislikeNum;
    }

    public ReplyContent getContent() {
        return content;
    }

    public void setContent(ReplyContent content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getMember() {
        return member;
    }

    public void setMember(User member) {
        this.member = member;
    }

    public List<ReplyInfo> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<ReplyInfo> replyList) {
        this.replyList = replyList;
    }

    public int getReplyNum() {
        return replyNum;
    }

    public void setReplyNum(int replyNum) {
        this.replyNum = replyNum;
    }

    @Override
    public String toString() {
        return "ReplyInfo{" +
                "rpid=" + rpid +
                ", oid=" + oid +
                ", status='" + status + '\'' +
                ", mid=" + mid +
                ", root=" + root +
                ", parent=" + parent +
                ", ctime=" + ctime +
                ", likeNum=" + likeNum +
                ", dislikeNum=" + dislikeNum +
                ", content=" + content +
                ", type='" + type + '\'' +
                ", replyNum=" + replyNum +
                ", member=" + member +
                ", replyList=" + replyList +
                '}';
    }
}