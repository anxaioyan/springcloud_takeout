/**
 * Copyright (C), 2015-2019
 * FileName: MyRedNumberBean
 * Author:   Administrator
 * Date:     2019/4/22 20:18
 * Description: 红包
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.model.personal.mypersonaltree;

/**
 * 〈一句话功能简述〉<br> 
 * 〈红包〉
 *
 * @author Administrator
 * @create 2019/4/22
 * @since 1.0.0
 */
public class MyRedNumberBean {

    private Integer id;

    private Integer redNumber;

    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRedNumber() {
        return redNumber;
    }

    public void setRedNumber(Integer redNumber) {
        this.redNumber = redNumber;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "MyRedNumberBean{" +
                "id=" + id +
                ", redNumber=" + redNumber +
                ", userId=" + userId +
                '}';
    }
}
