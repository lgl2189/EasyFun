package com.easyfun.controller;

import com.easyfun.entity.JsonDataWrapper;
import com.easyfun.pojo.Video;
import com.easyfun.service.VideoService;
import com.easyfun.util.JsonDataWrapperUtil;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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

    private static final String SAMPLE_VIDEO_PATH = "C:\\Users\\12145\\Desktop\\Easy_Fun\\测试视频\\sample.mp4";

    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        Assert.notNull(videoService, "videoService must not be null");
        this.videoService = videoService;
    }

    @GetMapping(value = "")
    public ResponseEntity<Resource> getVideo(@RequestHeader(value = "Range", required = false) String range,
                                             @RequestParam("path") String path) {
        //获取视频文件
        File file = new File(SAMPLE_VIDEO_PATH);
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
            InputStreamResource resource = new InputStreamResource(new ByteArrayInputStream(data));
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
    public @ResponseBody JsonDataWrapper getVideo(Long vid) {
        Video video = videoService.getVideoByVid(vid);
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
}