package pers.kingvi.foreigntrade.freightagency.api;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;
import pers.kingvi.foreigntrade.config.AccountNotMatchException;
import pers.kingvi.foreigntrade.config.GlobalControlUtils;
import pers.kingvi.foreigntrade.config.LoginUtils;
import pers.kingvi.foreigntrade.config.WebSocketUtils;
import pers.kingvi.foreigntrade.filter.CustomizedToken;
import pers.kingvi.foreigntrade.freightagency.service.FreightAgencyService;
import pers.kingvi.foreigntrade.po.FreightAgency;
import pers.kingvi.foreigntrade.po.Message;
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

    @Autowired
    private FreightAgencyService freightAgencyService;

    @ResponseBody
    @RequestMapping(value = "/login")
    public Result login(@RequestParam("email") String email, @RequestParam("password") String password) {
        if (!GlobalControlUtils.isLoginStatus()) {
            return new Result(-2, "登录功能已关闭，请联系管理员开启");
        }
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
            if (subject.isAuthenticated() && subject.hasRole("fa")) {
//                已登录状态，且账号密码正确，直接返回用户信息
                if (FaUtils.getUserVo().getEmail().equals(email.trim()) && FaUtils.getUserVo().getPassword().equals(password.trim())) {
                    AuthResult authResult = new AuthResult(1000, "fa", FaUtils.getUserVo().getName(), "login");
                    return new Result<AuthResult>().success(authResult);
                }
            }
            try {
                subject.login(token);
            } catch (UnknownAccountException uae) {
                return new Result<>().error(new LoginError(ResultInfo.EMAIL_NOT_EXIST, null));
            } catch (AccountNotMatchException ane) {
                return new Result<>().error(new LoginError(ResultInfo.FTS_LOGIN_ACCOUNT_REJECT, null));
            } catch (IncorrectCredentialsException ice) {
                return new Result<>().error(new LoginError(null, ResultInfo.PASSWORD_ERROR));
            }
            Session session = subject.getSession();
            Long faId = FaUtils.getUserVo().getId();
            Message message = new Message("sessionDestroyed");
//            若存在登录的id，且登录id不在当前浏览器，则强制这个登录session退出
            if (LoginUtils.containsKey(faId) && session.getAttribute("id") != null && session.getId() != LoginUtils.get(faId).getId()) {
                try {
                    if (WebSocketUtils.hasConnection(faId)) {
                        WebSocketUtils.getWebsocketSession().get(faId).sendMessage(new TextMessage(JSONObject.toJSONString(message)));
                    }
                    LoginUtils.getWebsocketSession().get(faId).stop();
                } catch (Exception e) {
                    e.printStackTrace();
                    return new Result<>().fail("后台错误");
                }
            }
//                同一平台不同账号在同一浏览器登录，存在登录的id，且登录的sessionId与当前的sessionId相同，则LoginUtils删除已保存的登录的session
            if (!LoginUtils.containsKey(faId) && LoginUtils.containsSessionId(String.valueOf(session.getId()))) {
                Long id = LoginUtils.getId(String.valueOf(session.getId()));
                LoginUtils.removeSession(id);
                WebSocketUtils.removeSession(id);
            }
//            设置id属性
            session.setAttribute("id", faId);
//            设置类型属性
            session.setAttribute("type", "fa");
            LoginUtils.put(faId, session);
            LoginUtils.putSessionId(String.valueOf(session.getId()), faId);
//            保存用户登录状态
            AuthResult authResult = new AuthResult(1000, "fa", FaUtils.getUserVo().getName(), "login");
            return new Result<AuthResult>().success(authResult);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/user-info")
    public Result getUserInfo() {
        Subject subject = SecurityUtils.getSubject();
        Long faId = FaUtils.getUserVo().getId();
        FreightAgency freightAgency = freightAgencyService.selectByPrimaryKey(faId);
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
