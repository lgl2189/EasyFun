package com.easyfun.mapper;

import com.easyfun.pojo.Token;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TokenMapper {
    int deleteByPrimaryKey(String token);

    int insert(Token row);

    Token selectByPrimaryKey(String token);

    List<Token> selectAll();

    int updateByPrimaryKey(Token row);
}