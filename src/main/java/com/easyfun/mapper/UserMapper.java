package com.easyfun.mapper;

import com.easyfun.pojo.User;
import com.google.gson.JsonArray;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Long uid);

    int insert(String phone);

    User selectByPrimaryKey(Long uid);

    List<User> selectAll();

    Long selectUid(User user);

    int updateByPrimaryKey(User row);

    String isPhoneExist(String phone);

    User selectUserInfoPublic(Long uid);

    int modifyUserCoin(@Param("uid") Long uid, @Param("num") int num);

    void updateAttentionList(@Param("uid") Long uid, @Param("attentionList")JsonArray attentionList);

    void modifyUserAttentionNum(@Param("uid") Long uid, @Param("num") int num);

    void modifyUserFollowNum(@Param("uid") Long uid, @Param("num") int num);
}