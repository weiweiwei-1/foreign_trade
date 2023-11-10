package pers.kingvi.foreigntrade.freightagency.api;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.codehaus.jackson.node.LongNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pers.kingvi.foreigntrade.admin.service.UserService;
import pers.kingvi.foreigntrade.common.IdWorker;
import pers.kingvi.foreigntrade.config.GlobalControlUtils;
import pers.kingvi.foreigntrade.config.LoginUtils;
import pers.kingvi.foreigntrade.filter.CustomizedToken;
import pers.kingvi.foreigntrade.freightagency.service.FreightAgencyService;
import pers.kingvi.foreigntrade.po.FreightAgency;
import pers.kingvi.foreigntrade.po.User;
import pers.kingvi.foreigntrade.util.*;
import pers.kingvi.foreigntrade.util.fa.FaUtils;
import pers.kingvi.foreigntrade.vo.AuthResult;
import pers.kingvi.foreigntrade.vo.error.LoginError;

import java.sql.SQLException;
import java.util.Random;
import java.util.regex.Pattern;

@Controller
@RequestMapping(value = "/fa/user")
public class FaRegisterController {

    @Autowired
    private FreightAgencyService freightAgencyService;

    @Autowired
    private UserService userService;

    private String getRandomName() {
        String[] randomName = new String[]{"邂逅", "遇见", "相遇"};
        StringBuilder targetName = new StringBuilder(randomName[new Random().nextInt(randomName.length)]);
        int randomInteger;
        for (int i = 0; i < 4; i++) {
            randomInteger = new Random().nextInt(10);
            targetName.append(randomInteger);
        }
        return targetName.toString();
    }

    @RequestMapping(value = "/register")
    @ResponseBody
    public Result register(@RequestParam("account") String email, @RequestParam("password") String password, @RequestParam("code") String code) {
        if (!GlobalControlUtils.isRegisterStatus()) {
            return new Result(-2, "为了安全，注册功能已关闭，请联系管理员开启");
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
        if (emailError != null || passwordError != null) {
            return new Result<>().error(new LoginError(emailError, passwordError, null));
        } else {
            //格式校验通过的条件下，才查询数据库判断邮箱是否注册，否则先返回错误信息
            User user = userService.selectByUserAccount(email.trim());
            if (user != null) {
                emailError = ResultInfo.EMAIL_EXIST;
                return new Result<>().error(new LoginError(emailError, null, null));
            }
            try {
                    //雪花算法生成唯一自增id
                    IdWorker idWorker = new IdWorker(1, 1, 1);
                    FreightAgency fa = new FreightAgency();
                    Long id = idWorker.nextId();
                    fa.setId(id);
                    fa.setAccount(email.trim());
                    fa.setPassword(password.trim());
                    fa.setCompany(" ");
                    fa.setCity(" ");
                    fa.setName(getRandomName());
                    fa.setPhoto("default.jpg");
                    freightAgencyService.insertSelective(fa);
                } catch (DataAccessException e) {
                    SQLException exception = (SQLException) e.getCause();
                    int statusCode = exception.getErrorCode();
                    String msg = ResultInfo.DBS_ERROR + statusCode;
                    return new Result(ResultCode.FAIL, msg);
                }
            CustomizedToken token = new CustomizedToken(email.trim(), password.trim(), "fa");
            token.setRememberMe(false);
            Subject subject = SecurityUtils.getSubject();
            try {
                subject.login(token);
            } catch (Exception e) {
                return new Result(ResultCode.FAIL, e.toString());
            }
            Session session = subject.getSession();
            Long faId = FaUtils.getUserVo().getId();
            if (LoginUtils.containsSessionId(String.valueOf(session.getId()))) {
                Long id = LoginUtils.getId(String.valueOf(session.getId()));
                LoginUtils.removeSession(id);
            }
            session.setAttribute("id", faId);
            session.setAttribute("type", "fa");
            //保存用户登录状态
            LoginUtils.put(FaUtils.getUserVo().getId(), session);
            LoginUtils.putSessionId(String.valueOf(session.getId()), faId);
            AuthResult authResult = new AuthResult(1000, "fa", FaUtils.getUserVo().getName(), "login");
            return new Result<AuthResult>().success(authResult);
            }
    }
}
