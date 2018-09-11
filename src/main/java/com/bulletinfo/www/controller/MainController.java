package com.bulletinfo.www.controller;

import com.bulletinfo.www.domain.Result;
import com.bulletinfo.www.domain.User;
import com.bulletinfo.www.servers.UserServers;
import com.bulletinfo.www.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


/**
 * Created by Mysteriouseyes on 2018/9/5.
 */
@Controller
public class MainController {

    @Autowired
    private UserServers us;

    @GetMapping(value = "/")
    public String MainTest(){
        return "hello";
    }

    @PostMapping("/register")
    public Result Register(@Valid User user){
        User uss = us.AddUser(user);
        Result result = null;
        if (!"".equals(uss.getId())){
            result = ResultUtils.success(uss);
        }else{
            result = ResultUtils.filed(uss);
        }
        return  result;
    }

    @PostMapping("/login")
    public Result Login(@Valid User user){
        List<User> list =  us.Login(user);
        Result result=null;
        if (list.size() == 0){
            result = ResultUtils.filed(list);
        }else{
            result = ResultUtils.success(list);
        }
        return  result;
    }


}
