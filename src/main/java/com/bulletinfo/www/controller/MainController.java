package com.bulletinfo.www.controller;

import com.bulletinfo.www.domain.Friend;
import com.bulletinfo.www.domain.Result;
import com.bulletinfo.www.domain.User;
import com.bulletinfo.www.servers.FServers;
import com.bulletinfo.www.servers.UserServers;
import com.bulletinfo.www.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;

@RestController
public class MainController {
    @Autowired
    private FServers fServers;

    @Autowired
    private UserServers userServers;

    @PostMapping(value = "/")
    public String MainTest(){
        return "hello";
    }

    /**
     * 注册账号，自动生成uid
     * @param user
     * @return
     * @throws SQLException
     */
    @PostMapping("/reginster")
    public Result Register(@Valid User user){
        System.out.println("user is:"+user);
        userServers.AddUser(user);
        return ResultUtils.success(null);
    }

    @PostMapping("/friends/{uid}")
    public Result FindByFriend(@PathVariable Integer uid){
        List<Friend> list = fServers.UserList(uid);
        return ResultUtils.success(list);
    }

    @PostMapping("/login/{uid}/{upwd}")
    public Result Login(@PathVariable Integer uid, @PathVariable String upwd){
        boolean result= userServers.Login(uid, upwd);
        return ResultUtils.success(result);
    }

}
