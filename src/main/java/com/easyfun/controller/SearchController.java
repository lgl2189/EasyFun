package com.easyfun.controller;

import com.easyfun.entity.JsonDataWrapper;
import com.easyfun.entity.PageObjectWrapper;
import com.easyfun.pojo.Video;
import com.easyfun.service.SearchService;
import com.easyfun.service.VideoService;
import com.easyfun.util.JsonDataWrapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/12/30 上午11:24
 */

@Controller
@RequestMapping("/search")
public class SearchController {

    private final VideoService videoService;
    private final SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService, VideoService videoService) {
        Assert.notNull(searchService, "searchService must not be null");
        Assert.notNull(videoService, "videoService must not be null");
        this.searchService = searchService;
        this.videoService = videoService;
    }

    @GetMapping("")
    @ResponseBody
    public JsonDataWrapper search(@RequestParam("key") List<String> keyList,
                                  @RequestParam(value = "page_num", defaultValue = "1") int pageNum,
                                  @RequestParam(value = "page_size", defaultValue = "30") int pageSize) {
        PageObjectWrapper<List<Video>,Video> videoPageObject = searchService.searchTitleByKeyWords(keyList,pageNum,pageSize);
        Map<String, Object> resMap = new HashMap<>();
        resMap.put("result_list", videoPageObject.getObject());
        resMap.put("page_total", videoPageObject.getPageInfo().getPages());
        return JsonDataWrapperUtil.success_200(resMap);
    }
}