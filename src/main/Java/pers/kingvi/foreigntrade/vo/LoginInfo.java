package pers.kingvi.foreigntrade.vo;

public class LoginInfo {
    private String role;
    private String loginName;
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public LoginInfo() {

    }

    public LoginInfo(String role, String loginName) {
        this.role = role;
        this.loginName = loginName;
    }
}
