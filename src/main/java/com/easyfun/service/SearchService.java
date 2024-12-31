package com.easyfun.service;

import com.easyfun.entity.PageObjectWrapper;
import com.easyfun.mapper.SearchMapper;
import com.easyfun.mapper.VideoMapper;
import com.easyfun.pojo.Video;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.*;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/12/30 上午11:28
 */

@Service
public class SearchService {

    private final SearchMapper searchMapper;
    private final VideoMapper videoMapper;

    @Autowired
    public SearchService(SearchMapper searchMapper, VideoMapper videoMapper) {
        Assert.notNull(searchMapper, "searchMapper must not be null");
        Assert.notNull(videoMapper, "videoMapper must not be null");
        this.searchMapper = searchMapper;
        this.videoMapper = videoMapper;
    }

    public PageObjectWrapper<List<Video>,Video> searchTitleByKeyWords(List<String> keys, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Video> videoInfoList = searchMapper.searchVideoTitleByKeywords(keys);
        PageInfo<Video> pageInfo = new PageInfo<>(videoInfoList);
        PageHelper.clearPage();
        return new PageObjectWrapper<List<Video>,Video>(videoInfoList,pageInfo);
    }
}