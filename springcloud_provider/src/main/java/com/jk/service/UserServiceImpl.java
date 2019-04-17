package com.jk.service;

import com.jk.mapper.UserMapper;
import com.jk.model.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;


    @Override
    @ResponseBody
    public Boolean reg(UserBean userBean) {
        //检查该账号是否在数据存在，如果count > 0 表示账号存在，否则不存在
        int count = userMapper.getUserInfoByAccount(userBean.getAccount());
        if (count > 0) {
            return false;
        }else {
            userMapper.reg(userBean);
            return true;
        }
    }

    @Override
    @ResponseBody
    public List<UserBean> queryReg(String account) {
        return   userMapper.queryReg(account);
    }
}
