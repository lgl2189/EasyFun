package com.easyfun.mapper;

import com.easyfun.pojo.VideoSave;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VideoSaveMapper {
    int insert(VideoSave row);

    List<VideoSave> selectAll();

    VideoSave select(@Param("vid") long vid, @Param("uid") long uid);

    int updateLike(@Param("vid") long vid, @Param("uid") long uid, @Param("isLike") boolean isLike);

    int updateCoinNum(@Param("vid") long vid, @Param("uid") long uid, @Param("coinNum") int coinNum);

    int updateFav(@Param("vid") long vid, @Param("uid") long uid, @Param("isFav") boolean isFav);

    int updateShare(@Param("vid") long vid, @Param("uid") long uid, @Param("isShare") boolean isShare);
}