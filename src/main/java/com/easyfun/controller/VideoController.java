package com.easyfun.controller;

import com.easyfun.entity.JsonDataWrapper;
import com.easyfun.entity.PageObjectWrapper;
import com.easyfun.entity.VideoUploadInfo;
import com.easyfun.pojo.Video;
import com.easyfun.pojo.VideoSave;
import com.easyfun.service.UserService;
import com.easyfun.service.VideoSaveService;
import com.easyfun.service.VideoService;
import com.easyfun.util.JsonDataWrapperUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;
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

    private final UserService userService;
    private final VideoService videoService;
    private final VideoSaveService videoSaveService;
    private final Gson gson;

    @Autowired
    public VideoController(UserService userService, VideoService videoService, VideoSaveService videoSaveService, Gson gson) {
        Assert.notNull(userService, "userService must not be null");
        Assert.notNull(videoService, "videoService must not be null");
        Assert.notNull(videoSaveService, "videoSaveService must not be null");
        Assert.notNull(gson, "gson must not be null");
        this.userService = userService;
        this.videoService = videoService;
        this.videoSaveService = videoSaveService;
        this.gson = gson;
    }

    @GetMapping(value = "")
    public ResponseEntity<Resource> getVideo(@RequestHeader(value = "Range", required = false) String range,
                                             @RequestParam("vid") String vid) {
        //获取视频路径
        if (vid == null || vid.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        long vidLong;
        try {
            vidLong = Long.parseLong(vid);
        }
        catch (NumberFormatException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        String path = String.valueOf(videoService.getVideoPath(vidLong));
        //获取视频文件
        File file = new File(path);
        if (!file.exists()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        long fileSize = file.length();
        //获取视频请求范围
        long start = 0, end = fileSize - 1;
        if (range != null) {
            if (range.startsWith("bytes=")) {
                String[] parts = range.substring(6).split("-");
                try {
                    start = Long.parseLong(parts[0]);
                    if (parts.length > 1 && !parts[1].isEmpty()) {
                        end = Long.parseLong(parts[1]);
                    }
                }
                catch (NumberFormatException e) {
                    start = 0;
                    end = fileSize - 1;
                }
                end = Math.min(end, fileSize - 1);
            }
        }
        try {
            byte[] data = readFile(file, start, end);
            ByteArrayResource resource = new ByteArrayResource(data);
            String contentLength = String.valueOf(end - start + 1);
            String contentRange = "bytes " + start + "-" + end + "/" + fileSize;
            if (range != null) {
                return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT)
                        .header(HttpHeaders.CONTENT_TYPE, "video/mp4")
                        .header(HttpHeaders.CONTENT_LENGTH, contentLength)
                        .header(HttpHeaders.CONTENT_RANGE, contentRange)
                        .header(HttpHeaders.ACCEPT_RANGES, "bytes")
                        .body(resource);
            }
            else {
                return ResponseEntity.status(HttpStatus.OK)
                        .header(HttpHeaders.CONTENT_TYPE, "video/mp4")
                        .header(HttpHeaders.CONTENT_LENGTH, contentLength)
                        .header(HttpHeaders.CONTENT_RANGE, contentRange)
                        .body(resource);
            }
        }
        catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private byte[] readFile(File file, long start, long end) throws IOException {
        try (FileInputStream fis = new FileInputStream(file);
             FileChannel channel = fis.getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate((int) (end - start + 1));
            channel.read(buffer, start);
            buffer.flip();
            return buffer.array();
        }
    }

    @GetMapping("/info")
    public @ResponseBody JsonDataWrapper getVideoInfo(Long vid) {
        Video video = videoService.getVideoByVid(vid);
        if (video == null) {
            return JsonDataWrapperUtil.fail_404(null, "视频不存在");
        }
        Map<String, Video> resMap = new HashMap<>();
        resMap.put("video_info", video);
        return JsonDataWrapperUtil.success_200(resMap);
    }

    @GetMapping("/recommend")
    public @ResponseBody JsonDataWrapper getRandomVideo(Integer num, String type) {
        List<Video> recommendVideoList = videoService.getRecommendVideoList(num, VideoService.VideoInfoType.SIMPLE);
        Map<String, List<Video>> resMap = new HashMap<>();
        resMap.put("video_list", recommendVideoList);
        return JsonDataWrapperUtil.success_200(resMap);
    }

    @PostMapping("/upload")
    public @ResponseBody JsonDataWrapper uploadVideo(@RequestParam("video_files") MultipartFile[] videoFiles,
                                                     @RequestParam(value = "cover_blobs", required = false) MultipartFile[] videoCovers,
                                                     @RequestParam("meta_data") String metaDataStr,
                                                     @RequestParam("publisher_uid") Long publisherUid) {
        if (videoFiles == null || videoFiles.length == 0) {
            return JsonDataWrapperUtil.fail_402(null, "请上传视频文件");
        }
        Type metaDataType = new TypeToken<List<VideoUploadInfo>>() {
        }.getType();
        List<VideoUploadInfo> metaList = gson.fromJson(metaDataStr, metaDataType);
        Map<String, VideoUploadInfo> metaHashMap = new HashMap<>();
        for (VideoUploadInfo meta : metaList) {
            metaHashMap.put(meta.getUuid(), meta);
        }
        int count = 0;
        for (MultipartFile videoFile : videoFiles) {
            if (videoFile.isEmpty()) {
                ++count;
                continue;
            }
            VideoUploadInfo videoUploadInfo = metaHashMap.get(videoFile.getOriginalFilename());
            try {
                videoUploadInfo.setVideoFile(videoFile.getBytes());
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if (videoCovers != null) {
            for (MultipartFile coverBlob : videoCovers) {
                VideoUploadInfo videoUploadInfo = metaHashMap.get(coverBlob.getOriginalFilename());
                try {
                    videoUploadInfo.setCoverFile(coverBlob.getBytes());
                }
                catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        String publisheName = userService.getUserInfoPublic(publisherUid).getName();
        for (Map.Entry<String, VideoUploadInfo> entry : metaHashMap.entrySet()) {
            VideoUploadInfo videoUploadInfo = entry.getValue();
            videoUploadInfo.setPublisherUid(publisherUid);
            videoUploadInfo.setPublisherName(publisheName);
            byte[] videoBytes = videoUploadInfo.getVideoFile();
            byte[] coverBytes = videoUploadInfo.getCoverFile();
            videoService.addVideo(videoUploadInfo, videoBytes, coverBytes);
        }
        return JsonDataWrapperUtil.success_200(null, "上传失败个数：" + count);
    }

    @GetMapping("/user/status/modify")
    public @ResponseBody JsonDataWrapper modifyUserStatus(@RequestParam("vid") Long vid, @RequestParam("uid") Long uid,
                                                          @RequestParam("type") String type,
                                                          @RequestParam("value") int value) {
        if (value < 0 || value > 3) {
            return JsonDataWrapperUtil.fail_402(null, "value参数错误");
        }
        boolean valueBool = value == 1;
        VideoSave videoSave = new VideoSave();
        switch (type) {
            case "like": {
                videoService.updateLikeNum(vid, valueBool);
                videoSave.setIsLike(valueBool);
                break;
            }
            case "coin": {
                //检查用户是否有足够的硬币
                if (value > userService.getUserInfoPublic(uid).getCoin()) {
                    return JsonDataWrapperUtil.fail_402(null, "硬币不足");
                }
                userService.decreaseCoin(uid, value);
                videoService.updateCoinNum(vid, value);
                videoSave.setCoinNum(value);
                break;
            }
            case "fav": {
                videoService.updateFavoriteNum(vid, valueBool);
                videoSave.setIsFav(valueBool);
                break;
            }
            case "share": {
                videoService.updateShareNum(vid, valueBool);
                videoSave.setIsShare(valueBool);
                break;
            }
            default: {
                return JsonDataWrapperUtil.fail_402(null, "type参数错误");
            }
        }
        videoSave.setVid(vid);
        videoSave.setUid(uid);
        videoSaveService.updateVideoSave(vid, uid, videoSave);
        return JsonDataWrapperUtil.success_200(null);
    }

    @GetMapping("/user/status/get")
    public @ResponseBody JsonDataWrapper getUserStatus(@RequestParam("vid") Long vid, @RequestParam("uid") Long uid) {
        VideoSave videoSave = videoSaveService.getVideoSave(vid, uid);
        Map<String, Object> resMap = new HashMap<>();
        if (videoSave != null) {
            resMap.put("is_like", videoSave.getIsLike());
            resMap.put("coin_num", videoSave.getCoinNum());
            resMap.put("is_fav", videoSave.getIsFav());
            resMap.put("is_share", videoSave.getIsShare());
            resMap.put("is_save", "true");
        }
        else {
            resMap.put("is_save", "false");
        }
        return JsonDataWrapperUtil.success_200(resMap);
    }

    @GetMapping("/get/upload")
    @ResponseBody
    public JsonDataWrapper getUserUploadList(@RequestParam("publisher_uid") Long publisherUid,
                                             @RequestParam(value = "page_num", required = false, defaultValue = "1") int pageNum,
                                             @RequestParam(value = "page_size", required = false, defaultValue = "10") int pageSize) {
        //检查用户是否存在
        if(!userService.isUserExists(publisherUid)){
            return JsonDataWrapperUtil.fail_402(null, "用户不存在");
        }
        PageObjectWrapper<List<Video>,Video> pageObjectWrapper = videoService.getVideoListByPublisherUid(publisherUid, pageNum, pageSize);
        List<Video> videoList = pageObjectWrapper.getObject();
        Map<String,Object> resMap = new HashMap<>();
        resMap.put("video_list", videoList);
        resMap.put("page_total", pageObjectWrapper.getPageInfo().getPages());
        return JsonDataWrapperUtil.success_200(resMap);
    }

    @GetMapping("/get/upload/recommend")
    @ResponseBody
    public JsonDataWrapper getRecommendUploadList(@RequestParam("publisher_uid") Long publisherUid,
                                                  @RequestParam(value = "num", required = false, defaultValue = "10") int num) {
        //推荐用户播放量前十的视频
        //检查用户是否存在
        if(!userService.isUserExists(publisherUid)){
            return JsonDataWrapperUtil.fail_402(null, "用户不存在");
        }
        List<Video> recommendVideoList = videoService.getRecommendUploadVideo(publisherUid,num);
        Map<String,Object> resMap = new HashMap<>();
        resMap.put("video_list", recommendVideoList);
        return JsonDataWrapperUtil.success_200(resMap);
    }
}