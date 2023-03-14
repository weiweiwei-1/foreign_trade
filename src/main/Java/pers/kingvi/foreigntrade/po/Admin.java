package pers.kingvi.foreigntrade.po;

public class Admin {
    private Integer id;

    private String account;

    private String password;

    private String createTime;

    private String loginTime;

    public Admin() {

    }

    public Admin(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", createTime='" + createTime + '\'' +
                ", loginTime='" + loginTime + '\'' +
                '}';
    }
}
