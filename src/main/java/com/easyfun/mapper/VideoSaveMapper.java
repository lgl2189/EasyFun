package com.easyfun.mapper;

import com.easyfun.pojo.VideoSave;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoSaveMapper {
    int insert(VideoSave row);

    List<VideoSave> selectAll();

    void updateLike(@Param("vid") long vid, @Param("uid") long uid, @Param("isLike") boolean isLike);

    void updateCoinNum(@Param("vid") long vid, @Param("uid") long uid, @Param("coinNum") int coinNum);

    void updateFav(@Param("vid") long vid, @Param("uid") long uid, @Param("isFav") boolean isFav);

    void updateShare(@Param("vid") long vid, @Param("uid") long uid, @Param("isShare") boolean isShare);
}