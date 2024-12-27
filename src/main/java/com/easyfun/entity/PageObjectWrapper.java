package com.easyfun.entity;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/12/27 上午11:22
 */


public class PageObjectWrapper <T>{
    private T object;
    private int pageNum;
    private int pageSize;
    private int total;

    public PageObjectWrapper() {
    }

    public PageObjectWrapper(T object, int pageNum, int pageSize, int total) {
        this.object = object;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "PageObjectWrapper{" +
                "object=" + object +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", total=" + total +
                '}';
    }
}