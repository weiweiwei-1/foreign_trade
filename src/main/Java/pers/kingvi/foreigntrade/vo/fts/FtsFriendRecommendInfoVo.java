package pers.kingvi.foreigntrade.vo.fts;

import com.baomidou.mybatisplus.annotations.TableId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class FtsFriendRecommendInfoVo {

    @JsonSerialize(using = ToStringSerializer.class)
    @TableId
    private Long id;

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

    public FtsFriendRecommendInfoVo() {

    }

    public FtsFriendRecommendInfoVo(Long id, String photo, String name, String city, String company, String companyLink, String sex, Integer age, Integer workingTime, String mainBussinessScope, String serviceAdvantage) {
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
}
