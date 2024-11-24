package com.easyfun.mapper;

import com.easyfun.pojo.CommentArea;

import java.util.List;

public interface CommentAreaMapper {
    int deleteByPrimaryKey(Long caid);

    int insert(CommentArea row);

    CommentArea selectByPrimaryKey(Long caid);

    List<CommentArea> selectAll();

    int updateByPrimaryKey(CommentArea row);
}