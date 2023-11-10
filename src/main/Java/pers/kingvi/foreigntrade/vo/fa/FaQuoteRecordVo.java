package pers.kingvi.foreigntrade.vo.fa;

import com.baomidou.mybatisplus.annotations.TableId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class FaQuoteRecordVo {
    private Integer id;
    @JsonSerialize(using = ToStringSerializer.class)
    @TableId
    private long ftsId;
    private String photo;
    private String productName;
    private String origin;
    private String destinationCountry;
    private String sendTime;
    private double weight;
    private String realOrder;

    public FaQuoteRecordVo() {

    }

    public FaQuoteRecordVo(Integer id, long ftsId, String photo, String productName, String origin, String destinationCountry, String sendTime, double weight, String realOrder) {
        this.id = id;
        this.ftsId = ftsId;
        this.photo = photo;
        this.productName = productName;
        this.origin = origin;
        this.destinationCountry = destinationCountry;
        this.sendTime = sendTime;
        this.weight = weight;
        this.realOrder = realOrder;
    }

    public long getFtsId() {
        return ftsId;
    }

    public void setFtsId(long ftsId) {
        this.ftsId = ftsId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getRealOrder() {
        return realOrder;
    }

    public void setRealOrder(String realOrder) {
        this.realOrder = realOrder;
    }
}
