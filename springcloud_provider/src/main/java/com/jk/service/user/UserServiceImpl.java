/**
 * Copyright (C), 2015-2019,金科教育
 * FileName: UserServiceImpl
 * Author:  张成元
 * Date:     2019/4/16 22:39
 * Description: a
 * History:
 * <author>          <time>          <version>          <desc>
 * 张成元           修改时间           版本号              描述
 */
package com.jk.service.user;

import com.alibaba.fastjson.JSON;
import com.jk.mapper.user.UserMapper;
import com.jk.model.user.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈a〉
 *
 * @author 张成元
 * @create 2019/4/16
 * @since 1.0.0
 */
@Controller
public class UserServiceImpl implements  UserService{

    @Autowired
    private UserMapper userMapper;


    @Override
    public HashMap<String, Object> login(String name) {
        UserBean userBean = JSON.parseObject(name, UserBean.class);

        System.out.println("+++++++++++++"+userBean.toString());

        HashMap<String, Object> result = new HashMap<>();
        //UserBean userBean = new UserBean();



        //通过前台传过来的账号获取账号的信息
        UserBean userInfo = userMapper.findUserInfoByAccount(userBean.getAccount());

        if (userInfo == null) {
            result.put("code", 2);
            result.put("msg", "账号或密码错误");
            return result;
        }
        //判断前台传过来的密码是否和数据库的一致（注意：前台的密码需要加密后再比较）
        //String password = users.getPassword();
        //System.out.println(password);
        if (!userInfo.getPassword().equals(userBean.getPassword())) {
            result.put("code", 3);
            result.put("msg", "账号或密码错误");
            return result;
        }
        //将用户信息存入到session中
        result.put("code", 0);
        result.put("msg", "登录成功");
        System.out.println(result.toString());
        return result;
    }


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
