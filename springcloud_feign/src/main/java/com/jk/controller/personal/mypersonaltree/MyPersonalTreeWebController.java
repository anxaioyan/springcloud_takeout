package com.jk.controller.personal.mypersonaltree;
/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: MyPersonalTree
 * Author:   Administrator
 * Date:     2019/4/16 19:02
 * Description: 个人资料 树
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */



import com.jk.model.personal.mypersonaltree.MyPersonalTreeBean;
import com.jk.service.Personal;
import com.jk.service.personal.mypersonaltree.MyPersonalTreeApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈个人资料 树〉
 *
 * @author Administrator
 * @create 2019/4/16
 * @since 1.0.0
 */

@Controller
@RequestMapping("myPersonalTree")
public class MyPersonalTreeWebController {

    @Autowired
    private Personal personal;

    /**
     * 个人资料树
     */
    @GetMapping("treeListMy")
    @ResponseBody
    public List<MyPersonalTreeBean> treeListMy(){
        List<MyPersonalTreeBean> myPersonalTreeBeans = personal.treeListMy();
       System.out.println(myPersonalTreeBeans.toString());
        return myPersonalTreeBeans;
    }




}
