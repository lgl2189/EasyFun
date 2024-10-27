package com.easyfun.entity;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/10/27 下午2:07
 */


public class DataWrapper {
    private Object data;
    private String status;
    private String message;

    public DataWrapper(Object data) {
        this.data = data;
    }

    public DataWrapper(Object data, String status, String message) {
        this.data = data;
        this.status = status;
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}