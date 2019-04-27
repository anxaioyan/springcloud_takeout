package com.jk.shiro;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @Description: java类作用描述
 * @Author: 贾志涛
 * @CreateDate: 2019/4/24$ 9:25$
 * @UpdateUser: 贾志涛
 * @UpdateDate: 2019/4/24$ 9:25$
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class MyFormAuthenticationFilfer extends FormAuthenticationFilter {

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        String successUrl = "/page/toIndex";
        WebUtils.issueRedirect(request, response, successUrl);
        return false;
    }

}
