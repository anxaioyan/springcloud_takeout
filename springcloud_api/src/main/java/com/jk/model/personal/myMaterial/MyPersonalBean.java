/**
 * Copyright (C), 2015-2019
 * FileName: MyPersonalBean
 * Author:   Administrator
 * Date:     2019/4/19 19:25
 * Description: 用户资料
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.model.personal.myMaterial;

/**
 * 〈一句话功能简述〉<br> 
 * 〈用户资料〉
 *
 * @author Administrator
 * @create 2019/4/19
 * @since 1.0.0
 */
public class MyPersonalBean {

    private Integer id;

    private String mytopimg;

    private String info;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMytopimg() {
        return mytopimg;
    }

    public void setMytopimg(String mytopimg) {
        this.mytopimg = mytopimg;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }


    @Override
    public String toString() {
        return "MyPersonalBean{" +
                "id=" + id +
                ", mytopimg='" + mytopimg + '\'' +
                ", info='" + info + '\'' +
                '}';
    }

}
