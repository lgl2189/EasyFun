package com.easyfun.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/11/22 下午2:39
 */

@Service
public class ImageService {

    private static final String COVER_IMAGE_PATH = "C:\\Users\\12145\\Desktop\\Easy_Fun\\测试图片\\";

    /**
     * 获取封面图片
     *
     * @param coverImageUuid 封面图片的UUID，用于构建文件路径
     * @return 返回值为null表示封面图片不存在
     */
    public byte[] getCoverImage(String coverImageUuid) {
        String imagePath = COVER_IMAGE_PATH + coverImageUuid + ".avif";
        File file = new File(imagePath);
        if (!file.exists()) {
            return null;
        }
        try (FileInputStream fis = new FileInputStream(file)) {
            return fis.readAllBytes();
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}