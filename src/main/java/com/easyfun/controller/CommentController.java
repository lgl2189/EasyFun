package com.easyfun.controller;

import com.easyfun.entity.JsonDataWrapper;
import com.easyfun.entity.PageObjectWrapper;
import com.easyfun.entity.ReplyInfo;
import com.easyfun.pojo.CommentSave;
import com.easyfun.pojo.Reply;
import com.easyfun.service.CommentService;
import com.easyfun.service.VideoService;
import com.easyfun.util.JsonDataWrapperUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

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
    public CommentController(VideoService videoService, CommentService commentService) {
        Assert.notNull(videoService, "videoService must not be null");
        Assert.notNull(commentService, "commentService must not be null");
        this.videoService = videoService;
        this.commentService = commentService;
    }

    @PostMapping("/add")
    @ResponseBody
    public JsonDataWrapper addComment(@RequestBody Map<String, String> reqMap) {
        try {
            long oid = Long.parseLong(reqMap.get("oid"));
            long mid = Long.parseLong(reqMap.get("mid"));
            long root = Long.parseLong(reqMap.get("root"));
            long parent = Long.parseLong(reqMap.get("parent"));
            String content = reqMap.get("content");
            Reply reply = new Reply(oid, "normal", mid, root, parent,
                    LocalDateTime.now(), 0, 0,
                    content, "normal", 0);
            commentService.addReply(reply);
            return JsonDataWrapperUtil.success_200(null);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return JsonDataWrapperUtil.fail_403(null);
        }
    }

    @RequestMapping("/get")
    @ResponseBody
    public JsonDataWrapper getCommentArea(@RequestParam("vid") long vid,@RequestParam("page") int page,
                                          @RequestParam("pageSize") int pageSize) {
        try {
            long caid = videoService.getVideoByVid(vid).getCommentAid();
            PageObjectWrapper<List<ReplyInfo>> pageObjectWrapper = commentService.getReplyListByCaid(caid,page,pageSize);
            List<ReplyInfo> replyList = pageObjectWrapper.getObject();
            Map<String, Object> resMap = new HashMap<>();
            resMap.put("caid", caid);
            resMap.put("commentList", replyList);
            resMap.put("page", pageObjectWrapper.getPageNum());
            resMap.put("total", pageObjectWrapper.getTotal());
            return JsonDataWrapperUtil.success_200(resMap);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return JsonDataWrapperUtil.fail_403(null);
        }
    }

    @RequestMapping("/get/secondary")
    @ResponseBody
    public JsonDataWrapper getSecondaryComment(@RequestParam("oid") long oid, @RequestParam("root") long root) {
        try {
            List<ReplyInfo> secondaryReplyList = commentService.getSecondaryReply(oid, root);
            Map<String, List<ReplyInfo>> resMap = new HashMap<>();
            resMap.put("reply_list", secondaryReplyList);
            return JsonDataWrapperUtil.success_200(resMap);
        }
        catch (Exception e) {
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

    /**
     * 修改评论的点赞或点踩状态
     * @param reqMap
     * @return
     */
    @PostMapping("/like")
    @ResponseBody
    public JsonDataWrapper likeComment(@RequestBody Map<String, String> reqMap) {
        //TODO: 应该判断是否已经点赞或点踩，避免因为前端错误导致数据库错误，进而造成同一个uid可以多次点赞同一个评论
        long rpid = Long.parseLong(reqMap.get("rpid"));
        long uid = Long.parseLong(reqMap.get("uid"));
        long caid = Long.parseLong(reqMap.get("caid"));
        String type = reqMap.get("type");
        boolean value = reqMap.get("value").equals("1");
        CommentSave commentSave = new CommentSave(rpid, uid, caid, false, false);
        if (type.equals("like")) {
            commentSave.setIsLike(value);
            boolean success = commentService.updateReplyLike(commentSave);
            if (!success) {
                return JsonDataWrapperUtil.fail_402(null, "点赞失败，已经点赞过了");
            }
        }
        else {
            commentSave.setIsDislike(value);
            boolean success = commentService.updateReplyDislike(commentSave);
            if (!success) {
                return JsonDataWrapperUtil.fail_402(null, "点赞失败，已经点踩过了");
            }
        }
        return JsonDataWrapperUtil.success_200(null);
    }

    @PostMapping("/get/like")
    @ResponseBody
    public JsonDataWrapper getCommentLike(@RequestParam("rpid") long rpid, @RequestParam("uid") long uid) {
        CommentSave commentSave = commentService.getCommentSave(rpid, uid);
        Map<String, Boolean> resMap = new HashMap<>();
        resMap.put("is_like", commentSave.getIsLike());
        resMap.put("is_dislike", commentSave.getIsDislike());
        return JsonDataWrapperUtil.success_200(resMap);
    }
}