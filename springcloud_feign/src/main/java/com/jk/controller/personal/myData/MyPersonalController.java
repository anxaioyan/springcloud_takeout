/**
 * Copyright (C), 2015-2019
 * FileName: MyPersonalController
 * Author:   Administrator
 * Date:     2019/4/21 10:07
 * Description: 查询个人资料
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.controller.personal.myData;

import com.aliyun.oss.OSSClient;
import com.jk.model.personal.myMaterial.MyPersonalBean;
import com.jk.model.personal.myMaterial.MyResideBean;
import com.jk.model.personal.mypersonaltree.MyRedNumberBean;
import com.jk.service.Personal;
import com.jk.utils.AliyunOSSClientUtil;
import com.jk.utils.OSSClientConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.HashMap;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈查询个人资料〉
 *
 * @author Administrator
 * @create 2019/4/21
 * @since 1.0.0
 */
@Controller
@RequestMapping("myPersonal")
public class MyPersonalController {

    @Autowired
    private Personal personal;


    @GetMapping("findMyPersonal/{id}")
    @ResponseBody
    public MyPersonalBean findMyPersonal(@PathVariable("id") Integer id){

        //假数据 假如从redis取出1
        id=1;
        return personal.findMyPersonal(id);

    }



    /**
     * 新增地址信息
     * @param myResideBean
     * @return
     */
    @PostMapping("upDatePersonal")
    @ResponseBody
    public Boolean upDatePersonal(@RequestBody MyPersonalBean myPersonalBean ){

        try {

            System.out.println(myPersonalBean.toString());
            personal.upDatePersonal(myPersonalBean);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }

    }


    /**
     * 获取红包
     * @return
     */
    @GetMapping("upDateRed")
    @ResponseBody
    public HashMap<String,Object> upDateRed(){
           Integer userId=1;
           HashMap<String ,Object> pman= personal.upDateRed(userId);
           return pman;
    }

    /**
     * 查询红包
     */
    @GetMapping("findRedNumber")
    @ResponseBody
    public List<MyRedNumberBean> findRedNumber(){
        Integer id=1;
        return personal.findRedNumber(id);

    }

}
