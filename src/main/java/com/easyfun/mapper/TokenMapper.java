package com.easyfun.mapper;

import com.easyfun.pojo.Token;
import java.util.List;

public interface TokenMapper {
    int deleteByPrimaryKey(String token);

    int insert(Token row);

    Token selectByPrimaryKey(String token);

    List<Token> selectAll();

    int updateByPrimaryKey(Token row);
}