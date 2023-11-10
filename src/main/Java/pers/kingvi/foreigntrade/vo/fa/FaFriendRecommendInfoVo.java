package pers.kingvi.foreigntrade.vo.fa;

import com.baomidou.mybatisplus.annotations.TableId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class FaFriendRecommendInfoVo {
    @JsonSerialize(using = ToStringSerializer.class)
    @TableId
    private Long id;

    private String photo;

    private String name;

    private String city;

    private String company;

    private String storeLink;

    private String sex;

    private Integer age;

    private Integer workingTime;

    private String industry;

    private String mainProduct;

    public FaFriendRecommendInfoVo() {

    }

    public FaFriendRecommendInfoVo(Long id, String photo, String name, String city, String company, String storeLink, String sex, Integer age, Integer workingTime, String industry, String mainProduct) {
        this.id = id;
        this.photo = photo;
        this.name = name;
        this.city = city;
        this.company = company;
        this.storeLink = storeLink;
        this.sex = sex;
        this.age = age;
        this.workingTime = workingTime;
        this.industry = industry;
        this.mainProduct = mainProduct;
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
}
