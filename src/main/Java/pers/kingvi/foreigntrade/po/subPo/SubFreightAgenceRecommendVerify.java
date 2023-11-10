package pers.kingvi.foreigntrade.po.subPo;

import pers.kingvi.foreigntrade.po.FreightAgencyRecommendVerify;

import java.sql.Timestamp;

public class SubFreightAgenceRecommendVerify extends FreightAgencyRecommendVerify {
//    继承父类属性，同时新增account邮箱属性
    private String account;

    public SubFreightAgenceRecommendVerify() {

    }

    public SubFreightAgenceRecommendVerify(Long faId, String faName, String faCompany, String companyLink, String faCity, String keyWords, String mainBusiness, String description, String activityPhoto, String phone, String weChat, String email, Timestamp sendTime, String account) {
        super(faId, faName, faCompany, companyLink, faCity, keyWords, mainBusiness, description, activityPhoto, phone, weChat, email, sendTime);
        this.account = account;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
