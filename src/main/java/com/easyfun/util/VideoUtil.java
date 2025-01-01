package com.easyfun.util;

import org.bytedeco.javacv.FFmpegFrameGrabber;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author     ：李冠良
 * @description： 无描述
 * @date       ：2025/1/1 上午12:55
 */


public class VideoUtil {
    /**
     * 获取视频文件的时长字符串
     * @param videoFilePath
     * @return 视频文件的时长字符串
     */
    public static String getVideoDurationStr(String videoFilePath) {
        String duration = "00:00:00";
        try (FFmpegFrameGrabber grabber = new FFmpegFrameGrabber(videoFilePath)) {
            grabber.start();

            // 获取视频的持续时间（以微秒为单位）
            long lengthInMicroseconds = grabber.getLengthInTime();
            double totalSeconds = lengthInMicroseconds / 1_000_000.0; // 转换为秒

            // 使用 SimpleDateFormat 将总秒数转换为 HH:mm:ss 格式
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            sdf.setTimeZone(TimeZone.getTimeZone("UTC")); // 设置为 UTC 避免时区影响
            duration = sdf.format(new Date((long) (totalSeconds * 1000)));
            grabber.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return duration;
    }
}