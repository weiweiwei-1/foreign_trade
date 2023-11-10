package pers.kingvi.foreigntrade.vo.fa;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class QuoteRecordProductVo {
    private Integer productId;   //产品id

    @JsonSerialize(using = ToStringSerializer.class)
    @TableId(type = IdType.AUTO)
    private Long ftsId;       //外贸id

    @JsonSerialize(using = ToStringSerializer.class)
    @TableId(type = IdType.AUTO)
    private Long faId;         //货代id

    private String ftsName;      //外贸名字

    private String ftsPhoto;      //外贸头像

    private String productPhoto;   //产品图片

    private String productName;    //产品名字

    private String origin;      //发货地

    private String destination;      //目的地

    private Double weight;          //重量

    private String realOrder;       //是否实单

    private String sendTime;        //发送时间

    private Integer quoteCount;     //剩余报价数

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Long getFtsId() {
        return ftsId;
    }

    public void setFtsId(Long ftsId) {
        this.ftsId = ftsId;
    }

    public Long getFaId() {
        return faId;
    }

    public void setFaId(Long faId) {
        this.faId = faId;
    }

    public String getFtsName() {
        return ftsName;
    }

    public void setFtsName(String ftsName) {
        this.ftsName = ftsName;
    }

    public String getFtsPhoto() {
        return ftsPhoto;
    }

    public void setFtsPhoto(String ftsPhoto) {
        this.ftsPhoto = ftsPhoto;
    }

    public String getProductPhoto() {
        return productPhoto;
    }

    public void setProductPhoto(String productPhoto) {
        this.productPhoto = productPhoto;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getRealOrder() {
        return realOrder;
    }

    public void setRealOrder(String realOrder) {
        this.realOrder = realOrder;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public Integer getQuoteCount() {
        return quoteCount;
    }

    public void setQuoteCount(Integer quoteCount) {
        this.quoteCount = quoteCount;
    }

    @Override
    public String toString() {
        return "QuoteRecordProductVo{" +
                "productId=" + productId +
                ", ftsId=" + ftsId +
                ", ftsName='" + ftsName + '\'' +
                ", ftsPhoto='" + ftsPhoto + '\'' +
                ", productPhoto='" + productPhoto + '\'' +
                ", productName='" + productName + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", weight=" + weight +
                ", realOrder='" + realOrder + '\'' +
                ", sendTime='" + sendTime + '\'' +
                ", quoteCount=" + quoteCount +
                '}';
    }
}
