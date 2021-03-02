package pers.kingvi.foreigntrade.po;

import java.util.Date;

public class FreightAgency {
    private Long id;

    private String account;

    private String password;

    private String company;

    private String city;

    private String name;

    private String photo;

    private String mainBussinessScope;

    private Integer workingTime;

    private Integer age;

    private String sex;

    private String serviceAdvantage;

    private String companyLink;

    private String weChat;

    private String phone;

    private String email;

    private Integer sendQuoteCount;

    private Integer advertiseCount;

    private String userStatus;

    private String registerTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    public String getMainBussinessScope() {
        return mainBussinessScope;
    }

    public void setMainBussinessScope(String mainBussinessScope) {
        this.mainBussinessScope = mainBussinessScope == null ? null : mainBussinessScope.trim();
    }

    public Integer getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(Integer workingTime) {
        this.workingTime = workingTime;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getServiceAdvantage() {
        return serviceAdvantage;
    }

    public void setServiceAdvantage(String serviceAdvantage) {
        this.serviceAdvantage = serviceAdvantage == null ? null : serviceAdvantage.trim();
    }

    public String getCompanyLink() {
        return companyLink;
    }

    public void setCompanyLink(String companyLink) {
        this.companyLink = companyLink == null ? null : companyLink.trim();
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat == null ? null : weChat.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getSendQuoteCount() {
        return sendQuoteCount;
    }

    public void setSendQuoteCount(Integer sendQuoteCount) {
        this.sendQuoteCount = sendQuoteCount;
    }

    public Integer getAdvertiseCount() {
        return advertiseCount;
    }

    public void setAdvertiseCount(Integer advertiseCount) {
        this.advertiseCount = advertiseCount;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus == null ? null : userStatus.trim();
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    @Override
    public String toString() {
        return "FreightAgency{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", company='" + company + '\'' +
                ", city='" + city + '\'' +
                ", name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                ", mainBussinessScope='" + mainBussinessScope + '\'' +
                ", workingTime=" + workingTime +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", serviceAdvantage='" + serviceAdvantage + '\'' +
                ", companyLink='" + companyLink + '\'' +
                ", weChat='" + weChat + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", sendQuoteCount=" + sendQuoteCount +
                ", advertiseCount=" + advertiseCount +
                ", userStatus='" + userStatus + '\'' +
                ", registerTime='" + registerTime + '\'' +
                '}';
    }
}