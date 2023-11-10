package pers.kingvi.foreigntrade.vo.fa;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class QuoteFaInfoVo {
//    货代id
    @JsonSerialize(using = ToStringSerializer.class)
    @TableId(type = IdType.AUTO)
    private Long id;
//    货代名
    private String name;
//    货代照片
    private String photo;
//    货代城市
    private String city;
//    货代公司名
    private String company;
//    货代公司官网
    private String CompanyLink;
//    主营业务
    private String mainBussinessScope;

    public QuoteFaInfoVo() {

    }

    public QuoteFaInfoVo(Long id, String name, String photo, String city, String company, String CompanyLink, String mainBussinessScope) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.city = city;
        this.company = company;
        this.CompanyLink = CompanyLink;
        this.mainBussinessScope = mainBussinessScope;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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
        return CompanyLink;
    }

    public void setCompanyLink(String CompanyLink) {
        this.CompanyLink = CompanyLink;
    }

    public String getmainBussinessScope() {
        return mainBussinessScope;
    }

    public void setmainBussinessScope(String mainBussinessScope) {
        this.mainBussinessScope = mainBussinessScope;
    }
}
