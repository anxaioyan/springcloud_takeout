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
import com.jk.model.personal.myMaterial.MyPersonalBean;
import com.jk.model.personal.myMaterial.MyResideBean;
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

    /**
     * 查询个人中心树
     * @return
     */
    @Override
    public List<MyPersonalTreeBean> treeListMy() {

        Integer pid=0;
        List<MyPersonalTreeBean> list = getNodes(pid);
        return list;

    }

    /**
     * 查询个人地址资料
     * @return
     */
    @Override
    public List<MyResideBean> findMyReside() {
        return myPersonalMapper.findMyReside();
    }

    /**
     * 删除个人地址
     * @param id
     */
    @Override
    public void deleteMyReside(Integer id) {
        myPersonalMapper.deleteMyReside(id);
    }

    /**
     * 新增地址
     * @param myResideBean
     */
    @Override
    public void addMyReside(MyResideBean myResideBean) {
        myPersonalMapper.addMyReside(myResideBean);
    }

    /**
     * 修改回显
     * @param id
     * @return
     */
    @Override
    public MyResideBean findUpdeMyResideById(Integer id) {

        return myPersonalMapper.findUpdeMyResideById(id);
    }

    /**
     * 修改地址
     * @param myResideBean
     */
    @Override
    public void upDateMyReside(MyResideBean myResideBean) {
        myPersonalMapper.upDateMyReside(myResideBean);
    }


    /**
     * 通过用户id查询资料
     * @param id
     * @return
     */
    @Override
    public MyPersonalBean findMyPersonal(Integer id) {

        return myPersonalMapper.findMyPersonal(id);
    }


    /**
     * 修改个人资料
     * @param myPersonalBean
     */
    @Override
    public void upDatePersonal(MyPersonalBean myPersonalBean) {
        myPersonalMapper.upDatePersonal(myPersonalBean);
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
