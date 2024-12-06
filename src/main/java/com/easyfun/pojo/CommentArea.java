package com.easyfun.pojo;

public class CommentArea {
    private Long caid;

    private Integer type;

    public CommentArea() {
    }

    public CommentArea(Long caid, Integer type) {
        this.caid = caid;
        this.type = type;
    }

    public Long getCaid() {
        return caid;
    }

    public void setCaid(Long caid) {
        this.caid = caid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}