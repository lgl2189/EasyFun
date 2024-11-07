package com.easyfun.controller;

import com.easyfun.entity.JsonDataWrapper;
import com.easyfun.util.JsonDataWrapperUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/11/4 下午3:37
 */

@Controller
@RequestMapping("/video")
public class VideoController {
    @GetMapping("randomVideo")
    public @ResponseBody JsonDataWrapper getRandomVideo(Integer num, String type) {


        return JsonDataWrapperUtil.success_200(null);
    }
}