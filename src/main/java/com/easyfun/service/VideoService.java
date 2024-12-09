package com.easyfun.service;

import com.easyfun.mapper.CommentAreaMapper;
import com.easyfun.mapper.VideoMapper;
import com.easyfun.pojo.CommentArea;
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
import java.util.UUID;

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
    private final ImageService imageService;


    @Autowired
    public VideoService(VideoMapper videoMapper, CommentAreaMapper commentAreaMapper, ImageService imageService) {
        Assert.notNull(videoMapper, "videoMapper must not be null");
        Assert.notNull(commentAreaMapper, "commentAreaMapper must not be null");
        Assert.notNull(imageService, "imageService must not be null");
        this.videoMapper = videoMapper;
        this.commentAreaMapper = commentAreaMapper;
        this.imageService = imageService;
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

    public void addVideo(String videoName, byte[] videoBytes,byte[] coverBytes) {
        Video video = new Video();
        String imageUuid = "2";
        String videoUuid = saveVideo(video, videoBytes);
        if(coverBytes != null){
            imageUuid = imageService.addImage(coverBytes);
        }
        String videoPath = VIDEO_PATH_PREFIX + videoUuid + ".mp4";
        video.setTitle(videoName);
        video.setVideoPath(videoPath);
        //#
        video.setPublisherId(1L);
        video.setPublisherName("admin");
        video.setPublishDatetime(LocalDateTime.now());
        video.setIsOriginal(true);
        video.setDescription("无描述");
        video.setTagList(new JsonArray());
        Long caid = commentAreaMapper.getMaxCaid() + 1;
        commentAreaMapper.insert(new CommentArea(caid,1));
        video.setCommentAid(caid);
        video.setVideoDuration(LocalTime.of(1,1,1));
        video.setCoverUuid(imageUuid);
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
    }

    public String saveVideo(Video video, byte[] videoBytes) {
        String videoUuid = UUID.randomUUID().toString().replace("-", "");
        String videoUrl = VIDEO_PATH_PREFIX + videoUuid + ".mp4";
        try(FileOutputStream fos = new FileOutputStream(videoUrl)){
            fos.write(videoBytes);
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return videoUuid;
    }

}