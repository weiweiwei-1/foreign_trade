package pers.kingvi.foreigntrade.po;

import com.baomidou.mybatisplus.annotations.TableId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class FreightAgencyRecommend {
    private Integer id;

    @JsonSerialize(using = ToStringSerializer.class)
    @TableId
    private Long faId;

    private String faName;

    private String faCompany;

    private String companyLink;

    private String faCity;

    private String keyWords;

    private String mainBusiness;

    private String description;

    private String activityPhoto;

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

    public Long getFaId() {
        return faId;
    }

    public void setFaId(Long faId) {
        this.faId = faId;
    }

    public String getFaName() {
        return faName;
    }

    public void setFaName(String faName) {
        this.faName = faName == null ? null : faName.trim();
    }

    public String getFaCompany() {
        return faCompany;
    }

    public void setFaCompany(String faCompany) {
        this.faCompany = faCompany == null ? null : faCompany.trim();
    }

    public String getCompanyLink() {
        return companyLink;
    }

    public void setCompanyLink(String companyLink) {
        this.companyLink = companyLink == null ? null : companyLink.trim();
    }

    public String getFaCity() {
        return faCity;
    }

    public void setFaCity(String faCity) {
        this.faCity = faCity == null ? null : faCity.trim();
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords == null ? null : keyWords.trim();
    }

    public String getMainBusiness() {
        return mainBusiness;
    }

    public void setMainBusiness(String mainBusiness) {
        this.mainBusiness = mainBusiness == null ? null : mainBusiness.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getActivityPhoto() {
        return activityPhoto;
    }

    public void setActivityPhoto(String activityPhoto) {
        this.activityPhoto = activityPhoto == null ? null : activityPhoto.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat == null ? null : weChat.trim();
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
        return "FreightAgencyRecommend{" +
                "id=" + id +
                ", faId=" + faId +
                ", faName='" + faName + '\'' +
                ", faCompany='" + faCompany + '\'' +
                ", companyLink='" + companyLink + '\'' +
                ", faCity='" + faCity + '\'' +
                ", keyWords='" + keyWords + '\'' +
                ", mainBusiness='" + mainBusiness + '\'' +
                ", description='" + description + '\'' +
                ", activityPhoto='" + activityPhoto + '\'' +
                ", phone='" + phone + '\'' +
                ", weChat='" + weChat + '\'' +
                ", email='" + email + '\'' +
                ", sendTime='" + sendTime + '\'' +
                ", verifyStatus='" + verifyStatus + '\'' +
                '}';
    }
}