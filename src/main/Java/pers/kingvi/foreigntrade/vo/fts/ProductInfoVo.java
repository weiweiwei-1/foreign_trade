package pers.kingvi.foreigntrade.vo.fts;

public class ProductInfoVo {
    //产品照片
    private String photo;
    //产品名
    private String productName;
    //发货地
    private String origin;
    //目的国
    private String destinationCountry;
    //目的国详细地址
    private String destination;
    //重量
    private Double weight;
    //体积
    private String volumn;
    //是否带电
    private String charger;
    //是否认证
    private String certificate;
    //是否实单
    private String realOrder;
    //发送时间
    private String sendTime;
    //截止目前剩余报价数
    private Integer quoteCount;
    //备注
    private String remark;

    public ProductInfoVo() {

    }

    public ProductInfoVo(String photo, String productName, String origin, String destinationCountry, String destination, Double weight, String volumn, String charger, String certificate, String realOrder, String sendTime, Integer quoteCount, String remark) {
        this.photo = photo;
        this.productName = productName;
        this.origin = origin;
        this.destinationCountry = destinationCountry;
        this.destination = destination;
        this.weight = weight;
        this.volumn = volumn;
        this.charger = charger;
        this.certificate = certificate;
        this.realOrder = realOrder;
        this.sendTime = sendTime;
        this.quoteCount = quoteCount;
        this.remark = remark;
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

    public String getVolumn() {
        return volumn;
    }

    public void setVolumn(String volumn) {
        this.volumn = volumn;
    }

    public String getCharger() {
        return charger;
    }

    public void setCharger(String charger) {
        this.charger = charger;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
