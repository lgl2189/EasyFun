package com.easyfun.util;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/11/22 上午8:42
 */


public class VideoThumbnailGenerator {

    public static void generateThumbnail(String videoFilePath, String thumbnailPath) {
        // FFmpeg命令
        String command = "ffmpeg -i " + videoFilePath + " -vf \"select='gt(scene,0.3)'\" -vframes 1 " + thumbnailPath;
        try {
            // 执行FFmpeg命令
            Process process = Runtime.getRuntime().exec(command);
            // 读取命令输出，并打印到控制台，用于调试
//            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//            String line;
//            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
//            }

            // 等待命令执行完毕
            int exitCode = process.waitFor();
//            System.out.println("FFmpeg command executed with exit code: " + exitCode);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}