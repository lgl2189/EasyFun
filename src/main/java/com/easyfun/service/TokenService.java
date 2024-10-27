package com.easyfun.service;

import com.easyfun.mapper.TokenMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/10/27 下午3:08
 */


public class TokenService {

    @Autowired
    private TokenMapper tokenMapper;

    public Boolean searchByToken(String token) {
        // TODO: 根据token查询用户信息
        tokenMapper.selectByPrimaryKey("1");
        return true;
    }

}