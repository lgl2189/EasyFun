package com.easyfun.mapper;

import com.easyfun.pojo.User;
import org.apache.ibatis.annotations.Mapper;

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
}