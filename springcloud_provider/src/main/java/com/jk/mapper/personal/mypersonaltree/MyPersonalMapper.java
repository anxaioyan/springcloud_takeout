/**
 * Copyright (C), 2015-2019
 * FileName: MyPersonalMapper
 * Author:   Administrator
 * Date:     2019/4/17 10:29
 * Description: 树mapper层
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.mapper.personal.mypersonaltree;

import com.jk.model.personal.myMaterial.MyPersonalBean;
import com.jk.model.personal.myMaterial.MyResideBean;
import com.jk.model.personal.mypersonaltree.MyPersonalTreeBean;
import com.jk.model.personal.mypersonaltree.MyRedNumberBean;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈树mapper层〉
 *
 * @author Administrator
 * @create 2019/4/17
 * @since 1.0.0
 */
public interface MyPersonalMapper {

    List<MyPersonalTreeBean> queryTreeBeanBy(Integer pid);

    List<MyResideBean> findMyReside();

    void deleteMyReside(Integer id);

    void addMyReside(MyResideBean myResideBean);

    MyResideBean findUpdeMyResideById(Integer id);

    void upDateMyReside(MyResideBean myResideBean);

    MyPersonalBean findMyPersonal(Integer id);

    void upDatePersonal(MyPersonalBean myPersonalBean);

    void upDateRed(Integer userId, Integer redNumber);

    int findRedCount(Integer userId);

    List<MyRedNumberBean> findRedNumber(Integer id);

    Integer findMyGold(Integer id);
}