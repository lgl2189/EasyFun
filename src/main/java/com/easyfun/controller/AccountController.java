package com.easyfun.controller;

import com.easyfun.entity.JsonDataWrapper;
import com.easyfun.pojo.User;
import com.easyfun.service.TokenService;
import com.easyfun.service.UserService;
import com.easyfun.util.JsonDataWrapperUtil;
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

    @Autowired
    public AccountController(TokenService tokenService, UserService userService) {
        Assert.notNull(tokenService, "tokenService must not be null");
        Assert.notNull(userService, "userService must not be null");
        this.tokenService = tokenService;
        this.userService = userService;
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
        if(!tokenService.isVerificationTokenExist(loginToken)){
            return JsonDataWrapperUtil.fail_402(null);
        }
        User user = new User();
        user.setPhone(phone);
        user.setPassword(password);
        Long userId = userService.getUid(user);
        if (userId == null) {
            return JsonDataWrapperUtil.fail_402(null);
        }
        String token = tokenService.insertToken(userId);
        tokenService.deleteVerificationToken(loginToken);
        Map<String, String> resMap = new HashMap<>();
        resMap.put("account_token", token);
        return JsonDataWrapperUtil.success_200(resMap);
    }

    @PostMapping("/login/phone")
    public JsonDataWrapper loginByPhone(@RequestBody Map<String, String> reqMap) {
//        Long userId = userService.getUid(user);
//        if(userId != null) {
//            String token = tokenService.insertToken(userId);
//            return JsonDataWrapperUtil.success(token);
//        }
        return JsonDataWrapperUtil.fail_401(null);
    }

    @PostMapping("/login/token")
    public @ResponseBody JsonDataWrapper loginByToken(@RequestBody Map<String, String> reqMap) {
        String loginToken = reqMap.get("account_token");
        if(!tokenService.isTokenExpired(loginToken)){
            //token未过期，验证通过
            return  JsonDataWrapperUtil.success_200(null);
        }
        return JsonDataWrapperUtil.fail_402(null);
    }
}