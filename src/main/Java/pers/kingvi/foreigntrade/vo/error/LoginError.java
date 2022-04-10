package pers.kingvi.foreigntrade.vo.error;

import pers.kingvi.foreigntrade.po.LoginRecord;

public class LoginError {
    //邮箱错误信息
    private String emailError;
    //密码错误信息
    private String passwordError;
    //错误代码code
    private String codeError;

    public LoginError() {

    }

    public LoginError(String emailError, String passwordError, String codeError) {
        this.emailError = emailError;
        this.passwordError = passwordError;
        this.codeError = codeError;
    }

    public LoginError(String emailError, String passwordError) {
        this.emailError = emailError;
        this.passwordError = passwordError;
    }

    public String getEmailError() {
        return emailError;
    }

    public void setEmailError(String emailError) {
        this.emailError = emailError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getCodeError() {
        return codeError;
    }

    public void setCodeError(String codeError) {
        this.codeError = codeError;
    }
}
