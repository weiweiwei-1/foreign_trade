package pers.kingvi.foreigntrade.po;

public class ProductInformation {
    private Integer id;

    private Long ftsId;

    private String ftsName;

    private String photo;

    private String productName;

    private String origin;

    private String destination;

    private String postcode;

    private Double weight;

    private String volumn;

    private String timeRequirement;

    private String charger;

    private String certificate;

    private String realOrder;

    private String remark;

    private String sendTime;

    private Integer quoteCount;

    private String verifyStatus;

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
        this.ftsName = ftsName == null ? null : ftsName.trim();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin == null ? null : origin.trim();
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination == null ? null : destination.trim();
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
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
        this.volumn = volumn == null ? null : volumn.trim();
    }

    public String getTimeRequirement() {
        return timeRequirement;
    }

    public void setTimeRequirement(String timeRequirement) {
        this.timeRequirement = timeRequirement == null ? null : timeRequirement.trim();
    }

    public String getCharger() {
        return charger;
    }

    public void setCharger(String charger) {
        this.charger = charger == null ? null : charger.trim();
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate == null ? null : certificate.trim();
    }

    public String getRealOrder() {
        return realOrder;
    }

    public void setRealOrder(String realOrder) {
        this.realOrder = realOrder == null ? null : realOrder.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public String getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(String verifyStatus) {
        this.verifyStatus = verifyStatus == null ? null : verifyStatus.trim();
    }

    @Override
    public String toString() {
        return "ProductInformation{" +
                "id=" + id +
                ", ftsId=" + ftsId +
                ", ftsName='" + ftsName + '\'' +
                ", photo='" + photo + '\'' +
                ", productName='" + productName + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", postcode='" + postcode + '\'' +
                ", weight=" + weight +
                ", volumn='" + volumn + '\'' +
                ", timeRequirement='" + timeRequirement + '\'' +
                ", charger='" + charger + '\'' +
                ", certificate='" + certificate + '\'' +
                ", realOrder='" + realOrder + '\'' +
                ", remark='" + remark + '\'' +
                ", sendTime='" + sendTime + '\'' +
                ", quoteCount=" + quoteCount +
                ", verifyStatus='" + verifyStatus + '\'' +
                '}';
    }
}