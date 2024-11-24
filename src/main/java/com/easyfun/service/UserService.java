package com.easyfun.service;

import com.easyfun.mapper.UserMapper;
import com.easyfun.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/11/22 下午4:21
 */
@Service
public class UserService {
    private UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        Assert.notNull(userMapper, "userMapper must not be null");
        this.userMapper = userMapper;
    }

    public User getUserInfoPublic(long uid) {
        return userMapper.selectUserInfoPublic(uid);
    }

    public User getUserInfoPrivate(long uid) {
        return userMapper.selectByPrimaryKey(uid);
    }
}