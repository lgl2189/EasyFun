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
        VideoSave newVideoSave = new VideoSave();
        newVideoSave.setVid(vid);
        newVideoSave.setUid(uid);
        newVideoSave.setIsLike(false);
        newVideoSave.setCoinNum(0);
        newVideoSave.setIsFav(false);
        newVideoSave.setIsShare(false);
        if (videoSave.getIsLike() != null) {
            newVideoSave.setIsLike(videoSave.getIsLike());
            affectRow = videoSaveMapper.updateLike(vid, uid, videoSave.getIsLike());
        }
        if (videoSave.getCoinNum() != null) {
            newVideoSave.setCoinNum(videoSave.getCoinNum());
            affectRow = videoSaveMapper.updateCoinNum(vid, uid, videoSave.getCoinNum());
        }
        if (videoSave.getIsFav() != null) {
            newVideoSave.setIsFav(videoSave.getIsFav());
            affectRow = videoSaveMapper.updateFav(vid, uid, videoSave.getIsFav());
        }
        if (videoSave.getIsShare() != null) {
            newVideoSave.setIsShare(videoSave.getIsShare());
            affectRow = videoSaveMapper.updateShare(vid, uid, videoSave.getIsShare());
        }
        if(affectRow == 0){
            videoSaveMapper.insert(newVideoSave);
        }
    }

    public VideoSave getVideoSave(long vid,long uid) {
        VideoSave videoSave = videoSaveMapper.select(vid,uid);
        if(videoSave == null){
            videoSave = new VideoSave();
            videoSave.setVid(vid);
            videoSave.setUid(uid);
            videoSave.setIsLike(false);
            videoSave.setIsFav(false);
            videoSave.setIsShare(false);
            videoSave.setCoinNum(0);
        }
        return videoSave;
    }
}