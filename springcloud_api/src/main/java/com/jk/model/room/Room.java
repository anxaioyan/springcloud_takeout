/**
 * Copyright (C), 2019, 金科
 * FileName:
 * Author:   赵传明
 * Date:
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.model.room;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 琪
 * @create 2019/4/23
 * @since 1.0.0
 */
public class Room {


    private  Integer roomid;
    private  String  roomname;
    private  Integer  shopid;
    private  Integer roomstatus;
    private  Integer  shopstatus;
    private  String   shopstore;
    private  String  shopname;

    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }

    public Integer getShopid() {
        return shopid;
    }

    public Integer getShopstatus() {
        return shopstatus;
    }

    public void setShopstatus(Integer shopstatus) {
        this.shopstatus = shopstatus;
    }

    public String getShopstore() {
        return shopstore;
    }

    public void setShopstore(String shopstore) {
        this.shopstore = shopstore;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public Integer getRoomstatus() {
        return roomstatus;
    }

    public void setRoomstatus(Integer roomstatus) {
        this.roomstatus = roomstatus;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }
}
