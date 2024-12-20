package com.easyfun.mapper;

import com.easyfun.pojo.Reply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReplyMapper {
    int deleteByPrimaryKey(Long rpid);

    int insert(Reply row);

    Reply selectByPrimaryKey(Long rpid);

    List<Reply> selectAllFirstReply(Long oid);

    List<Reply> selectPartFirstReply(@Param("oid") Long oid,@Param("num") int num);

    List<Reply> selectPartSecondaryReply(@Param("oid") Long oid,@Param("num") int num);

    List<Reply> selectAllSecondaryReply(Long oid);

    List<Reply> selectAllSpecificSecondaryReply(@Param("oid") Long oid,@Param("root") Long root);

    List<Reply> selectPartSpecificSecondaryReply(@Param("oid") Long oid,@Param("root") Long root,@Param("num") int num);

    List<Reply> selectAll();

    int updateByPrimaryKey(Reply row);

    void updateReplyNum(@Param("oid") Long oid,@Param("root") Long root,@Param("parent") Long parent);
}