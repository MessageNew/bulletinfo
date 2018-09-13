package com.bulletinfo.www.servers;

import com.bulletinfo.www.domain.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mysteriouseyes on 2018/9/5.
 */
@Service
public class UserMServers {


    /**
     * 消息发送:发送格式
     * {
     *      time:20160906162845,
     *      msg:xxxxxx,
     *      put:张x,
     *      me:xx,
     *      state: 发送
     * }
     * @param object
     * @return
     */
    public static Result sendM(Object object){
        return null;
    }

}
