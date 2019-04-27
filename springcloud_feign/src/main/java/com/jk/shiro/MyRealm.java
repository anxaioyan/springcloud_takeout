/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: MyRealm
 * Author:   zyl
 * Date:     2018/12/26 13:56
 * Description: test
 * History:
 */
package com.jk.shiro;


import com.jk.model.user.UserBean;
import com.jk.service.user.UserServiceFeign;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈test〉
 *
 * @author zyl
 * @create 2018/12/26
 * @since 1.0.0
 */
public class MyRealm extends AuthorizingRealm {

	/*    @Resource
        private UserService userServcice;*/
	@Autowired
	private UserServiceFeign userService;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		//获取主身份信息
		String userCode = (String)principals.getPrimaryPrincipal();

		//根据身份信息获取权限信息
		//模拟从数据库获取到数据
		//将roleid通过userid返回

		//List<String> permissions = userService.queryRolePowerByUserName(userCode);
		//将查询到授权信息填充到对象中
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//info.addStringPermissions(permissions);

		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//1.从token取出用户身份信息
		String username = (String)token.getPrincipal();
		UserBean user = userService.queryUserByName(username);
		//System.out.println(user);
		//如果查询不到则返回null
		if(user!=null){
			if(!username.equals(user.getAccount())){//这里模拟查询不到
				throw new UnknownAccountException();
			}}
		//2.根据用户userCode查询数据库

		//模拟从数据库查询到的密码
		String password =user.getPassword();

		//查询不到返回null

		//查询到返回认证信息
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username,password,this.getName());
		SecurityUtils.getSubject().getSession().setAttribute("user", user);
		return authenticationInfo;
	}

}
