package com.easyfun.service;

import com.easyfun.mapper.UserMapper;
import com.easyfun.pojo.User;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/11/22 下午4:21
 */
@Service
public class UserService {
    private final UserMapper userMapper;
    private final Gson gson;

    @Autowired
    public UserService(UserMapper userMapper, Gson gson) {
        Assert.notNull(userMapper, "userMapper must not be null");
        Assert.notNull(gson, "gson must not be null");
        this.userMapper = userMapper;
        this.gson = gson;
    }

    public User getUserInfoPublic(long uid) {
        return userMapper.selectUserInfoPublic(uid);
    }

    public User getUserInfoPrivate(long uid) {
        return userMapper.selectByPrimaryKey(uid);
    }

    public boolean increaseCoin(long uid, int coin) {
        userMapper.modifyUserCoin(uid, coin);
        return true;
    }

    public boolean decreaseCoin(long uid, int coinNum) {
        int nowCoin = userMapper.selectByPrimaryKey(uid).getCoin();
        if(nowCoin < coinNum) {
            return false;
        }
        userMapper.modifyUserCoin(uid, -coinNum);
        return true;
    }

    public boolean focusUser(long uid,long focusUid) {
        JsonArray attentionJsonArray = userMapper.selectByPrimaryKey(uid).getAttentionList();
        List<Long> attentionList = gson.fromJson(attentionJsonArray, new TypeToken<List<Long>>() {});
        if(attentionList.contains(focusUid)){
            return false;
        }
        attentionList.add(focusUid);
        JsonArray newJsonArray = gson.fromJson(gson.toJson(attentionList),JsonArray.class);
        userMapper.updateAttentionList(uid,newJsonArray);
        userMapper.modifyUserAttentionNum(uid,1);
        userMapper.modifyUserFollowNum(focusUid,1);
        return true;
    }

    public boolean unfocusUser(long uid,long focusUid) {
        JsonArray attentionJsonArray = userMapper.selectByPrimaryKey(uid).getAttentionList();
        List<Long> attentionList = gson.fromJson(attentionJsonArray, new TypeToken<List<Long>>() {});
        if(!attentionList.contains(focusUid)){
            return false;
        }
        attentionList.remove(focusUid);
        JsonArray newJsonArray = gson.fromJson(gson.toJson(attentionList),JsonArray.class);
        userMapper.updateAttentionList(uid,newJsonArray);
        userMapper.modifyUserAttentionNum(uid,-1);
        userMapper.modifyUserFollowNum(focusUid,-1);
        return true;
    }

    /**
     * 判断用户是否存在
     * @param uid
     * @return true：存在，false：不存在
     */
    public boolean isUserExists(Long uid) {
        return userMapper.selectByPrimaryKey(uid) != null;
    }
}