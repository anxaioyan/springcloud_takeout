/**
 * Copyright (C), 2015-2019
 * FileName: MyResideBean
 * Author:   Administrator
 * Date:     2019/4/18 11:08
 * Description: 地址实体
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.model.personal.myMaterial;

/**
 * 〈一句话功能简述〉<br> 
 * 〈地址实体〉
 *
 * @author Administrator
 * @create 2019/4/18
 * @since 1.0.0
 */
public class MyResideBean {

    private Integer id;

    private String  surName;

    private String  sex;

    private String  areaReside;

    private String  address;

    private String  tel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getAreaReside() {
        return areaReside;
    }

    public void setAreaReside(String areaReside) {
        this.areaReside = areaReside;
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "MyResideBean{" +
                "id=" + id +
                ", surName='" + surName + '\'' +
                ", sex='" + sex + '\'' +
                ", areaReside='" + areaReside + '\'' +

                ", address='" + address + '\'' +
                ", tel=" + tel +
                '}';
    }
}
