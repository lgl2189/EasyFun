package com.easyfun.controller;

import com.easyfun.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/11/22 上午9:00
 */

@Controller
@RequestMapping("/image")
public class ImageController {

    private ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        Assert.notNull(imageService, "imageService must not be null");
        this.imageService = imageService;
    }

    @GetMapping("/video/cover")
    public ResponseEntity<StreamingResponseBody> getImage(@RequestParam("image_uuid") String imageUuid){
        byte[] imageBytes = imageService.getCoverImage(imageUuid);
        //判断图片是否存在，不存在则返回404
        if(imageBytes == null){
            return ResponseEntity.notFound().build();
        }
        StreamingResponseBody responseBody = outputStream -> {
            outputStream.write(imageBytes);
            outputStream.flush();
            //Spring框架负责关闭，手动关闭可能提前关闭输出流，导致错误
        };
        return ResponseEntity.ok()
               .contentLength(imageBytes.length)
               .contentType(MediaType.valueOf("image/avif"))
                .body(responseBody);
    }
}