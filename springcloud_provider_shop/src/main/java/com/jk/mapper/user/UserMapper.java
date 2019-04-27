/**
 * Copyright (C), 2015-2019,金科教育
 * FileName: UserMapper
 * Author:  张成元
 * Date:     2019/4/16 22:38
 * Description: a
 * History:
 * <author>          <time>          <version>          <desc>
 * 张成元           修改时间           版本号              描述
 */
package com.jk.mapper.user;


import com.jk.model.shop.GoodBean;
import com.jk.model.shop.ShangBean;
import com.jk.model.shop.ShopBean;
import com.jk.model.user.UserBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈a〉
 *
 * @author 张成元
 * @create 2019/4/16
 * @since 1.0.0
 */
public interface UserMapper {

    UserBean findUserInfoByAccount(String account);
    //注册
    List<UserBean> queryReg(String account);

    int getUserInfoByAccount(String account);

    void reg(UserBean userBean);

    //查询
    int findMerchantCount(@Param("shangBean")ShangBean shangBean);
    List<ShangBean> findMenchant(@Param("start")int start,@Param("rows") Integer rows,@Param("shangBean")ShangBean shangBean);

    //回显
    ShangBean findXiangqingById(Integer id);

    void saveShops(ShopBean shopBean);

    ShopBean findShopListById(Integer id);

    List<ShopBean> findShop();

    void delOne(Integer id);

    UserBean findUserByLoginNumber(String phoneNumber);

    void deleteMany(@Param("ids") Integer[] ids);

    List<GoodBean> findShang(@Param("id") Integer id,@Param("goodBean") GoodBean goodBean);

    GoodBean findGoodById(Integer id);





    @Select("select * from t_reg t where t.account=#{account}")
    UserBean queryUserByName(@Param("account") String account);

    @Select("select * from t_reg t where t.account=#{account}")
    List<String> queryUserId(String string);
}
