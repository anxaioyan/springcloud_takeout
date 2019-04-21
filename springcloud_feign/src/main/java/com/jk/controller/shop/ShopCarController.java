/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ShopCarController
 * Author:   Administrator
 * Date:     2019/4/18 16:51
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.controller.shop;

import com.jk.Service.shop.ShopServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lvdl
 * @create 2019/4/18
 * @since 1.0.0
 */

@RestController
@RequestMapping("shop")
public class ShopCarController {

    @Autowired
    private ShopServiceFeign shopService;

}