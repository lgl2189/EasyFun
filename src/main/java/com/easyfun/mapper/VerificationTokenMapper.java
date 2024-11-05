package com.easyfun.mapper;

import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface VerificationTokenMapper {
    int insert(@Param("tokenValue") String tokenValue,@Param("expireDatetime") LocalDateTime expireDatetime);

    String selectByTokenValue(String tokenValue);

    int deleteByTokenValue(String tokenValue);

    int deleteExpired();
}