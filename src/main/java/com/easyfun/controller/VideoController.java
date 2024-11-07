package com.easyfun.controller;

import com.easyfun.entity.JsonDataWrapper;
import com.easyfun.pojo.Video;
import com.easyfun.service.VideoService;
import com.easyfun.util.JsonDataWrapperUtil;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/11/4 下午3:37
 */

@Controller
@RequestMapping("/video")
public class VideoController {

    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        Assert.notNull(videoService, "videoService must not be null");
        this.videoService = videoService;
    }

    @GetMapping("randomVideo")
    public @ResponseBody JsonDataWrapper getRandomVideo(Integer num, String type) {
        List<Video> recommendVideoList = videoService.getRecommendVideoList(num, VideoService.VideoInfoType.SIMPLE);
        System.out.println(recommendVideoList);
        return JsonDataWrapperUtil.success_200(null);
    }
}