package pers.kingvi.foreigntrade.vo.fa;

public class FaRecommendInfoShowVo {

    private String activityPhoto;

    private String faName;

    private String faCompany;

    private String companyLink;

    private String faCity;

    private String phone;

    private String weChat;

    private String email;

    private String sendTime;

    public FaRecommendInfoShowVo() {

    }

    public FaRecommendInfoShowVo(String activityPhoto, String faName, String faCompany, String companyLink, String faCity, String phone, String weChat, String email, String sendTime) {
        this.activityPhoto = activityPhoto;
        this.faName = faName;
        this.faCompany = faCompany;
        this.companyLink = companyLink;
        this.faCity = faCity;
        this.phone = phone;
        this.weChat = weChat;
        this.email = email;
        this.sendTime = sendTime;
    }

    public String getActivityPhoto() {
        return activityPhoto;
    }

    public void setActivityPhoto(String activityPhoto) {
        this.activityPhoto = activityPhoto;
    }

    public String getFaName() {
        return faName;
    }

    public void setFaName(String faName) {
        this.faName = faName;
    }

    public String getFaCompany() {
        return faCompany;
    }

    public void setFaCompany(String faCompany) {
        this.faCompany = faCompany;
    }

    public String getCompanyLink() {
        return companyLink;
    }

    public void setCompanyLink(String companyLink) {
        this.companyLink = companyLink;
    }

    public String getFaCity() {
        return faCity;
    }

    public void setFaCity(String faCity) {
        this.faCity = faCity;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }
}
