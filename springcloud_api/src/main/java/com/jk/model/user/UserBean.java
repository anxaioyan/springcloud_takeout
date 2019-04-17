/**
 * Copyright (C), 2015-2019,金科教育
 * FileName: UserBean
 * Author:  张成元
 * Date:     2019/4/16 15:38
 * Description: a
 * History:
 * <author>          <time>          <version>          <desc>
 * 张成元           修改时间           版本号              描述
 */
package com.jk.model.user;

/**
 * 〈一句话功能简述〉<br> 
 * 〈a〉
 *
 * @author 张成元
 * @create 2019/4/16
 * @since 1.0.0
 */
public class UserBean {
    private Integer id;

    private String account;

    private String password;

    private String repassword;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", repassword='" + repassword + '\'' +
                '}';
    }
}
