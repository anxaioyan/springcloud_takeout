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
import com.alibaba.fastjson.JSONObject;
import com.jk.mapper.user.UserMapper;
import com.jk.model.shop.GoodBean;
import com.jk.model.shop.ShangBean;
import com.jk.model.shop.ShopBean;
import com.jk.model.user.UserBean;
import com.jk.utils.CommonConst;
import com.jk.utils.DateUtil;
import com.jk.utils.HttpClientUtil;
import com.jk.utils.Md5Util;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @Autowired
    private RedisTemplate redisTemplate;


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
    public HashMap<String, Object> findMenchant(@RequestParam("page") Integer page,@RequestParam("rows") Integer rows,@RequestParam("searchList")String searchList) {
        ShangBean shangBean = JSON.parseObject(searchList, ShangBean.class);
        HashMap<String, Object> hashMap = new HashMap<>();
        //查询总条数
        int total = userMapper.findMerchantCount(shangBean);
        //分页查询
        int start = (page-1)*rows;
        List<ShangBean> list = userMapper.findMenchant(start,rows,shangBean);
        hashMap.put("total", total);
        hashMap.put("rows", list);
        return hashMap;
    }


    @Override
    @ResponseBody
    public List<UserBean> queryReg(String account) {
        return   userMapper.queryReg(account);
    }

    //查询商品

    @Override
    @ResponseBody
    public ShangBean findXiangqingById(Integer id) {
        ShangBean xiangqingById = userMapper.findXiangqingById(id);
        return xiangqingById;
    }

  @Override
    @ResponseBody
    public void saveShops(@RequestParam("id") Integer id, @RequestParam("counts")  Integer counts) {
      GoodBean goodBean = userMapper.findGoodById(id);
       ShopBean shopBean = new ShopBean();
        Integer id1 = goodBean.getId();
        shopBean.setId(id1);
        String name = goodBean.getName();
        shopBean.setName(name);
        String peisong = goodBean.getPeisong();
        shopBean.setPeisong(peisong);
        Integer counts1 = goodBean.getCounts();
        shopBean.setCount(counts1);
        double price = goodBean.getPrice();
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
    public String gainMessgerCode(String account) {
        Object yanzhengma = redisTemplate.opsForValue().get(account);
        if (yanzhengma == null || yanzhengma.equals("")) {
            /*String createRandom = createRandom();
            System.out.println("手机验证码为:" + createRandom);
            redisTemplate.opsForValue().set(account, createRandom);
            redisTemplate.expire(account, 5, TimeUnit.MINUTES);*/
            HashMap<String, Object> params = new HashMap<String, Object>();
            params.put("accountSid", CommonConst.ACCOUNT_SID);
            params.put("templateid", CommonConst.TEMPLATE_ID);
            String createRandom = createRandom();
            params.put("param", createRandom + "," + 5);
            System.out.println("手机验证码为:" + createRandom);
            params.put("to", account);
            String timestamp = DateUtil.dataString(new Date(), null);
            params.put("timestamp", timestamp);
            String md532 = Md5Util.getMd532(CommonConst.ACCOUNT_SID + CommonConst.AUTH_TOKEN + timestamp);
            params.put("sig", md532);
            String returnStr = HttpClientUtil.post("https://api.miaodiyun.com/20150822/industrySMS/sendSMS", params);
            System.out.println(returnStr);
            JSONObject parseObject = JSON.parseObject(returnStr);
            String respCode = parseObject.getString("respCode");
            if(respCode.equals("00000")){
                redisTemplate.opsForValue().set(account, createRandom);
                redisTemplate.expire(account, 5, TimeUnit.MINUTES);
            }
            return "1";
        } else {
            return "0";
        }
    }

    public String createRandom(){
        String number = "";
        for(int i = 0;i<6;i++){
            number = number + (int) (Math.random() * 9);
        }
        return number;
    }

    @Override
    @ResponseBody
    public HashMap<String, Object> messagelogin(String account, String messageCode) {
        HashMap<String, Object> result=new HashMap<>();
//        HttpSession session = request.getSession();
        //验证手机号是否存在
        UserBean user = userMapper.findUserByLoginNumber(account);
        if(user==null){
            result.put("code", 1);
            result.put("msg", "手机号不存在");
            return result;
        }
        //验证短信验证码是否正确
        //判断key是否存在
        if(!redisTemplate.hasKey(account)){
            result.put("code", 2);
            result.put("msg", "验证码已过期");
            return result;
        }
        String yanzhengma = redisTemplate.opsForValue().get(account).toString();
        if(!messageCode.equals(yanzhengma)){
                result.put("code", 3);
                result.put("msg", "手机验证码错误");
                return result;
        }
        //登录成功
        result.put("code", 0);
        result.put("msg", "登陆成功");
//        session.setAttribute(session.getId(),user);
        //清redis缓存
        redisTemplate.delete(account);
        return result;
    }

    @Override
    @ResponseBody
    public void deleteMany(Integer[] ids) {
        userMapper.deleteMany(ids);
    }


    @Override
    @ResponseBody
    public List<GoodBean> findShang(Integer id,String search) {
        GoodBean goodBean = JSON.parseObject(search, GoodBean.class);
        return userMapper.findShang(id,goodBean);
    }

    //回显商品
    @Override
    @ResponseBody
    public GoodBean findGoodById(Integer id) {
        return userMapper.findGoodById(id);
    }
}
