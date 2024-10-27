package com.easyfun.mapper;

import com.easyfun.pojo.User;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Long uid);

    int insert(User row);

    User selectByPrimaryKey(Long uid);

    List<User> selectAll();

    int updateByPrimaryKey(User row);
}