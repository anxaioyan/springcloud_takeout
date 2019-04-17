/**
 * Copyright (C), 2015-2019,金科教育
 * FileName: UserService
 * Author:  张成元
 * Date:     2019/4/16 22:25
 * Description: a
 * History:
 * <author>          <time>          <version>          <desc>
 * 张成元           修改时间           版本号              描述
 */
package com.jk.service.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * 〈一句话功能简述〉<br> 
 * 〈a〉
 *
 * @author 张成元
 * @create 2019/4/16
 * @since 1.0.0
 */
public interface UserService {


    @PostMapping("login")
    @ResponseBody
    HashMap<String, Object> login(@RequestParam("name") String name);

}
