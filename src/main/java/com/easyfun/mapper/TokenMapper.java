package com.easyfun.mapper;

import com.easyfun.pojo.Token;

import java.util.List;

public interface TokenMapper {
    int deleteByPrimaryKey(String token);

    int insert(Token row);

    Token selectByPrimaryKey(String token);

    List<Token> selectAll();

    /**
     * 更新token信息，只会更新uid和token两个字段，其中为空的字段不会更新，当后两列均为空时，不会更新任何字段
     * @param row 新的Token对象
     * @return 更新的行数
     */
    int updateByPrimaryKey(Token row);
}