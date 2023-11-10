package pers.kingvi.foreigntrade.vo.fts;

public class ProductQuoteVo {
    private String shippingWay;

    private Integer price;

    private String arrangeTime;

    private String deliverTime;

    private String sendTime;

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

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public ProductQuoteVo() {

    }

    public ProductQuoteVo(String shippingWay, Integer price, String arrangeTime, String deliverTime, String sendTime) {
        this.shippingWay = shippingWay;
        this.price = price;
        this.arrangeTime = arrangeTime;
        this.deliverTime = deliverTime;
        this.sendTime = sendTime;
    }
}
