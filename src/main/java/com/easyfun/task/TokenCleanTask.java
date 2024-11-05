package com.easyfun.task;

import com.easyfun.mapper.TokenMapper;
import com.easyfun.mapper.VerificationTokenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/10/30 下午2:25
 */

@Component
public class TokenCleanTask {

    private final VerificationTokenMapper verificationTokenMapper;
    private final TokenMapper tokenMapper;

    @Autowired
    public TokenCleanTask(VerificationTokenMapper verificationTokenMapper, TokenMapper tokenMapper) {
        Assert.notNull(verificationTokenMapper, "verificationTokenMapper must not be null");
        this.verificationTokenMapper = verificationTokenMapper;
        this.tokenMapper = tokenMapper;
    }

    //秒 分 时 日 月 星期
    @Scheduled(cron = "0 */10 * * * *")
    public void cleanVerificationToken() {
        verificationTokenMapper.deleteExpired();
    }

    @Scheduled(cron = "0 */10 * * * *")
    public void cleanToken() {
        tokenMapper.deleteExpired();
    }
}