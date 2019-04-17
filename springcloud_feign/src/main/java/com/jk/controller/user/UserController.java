/**
 * Copyright (C), 2015-2019,金科教育
 * FileName: UserController
 * Author:  张成元
 * Date:     2019/4/16 22:28
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 张成元           修改时间           版本号              描述
 */
package com.jk.controller.user;

import com.jk.Service.user.UserServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 张成元
 * @create 2019/4/16
 * @since 1.0.0
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServiceFeign userService;


    @PostMapping("login")
    @ResponseBody
    public HashMap<String, Object> login(@RequestParam("name") String name) {
        HashMap<String, Object> result=userService.login(name);
        System.out.println("----------------------------------------------s"+name);

        return result;
    }
}
