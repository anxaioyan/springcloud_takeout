/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: MyPersonalTree
 * Author:   Administrator
 * Date:     2019/4/16 16:14
 * Description: 个人资料展示
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.model.personal.mypersonaltree
        ;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈个人资料展示〉
 *
 * @author Administrator
 * @create 2019/4/16
 * @since 1.0.0
 */


public class MyPersonalTreeBean {

    private  Integer  id;

    private  String  name;

    private  Integer pid;

    private  String  url;

    private  String  menuIcon;

    private  Boolean  spread=true;

    private List<MyPersonalTreeBean> children;




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Boolean getSpread() {
        return spread;
    }

    public void setSpread(Boolean spread) {
        this.spread = spread;
    }

    public List<MyPersonalTreeBean> getChildren() {
        return children;
    }

    public void setChildren(List<MyPersonalTreeBean> children) {
        this.children = children;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    @Override
    public String toString() {
        return "MyPersonalTreeBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pid=" + pid +
                ", url='" + url + '\'' +
                ", menuIcon='" + menuIcon + '\'' +
                ", spread=" + spread +
                ", children=" + children +
                '}';
    }
}
