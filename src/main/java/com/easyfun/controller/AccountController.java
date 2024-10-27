package com.easyfun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/10/24 下午5:27
 */

@Controller
@RequestMapping("/account")
public class AccountController {
    @PostMapping("/login/pass")
    public String loginByPass() {

        return null;
    }

    @PostMapping("/login/phone")
    public String loginByPhone() {

        return null;
    }
}