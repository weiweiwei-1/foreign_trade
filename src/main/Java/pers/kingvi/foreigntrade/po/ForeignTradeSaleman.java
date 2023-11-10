package pers.kingvi.foreigntrade.po;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class ForeignTradeSaleman {

    @JsonSerialize(using = ToStringSerializer.class)
    @TableId
    private Long id;

    private String account;

    private String password;

    private String company;

    private String city;

    private String name;

    private String photo;

    private String industry;

    private Integer workingTime;

    private Integer age;

    private String sex;

    private String mainProduct;

    private String storeLink;

    private String weChat;

    private String phone;

    private String email;

    private Integer sendProductCount;

    private Integer demandCount;

    private String userStatus;

    private String registerTime;

    public ForeignTradeSaleman() {

    }

    public ForeignTradeSaleman(Integer sendProductCount) {
        this.sendProductCount = sendProductCount;
    }

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

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
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

    public String getMainProduct() {
        return mainProduct;
    }

    public void setMainProduct(String mainProduct) {
        this.mainProduct = mainProduct == null ? null : mainProduct.trim();
    }

    public String getStoreLink() {
        return storeLink;
    }

    public void setStoreLink(String storeLink) {
        this.storeLink = storeLink == null ? null : storeLink.trim();
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

    public Integer getSendProductCount() {
        return sendProductCount;
    }

    public void setSendProductCount(Integer sendProductCount) {
        this.sendProductCount = sendProductCount;
    }

    public Integer getDemandCount() {
        return demandCount;
    }

    public void setDemandCount(Integer demandCount) {
        this.demandCount = demandCount;
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
        return "fts{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", company='" + company + '\'' +
                ", city='" + city + '\'' +
                ", name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                ", industry='" + industry + '\'' +
                ", workingTime=" + workingTime +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", mainProduct='" + mainProduct + '\'' +
                ", storeLink='" + storeLink + '\'' +
                ", weChat='" + weChat + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", sendProductCount=" + sendProductCount +
                ", demandCount=" + demandCount +
                ", userStatus='" + userStatus + '\'' +
                ", registerTime='" + registerTime + '\'' +
                '}';
    }
}