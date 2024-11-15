package com.easyfun.util;

import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.Frame;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/11/14 下午5:32
 */


public class VideoTranscoder {
    public static void transcode(String inputPath, String outputPath, int width, int height, int videoBitrate) throws Exception {
        try (FFmpegFrameGrabber grabber = new FFmpegFrameGrabber(inputPath);
             FFmpegFrameRecorder recorder = new FFmpegFrameRecorder(outputPath, width, height)) {
            grabber.start();
            recorder.setVideoCodecName("libx264"); // 设置视频编解码器为 H.264
            recorder.setAudioCodecName("aac"); // 设置音频编解码器为 AAC
            recorder.setOption("skip_frame", "1");// 启用帧跳过功能，以确保比特率控制有效。设置1表示跳过1帧，即每2帧取1帧进行编码。
            recorder.setVideoCodec(grabber.getVideoCodec());
            recorder.setFormat("mp4");
            recorder.setFrameRate(grabber.getFrameRate());
            recorder.setVideoBitrate(videoBitrate);
            recorder.setSampleRate(grabber.getSampleRate());// 设置音频采样率。
            recorder.setAudioChannels(grabber.getAudioChannels());// 设置音频通道数。
            recorder.setAudioBitrate(grabber.getAudioBitrate());// 设置音频比特率。
            recorder.start();
            Frame frame;
            while ((frame = grabber.grabFrame()) != null) {
                if (frame.image != null) {
                    recorder.record(frame);
                }
            }
        }
    }
}