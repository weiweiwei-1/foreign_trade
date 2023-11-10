package pers.kingvi.foreigntrade.po;

public class ForeignTradeSalemanDemand {
    private Integer id;


    private Long ftsId;

    private String ftsName;

    private String ftsCompany;

    private String ftsCity;

    private String mainBusiness;

    private String requirement;

    private String demandDescription;

    private String phone;

    private String weChat;

    private String email;

    private String sendTime;

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

    public String getFtsCompany() {
        return ftsCompany;
    }

    public void setFtsCompany(String ftsCompany) {
        this.ftsCompany = ftsCompany == null ? null : ftsCompany.trim();
    }

    public String getFtsCity() {
        return ftsCity;
    }

    public void setFtsCity(String ftsCity) {
        this.ftsCity = ftsCity == null ? null : ftsCity.trim();
    }

    public String getMainBusiness() {
        return mainBusiness;
    }

    public void setMainBusiness(String mainBusiness) {
        this.mainBusiness = mainBusiness == null ? null : mainBusiness.trim();
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement == null ? null : requirement.trim();
    }

    public String getDemandDescription() {
        return demandDescription;
    }

    public void setDemandDescription(String demandDescription) {
        this.demandDescription = demandDescription == null ? null : demandDescription.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getWechat() {
        return weChat;
    }

    public void setWechat(String wechat) {
        this.weChat = wechat == null ? null : wechat.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(String verifyStatus) {
        this.verifyStatus = verifyStatus == null ? null : verifyStatus.trim();
    }

    @Override
    public String toString() {
        return "ForeignTradeSalemanDemand{" +
                "id=" + id +
                ", ftsId=" + ftsId +
                ", ftsName='" + ftsName + '\'' +
                ", ftsCompany='" + ftsCompany + '\'' +
                ", ftsCity='" + ftsCity + '\'' +
                ", mainBusiness='" + mainBusiness + '\'' +
                ", requirement='" + requirement + '\'' +
                ", demandDescription='" + demandDescription + '\'' +
                ", phone='" + phone + '\'' +
                ", weChat='" + weChat + '\'' +
                ", email='" + email + '\'' +
                ", sendTime='" + sendTime + '\'' +
                ", verifyStatus='" + verifyStatus + '\'' +
                '}';
    }
}