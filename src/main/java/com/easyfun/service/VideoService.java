package com.easyfun.service;

import com.easyfun.mapper.VideoMapper;
import com.easyfun.pojo.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/11/7 上午9:26
 */

@Service
public class VideoService {

    public enum VideoInfoType{
        SIMPLE,
        FULL
    }

    private final VideoMapper videoMapper;


    @Autowired
    public VideoService(VideoMapper videoMapper) {
        Assert.notNull(videoMapper, "videoMapper must not be null");
        this.videoMapper = videoMapper;
    }

    public List<Video> getRecommendVideoList(int num, VideoInfoType type){
        return videoMapper.selectAll();
    }
}