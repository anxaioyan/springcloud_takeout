/**
 * Copyright (C), 2015-2019,金科教育
 * FileName: UserController
 * Author:  张成元
 * Date:     2019/4/16 22:28
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 张成元           修改时间           版本号              描述
 */
package com.jk.controller.user;

import com.jk.service.user.UserServiceFeign;
import com.jk.model.shop.MerchantBean;
import com.jk.model.shop.ShopBean;
import com.jk.model.user.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 张成元
 * @create 2019/4/16
 * @since 1.0.0
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServiceFeign userService;


    @PostMapping("login")
    @ResponseBody
    public HashMap<String, Object> login(@RequestParam("name") String name) {
        HashMap<String, Object> result=userService.login(name);
        System.out.println("----------------------------------------------s"+name);

        return result;
    }

    @GetMapping("queryReg")
    @ResponseBody
    public List<UserBean> queryReg(@RequestParam("account")String account) {
        return  userService.queryReg(account);
    }

    @PostMapping("reg")
    @ResponseBody
    public  Boolean reg(@RequestBody UserBean userBean){
        try {
            return userService.reg(userBean);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @GetMapping("findMenchant")
    @ResponseBody
    public HashMap<String,Object> findMenchant(@RequestParam("page") Integer page,@RequestParam("rows") Integer rows,@RequestParam("searchList")String searchList) {
        return  userService.findMenchant(page,rows,searchList);
    }
    //到详情页面
    @RequestMapping("toXiangqing")
    public String toShowInfo(Integer id, Model md){
        md.addAttribute("id",id);
        return "xiangqing";
        //   return "商品详情";
    }
    //到详情页面
    @RequestMapping("toShop")
    public String toShop(Integer id, Model md){
        md.addAttribute("id",id);
        return "shop";
        //   return "商品详情";
    }
    @GetMapping("findXiangqingById/{id}")
    @ResponseBody
    public MerchantBean findXiangqingById(@PathVariable("id") Integer id){
        return userService.findXiangqingById(id);
    }

    @PostMapping("saveShops")
    @ResponseBody
    public void saveShops(@RequestParam("id") Integer id,@RequestParam("counts")Integer counts){
        userService.saveShops(id,counts);
    }


    @GetMapping("findShopListById/{id}")
    @ResponseBody
    public ShopBean findShopListById(@PathVariable("id") Integer id){
        return userService.findShopListById(id);
    }

    @GetMapping("findShop")
    @ResponseBody
    public  List<ShopBean> findShop(){
        return userService.findShop();
    }

    //购物车删除
    @DeleteMapping("delOne/{id}")
    @ResponseBody
    public  void delOne(@PathVariable("id") Integer id){
        userService.delOne(id);
    }
}
