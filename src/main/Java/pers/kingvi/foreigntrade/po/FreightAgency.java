package pers.kingvi.foreigntrade.po;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

public class FreightAgency {
    @TableId(type = IdType.AUTO)
    private Long id;

    private Integer sendQuoteCount;

    private String account;

    private String password;

    private String photo;

    private String name;

    private String city;

    private String company;

    private String companyLink;

    private String sex;

    private Integer age;

    private Integer workingTime;

    private String mainBussinessScope;

    private String serviceAdvantage;

    private String weChat;

    private String phone;

    private String email;

    private Integer advertiseCount;

    private String userStatus;

    private String registerTime;

    public FreightAgency() {

    }

    public FreightAgency(Integer sendQuoteCount) {
        this.sendQuoteCount = sendQuoteCount;
    }

    public FreightAgency(Long id, String photo, String name, String city, String company, String companyLink, String sex, Integer age, Integer workingTime, String mainBussinessScope, String serviceAdvantage, String weChat, String phone, String email) {
        this.id = id;
        this.photo = photo;
        this.name = name;
        this.city = city;
        this.company = company;
        this.companyLink = companyLink;
        this.sex = sex;
        this.age = age;
        this.workingTime = workingTime;
        this.mainBussinessScope = mainBussinessScope;
        this.serviceAdvantage = serviceAdvantage;
        this.weChat = weChat;
        this.phone = phone;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSendQuoteCount() {
        return sendQuoteCount;
    }

    public void setSendQuoteCount(Integer sendQuoteCount) {
        this.sendQuoteCount = sendQuoteCount;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(Integer workingTime) {
        this.workingTime = workingTime;
    }

    public String getMainBussinessScope() {
        return mainBussinessScope;
    }

    public void setMainBussinessScope(String mainBussinessScope) {
        this.mainBussinessScope = mainBussinessScope;
    }

    public String getServiceAdvantage() {
        return serviceAdvantage;
    }

    public void setServiceAdvantage(String serviceAdvantage) {
        this.serviceAdvantage = serviceAdvantage;
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        this.userStatus = userStatus;
    }
}