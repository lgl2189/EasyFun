package com.easyfun.mapper;

import com.easyfun.pojo.CommentArea;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentAreaMapper {
    int deleteByPrimaryKey(Long caid);

    int insert(CommentArea row);

    CommentArea selectByPrimaryKey(Long caid);

    List<CommentArea> selectAll();

    int updateByPrimaryKey(CommentArea row);

    Long getMaxCaid();
}