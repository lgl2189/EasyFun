package com.easyfun.service;

import com.easyfun.entity.ReplyInfo;
import com.easyfun.mapper.*;
import com.easyfun.pojo.CommentArea;
import com.easyfun.pojo.CommentSave;
import com.easyfun.pojo.Reply;
import com.easyfun.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/11/23 下午9:17
 */

@Service
public class CommentService {

    private final CommentAreaMapper commentAreaMapper;
    private final ReplyMapper replyMapper;
    private final VideoMapper videoMapper;
    private final UserMapper userMapper;
    private final CommentSaveMapper commentSaveMapper;

    @Autowired
    public CommentService(CommentAreaMapper commentAreaMapper, ReplyMapper replyMapper,
                          VideoMapper videoMapper, UserMapper userMapper,
                          CommentSaveMapper commentSaveMapper) {
        Assert.notNull(commentAreaMapper, "commentAreaMapper must not be null");
        Assert.notNull(replyMapper, "replyMapper must not be null");
        Assert.notNull(videoMapper, "videoMapper must not be null");
        Assert.notNull(userMapper, "userMapper must not be null");
        Assert.notNull(commentSaveMapper, "commentSaveMapper must not be null");
        this.commentAreaMapper = commentAreaMapper;
        this.replyMapper = replyMapper;
        this.videoMapper = videoMapper;
        this.userMapper = userMapper;
        this.commentSaveMapper = commentSaveMapper;
    }

    //评论区相关

    public void addCommentArea(CommentArea commentArea) {
        commentAreaMapper.insert(commentArea);
    }

    public void addCommentArea(int type) {
        CommentArea commentArea = new CommentArea();
        commentArea.setType(type);
        addCommentArea(commentArea);
    }

    public void deleteCommentArea(long caid) {
        commentAreaMapper.deleteByPrimaryKey(caid);
    }

    public CommentArea getCommentArea(long caid) {
        return commentAreaMapper.selectByPrimaryKey(caid);
    }

    public void updateCommentArea(CommentArea commentArea) {
        commentAreaMapper.updateByPrimaryKey(commentArea);
    }

    //评论相关

    public void addReply(Reply reply) {
        //TODO: 检查评论区是否存在
        replyMapper.updateReplyNum(reply.getOid(), reply.getRoot(), reply.getParent());
        replyMapper.insert(reply);
    }

    public void deleteReply(long rpid) {
        replyMapper.deleteByPrimaryKey(rpid);
    }

    public void updateReply(Reply reply) {
        replyMapper.updateByPrimaryKey(reply);
    }

    public Reply getReply(long rpid) {
        return replyMapper.selectByPrimaryKey(rpid);
    }

    public List<Reply> getReplyListByVideoId(long vid) {
        long caid = videoMapper.selectByPrimaryKey(vid).getCommentAid();
        return null;
    }

    public List<ReplyInfo> getReplyListByCaid(long caid) {
        List<ReplyInfo> resList = new ArrayList<>();
        List<Reply> firstReplyList = replyMapper.selectPartFirstReply(caid, 10);
        for (Reply firstReply : firstReplyList) {
            long firstRpid = firstReply.getRpid();
            long firstMid = firstReply.getMid();
            List<Reply> secondaryReplylist = replyMapper.selectPartSpecificSecondaryReply(caid, firstRpid, 2);
            List<ReplyInfo> secondaryReplyInfoList = new ArrayList<>();
            User firstUser = userMapper.selectUserInfoPublic(firstMid);
            for (Reply secondaryReply : secondaryReplylist) {
                long secondaryMid = secondaryReply.getMid();
                User secondaryUser = userMapper.selectByPrimaryKey(secondaryMid);
                ReplyInfo secondaryReplyInfo = new ReplyInfo(secondaryReply, secondaryUser, null);
                secondaryReplyInfoList.add(secondaryReplyInfo);
            }
            ReplyInfo replyInfo = new ReplyInfo(firstReply, firstUser, secondaryReplyInfoList);
            resList.add(replyInfo);
        }
        return resList;
    }

    public List<ReplyInfo> getSecondaryReply(long oid, long root) {
        List<Reply> replyList = replyMapper.selectAllSpecificSecondaryReply(oid, root);
        List<ReplyInfo> replyInfoList = new ArrayList<>();
        for (Reply reply : replyList) {
            long replyMid = reply.getMid();
            User replyUser = userMapper.selectUserInfoPublic(replyMid);
            ReplyInfo replyInfo = new ReplyInfo(reply, replyUser, null);
            replyInfoList.add(replyInfo);
        }
        return replyInfoList;
    }

    /**
     * 更新评论点赞
     *
     * @param commentSave
     * @return true 成功，false 失败，失败说明已经点过赞，前端出现错误请求
     */
    public boolean updateReplyLike(CommentSave commentSave) {
        CommentSave existComment = commentSaveMapper.selectLikeAndDislike(commentSave.getRpid(), commentSave.getUid());
        if (existComment == null) {
            return false;
        }
        replyMapper.updateReplyLike(commentSave.getRpid(), commentSave.getIsLike() ? 1 : -1);
        int effectRow = commentSaveMapper.updateLike(commentSave.getRpid(), commentSave.getUid(), commentSave.getIsLike());
        if (effectRow == 0) {
            commentSaveMapper.insert(commentSave);
        }
        return true;
    }

    /**
     * 更新评论踩
     *
     * @param commentSave
     * @return true 成功， false 失败，失败说明已经踩过，前端出现错误请求
     */
    public boolean updateReplyDislike(CommentSave commentSave) {
        CommentSave existComment = commentSaveMapper.selectLikeAndDislike(commentSave.getRpid(), commentSave.getUid());
        if (existComment == null) {
            return false;
        }
        replyMapper.updateReplyDislike(commentSave.getRpid(), commentSave.getIsDislike() ? 1 : -1);
        int effectRow = commentSaveMapper.updateDislike(commentSave.getRpid(), commentSave.getUid(), commentSave.getIsDislike());
        if (effectRow == 0) {
            commentSaveMapper.insert(commentSave);
        }
        return true;
    }

    /**
     * 获取评论点赞和踩状态
     * @param rpid
     * @param uid
     * @return 如果没有记录，返回isLike和isDislike都为false的CommentSave对象
     */
    public CommentSave getCommentSave(long rpid, long uid) {
        CommentSave commentSave = commentSaveMapper.selectLikeAndDislike(rpid, uid);
        if(commentSave == null){
            commentSave = new CommentSave();
            commentSave.setRpid(rpid);
            commentSave.setUid(uid);
            commentSave.setIsLike(false);
            commentSave.setIsDislike(false);
        }
        return commentSave;
    }
}