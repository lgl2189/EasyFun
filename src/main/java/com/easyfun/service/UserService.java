package com.easyfun.service;

import com.easyfun.mapper.UserMapper;
import com.easyfun.pojo.User;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/10/27 下午5:57
 */

@Service
public class UserService {

    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        Assert.notNull(userMapper, "userMapper must not be null");
        this.userMapper = userMapper;
    }

    /**
     * 根据姓名、手机号、邮箱中第一个不为空的参数获取uid
     * @param user 包含用户信息的User对象
     * @return uid。如果姓名、手机号、邮箱都为空，返回null
     */
    public Long getUid(User user) {
        String name = user.getName();
        String phone = user.getPhone();
        String email = user.getEmail();
        if ((name != null && !name.isEmpty())
                || (phone != null && !phone.isEmpty())
                || (email != null && !email.isEmpty())
        ) {
            return userMapper.selectUid(user);
        }
        return null;
    }
}