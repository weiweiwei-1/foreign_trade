package pers.kingvi.foreigntrade.po;

public class QuoteRecord {
    private Integer id;

    private Integer productId;

    private Long faId;

    private String shippingWay;

    private Integer price;

    private String arrangeTime;

    private String deliverTime;

    private String remark;

    private String status;

    private String sendTime;

    public QuoteRecord() {

    }

    public QuoteRecord(Integer productId, Long faId) {
        this.productId = productId;
        this.faId = faId;
    }

    public QuoteRecord(Integer productId, Long faId, String shippingWay, Integer price, String arrangeTime, String deliverTime, String remark) {
        this.productId = productId;
        this.faId = faId;
        this.shippingWay = shippingWay;
        this.price = price;
        this.arrangeTime = arrangeTime;
        this.deliverTime = deliverTime;
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Long getFaId() {
        return faId;
    }

    public void setFaId(Long faId) {
        this.faId = faId;
    }

    public String getShippingWay() {
        return shippingWay;
    }

    public void setShippingWay(String shippingWay) {
        this.shippingWay = shippingWay == null ? null : shippingWay.trim();
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
        this.arrangeTime = arrangeTime == null ? null : arrangeTime.trim();
    }

    public String getDeliverTime() {
        return deliverTime;
    }

    public void setDeliverTime(String deliverTime) {
        this.deliverTime = deliverTime == null ? null : deliverTime.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    @Override
    public String toString() {
        return "QuoteRecord{" +
                "id=" + id +
                ", productId=" + productId +
                ", faId=" + faId +
                ", shippingWay='" + shippingWay + '\'' +
                ", price=" + price +
                ", arrangeTime='" + arrangeTime + '\'' +
                ", deliverTime='" + deliverTime + '\'' +
                ", remark='" + remark + '\'' +
                ", status='" + status + '\'' +
                ", sendTime='" + sendTime + '\'' +
                '}';
    }
}