package com.bulletinfo.www.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Mysteriouseyes on 2018/9/5.
 */
@RestController
public class MainController {

    @GetMapping(value = "/")
    public String MainTest(){
        return "hello";
    }

}
