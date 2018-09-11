package com.bulletinfo.www.servers;

import com.bulletinfo.www.domain.User;
import com.bulletinfo.www.respository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mysteriouseyes on 2018/9/5.
 */
@Service
public class UserServers {
    @Autowired
    private UserRespository dao;

    public User AddUser(User user){
        return dao.save(user);
    }

    public List<User> Login(User user){
       return dao.findByLogin(user.getUid(),user.getPassword());
    }




}
