package pers.kingvi.foreigntrade.vo;

public class FriendApplyVo {
    private String photo;

    private Long senderId;

    private String senderName;

    private String sendTime;

    private String company;

    private String companyLink;

    private String city;

    private String mainBusiness;

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
