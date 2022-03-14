package pers.kingvi.foreigntrade.freightagency.api;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.kingvi.foreigntrade.filter.CustomizedToken;
import pers.kingvi.foreigntrade.po.FreightAgency;
import pers.kingvi.foreigntrade.util.ErrorInfo;
import pers.kingvi.foreigntrade.util.LoginError;
import pers.kingvi.foreigntrade.util.Result;

import java.util.regex.Pattern;

@Controller
@RequestMapping(value = "/fa/user")
public class FaLoginController {

    @ResponseBody
    @RequestMapping(value = "/login")
    public Result login(@RequestParam("email") String email, @RequestParam("password") String password) {
        String emailError = null;
        String passwordError = null;
        if (StringUtils.isBlank(email)) {
            emailError = ErrorInfo.NULL_EMAIL;
        } else {
            String emailPatten = "(^?:[a-zA-Z0-9]+[_\\-+.]?)*[a-zA-Z0-9]+@(?:([a-zA-Z0-9]+-?)*[a-zA-Z0-9]+\\.)+([a-zA-Z]{2,})+$";
            if (!Pattern.matches(emailPatten, email)) {
                emailError = ErrorInfo.EMAIL_FORMAT;
            }
        }
        if (StringUtils.isBlank(password)) {
            passwordError = ErrorInfo.NULL_PASSWORD;
        } else if (password.trim().length() < 6 || password.trim().length() > 15) {
            passwordError = ErrorInfo.PASSWORD_LENGTH;
        }
        if (emailError != null || passwordError != null) {
            return new Result<>().error(new LoginError(emailError, passwordError, null));
        } else {
            CustomizedToken token = new CustomizedToken(email, password, "Fa");
            token.setRememberMe(false);
            Subject subject = SecurityUtils.getSubject();
            try {
                subject.login(token);
            } catch (UnknownAccountException uae) {
                return new Result<>().error(new LoginError(ErrorInfo.EMAIL_NOT_EXIST, null));
            } catch (IncorrectCredentialsException ice) {
                return new Result<>().error(new LoginError(null, ErrorInfo.PASSWORD_ERROR));
            }
            System.out.println("登录用户角色为：" + subject.getPrincipal());
            Session session = subject.getSession();
            FreightAgency freightAgency = (FreightAgency)SecurityUtils.getSubject().getPrincipal();
            session.setAttribute("id", freightAgency.getId());
            if (subject.hasRole("Fa")) {
                System.out.println("含有货代角色");
            }
            return Result.success;
        }
    }
}
