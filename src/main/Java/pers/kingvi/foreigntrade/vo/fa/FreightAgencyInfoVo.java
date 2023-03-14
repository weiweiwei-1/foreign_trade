package pers.kingvi.foreigntrade.vo.fa;

public class FreightAgencyInfoVo {

    //照片
    private String photo;
    //账号
    private String account;
    //剩余报价数
    private Integer sendQuoteCount;
    //昵称或名字
    private String name;
    //所在城市
    private String city;
    //公司
    private String company;
    //公司网址
    private String companyLink;
    //性别
    private String sex;
    //年龄
    private Integer age;
    //从业时间
    private Integer workingTime;
    //主营业务范围(服务国家，商品类目等)
    private String mainBussinessScope;
    //服务优势
    private String serviceAdvantage;
    //微信
    private String weChat;
    //电话
    private String phone;
    //邮箱
    private String email;

    public FreightAgencyInfoVo() {
    }

    public FreightAgencyInfoVo(String photo, String account, Integer sendQuoteCount, String name, String city, String company, String companyLink, String sex, Integer age, Integer workingTime, String mainBussinessScope, String serviceAdvantage, String weChat, String phone, String email) {
        this.photo = photo;
        this.account = account;
        this.sendQuoteCount = sendQuoteCount;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getSendQuoteCount() {
        return sendQuoteCount;
    }

    public void setSendQuoteCount(Integer sendQuoteCount) {
        this.sendQuoteCount = sendQuoteCount;
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
}
