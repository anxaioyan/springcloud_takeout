/**
 * Copyright (C), 2015-2019,金科教育
 * FileName: UserMapper
 * Author:  张成元
 * Date:     2019/4/16 22:38
 * Description: a
 * History:
 * <author>          <time>          <version>          <desc>
 * 张成元           修改时间           版本号              描述
 */
package com.jk.mapper.user;

import com.jk.model.user.UserBean;

/**
 * 〈一句话功能简述〉<br> 
 * 〈a〉
 *
 * @author 张成元
 * @create 2019/4/16
 * @since 1.0.0
 */
public interface UserMapper {

    UserBean findUserInfoByAccount(String account);
}
