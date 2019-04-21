/**
 * Copyright (C), 2015-2019,金科教育
 * FileName: PageController
 * Author:  张成元
 * Date:     2019/4/16 22:30
 * Description: a
 * History:
 * <author>          <time>          <version>          <desc>
 * 张成元           修改时间           版本号              描述
 */
package com.jk.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 〈一句话功能简述〉<br> 
 * 〈a〉
 *
 * @author 张成元
 * @create 2019/4/16
 * @since 1.0.0
 */
@Controller
@RequestMapping("page")
public class PageController {

    @RequestMapping("tologin")
    public  String tologin(){
        return "login";
    }

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
