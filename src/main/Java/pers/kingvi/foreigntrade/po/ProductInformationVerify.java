package pers.kingvi.foreigntrade.po;

import org.springframework.beans.factory.annotation.Required;

public class ProductInformationVerify {
    private Integer id;

    private Long ftsId;

    private String ftsName;

    private String photo;

    private String productName;

    private String origin;

    private String destinationCountry;

    private String postcode;

    private Double weight;

    private String volumn;

    private String timeRequirement;

    private String realOrder;

    private String charger;

    private String certificate;

    private String destination;

    private String remark;

    private String sendTime;

    private Byte quoteCount;

    private String verifyStatus;

    public ProductInformationVerify() {

    }

    public ProductInformationVerify(Long ftsId, String ftsName, String photo, String productName, String origin, String destinationCountry, String postcode, Double weight, String volumn, String timeRequirement, String realOrder, String charger, String certificate, String destination, String remark) {
        this.ftsId = ftsId;
        this.ftsName = ftsName;
        this.photo = photo;
        this.productName = productName;
        this.origin = origin;
        this.destinationCountry = destinationCountry;
        this.postcode = postcode;
        this.weight = weight;
        this.volumn = volumn;
        this.timeRequirement = timeRequirement;
        this.realOrder = realOrder;
        this.charger = charger;
        this.certificate = certificate;
        this.destination = destination;
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getFtsId() {
        return ftsId;
    }

    public void setFtsId(Long ftsId) {
        this.ftsId = ftsId;
    }

    public String getFtsName() {
        return ftsName;
    }

    public void setFtsName(String ftsName) {
        this.ftsName = ftsName;
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

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
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

    public String getTimeRequirement() {
        return timeRequirement;
    }

    public void setTimeRequirement(String timeRequirement) {
        this.timeRequirement = timeRequirement;
    }

    public String getRealOrder() {
        return realOrder;
    }

    public void setRealOrder(String realOrder) {
        this.realOrder = realOrder;
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

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public Byte getQuoteCount() {
        return quoteCount;
    }

    public void setQuoteCount(Byte quoteCount) {
        this.quoteCount = quoteCount;
    }

    public String getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(String verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

    @Override
    public String toString() {
        return "ProductInformationVerify{" +
                "id=" + id +
                ", ftsId=" + ftsId +
                ", ftsName='" + ftsName + '\'' +
                ", photo='" + photo + '\'' +
                ", productName='" + productName + '\'' +
                ", origin='" + origin + '\'' +
                ", destinationCountry='" + destinationCountry + '\'' +
                ", postcode='" + postcode + '\'' +
                ", weight=" + weight +
                ", volumn='" + volumn + '\'' +
                ", timeRequirement='" + timeRequirement + '\'' +
                ", realOrder='" + realOrder + '\'' +
                ", charger='" + charger + '\'' +
                ", certificate='" + certificate + '\'' +
                ", destination='" + destination + '\'' +
                ", remark='" + remark + '\'' +
                ", sendTime='" + sendTime + '\'' +
                ", quoteCount=" + quoteCount +
                ", verifyStatus='" + verifyStatus + '\'' +
                '}';
    }
}