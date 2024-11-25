package com.easyfun.controller;

import com.easyfun.entity.JsonDataWrapper;
import com.easyfun.pojo.User;
import com.easyfun.service.TokenService;
import com.easyfun.service.UserService;
import com.easyfun.util.JsonDataWrapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/11/22 下午4:04
 */

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    private TokenService tokenService;

    @Autowired
    public UserController(UserService userService, TokenService tokenService){
        Assert.notNull(userService, "userService must not be null");
        Assert.notNull(tokenService, "tokenService must not be null");
        this.userService = userService;
        this.tokenService = tokenService;
    }

    @RequestMapping("/info/public")
    @ResponseBody
    public JsonDataWrapper getUserInfoPublic(@RequestParam("uid") Long uid){
        User user = userService.getUserInfoPublic(uid);
        if(user == null){
            return JsonDataWrapperUtil.fail_402(null);
        }
        Map<String,User> resMap = new HashMap<String,User>();
        resMap.put("user_info", user);
        return JsonDataWrapperUtil.success_200(resMap);
    }

    @RequestMapping("/info/private")
    @ResponseBody
    public JsonDataWrapper getUserInfoPrivate(@RequestParam("uid") Long uid,@RequestParam("accountToken") String token){
        //TODO: 需要验证用户权限，使用token
        if(tokenService.isTokenExpired(token)){
            return JsonDataWrapperUtil.fail_402(null);
        }
        User user = userService.getUserInfoPrivate(uid);
        if(user == null){
            return JsonDataWrapperUtil.fail_402(null);
        }
        Map<String,User> resMap = new HashMap<>();
        resMap.put("user_info", user);
        return JsonDataWrapperUtil.success_200(resMap);
    }
}