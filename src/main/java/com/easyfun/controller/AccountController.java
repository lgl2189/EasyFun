package com.easyfun.controller;

import com.easyfun.entity.JsonDataWrapper;
import com.easyfun.mapper.UserMapper;
import com.easyfun.pojo.User;
import com.easyfun.service.TokenService;
import com.easyfun.service.UserService;
import com.easyfun.util.JsonDataWrapperUtil;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/10/24 下午5:27
 */

@Controller
@RequestMapping("/account")
public class AccountController {

    private final TokenService tokenService;
    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public AccountController(TokenService tokenService, UserService userService, UserMapper userMapper) {
        Assert.notNull(tokenService, "tokenService must not be null");
        Assert.notNull(userService, "userService must not be null");
        this.tokenService = tokenService;
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/get/loginToken")
    public @ResponseBody JsonDataWrapper getLoginToken() {
        String loginToken = tokenService.getVerificationToken(LocalDateTime.now().plusHours(6));
        Map<String, String> resMap = new HashMap<>();
        resMap.put("login_token", loginToken);
        return JsonDataWrapperUtil.success_200(resMap);
    }

    @PostMapping("/login/pass")
    public @ResponseBody JsonDataWrapper loginByPass(@RequestBody Map<String, String> reqMap) {
        String phone = reqMap.get("phone");
        String password = reqMap.get("password");
        String loginToken = reqMap.get("login_token");
        // TODO: 校验login_token是否存在于数据库
        if (!tokenService.isVerificationTokenExist(loginToken)) {
            return JsonDataWrapperUtil.fail_402(null);
        }
        //校验密码是否正确
        User user = new User();
        user.setPhone(phone);
        Long uid = userService.getUid(user);
        //TODO:返回不同信息
        if (uid == null) {
            return JsonDataWrapperUtil.fail_402(null);
        }
        if (!userService.isPasswordRight(uid, password)) {
            return JsonDataWrapperUtil.fail_402(null);
        }
        String token = tokenService.insertToken(uid);
        tokenService.deleteVerificationToken(loginToken);
        Map<String, String> resMap = new HashMap<>();
        resMap.put("account_token", token);
        return JsonDataWrapperUtil.success_200(resMap);
    }

    @PostMapping("/login/phone")
    public @ResponseBody JsonDataWrapper loginByPhone(@RequestBody Map<String, String> reqMap) {
        String phone = reqMap.get("phone");
        String verificationCode = reqMap.get("verification_code");
        String loginToken = reqMap.get("login_token");
        // TODO: 校验login_token是否存在于数据库
        if (!tokenService.isVerificationTokenExist(loginToken)) {
            return JsonDataWrapperUtil.fail_402(null);
        }
        //校验手机号是否已注册
        boolean isPhoneUsed = userService.registerUser(phone);
        //校验验证码是否正确
        if (!verificationCode.equals("1234")) {
            return JsonDataWrapperUtil.fail_402(null);
        }
        User user = new User();
        user.setPhone(phone);
        Long uid = userService.getUid(user);
        if (uid == null) {
            return JsonDataWrapperUtil.fail_403(null);
        }
        String token = tokenService.insertToken(uid);
        tokenService.deleteVerificationToken(loginToken);
        boolean hasPassword = userService.hasPassword(uid);
        Map<String, String> resMap = new HashMap<>();
        resMap.put("new_user", String.valueOf(!isPhoneUsed));
        resMap.put("has_password", String.valueOf(hasPassword));
        resMap.put("account_token", token);
        return JsonDataWrapperUtil.success_200(resMap);
    }

    @PostMapping("/login/token")
    public @ResponseBody JsonDataWrapper loginByToken(@RequestBody Map<String, String> reqMap) {
        String loginToken = reqMap.get("account_token");
        if (tokenService.isTokenExpired(loginToken)) {
            return JsonDataWrapperUtil.fail_402(null);
        }
        //token未过期，验证通过
        return JsonDataWrapperUtil.success_200(null);
    }

    @PostMapping("/change/password")
    public @ResponseBody JsonDataWrapper changePassword(@RequestBody Map<String, String> reqMap) {
        String accountToken = reqMap.get("account_token");
        String password = reqMap.get("password");
        Long uid = tokenService.getUidByToken(accountToken);
        if (uid == null) {
            return JsonDataWrapperUtil.fail_402(null);
        }
        if (!userService.changePassword(uid, UserService.DEFAULT_PASSWORD, password)) {
            return JsonDataWrapperUtil.fail_402(null);
        }
        ;
        return JsonDataWrapperUtil.success_200(null);
    }

    @PostMapping("/logout")
    public @ResponseBody JsonDataWrapper logout(@RequestBody Map<String, String> resMap) {
        String accountToken = resMap.get("account_token");
        tokenService.deleteToken(accountToken);
        return JsonDataWrapperUtil.success_200(null);
    }
}