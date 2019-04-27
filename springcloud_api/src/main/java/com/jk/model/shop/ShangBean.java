package com.jk.model.shop;

public class ShangBean {

    /** 主键id */
    private Integer id ;
    /** 商户名称 */
    private String name ;
    /** 商户类型 */
    private Integer type ;
    /** 商户规模 */
    private String standard ;
    /** 商户店铺图片 */
    private String image ;
    /** 商户描述 */
    private String info ;
    /** 商户创建时间 */
    private String expirationdate ;
    /** 店铺负责人 */
    private String principal ;
    /** 店铺开业时间 */
    private String createtime ;
    /** 店铺状态（是否营业） */
    private Integer status ;
    /** 店铺人数 */
    private Integer number ;
    /** 店铺资格证 */
    private String certification ;
    /** 店铺地址 */
    private Integer area ;

    private String areaName;
    /**省级 */
    private Integer city ;

    private String cityName;
    /** 县级 */
    private Integer xian ;

    private String xianName;
    /**详细地址 */
    private String address ;
    /* 营业时间*/
    private String yinye;

    private String peisong;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
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

    public String getExpirationdate() {
        return expirationdate;
    }

    public void setExpirationdate(String expirationdate) {
        this.expirationdate = expirationdate;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getXian() {
        return xian;
    }

    public void setXian(Integer xian) {
        this.xian = xian;
    }

    public String getXianName() {
        return xianName;
    }

    public void setXianName(String xianName) {
        this.xianName = xianName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getYinye() {
        return yinye;
    }

    public void setYinye(String yinye) {
        this.yinye = yinye;
    }

    public String getPeisong() {
        return peisong;
    }

    public void setPeisong(String peisong) {
        this.peisong = peisong;
    }

    @Override
    public String toString() {
        return "ShangBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", standard='" + standard + '\'' +
                ", image='" + image + '\'' +
                ", info='" + info + '\'' +
                ", expirationdate='" + expirationdate + '\'' +
                ", principal='" + principal + '\'' +
                ", createtime='" + createtime + '\'' +
                ", status=" + status +
                ", number=" + number +
                ", certification='" + certification + '\'' +
                ", area=" + area +
                ", areaName='" + areaName + '\'' +
                ", city=" + city +
                ", cityName='" + cityName + '\'' +
                ", xian=" + xian +
                ", xianName='" + xianName + '\'' +
                ", address='" + address + '\'' +
                ", yinye='" + yinye + '\'' +
                ", peisong='" + peisong + '\'' +
                '}';
    }
}
