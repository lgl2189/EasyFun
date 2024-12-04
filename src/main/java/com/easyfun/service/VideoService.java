package com.easyfun.service;

import com.easyfun.mapper.CommentAreaMapper;
import com.easyfun.mapper.VideoMapper;
import com.easyfun.pojo.Video;
import com.google.gson.JsonArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/11/7 上午9:26
 */

@Service
public class VideoService {

    public enum VideoInfoType {
        SIMPLE,
        FULL
    }

    private static final String VIDEO_PATH_PREFIX = "C:\\Users\\12145\\Desktop\\Easy_Fun\\视频存储\\";

    private final VideoMapper videoMapper;
    private final CommentAreaMapper commentAreaMapper;


    @Autowired
    public VideoService(VideoMapper videoMapper, CommentAreaMapper commentAreaMapper) {
        Assert.notNull(videoMapper, "videoMapper must not be null");
        Assert.notNull(commentAreaMapper, "commentAreaMapper must not be null");
        this.videoMapper = videoMapper;
        this.commentAreaMapper = commentAreaMapper;
    }

    public Video getVideoByVid(Long vid) {
        return videoMapper.selectByPrimaryKey(vid);
    }

    public List<Video> getRecommendVideoList(int num, VideoInfoType type) {
        return switch (type) {
            case SIMPLE -> videoMapper.selectRandomVideoSimple(num);
            default -> null;
        };
    }

    public String getVideoPath(Long vid) {
        return videoMapper.selectVideoUrlByPrimaryKey(vid);
    }

    public void addVideo(String videoName, byte[] videoBytes) {
        Video video = new Video();
        video.setTitle(videoName);
        //#
        video.setPublisherId(1L);
        video.setPublisherName("admin");
        video.setPublishDatetime(LocalDateTime.now());
        video.setIsOriginal(true);
        video.setDescription("无描述");
        video.setTagList(new JsonArray());
        video.setCommentAid(commentAreaMapper.getMaxCaid() + 1);
        video.setVideoDuration(LocalTime.of(1,1,1));
        video.setCoverUuid("");
        video.setVideoPath(VIDEO_PATH_PREFIX + video.getVid() + ".mp4");
        video.setLikeNum(0);
        video.setCoinNum(0);
        video.setFavoriteNum(0);
        video.setShareNum(0);
        video.setViewNum(0);
        video.setDanmakuNum(0);
        video.setCommentNum(0);
        video.setDanmakuList(new JsonArray());

        //
        video.setVid(videoMapper.getMaxVid() + 1);
        videoMapper.insert(video);
        saveVideo(video, videoBytes);
    }

    public void saveVideo(Video video, byte[] videoBytes) {
        String videoUrl = VIDEO_PATH_PREFIX + video.getVid() + ".mp4";
        try(FileOutputStream fos = new FileOutputStream(videoUrl)){
            fos.write(videoBytes);
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}