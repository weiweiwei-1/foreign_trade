package pers.kingvi.foreigntrade.vo.fts;

public class ForeignTradeSalemanInfoVo {
    //照片
    private String photo;
    //账号
    private String account;
    //剩余产品
    private Integer sendProductCount;
    //昵称
    private String name;
    //年龄
    private Integer age;
    //性别
    private String sex;
    //城市
    private String city;
    //公司名
    private String company;
    //店铺地址
    private String storeLink;
    //从业时间
    private Integer workingTime;
    //从事行业
    private String industry;
    //主要产品
    private String mainProduct;
    //微信
    private String weChat;
    //电话
    private String phone;
    //邮箱
    private String email;

    public ForeignTradeSalemanInfoVo() {

    }

    public ForeignTradeSalemanInfoVo(String photo, String account, Integer sendProductCount, String name, Integer age, String sex, String city, String company, String storeLink, Integer workingTime, String industry, String mainProduct, String weChat, String phone, String email) {
        this.photo = photo;
        this.account = account;
        this.sendProductCount = sendProductCount;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.city = city;
        this.company = company;
        this.storeLink = storeLink;
        this.workingTime = workingTime;
        this.industry = industry;
        this.mainProduct = mainProduct;
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

    public Integer getSendProductCount() {
        return sendProductCount;
    }

    public void setSendProductCount(Integer sendProductCount) {
        this.sendProductCount = sendProductCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        this.sex = sex;
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
