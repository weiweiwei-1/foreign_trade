package pers.kingvi.foreigntrade.util;

import pers.kingvi.foreigntrade.po.LoginRecord;

public class LoginError {
    private String emailError;
    private String passwordError;
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
