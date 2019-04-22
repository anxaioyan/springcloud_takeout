package com.jk.model.shop;

public class Pingjia {

    private Integer id;
    private String neirong;
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNeirong() {
        return neirong;
    }

    public void setNeirong(String neirong) {
        this.neirong = neirong;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Pingjia{" +
                "id=" + id +
                ", neirong='" + neirong + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
