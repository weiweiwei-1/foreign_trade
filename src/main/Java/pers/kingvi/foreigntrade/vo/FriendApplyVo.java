package pers.kingvi.foreigntrade.vo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class FriendApplyVo {
    private String photo;

    @JsonSerialize(using = ToStringSerializer.class)
    @TableId(type = IdType.AUTO)
    private Long senderId;

    private String name;

    private String senderName;

    private String sendTime;

    private String company;

    private String companyLink;

    private String city;

    private String mainBusiness;

    public FriendApplyVo() {

    }

    public FriendApplyVo(String photo, Long senderId, String name, String senderName, String sendTime, String company, String companyLink, String city, String mainBusiness) {
        this.photo = photo;
        this.senderId = senderId;
        this.name = name;
        this.senderName = senderName;
        this.sendTime = sendTime;
        this.company = company;
        this.companyLink = companyLink;
        this.city = city;
        this.mainBusiness = mainBusiness;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompanyLink() {
        return companyLink;
    }

    public void setCompanyLink(String companyLink) {
        this.companyLink = companyLink;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMainBusiness() {
        return mainBusiness;
    }

    public void setMainBusiness(String mainBusiness) {
        this.mainBusiness = mainBusiness;
    }

    @Override
    public String toString() {
        return "FriendApplyVo{" +
                "photo='" + photo + '\'' +
                ", senderId=" + senderId +
                ", senderName='" + senderName + '\'' +
                ", sendTime='" + sendTime + '\'' +
                ", company='" + company + '\'' +
                ", companyLink='" + companyLink + '\'' +
                ", city='" + city + '\'' +
                ", mainBusiness='" + mainBusiness + '\'' +
                '}';
    }
}
