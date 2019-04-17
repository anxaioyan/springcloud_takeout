/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: MyPersonalServiceController
 * Author:   Administrator
 * Date:     2019/4/16 19:36
 * Description: 个人资料树
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.service.personal.mypersonaltree
        ;

import com.jk.mapper.personal.mypersonaltree.MyPersonalMapper;
import com.jk.model.personal.mypersonaltree.MyPersonalTreeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈个人资料树〉
 *
 * @author Administrator
 * @create 2019/4/16
 * @since 1.0.0
 */

@Controller
public class MyPersonalServiceController implements MyPersonalTreeApiService{

    @Autowired
    private MyPersonalMapper myPersonalMapper;

    @Override
    public List<MyPersonalTreeBean> treeListMy() {

        Integer pid=0;
        List<MyPersonalTreeBean> list = getNodes(pid);
        return list;

    }

    private List<MyPersonalTreeBean> getNodes(Integer pid) {

        List<MyPersonalTreeBean> list = myPersonalMapper.queryTreeBeanBy(pid);

        for (MyPersonalTreeBean treeBean : list) {
            Integer id = treeBean.getId();
            List<MyPersonalTreeBean> nodes = getNodes(id);
            treeBean.setChildren(nodes);
        }
        return list;
    }

}
