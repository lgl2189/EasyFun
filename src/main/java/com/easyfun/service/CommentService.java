package com.easyfun.service;

import com.easyfun.entity.ReplyInfo;
import com.easyfun.mapper.CommentAreaMapper;
import com.easyfun.mapper.ReplyMapper;
import com.easyfun.mapper.UserMapper;
import com.easyfun.mapper.VideoMapper;
import com.easyfun.pojo.CommentArea;
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

    @Autowired
    public CommentService(CommentAreaMapper commentAreaMapper, ReplyMapper replyMapper, VideoMapper videoMapper, UserMapper userMapper) {
        Assert.notNull(commentAreaMapper, "commentAreaMapper must not be null");
        Assert.notNull(replyMapper, "replyMapper must not be null");
        Assert.notNull(videoMapper, "videoMapper must not be null");
        Assert.notNull(userMapper, "userMapper must not be null");
        this.commentAreaMapper = commentAreaMapper;
        this.replyMapper = replyMapper;
        this.videoMapper = videoMapper;
        this.userMapper = userMapper;
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
        replyMapper.updateReplyNum(reply.getOid(),reply.getRoot(),reply.getParent());
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
        List<Reply> firstReplyList = replyMapper.selectPartFirstReply(caid,10);
        for(Reply firstReply:firstReplyList){
            long firstRpid = firstReply.getRpid();
            long firstMid = firstReply.getMid();
            List<Reply> secondaryReplylist = replyMapper.selectPartSpecificSecondaryReply(caid,firstRpid,2);
            List<ReplyInfo> secondaryReplyInfoList = new ArrayList<>();
            User firstUser = userMapper.selectUserInfoPublic(firstMid);
            for(Reply secondaryReply:secondaryReplylist){
                long secondaryMid = secondaryReply.getMid();
                User secondaryUser = userMapper.selectByPrimaryKey(secondaryMid);
                ReplyInfo secondaryReplyInfo = new ReplyInfo(secondaryReply,secondaryUser,null);
                secondaryReplyInfoList.add(secondaryReplyInfo);
            }
            ReplyInfo replyInfo = new ReplyInfo(firstReply,firstUser,secondaryReplyInfoList);
            resList.add(replyInfo);
        }
        return resList;
    }

    public List<ReplyInfo> getSecondaryReply(long oid,long root){
        List<Reply> replyList = replyMapper.selectAllSpecificSecondaryReply(oid,root);
        List<ReplyInfo> replyInfoList = new ArrayList<>();
        for(Reply reply:replyList){
            long replyMid = reply.getMid();
            User replyUser = userMapper.selectUserInfoPublic(replyMid);
            ReplyInfo replyInfo = new ReplyInfo(reply,replyUser,null);
            replyInfoList.add(replyInfo);
        }
        return replyInfoList;
    }
}