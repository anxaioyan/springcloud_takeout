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
import com.jk.model.shop.MerchantBean;
import com.jk.model.shop.ShopBean;
import com.jk.model.user.UserBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
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

    //查询商品
    @Override
    @ResponseBody
    public HashMap<String, Object> findMenchant(Integer page,Integer rows,String searchList) {
        MerchantBean merchantBean = JSON.parseObject(searchList,MerchantBean.class);
        HashMap<String, Object> hashMap = new HashMap<>();
        //查询总条数
        int total = userMapper.findMerchantCount(merchantBean);
        //分页查询
        int start = (page-1)*rows;
        List<MerchantBean> list = userMapper.findMenchant(start,rows,merchantBean);
        hashMap.put("total", total);
        hashMap.put("rows", list);
        return hashMap;
    }

    @Override
    @ResponseBody
    public MerchantBean findXiangqingById(Integer id) {
        return userMapper.findXiangqingById(id);
    }

    /*@Override
    @ResponseBody
    public void saveShop(@RequestParam("id") Integer id,@RequestParam("counts")  Integer counts) {
        MerchantBean merchantBean = userMapper.findXiangqingById(id);
        ShopBean shopBean = new ShopBean();
        Integer id1 = merchantBean.getId();
        shopBean.setSid(id1);
        String name = merchantBean.getName();
        shopBean.setName(name);
        String peisong = merchantBean.getPeisong();
        shopBean.setPeisong(peisong);
        Integer counts1 = merchantBean.getCounts();
        shopBean.setCount(counts1);
        double price = merchantBean.getPrice();
        shopBean.setPrice(price);
        mongoTemplate.save(shopBean);
    }*/

    @Override
    @ResponseBody
    public void saveShops(@RequestParam("id") Integer id, @RequestParam("counts")  Integer counts) {
        MerchantBean merchantBean = userMapper.findXiangqingById(id);
        ShopBean shopBean = new ShopBean();
        Integer id1 = merchantBean.getId();
        shopBean.setId(id1);
        String name = merchantBean.getName();
        shopBean.setName(name);
        String peisong = merchantBean.getPeisong();
        shopBean.setPeisong(peisong);
        Integer counts1 = merchantBean.getCounts();
        shopBean.setCount(counts1);
        double price = merchantBean.getPrice();
        shopBean.setPrice(price);
        userMapper.saveShops(shopBean);
    }


    @Override
    @ResponseBody
    public ShopBean findShopListById(Integer id) {
        return userMapper.findShopListById(id);
    }

    @Override
    @ResponseBody
    public List<ShopBean> findShop() {
        return userMapper.findShop();
    }

    @Override
    @ResponseBody
    public void delOne(Integer id) {
        userMapper.delOne(id);
    }

    @Override
    @ResponseBody
    public void deleteMany(Integer[] ids) {
        userMapper.deleteMany(ids);
    }


}
