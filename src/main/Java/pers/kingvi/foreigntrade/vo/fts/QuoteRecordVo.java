package pers.kingvi.foreigntrade.vo.fts;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class QuoteRecordVo {
    private Integer id;

    private String shippingWay;

    private Integer price;

    private String arrangeTime;

    private String deliverTime;

    @JsonSerialize(using = ToStringSerializer.class)
    @TableId(type = IdType.AUTO)
    private Long faId;

    public QuoteRecordVo(Integer id, String shippingWay, Integer price, String arrangeTime, String deliverTime, Long faId) {
        this.id = id;
        this.shippingWay = shippingWay;
        this.price = price;
        this.arrangeTime = arrangeTime;
        this.deliverTime = deliverTime;
        this.faId = faId;
    }

   /* public QuoteRecordVo(String shippingWay, Integer price, String arrangeTime, String deliverTime) {
        this.shippingWay = shippingWay;
        this.price = price;
        this.arrangeTime = arrangeTime;
        this.deliverTime = deliverTime;
    }*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShippingWay() {
        return shippingWay;
    }

    public void setShippingWay(String shippingWay) {
        this.shippingWay = shippingWay;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getArrangeTime() {
        return arrangeTime;
    }

    public void setArrangeTime(String arrangeTime) {
        this.arrangeTime = arrangeTime;
    }

    public String getDeliverTime() {
        return deliverTime;
    }

    public void setDeliverTime(String deliverTime) {
        this.deliverTime = deliverTime;
    }

    public Long getFaId() {
        return faId;
    }

    public void setFaId(Long faId) {
        this.faId = faId;
    }
}
