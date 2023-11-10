package pers.kingvi.foreigntrade.vo.fts;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class QuoteFtsInfoVo {

    @JsonSerialize(using = ToStringSerializer.class)
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private String photo;
    private String city;
    private String company;
    private String storeLink;
    private String industry;
    private String mainProduct;

    public QuoteFtsInfoVo() {

    }

    public QuoteFtsInfoVo(Long id, String name, String photo, String city, String company, String storeLink, String industry, String mainProduct) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.city = city;
        this.company = company;
        this.storeLink = storeLink;
        this.industry = industry;
        this.mainProduct = mainProduct;
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

    public String getStoreLink() {
        return storeLink;
    }

    public void setStoreLink(String storeLink) {
        this.storeLink = storeLink;
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
