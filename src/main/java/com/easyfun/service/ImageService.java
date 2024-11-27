package com.easyfun.service;

import com.easyfun.enumeration.ImageFormatEnum;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/11/22 下午2:39
 */

@Service
public class ImageService {

    //# TODO:测试代码，需要修改为实际路径
    private static final String COVER_IMAGE_PATH = "C:\\Users\\12145\\Desktop\\Easy_Fun\\测试图片\\";
    //

    /**
     * 获取封面图片
     *
     * @param imageUuid 封面图片的UUID，用于构建文件路径
     * @return 返回值为null表示封面图片不存在
     */
    public byte[] getImage(String imageUuid) {
        File file;
        int i=0;
        ImageFormatEnum[] values = ImageFormatEnum.values();
        for(ImageFormatEnum value : values) {
            String imagePath = COVER_IMAGE_PATH + imageUuid + "." + value.getFormatStr();
            file = new File(imagePath);
            if(file.exists()) {
                try (FileInputStream fis = new FileInputStream(file)) {
                    return fis.readAllBytes();
                }
                catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return null;
    }

}