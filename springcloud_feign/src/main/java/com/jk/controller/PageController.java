package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
public class PageController {

    //注册
    @RequestMapping("toReg")
    public  String toReg(){
        return "reg";
    }
    //首页
    @RequestMapping("toMyIndex")
    public  String toMyIndex(){
        return "myIndex";
    }

    @RequestMapping("toMain")
    public  String toMain(){
        return "main";
    }
    @RequestMapping("toShou")
    public  String toShou(){
        return "shou";
    }
}
