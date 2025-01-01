package com.easyfun.mapper;

import com.easyfun.pojo.Video;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VideoMapper {
    int deleteByPrimaryKey(Long vid);

    int insert(Video row);

    Video selectByPrimaryKey(Long vid);

    String selectVideoUrlByPrimaryKey(Long vid);

    List<Video> selectRandomVideoSimple(int count);

    List<Video> selectAll();

    int updateByPrimaryKey(Video row);

    Long getMaxVid();

    void adjustLikeNum(@Param("vid") Long vid, @Param("likeNum") int likeNum);

    void adjustCoinNum(@Param("vid") Long vid, @Param("coinNum") int CoinNum);

    void adjustFavoriteNum(@Param("vid") Long vid, @Param("favoriteNum") int favoriteNum);

    void adjustShareNum(@Param("vid") Long vid, @Param("shareNum") int shareNum);

    List<Video> selectByPublisherUid(@Param("publisherUid") Long publisherUid);

    List<Video> selectUploadVideosByView(@Param("publisherUid") Long publisherUid,@Param("num") Integer num);

}