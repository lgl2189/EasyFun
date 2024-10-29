package com.easyfun.util;

import org.apache.commons.text.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * @author ：李冠良
 * @description： 用于生成各种Token
 * @date ：2024/10/28 下午11:37
 */

@Component
public class TokenGenerator {

    private final RandomStringGenerator randomStringGenerator;

    private static final int VERIFY_TOKEN_DEFAULT_LENGTH = 50;
    private static final int ACCOUNT_RANDOM_STR_LENGTH = 30;
    private static final int UID_LENGTH = 20;



    @Autowired
    public TokenGenerator(RandomStringGenerator randomStringGenerator) {
        Assert.notNull(randomStringGenerator, "randomStringGenerator must not be null");
        this.randomStringGenerator = randomStringGenerator;
    }

    public String generateAccountTokenValue(Long uid) {
        // 生成token值
        int uidLength = String.valueOf(uid).length();
        String zeroPadding = "0".repeat(UID_LENGTH - uidLength);
        return randomStringGenerator.generate(ACCOUNT_RANDOM_STR_LENGTH) + zeroPadding + uid;
    }

    public String generateLoginToken() {
        return randomStringGenerator.generate(VERIFY_TOKEN_DEFAULT_LENGTH);
    }
}