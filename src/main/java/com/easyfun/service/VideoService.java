package com.easyfun.service;

import com.easyfun.mapper.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/11/7 上午9:26
 */

@Service
public class VideoService {

    private final VideoMapper videoMapper;

    @Autowired
    public VideoService(VideoMapper videoMapper) {
        Assert.notNull(videoMapper, "videoMapper must not be null");
        this.videoMapper = videoMapper;
    }
}