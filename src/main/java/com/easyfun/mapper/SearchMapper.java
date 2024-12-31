package com.easyfun.mapper;

import com.easyfun.pojo.Video;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface SearchMapper {

    List<Video> searchVideoTitleByKeywords(@Param("keywords") List<String> keywords);

}