package com.easyfun.pojo;

import java.time.LocalDateTime;

public class Reply {
    private Long rpid;

    private Long oid;

    private String status;

    private Long mid;

    private Long root;

    private Long parent;

    private LocalDateTime ctime;

    private Integer likeNum;

    private Integer dislikeNum;

    private String content;

    private String type;

    private int replyNum;

    public Reply() {
    }

    public Reply(Long rpid, Long oid, String status, Long mid, Long root, Long parent, LocalDateTime ctime, Integer likeNum, Integer dislikeNum, String content, String type,Integer replyNum) {
        this.rpid = rpid;
        this.oid = oid;
        this.status = status;
        this.mid = mid;
        this.root = root;
        this.parent = parent;
        this.ctime = ctime;
        this.likeNum = likeNum;
        this.dislikeNum = dislikeNum;
        this.content = content;
        this.type = type;
        this.replyNum = replyNum;
    }

    public Reply(Long oid, String status, Long mid, Long root, Long parent, LocalDateTime ctime, Integer likeNum, Integer dislikeNum, String content, String type,Integer replyNum) {
        this.oid = oid;
        this.status = status;
        this.mid = mid;
        this.root = root;
        this.parent = parent;
        this.ctime = ctime;
        this.likeNum = likeNum;
        this.dislikeNum = dislikeNum;
        this.content = content;
        this.type = type;
        this.replyNum = replyNum;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getReplyNum() {
        return replyNum;
    }

    public void setReplyNum(int replyNum) {
        this.replyNum = replyNum;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "rpid=" + rpid +
                ", oid=" + oid +
                ", status='" + status + '\'' +
                ", mid=" + mid +
                ", root=" + root +
                ", parent=" + parent +
                ", ctime=" + ctime +
                ", likeNum=" + likeNum +
                ", dislikeNum=" + dislikeNum +
                ", content='" + content + '\'' +
                ", type='" + type + '\'' +
                ", reply_num=" + replyNum +
                '}';
    }
}