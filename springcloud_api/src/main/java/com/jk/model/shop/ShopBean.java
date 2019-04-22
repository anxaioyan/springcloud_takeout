package com.jk.model.shop;


import java.io.Serializable;

//@Document(collection = "t_shop")
public class ShopBean implements Serializable {

  //  private String id;
   private Integer id;
    private String name;
    private String peisong;
    private Integer count;
    private Double price;


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

    public String getPeisong() {
        return peisong;
    }

    public void setPeisong(String peisong) {
        this.peisong = peisong;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ShopBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", peisong='" + peisong + '\'' +
                ", count=" + count +
                ", price=" + price +
                '}';
    }
}
