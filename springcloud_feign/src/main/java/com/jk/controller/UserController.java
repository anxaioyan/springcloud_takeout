package com.jk.controller;

import com.jk.model.UserBean;
import com.jk.service.UserServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServiceFeign userService;

    @GetMapping("queryReg")
    @ResponseBody
    public List<UserBean> queryReg(@RequestParam("account")String account) {
        return  userService.queryReg(account);
    }

    @PostMapping("reg")
    @ResponseBody
    public  Boolean reg(@RequestBody UserBean userBean){
        try {
            return userService.reg(userBean);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



}
