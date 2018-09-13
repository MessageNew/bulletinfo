package com.bulletinfo.www.servers;

import com.bulletinfo.www.domain.Result;
import com.bulletinfo.www.domain.UserMessage;
import com.bulletinfo.www.respository.UMResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mysteriouseyes on 2018/9/5.
 */
@Service
public class UserMServers {

    @Autowired
    private UMResponsitory umResponsitory;

    @Transactional
    public void SendMsg(UserMessage userMessage){
        umResponsitory.save(userMessage);
    }

    public List<UserMessage> ReceiveMsg(Integer mid, Integer uid){
        List<Integer> list = new ArrayList<>();
        list.add(mid);
        list.add(uid);
        return umResponsitory.findByputUserInAndGetUserIn(list, list);
    }



}
