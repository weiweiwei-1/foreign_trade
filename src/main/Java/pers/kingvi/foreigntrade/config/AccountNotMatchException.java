package pers.kingvi.foreigntrade.config;

import org.apache.shiro.authc.AccountException;

public class AccountNotMatchException extends AccountException {
    public AccountNotMatchException() {}

    public AccountNotMatchException(String message) {
        super(message);
    }

    public AccountNotMatchException(Throwable cause) {
        super(cause);
    }

    public AccountNotMatchException(String message, Throwable cause) {
        super(message, cause);
    }
}
