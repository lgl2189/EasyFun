package com.easyfun.controller;

import com.easyfun.entity.JsonDataWrapper;
import com.easyfun.entity.ReplyInfo;
import com.easyfun.pojo.Reply;
import com.easyfun.service.CommentService;
import com.easyfun.service.VideoService;
import com.easyfun.util.JsonDataWrapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/11/23 下午9:17
 */

@Controller
@RequestMapping("/comment")
public class CommentController {


    private final VideoService videoService;
    private final CommentService commentService;

    @Autowired
    public CommentController(VideoService videoService,CommentService commentService) {
        Assert.notNull(videoService, "videoService must not be null");
        Assert.notNull(commentService, "commentService must not be null");
        this.videoService = videoService;
        this.commentService = commentService;
    }

    @RequestMapping("/add")
    @ResponseBody
    public JsonDataWrapper addComment(@RequestBody Map<String, String> reqMap) {
        try{
            long oid = Long.parseLong(reqMap.get("oid"));
            long mid = Long.parseLong(reqMap.get("mid"));
            long root = Long.parseLong(reqMap.get("root"));
            long parent = Long.parseLong(reqMap.get("parent"));
            String content = reqMap.get("content");
            Reply reply = new Reply(oid,"normal",mid,root,parent,
                    LocalDateTime.now(),0,0,
                    content,"normal",0);
            commentService.addReply(reply);
            return JsonDataWrapperUtil.success_200(null);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return JsonDataWrapperUtil.fail_403(null);
        }
    }

    @RequestMapping("/get")
    @ResponseBody
    public JsonDataWrapper getCommentArea(@RequestParam("vid") long vid) {
        try{
            long caid = videoService.getVideoByVid(vid).getCommentAid();
            List<ReplyInfo> replyList = commentService.getReplyListByCaid(caid);
            Map<String,List<ReplyInfo>> resMap = new HashMap<>();
            resMap.put("commentList",replyList);
            return JsonDataWrapperUtil.success_200(resMap);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return JsonDataWrapperUtil.fail_403(null);
        }
    }

    @RequestMapping("/get/secondary")
    @ResponseBody
    public JsonDataWrapper getSecondaryComment(@RequestParam("oid") long oid,@RequestParam("root") long root){
        try{
            List<ReplyInfo> secondaryReplyList = commentService.getSecondaryReply(oid,root);
            Map<String,List<ReplyInfo>> resMap = new HashMap<>();
            resMap.put("reply_list",secondaryReplyList);
            return JsonDataWrapperUtil.success_200(resMap);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return JsonDataWrapperUtil.fail_403(null);
        }
    }

    @RequestMapping("/examine/start")
    @ResponseBody
    public JsonDataWrapper startExamineComment(@RequestBody Map<String, String> reqMap) {
        return JsonDataWrapperUtil.success_200(null);
    }

    @RequestMapping("/examine/finish")
    @ResponseBody
    public JsonDataWrapper finishExamineComment(@RequestBody Map<String, String> reqMap) {
        return JsonDataWrapperUtil.success_200(null);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public JsonDataWrapper deleteComment(@RequestBody Map<String, String> reqMap) {
        return JsonDataWrapperUtil.success_200(null);
    }
}