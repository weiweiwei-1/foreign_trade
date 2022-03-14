package pers.kingvi.foreigntrade.filter;

import org.apache.shiro.authc.UsernamePasswordToken;

//@Component
public class CustomizedToken extends UsernamePasswordToken {
    private static final long serialVersionUID = 1L;

    private String loginType;

    public CustomizedToken(final String username, final String password, String loginType) {
        super(username, password);
        this.loginType = loginType;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }
}
