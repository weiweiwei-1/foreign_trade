package pers.kingvi.foreigntrade.vo.fa;

import com.baomidou.mybatisplus.annotations.TableId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class FaFriendInfoDetailVo {
    @JsonSerialize(using = ToStringSerializer.class)
    @TableId
    private Long id;

    private String photo;

    private String name;

    private String reMark;

    private String city;

    private String company;

    private String storeLink;

    private String sex;

    private Integer age;

    private Integer workingTime;

    private String industry;

    private String mainProduct;

    private String weChat;

    private String phone;

    private String email;

    public FaFriendInfoDetailVo() {

    }

    public FaFriendInfoDetailVo(Long id, String photo, String name, String reMark, String city, String company, String storeLink, String sex, Integer age, Integer workingTime, String industry, String mainProduct, String weChat, String phone, String email) {
        this.id = id;
        this.photo = photo;
        this.name = name;
        this.reMark = reMark;
        this.city = city;
        this.company = company;
        this.storeLink = storeLink;
        this.sex = sex;
        this.age = age;
        this.workingTime = workingTime;
        this.industry = industry;
        this.mainProduct = mainProduct;
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

    public String getReMark() {
        return reMark;
    }

    public void setReMark(String reMark) {
        this.reMark = reMark;
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

    public String getStoreLink() {
        return storeLink;
    }

    public void setStoreLink(String storeLink) {
        this.storeLink = storeLink;
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

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getMainProduct() {
        return mainProduct;
    }

    public void setMainProduct(String mainProduct) {
        this.mainProduct = mainProduct;
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
}
