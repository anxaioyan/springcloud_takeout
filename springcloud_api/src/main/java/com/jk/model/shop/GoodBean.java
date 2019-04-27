package com.jk.model.shop;

import java.io.Serializable;

public class GoodBean implements Serializable {

    private static final long serialVersionUID = -4469302056838993663L;
    private Integer id;
    private String name;
    private String  type;
    private String image;
    private String info;
    private Integer counts;
    private Integer peoplebuy;
    private Integer updown;
    private String peisong;
    private Double price;
    private Integer shangId;
    private String ShangName;
    private Integer pingfen;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public Integer getPeoplebuy() {
        return peoplebuy;
    }

    public void setPeoplebuy(Integer peoplebuy) {
        this.peoplebuy = peoplebuy;
    }

    public Integer getUpdown() {
        return updown;
    }

    public void setUpdown(Integer updown) {
        this.updown = updown;
    }

    public String getPeisong() {
        return peisong;
    }

    public void setPeisong(String peisong) {
        this.peisong = peisong;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getShangId() {
        return shangId;
    }

    public void setShangId(Integer shangId) {
        this.shangId = shangId;
    }

    public String getShangName() {
        return ShangName;
    }

    public void setShangName(String shangName) {
        ShangName = shangName;
    }

    public Integer getPingfen() {
        return pingfen;
    }

    public void setPingfen(Integer pingfen) {
        this.pingfen = pingfen;
    }

    @Override
    public String toString() {
        return "GoodBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", image='" + image + '\'' +
                ", info='" + info + '\'' +
                ", counts=" + counts +
                ", peoplebuy=" + peoplebuy +
                ", updown=" + updown +
                ", peisong='" + peisong + '\'' +
                ", price=" + price +
                ", shangId=" + shangId +
                ", ShangName='" + ShangName + '\'' +
                ", pingfen=" + pingfen +
                '}';
    }
}
