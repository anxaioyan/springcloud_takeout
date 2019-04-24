/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: MyRealm
 * Author:   zyl
 * Date:     2018/12/26 13:56
 * Description: test
 * History:
 */
package com.jk.shiro;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.jk.model.user.UserBean;
import com.jk.service.user.UserServiceFeign;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 〈一句话功能简述〉<br> 
 * 〈test〉
 *
 * @author zyl
 * @create 2018/12/26
 * @since 1.0.0
 */
public class MyRealm extends AuthorizingRealm {

    @Resource
    private UserServiceFeign userServcice;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //获取主身份信息
    	String  string = (String) principals.getPrimaryPrincipal();
    	List<String> arr = new ArrayList<String>();
 	   	arr=  userServcice.queryUserId(string);
        //根据身份信息获取权限信息
        //模拟从数据库获取到数据
        List<String> permissions = new ArrayList<String>();
        
        for (String string1 : arr) {
        	if(string1!=null){
        		permissions.add(string1);
        	}
		}
        
       /* //根据身份信息获取权限信息
        //模拟从数据库获取到数据
        List<String> permissions = new ArrayList<String>();
        permissions.add("user:create"); //用户的创建权限
        permissions.add("user:update"); //商品的添加权限
        permissions.add("user:delete"); //商品的添加权限
        permissions.add("user:add"); //商品的添加权限
*/
        //将查询到授权信息填充到对象中
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissions);

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //1.从token取出用户身份信息
        String account = (String)token.getPrincipal();
        
        String password="";
        
        UserBean user = userServcice.queryUserByName(account);
        if(user!=null){
        	if(!account.equals(user.getAccount())){//这里模拟查询不到
                throw new UnknownAccountException();
            }
            //2.根据用户userCode查询数据库


            //模拟从数据库查询到的密码
        	password = user.getPassword();
        }else{
        	throw new UnknownAccountException();
        }
        
        //查询到返回认证信息
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(account,password,this.getName());
        SecurityUtils.getSubject().getSession().setAttribute("login", account);
        return authenticationInfo;
    }

}
