package com.easyfun.service;

import com.easyfun.entity.PageObjectWrapper;
import com.easyfun.entity.VideoUploadInfo;
import com.easyfun.mapper.CommentAreaMapper;
import com.easyfun.mapper.VideoMapper;
import com.easyfun.pojo.CommentArea;
import com.easyfun.pojo.Video;
import com.easyfun.util.VideoUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.io.FileOutputStream;
import java.lang.reflect.Type;
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
    private final Gson gson;


    @Autowired
    public VideoService(VideoMapper videoMapper, CommentAreaMapper commentAreaMapper, ImageService imageService, Gson gson) {
        Assert.notNull(videoMapper, "videoMapper must not be null");
        Assert.notNull(commentAreaMapper, "commentAreaMapper must not be null");
        Assert.notNull(imageService, "imageService must not be null");
        Assert.notNull(gson, "gson must not be null");
        this.videoMapper = videoMapper;
        this.commentAreaMapper = commentAreaMapper;
        this.imageService = imageService;
        this.gson = gson;
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

    public void addVideo(VideoUploadInfo videoUploadInfo, byte[] videoBytes, byte[] coverBytes) {
        Video video = new Video();
        String imageUuid = "2";
        String videoUuid = saveVideo(video, videoBytes);
        String videoUrl = VIDEO_PATH_PREFIX + videoUuid + ".mp4";
        if(coverBytes != null){
            imageUuid = imageService.addImage(coverBytes);
        }
        String videoPath = VIDEO_PATH_PREFIX + videoUuid + ".mp4";
        video.setTitle(videoUploadInfo.getTitle());
        video.setVideoPath(videoPath);
        video.setPublisherId(videoUploadInfo.getPublisherUid());
        video.setPublisherName(videoUploadInfo.getPublisherName());
        video.setPublishDatetime(LocalDateTime.now());
        video.setIsOriginal(videoUploadInfo.isType());
        video.setDescription(videoUploadInfo.getDescription());
        Type listType = new TypeToken<List<String>>(){}.getType();
        String tagListStr = gson.toJson(videoUploadInfo.getTagList(), listType);
        JsonArray tagListJsonArray = gson.fromJson(tagListStr, JsonArray.class);
        video.setTagList(tagListJsonArray);
        Long caid = commentAreaMapper.getMaxCaid() + 1;
        commentAreaMapper.insert(new CommentArea(caid,1));
        video.setCommentAid(caid);
        String duration=VideoUtil.getVideoDurationStr(videoUrl);
        video.setVideoDuration(LocalTime.parse(duration));
        video.setCoverUuid(imageUuid);
        video.setLikeNum(0);
        video.setCoinNum(0);
        video.setFavoriteNum(0);
        video.setShareNum(0);
        video.setViewNum(0);
        video.setDanmakuNum(0);
        video.setCommentNum(0);
        video.setDanmakuList(new JsonArray());
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

    public void updateLikeNum(Long vid, boolean isLike) {
        if(isLike){
            videoMapper.adjustLikeNum(vid, 1);
        }
        else{
            videoMapper.adjustLikeNum(vid, -1);
        }
    }

    public void updateCoinNum(Long vid, int coinNum) {
        if(coinNum >= 1 && coinNum <= 2){
            videoMapper.adjustCoinNum(vid, coinNum);
        }
    }

    public void updateFavoriteNum(Long vid, boolean isFavorite) {
        if(isFavorite){
            videoMapper.adjustFavoriteNum(vid, 1);
        }
        else{
            videoMapper.adjustFavoriteNum(vid, -1);
        }
    }

    public void updateShareNum(Long vid, boolean isShare) {
        if(isShare){
            videoMapper.adjustShareNum(vid, 1);
        }
        else{
            videoMapper.adjustShareNum(vid, -1);
        }
    }

    public boolean isVideoExists(Long vid) {
        return videoMapper.selectByPrimaryKey(vid) != null;
    }

    public PageObjectWrapper<List<Video>,Video> getVideoListByPublisherUid(Long publisherUid, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Video> videoList = videoMapper.selectByPublisherUid(publisherUid);
        PageInfo<Video> pageInfo = new PageInfo<>(videoList);
        PageHelper.clearPage();
        return new PageObjectWrapper<>(videoList, pageInfo);
    }

    public List<Video> getRecommendUploadVideo(Long publisherUid,int num) {
        return videoMapper.selectUploadVideosByView(publisherUid,num);
    }
}