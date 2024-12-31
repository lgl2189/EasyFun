package com.easyfun.mapper;

import com.easyfun.pojo.CommentSave;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentSaveMapper {
    int insert(CommentSave row);

    List<CommentSave> selectAll();

    int updateLike(@Param("rpid") Long rpid, @Param("uid") Long uid, @Param("isLike") boolean isLike);

    int updateDislike(@Param("rpid") Long rpid, @Param("uid") Long uid, @Param("isDislike") boolean isDislike);

    CommentSave selectLikeAndDislike(@Param("rpid") Long rpid, @Param("uid") Long uid);
}