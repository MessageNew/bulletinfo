package com.bulletinfo.www.servers;

import com.bulletinfo.www.domain.User;
import com.bulletinfo.www.respository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mysteriouseyes on 2018/9/5.
 */
@Service
public class UserServers {
    @Autowired
    private UserRespository userRespository;

    public void AddUser(User user){
        userRespository.save(user);
    }

}
