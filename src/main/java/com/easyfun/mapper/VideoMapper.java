package com.easyfun.mapper;

import com.easyfun.pojo.Video;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VideoMapper {
    int deleteByPrimaryKey(Long vid);

    int insert(Video row);

    Video selectByPrimaryKey(Long vid);

    List<Video> selectAll();

    int updateByPrimaryKey(Video row);
}