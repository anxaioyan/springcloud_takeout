/**
 * Copyright (C), 2015-2019,金科教育
 * FileName: UserServiceFeign
 * Author:  张成元
 * Date:     2019/4/16 22:51
 * Description: a
 * History:
 * <author>          <time>          <version>          <desc>
 * 张成元           修改时间           版本号              描述
 */
package com.jk.service.user;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * 〈一句话功能简述〉<br> 
 * 〈a〉
 *
 * @author 张成元
 * @create 2019/4/16
 * @since 1.0.0
 */
@FeignClient("provider-shop")
public interface UserServiceFeign extends UserService {

}
