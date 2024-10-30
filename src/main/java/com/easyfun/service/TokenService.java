package com.easyfun.service;

import com.easyfun.mapper.TokenMapper;
import com.easyfun.mapper.VerificationTokenMapper;
import com.easyfun.pojo.Token;
import com.easyfun.util.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

/**
 * @author ：李冠良
 * @description ： 用于各种token相关的操作，其中token特指用户保持登录状态的token
 * @date ：2024/10/27 下午3:08
 */

@Service
public class TokenService {

    private final TokenMapper tokenMapper;
    private final VerificationTokenMapper verificationTokenMapper;
    private final TokenGenerator tokenGenerator;

    @Autowired
    public TokenService(TokenMapper tokenMapper, VerificationTokenMapper verificationTokenMapper, TokenGenerator tokenGenerator) {
        Assert.notNull(tokenMapper, "tokenMapper must not be null");
        Assert.notNull(verificationTokenMapper, "verificationTokenMapper must not be null");
        Assert.notNull(tokenGenerator, "randomStringGenerator must not be null");
        this.tokenMapper = tokenMapper;
        this.verificationTokenMapper = verificationTokenMapper;
        this.tokenGenerator = tokenGenerator;
    }

    /**
     * 向数据库中插入token
     *
     * @param uid token所属的用户的uid
     */
    public String insertToken(Long uid) {
        String tokenValue = tokenGenerator.generateAccountTokenValue(uid);
        Token token = new Token(tokenValue, uid);
        tokenMapper.insert(token);
        return token.getTokenValue();
    }

    /**
     * 查询token是否存在且未过期
     *
     * @param tokenValue
     * @return true：存在且未过期；false：不存在或已过期
     */
    public Boolean searchByToken(String tokenValue) {
        // 根据token查询用户信息
        Token token = tokenMapper.selectByPrimaryKey(tokenValue);
        // 如果token不存在或已过期，则返回false
        if (token == null) {
            return false;
        }
        if (!isTokenActive(token)) {
            tokenMapper.deleteByPrimaryKey(tokenValue);
            return false;
        }
        // 刷新token的过期时间
        refreshToken(token);
        return true;
    }

    /**
     * 刷新token的过期时间，将过期时间设置为1天后
     *
     * @param token 要刷新的token对象
     */
    public void refreshToken(Token token) {
        token.setExpireDatetime(LocalDateTime.now().plusDays(1));
        tokenMapper.updateByPrimaryKey(token);
    }

    /**
     * 验证登录token是否有效
     *
     * @param tokenInfo 要验证的登录token的信息
     * @return true：有效；false：无效，token已过期
     */
    private boolean isTokenActive(@NonNull Token tokenInfo) {
        LocalDateTime expireDateTime = tokenInfo.getExpireDatetime();
        LocalDateTime now = LocalDateTime.now();
        return expireDateTime.isAfter(now);
    }

    //verificationToken相关操作
    public boolean isVerificationTokenExist(String tokenValue) {
        return verificationTokenMapper.selectByTokenValue(tokenValue) != null;
    }

    public String getVerificationToken(LocalDateTime expireDatetime) {
        String tokenValue = tokenGenerator.generateVerificationTokenValue();
        while (isVerificationTokenExist(tokenValue)) {
            tokenValue = tokenGenerator.generateVerificationTokenValue();
        }
        verificationTokenMapper.insert(tokenValue,expireDatetime);
        return tokenValue;
    }

    public void deleteVerificationToken(String tokenValue) {
        verificationTokenMapper.deleteByTokenValue(tokenValue);
    }
}