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

import java.util.HashMap;

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
        return null;
    }
}
