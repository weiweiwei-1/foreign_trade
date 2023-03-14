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
import pers.kingvi.foreigntrade.util.fa.FaUtils;
import pers.kingvi.foreigntrade.util.ResultInfo;
import pers.kingvi.foreigntrade.vo.error.LoginError;
import pers.kingvi.foreigntrade.util.Result;
import pers.kingvi.foreigntrade.vo.AuthResult;
import pers.kingvi.foreigntrade.vo.fa.FreightAgencyInfoVo;

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
            emailError = ResultInfo.NULL_EMAIL;
        } else {
            String emailPatten = "(^?:[a-zA-Z0-9]+[_\\-+.]?)*[a-zA-Z0-9]+@(?:([a-zA-Z0-9]+-?)*[a-zA-Z0-9]+\\.)+([a-zA-Z]{2,})+$";
            if (!Pattern.matches(emailPatten, email)) {
                emailError = ResultInfo.EMAIL_FORMAT;
            }
        }
        if (StringUtils.isBlank(password)) {
            passwordError = ResultInfo.NULL_PASSWORD;
        } else if (password.trim().length() < 6 || password.trim().length() > 15) {
            passwordError = ResultInfo.PASSWORD_LENGTH;
        }
        //email或者password格式校验错误则返回错误信息，不执行登录操作
        if (emailError != null || passwordError != null) {
            return new Result<>().error(new LoginError(emailError, passwordError, null));
        } else {
            //格式校验通过，进行登录操作
            CustomizedToken token = new CustomizedToken(email, password, "fa");
            token.setRememberMe(false);
            Subject subject = SecurityUtils.getSubject();
            try {
                subject.login(token);
            } catch (UnknownAccountException uae) {
                return new Result<>().error(new LoginError(ResultInfo.EMAIL_NOT_EXIST, null));
            } catch (IncorrectCredentialsException ice) {
                return new Result<>().error(new LoginError(null, ResultInfo.PASSWORD_ERROR));
            }
            System.out.println("登录用户角色为：" + subject.getPrincipal());
            Session session = subject.getSession();
            FaUtils.getUserVo().setPassword("");
            session.setAttribute("id", FaUtils.getUserVo().getId());
            AuthResult authResult = new AuthResult(1000, "fa", FaUtils.getUserVo().getName(), "login");
            return new Result<AuthResult>().success(authResult);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/user-info")
    public Result getUserInfo() {
        FreightAgency freightAgency = FaUtils.getUserVo();
        if (freightAgency != null) {
            FreightAgencyInfoVo freightAgencyInfoVo = new FreightAgencyInfoVo(
                    freightAgency.getPhoto(),
                    freightAgency.getAccount(),
                    freightAgency.getSendQuoteCount(),
                    freightAgency.getName(),
                    freightAgency.getCity(),
                    freightAgency.getCompany(),
                    freightAgency.getCompanyLink(),
                    freightAgency.getSex(),
                    freightAgency.getAge(),
                    freightAgency.getWorkingTime(),
                    freightAgency.getMainBussinessScope(),
                    freightAgency.getServiceAdvantage(),
                    freightAgency.getWeChat(),
                    freightAgency.getPhone(),
                    freightAgency.getEmail()
            );
            return new Result<FreightAgencyInfoVo>().success(freightAgencyInfoVo);
        }
        return null;

    }

    @ResponseBody
    @RequestMapping(value = "/logout")
    public Result logout(){
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
        } catch (Exception e) {
            return Result.fail;
        }
        return Result.success;
    }
}
