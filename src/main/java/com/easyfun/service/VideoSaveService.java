package com.easyfun.service;

import com.easyfun.mapper.VideoSaveMapper;
import com.easyfun.pojo.VideoSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/12/19 上午8:45
 */

@Service
public class VideoSaveService {
    private final VideoSaveMapper videoSaveMapper;

    @Autowired
    public VideoSaveService(VideoSaveMapper videoSaveMapper) {
        Assert.notNull(videoSaveMapper, "videoSaveMapper must not be null");
        this.videoSaveMapper = videoSaveMapper;
    }

    public void updateVideoSave(long vid, long uid, VideoSave videoSave) {
        int affectRow = 0;
        if (videoSave.getIsLike() != null) {
            affectRow = videoSaveMapper.updateLike(vid, uid, videoSave.getIsLike());
        }
        if (videoSave.getCoinNum() != null) {
            affectRow = videoSaveMapper.updateCoinNum(vid, uid, videoSave.getCoinNum());
        }
        if (videoSave.getIsFav() != null) {
            affectRow = videoSaveMapper.updateFav(vid, uid, videoSave.getIsFav());
        }
        if (videoSave.getIsShare() != null) {
            affectRow = videoSaveMapper.updateShare(vid, uid, videoSave.getIsShare());
        }
        if(affectRow == 0){
            videoSaveMapper.insert(videoSave);
        }
    }
}