package com.jk.mapper;

import com.jk.model.UserBean;
import org.springframework.stereotype.Controller;

import java.util.List;


public interface UserMapper {

    //注册
    List<UserBean> queryReg(String account);
    int getUserInfoByAccount(String account);
    void reg(UserBean userBean);
}
