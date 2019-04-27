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


import com.jk.model.shop.GoodBean;
import com.jk.model.shop.ShangBean;
import com.jk.model.shop.ShopBean;
import com.jk.model.user.UserBean;
import com.jk.service.user.UserServiceFeign;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private SolrClient client;


    @PostMapping("login")
    @ResponseBody
    public HashMap<String, Object> login(@RequestParam("name") String name) {
        HashMap<String, Object> result = userService.login(name);
        System.out.println("----------------------------------------------s" + name);

        return result;
    }

    @GetMapping("queryReg")
    @ResponseBody
    public List<UserBean> queryReg(@RequestParam("account") String account) {
        return userService.queryReg(account);
    }

    @PostMapping("reg")
    @ResponseBody
    public Boolean reg(@RequestBody UserBean userBean) {
        try {
            return userService.reg(userBean);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @GetMapping("findMenchant")
    @ResponseBody
    public HashMap<String, Object> findMenchant(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows,@RequestParam("searchList") String searchList) {

        return userService.findMenchant(page, rows,searchList);
    }

    //到详情页面
    @RequestMapping("toXiangqing")
    public String toShowInfo(Integer id, Model md) {
        md.addAttribute("id", id);
        return "xiangqing";
    }


    @GetMapping("findXiangqingById/{id}")
    @ResponseBody
    public ShangBean findXiangqingById(@PathVariable("id") Integer id) {
        return userService.findXiangqingById(id);
    }

    @PostMapping("saveShops")
     @ResponseBody
    public void saveShops(@RequestParam("id") Integer id, @RequestParam("counts") Integer counts) {
        deleteRedis();
        userService.saveShops(id, counts);
    }


    @GetMapping("findShopListById/{id}")
    @ResponseBody
    public ShopBean findShopListById(@PathVariable("id") Integer id) {
        return userService.findShopListById(id);
    }

    @GetMapping("findShop")
    @ResponseBody
    public List<ShopBean> findShop() {
        List<ShopBean> shopList = new ArrayList<>();
//1、定义缓冲key
        String key = "shopKey";
        //2、从缓冲中查找是否有当前用户的权限树
        if (!redisTemplate.hasKey(key)) {
            System.out.println("-----------走数据库");
            //3、如果没有：a.从数据库查  b. 把数据缓冲到redis
            shopList = userService.findShop();
            //b. 把数据缓冲到redis
            redisTemplate.opsForValue().set(key, shopList);
        } else {
            System.out.println("-----------走缓冲");
            //4、如果有：从缓冲中获取返回数据
            shopList = (List<ShopBean>) redisTemplate.opsForValue().get(key);
        }
        return shopList;
    }

    //删除redis缓存
    @RequestMapping("deleteRedis")
    @ResponseBody
    public void deleteRedis() {
        redisTemplate.delete("shopKey");
    }


    //购物车删除
    @DeleteMapping("delOne/{id}")
    @ResponseBody
    public void delOne(@PathVariable("id") Integer id) {
        deleteRedis();
        userService.delOne(id);
    }

    //删除
    @DeleteMapping("deleteMany")
    @ResponseBody
    public void deleteMany(@RequestParam("ids") Integer[] ids) {
        deleteRedis();
        userService.deleteMany(ids);
    }


    //手机验证码
    @GetMapping("gainMessgerCode")
    @ResponseBody
    public String gainMessgerCode(@RequestParam("account") String account) {
        return userService.gainMessgerCode(account);
    }

    @GetMapping("messagelogin")
    @ResponseBody
    public HashMap<String, Object> messagelogin(@RequestParam("account") String account, @RequestParam("messageCode") String messageCode) {
        return userService.messagelogin(account, messageCode);
    }



    //shiro登录

/*
    @RequestMapping("login2")
    public String login2(HttpServletRequest request, Model model) {
        ////获得验证的异常信息的名称，提示用户是账号错误还是密码错误
        String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
        if(UnknownAccountException.class.getName().equals(exceptionClassName)|| AuthenticationException.class.getName().equals(exceptionClassName)){
            model.addAttribute("message","UnknownAccountException -- > 账号不存在：");

        }else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            model.addAttribute("message","：IncorrectCredentialsException密码错误");
        }
        //登录失败之后 再跳转回登录页面
        //访问其他页面时 只要不是登录成功状态 都会跳转到登录页面
        return "login";
    }
*/

    /**
     * 当用户名密码不正确时
     * 跳转到此方法
     * 认证失败之后会进入此方法 提示用户失败原因
     * @return
     */
    @RequestMapping("login2")
    public String login2(HttpServletRequest request,Model model) {
        ////获得验证的异常信息的名称，提示用户是账号错误还是密码错误
        String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
        if(UnknownAccountException.class.getName().equals(exceptionClassName)|| AuthenticationException.class.getName().equals(exceptionClassName)){
            model.addAttribute("message","账号不存在：");

        }else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            model.addAttribute("message","密码错误");
        }
        //登录失败之后 再跳转回登录页面
        //访问其他页面时 只要不是登录成功状态 都会跳转到登录页面
        return "login";
    }

    /*solr搜索*/
    @RequestMapping("search")
    @ResponseBody
    public Map<String, Object> merchantList(GoodBean good, Integer page, Integer rows, HttpServletRequest request) throws IOException, SolrServerException {
        System.out.println("---" + good.getName());
        //因为使用easyui返回数据
        Map<String, Object> mSolr = new HashMap<String, Object>();
        //把所有查询的高亮显示内容发到list中
        List<GoodBean> goodList = new ArrayList<>();
        //查询条件的对象
        SolrQuery params = new SolrQuery();
        //判断前台传递的关键字是否为空
        if (!"".equals(good.getName()) && good.getName() != null) {
            //不为空设置条件为关键字
            params.set("q", good.getName());
        } else {//如果为空查询所有
            params.set("q", "*:*");

        }
        //默认查询字段  一般默认指定
        params.set("df", "name");
        //指定查询结果返回哪些字段
        params.set("fl", "id,name,info,price,peisong,image");
        // 设置高亮字段
        params.addHighlightField("name"); // 高亮字段
        //分页
        if (page == null) {
            params.setStart(0);
        } else {
            params.setStart((page - 1) * rows);
        }
        if (rows == null) {
            params.setRows(5);
        } else {
            params.setRows(rows);
        }
        //高亮
        //打开开关
        params.setHighlight(true);
        //设置前缀
        params.setHighlightSimplePre("<span style='color:red'>");
        //设置后缀
        params.setHighlightSimplePost("</span>");
        //QueryResponse是查询返回的对象数据   client.query("core1",params)  查询的是哪个索引库和条件
        QueryResponse queryResponse = client.query("core1", params);
        ///查询返回的结果list对象   不包括高亮
        SolrDocumentList results = queryResponse.getResults();
        //查询出来总条数
        long numFound = results.getNumFound();
        //查询返回的高亮结果
        Map<String, Map<String, List<String>>> highlight = queryResponse.getHighlighting();
        //循环查询的所有结果
        for (SolrDocument result : results) {
            //创建对象接收循环的对象数据
            GoodBean goodBean1 = new GoodBean();
            //设置高亮的字段
            String highname = "";
            //根据id获得高亮的内容
            Map<String, List<String>> map = highlight.get(result.get("id"));
            //根据高亮字段拿到数据
            List<String> list = map.get("name");
            //判断数据是否为空
            if (list == null) {
                //如果为空把普通字段放到对象中
                highname = (String) result.get("name");
            } else {
                //获得高亮字段查询的值放到变量
                highname = list.get(0);
            }
            goodBean1.setId(Integer.parseInt((String) result.get("id")));
            goodBean1.setName(highname);
            goodBean1.setInfo((String) result.get("info"));
            goodBean1.setPrice((Double) result.get("price"));
            goodBean1.setPeisong((String) result.get("peisong"));
            goodBean1.setImage((String) result.get("image"));
            goodList.add(goodBean1);
        }
        mSolr.put("total", numFound);
        mSolr.put("rows", goodList);
        String key = "keys";
        redisTemplate.opsForValue().set(key, goodList);
        return mSolr;
    }

    @RequestMapping("findSearch")
    @ResponseBody
    public List<GoodBean> findSearch(HttpServletRequest request) {
        String key = "keys";
        List<GoodBean> list = (List<GoodBean>) redisTemplate.opsForValue().get(key);
        for (GoodBean li : list) {
            System.out.println(li.getName());
            System.out.println("===========" + li.getPrice());
            System.out.println("===========" + li.getImage());
        }
        redisTemplate.delete(key);
        return list;
    }

    //根据商铺id查询商品
    @GetMapping("findShang/{id}")
    @ResponseBody
    public List<GoodBean> findShang(@PathVariable("id") Integer id,@RequestParam("search") String search) {
        return userService.findShang(id,search);
    }
    @GetMapping("findGoodById/{id}")
    @ResponseBody
    public GoodBean findGoodById(@PathVariable("id") Integer id){
        return userService.findGoodById(id);
    }

}
