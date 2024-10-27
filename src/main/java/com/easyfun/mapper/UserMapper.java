package com.easyfun.mapper;

import com.easyfun.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Long uid);

    int insert(User row);

    User selectByPrimaryKey(Long uid);

    List<User> selectAll();

    int updateByPrimaryKey(User row);
}