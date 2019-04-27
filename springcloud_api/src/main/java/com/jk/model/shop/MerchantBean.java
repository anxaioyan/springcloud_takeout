package com.jk.model.shop;

import java.io.Serializable;

public class MerchantBean implements Serializable {

    private static final long serialVersionUID = -2635155135575746682L;
    /** 主键id */
    private Integer id ;
    /** 商品名称 */
    private String name ;
    /** 商品类型 */
    private String type ;
    /** 商品规格 */
    private String standard ;
    /** 商品图片 */
    private String image ;
    /** 商品描述 */
    private String info ;
    /** 商品数量 */
    private Integer counts ;
    /** 商品保质期 */
    private String expirationdate ;
    /** 商品库存 */
    private Integer repertory ;
    /** 商品好评 */
    private String goodreputation ;
    /** 购买人数 */
    private Integer peoplebuy ;
    /** 店铺名称 */
    private String store ;
    /** 店铺负责人 */
    private String principal ;
    /** 店铺地址 */
    private String area ;
    /** 店铺大小 */
    private String big ;
    /** 店铺创始人 */
    private String originator ;
    /** 店铺开业时间 */
    private String createtime ;
    /** 店铺状态（是否营业） */
    private Integer status ;
    /** 店铺人数 */
    private Integer number ;
    /** 店铺营业时间 */
    private String starttime ;
    /** 店铺关闭时间 */
    private String endtime ;
    /** 店铺资格证 */
    private String certification ;
    /** 批准文号 */
    private String referencenumber ;
    /** 推广商品 */
    private String swag ;
    /** 活动商品 */
    private String promotionofgoods ;
    /** 推广商品价格 */
    private Double swagprice ;
    /** 活动商品价格 */
    private Double promotionprice ;
    /** 发票类型 */
    private Integer invoicetype ;
    /** 发票内容 */
    private String invoicecontents ;
    /** 发票金额 */
    private String invoiceprice ;
    //上i下架
    private Integer updown;
    //配送费
    private String peisong;
    //配送时间
    private String times;
    //商品价格
    private double price;
    //店铺评分
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

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public String getExpirationdate() {
        return expirationdate;
    }

    public void setExpirationdate(String expirationdate) {
        this.expirationdate = expirationdate;
    }

    public Integer getRepertory() {
        return repertory;
    }

    public void setRepertory(Integer repertory) {
        this.repertory = repertory;
    }

    public String getGoodreputation() {
        return goodreputation;
    }

    public void setGoodreputation(String goodreputation) {
        this.goodreputation = goodreputation;
    }

    public Integer getPeoplebuy() {
        return peoplebuy;
    }

    public void setPeoplebuy(Integer peoplebuy) {
        this.peoplebuy = peoplebuy;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getBig() {
        return big;
    }

    public void setBig(String big) {
        this.big = big;
    }

    public String getOriginator() {
        return originator;
    }

    public void setOriginator(String originator) {
        this.originator = originator;
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

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getReferencenumber() {
        return referencenumber;
    }

    public void setReferencenumber(String referencenumber) {
        this.referencenumber = referencenumber;
    }

    public String getSwag() {
        return swag;
    }

    public void setSwag(String swag) {
        this.swag = swag;
    }

    public String getPromotionofgoods() {
        return promotionofgoods;
    }

    public void setPromotionofgoods(String promotionofgoods) {
        this.promotionofgoods = promotionofgoods;
    }

    public Double getSwagprice() {
        return swagprice;
    }

    public void setSwagprice(Double swagprice) {
        this.swagprice = swagprice;
    }

    public Double getPromotionprice() {
        return promotionprice;
    }

    public void setPromotionprice(Double promotionprice) {
        this.promotionprice = promotionprice;
    }

    public Integer getInvoicetype() {
        return invoicetype;
    }

    public void setInvoicetype(Integer invoicetype) {
        this.invoicetype = invoicetype;
    }

    public String getInvoicecontents() {
        return invoicecontents;
    }

    public void setInvoicecontents(String invoicecontents) {
        this.invoicecontents = invoicecontents;
    }

    public String getInvoiceprice() {
        return invoiceprice;
    }

    public void setInvoiceprice(String invoiceprice) {
        this.invoiceprice = invoiceprice;
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

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getPingfen() {
        return pingfen;
    }

    public void setPingfen(Integer pingfen) {
        this.pingfen = pingfen;
    }

    @Override
    public String toString() {
        return "MerchantBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", standard='" + standard + '\'' +
                ", image='" + image + '\'' +
                ", info='" + info + '\'' +
                ", counts=" + counts +
                ", expirationdate='" + expirationdate + '\'' +
                ", repertory=" + repertory +
                ", goodreputation='" + goodreputation + '\'' +
                ", peoplebuy=" + peoplebuy +
                ", store='" + store + '\'' +
                ", principal='" + principal + '\'' +
                ", area='" + area + '\'' +
                ", big='" + big + '\'' +
                ", originator='" + originator + '\'' +
                ", createtime='" + createtime + '\'' +
                ", status=" + status +
                ", number=" + number +
                ", starttime='" + starttime + '\'' +
                ", endtime='" + endtime + '\'' +
                ", certification='" + certification + '\'' +
                ", referencenumber='" + referencenumber + '\'' +
                ", swag='" + swag + '\'' +
                ", promotionofgoods='" + promotionofgoods + '\'' +
                ", swagprice=" + swagprice +
                ", promotionprice=" + promotionprice +
                ", invoicetype=" + invoicetype +
                ", invoicecontents='" + invoicecontents + '\'' +
                ", invoiceprice='" + invoiceprice + '\'' +
                ", updown=" + updown +
                ", peisong='" + peisong + '\'' +
                ", times='" + times + '\'' +
                ", price=" + price +
                ", pingfen=" + pingfen +
                '}';
    }
}
