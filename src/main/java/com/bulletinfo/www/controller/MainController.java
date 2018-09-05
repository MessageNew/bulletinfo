package com.bulletinfo.www.controller;

import com.bulletinfo.www.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by Mysteriouseyes on 2018/9/5.
 */
@RestController
public class MainController {

    @PostMapping(value = "/")
    public String MainTest(@Valid User user){
        System.out.println(user.getUid());

        return "hello";
    }

}
