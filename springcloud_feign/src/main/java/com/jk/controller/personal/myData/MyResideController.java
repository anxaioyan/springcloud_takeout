/**
 * Copyright (C), 2015-2019
 * FileName: MyResideController
 * Author:   Administrator
 * Date:     2019/4/18 11:21
 * Description: 资料
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.controller.personal.myData;

import com.jk.model.personal.myMaterial.MyResideBean;
import com.jk.service.Personal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈资料〉
 *
 * @author Administrator
 * @create 2019/4/18
 * @since 1.0.0
 */
@Controller
@RequestMapping("myReside")
public class MyResideController {

    @Autowired
    private Personal personal;

    /**
     * 查询地址
     * @return
     */
    @GetMapping("findMyReside")
    @ResponseBody
    public List<MyResideBean> findMyReside(){

        return personal.findMyReside();
    }


    /**
     * 删除地址
     * @param id
     * @return
     */
    @DeleteMapping("deleteMyReside/{id}")
    @ResponseBody
    public Boolean deleteMyReside(@PathVariable("id") Integer id){
        try {
            personal.deleteMyReside(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }

    }


    /**
     * 新增地址信息
     * @param myResideBean
     * @return
     */
    @PostMapping("addMyReside")
    @ResponseBody
    public Boolean addMyReside(@RequestBody  MyResideBean myResideBean){
        try {
            System.out.println(myResideBean.toString());
            personal.addMyReside(myResideBean);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }

    }

    /**
     * 查询回显
     */
    @GetMapping("findUpdeMyResideById/{id}")
    @ResponseBody
    public MyResideBean findUpdeMyResideById(@PathVariable("id") Integer id){
        return  personal.findUpdeMyResideById(id);
    }

    /**
     * 修改
     */
    @PostMapping("upDateMyReside")
    @ResponseBody
    public Boolean upDateMyReside(@RequestBody  MyResideBean myResideBean){
        try {
            System.out.println(myResideBean.toString());
            personal.upDateMyReside(myResideBean);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }

    }



}
