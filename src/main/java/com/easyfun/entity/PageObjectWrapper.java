package com.easyfun.entity;

import com.github.pagehelper.PageInfo;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/12/27 上午11:22
 */

/**
 *
 * @param <T> 包裹的查询结果的类型 例如：List<User>
 * @param <E> 包裹的查询结果的一个元素的类型 例如：User
 */
public class PageObjectWrapper <T,E>{
    private T object;
    private PageInfo<E> pageInfo;

    public PageObjectWrapper() {
    }

    public PageObjectWrapper(T object, PageInfo<E> pageInfo) {
        this.object = object;
        this.pageInfo = pageInfo;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public PageInfo<E> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<E> pageInfo) {
        this.pageInfo = pageInfo;
    }

    @Override
    public String toString() {
        return "PageObjectWrapper{" +
                "object=" + object +
                ", pageInfo=" + pageInfo +
                '}';
    }
}