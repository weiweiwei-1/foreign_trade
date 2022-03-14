package pers.kingvi.foreigntrade.freightagency.api;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pers.kingvi.foreigntrade.admin.service.UserService;
import pers.kingvi.foreigntrade.common.IdWorker;
import pers.kingvi.foreigntrade.freightagency.service.FreightAgencyService;
import pers.kingvi.foreigntrade.po.FreightAgency;
import pers.kingvi.foreigntrade.po.User;
import pers.kingvi.foreigntrade.util.ErrorInfo;
import pers.kingvi.foreigntrade.util.LoginError;
import pers.kingvi.foreigntrade.util.Result;
import pers.kingvi.foreigntrade.util.ResultCode;

import java.sql.SQLException;
import java.util.regex.Pattern;

@Controller
@RequestMapping(value = "/fa/user")
public class FaRegisterController {

    @Autowired
    private FreightAgencyService freightAgencyService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register")
    @ResponseBody
    public Result register(@RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("code") String code) {
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
            //格式校验通过的条件下，才查询数据库判断邮箱是否注册，否则先返回错误信息
            User user = userService.selectByUserAccount(email);
            if (user != null) {
                emailError = ErrorInfo.EMAIL_EXIST;
                return new Result<>().error(new LoginError(emailError, null, null));
            }
            try {
                    //雪花算法生成唯一自增id
                    IdWorker idWorker = new IdWorker(1, 1, 1);
                    FreightAgency fa = new FreightAgency();
                    Long id = idWorker.nextId();
                    fa.setId(id);
                    fa.setAccount(email);
                    fa.setPassword(password);
                    fa.setCompany(" ");
                    fa.setCity(" ");
                    fa.setName(" ");
                    fa.setPhoto("default.jpg");
                    freightAgencyService.insertSelective(fa);
                } catch (DataAccessException e) {
                    SQLException exception = (SQLException) e.getCause();
                    int statusCode = exception.getErrorCode();
                    String msg = ErrorInfo.DBS_ERROR + statusCode;
                    return new Result(ResultCode.FAIL, msg);
                }
                return Result.success;
            }
    }
}
