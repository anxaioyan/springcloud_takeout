/**
<<<<<<< HEAD
 * Copyright (C), 2015-2019,金科教育
 * FileName: PageController
 * Author:  张成元
 * Date:     2019/4/16 22:30
 * Description: a
 * History:
 * <author>          <time>          <version>          <desc>
 * 张成元           修改时间           版本号              描述
 */
package com.jk.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 〈一句话功能简述〉<br> 
 * 〈a〉
 *
 * @author 张成元
 * @create 2019/4/16
 * @since 1.0.0
 */
@Controller
@RequestMapping("page")
public class PageController {

    @RequestMapping("tologin")
    public  String tologin(){
        return "login";
    }

    @RequestMapping("toTelLogin")
    public  String toTelLogin(){
        return "tellogin";
    }

    //注册
    @RequestMapping("toReg")
    public  String toReg(){
        return "reg";
    }
    //首页
    @RequestMapping("toMyIndex")
    public  String toMyIndex(){
        return "myIndex";
    }

    @RequestMapping("toMain")
    public  String toMain(){
        return "main";
    }

    @RequestMapping("toShou")
    public  String toShou(){
        return "shou";
    }


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

    @RequestMapping("toShop")
    public  String toShop(){
        return "shop";
    }

    //到详情页面
    @RequestMapping("toXiangqing")
    public String toShowInfo(Integer id, Model md){
        md.addAttribute("id",id);
        return "xiangqing";
        //   return "商品详情";
    }
    @RequestMapping("toPingjia")
    public  String toPingjia(){
        return "pingjia";
    }
    @RequestMapping("toGouwu")
    public  String toGouwu(){
        return "gouwu";
    }


    /**
     * 跳转红包
     */
    @RequestMapping("toMyRedb")
    public String toMyRedb(){
        return "personal/myAssets/myRedb";
    }


    /**
     * 跳转余额
     */
    @RequestMapping("toMyBalance")
    public String toMyBalance(){
        return "personal/myAssets/myBalance";
    }

    /**
     * 跳转金币
     */
    @RequestMapping("toMyGold")
    public String toMyGold(){
        return "personal/myAssets/myGold";
    }

    /**
     * 跳转近期订单
     */
    @RequestMapping("toMyOrder")
    public String toMyOrder(){
        return "personal/myOrder/myOrder";
    }

    /**
     * 跳转近期订单
     */
    @RequestMapping("toMyCollection")
    public String toMyCollection(){
        return "personal/myCollection/myCollection";
    }

    /**
     * 跳转评论页面
     */
    @GetMapping("/toComment")
    public String toComment(){
        return "comment";
    }
}
