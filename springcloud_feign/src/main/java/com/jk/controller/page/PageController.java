/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: PageController
 * Author:   Administrator
 * Date:     2019/4/16 18:57
 * Description: 跳转页面
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.controller.page
        ;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 〈一句话功能简述〉<br> 
 * 〈跳转页面〉
 *
 * @author Administrator
 * @create 2019/4/16
 * @since 1.0.0
 */

@Controller
@RequestMapping("page")
public class PageController {
    /**
     * 跳转个人资料树页面
     */
    @RequestMapping("toPersonalLayUi")
    public  String toPersonalLayUi(){
        return "personal/tree/personalLayUi";
    }


    /**
     * 跳转个人资料页面
     */
    @RequestMapping("toMyPersonal")
    public  String toPersonal(){
        return "personal/myPersonals/myPersonal";
    }


    /**
     * 跳转修改个人资料页面
     */
    @RequestMapping("toUpDatePersonal")
    public  String upDatePersonal(){
        return "personal/myPersonals/upDatePersonal";
    }




    /**
     * 跳转个人地址管理
     */
    @RequestMapping("toMyReside")
    public  String toMyReside(){
        return "personal/myReside/myReside";
    }


    /**
     * 跳转添加个人地址
     */
    @RequestMapping("toAddMyReside")
    public  String toAddMyReside(){
        return "personal/myReside/addMyReside";
    }

    /**
     * 跳转修改
     */
    @RequestMapping("toUpdeMyReside")
    public String toUpdeMyReside(){

        return "personal/myReside/updateMyReside";
    }




}
