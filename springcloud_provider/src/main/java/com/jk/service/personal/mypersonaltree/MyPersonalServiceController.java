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
import com.jk.model.personal.mypersonaltree.MyRedNumberBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

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

    /**
     * 获取红包
     * @param userId
     * @return
     */
    @Override
    public HashMap<String ,Object> upDateRed(Integer userId) {
        HashMap<String, Object>  parameter = new HashMap<>();

        if(userId!=null){
            int count=myPersonalMapper.findRedCount(userId);
            if (count>=5){
                parameter.put("code",1);
                parameter.put("reg","亲！您还有好多红包么有用，不能再点了呦！");
            }else {
                Random r=new Random();
                Integer redNumber=r.nextInt(10)+1;
                System.out.println(redNumber);
                parameter.put("reg","恭喜获得"+redNumber+"元红包！");
                parameter.put("code",0);
                myPersonalMapper.upDateRed(userId,redNumber);
            }
        }else {
            parameter.put("code",2);
            parameter.put("reg","亲！您还没有登录呢..T_T");
        }
        return parameter;
    }

    /**
     * 查询红包
     * @param id
     * @return
     */
    @Override
    public List<MyRedNumberBean> findRedNumber(Integer id) {
        return myPersonalMapper.findRedNumber(id);
    }

    /**
     * 查询金币
     * @param id
     * @return
     */
    @Override
    public Integer findMyGold(Integer id) {
        return myPersonalMapper.findMyGold(id);
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
