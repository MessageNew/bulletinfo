package com.bulletinfo.www.controller;

import com.bulletinfo.www.domain.User;
import com.bulletinfo.www.servers.UserServers;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Mysteriouseyes on 2018/9/5.
 */
@RestController
public class MainController {

    @Autowired
    private UserServers us;

    @GetMapping(value = "/")
    public String MainTest(){
        return "hello";
    }

    @PostMapping("/register")
    public String Register(@Valid User user){
        System.out.println("user is:"+user);
        us.AddUser(user);

        return  null;
    }

}
