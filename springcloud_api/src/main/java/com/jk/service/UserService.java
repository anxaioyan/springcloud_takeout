package com.jk.service;

import com.jk.model.UserBean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UserService {
    //注册
    @GetMapping("queryReg")
    @ResponseBody
    List<UserBean> queryReg(@RequestParam("account") String account);
    @PostMapping("reg")
    @ResponseBody
    Boolean reg(@RequestBody UserBean userBean);
}
