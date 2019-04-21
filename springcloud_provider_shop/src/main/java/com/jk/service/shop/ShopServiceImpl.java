/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ShopServiceImpl
 * Author:   Administrator
 * Date:     2019/4/18 17:00
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.service.shop;

import com.jk.mapper.shop.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author lvdl
 * @create 2019/4/18
 * @since 1.0.0
 */
@Controller
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopMapper shopMapper;

}