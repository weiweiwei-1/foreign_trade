package pers.kingvi.foreigntrade.admin.api;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.kingvi.foreigntrade.admin.service.AdminService;
import pers.kingvi.foreigntrade.filter.CustomizedToken;
import pers.kingvi.foreigntrade.util.Result;
import pers.kingvi.foreigntrade.util.ResultInfo;
import pers.kingvi.foreigntrade.vo.AuthResult;

@Controller
@RequestMapping(value = "/vivivi/user")
public class AdminController {

    @Autowired
    private AdminService adminService;


    /**
     * @param account 账号
     * @param password 密码
     * @return 登录结果信息
     */
    @ResponseBody
    @RequestMapping(value = "/login")
    public Result login(@RequestParam(value = "account") String account, @RequestParam("password") String password) {
        CustomizedToken token = new CustomizedToken(account.trim(), password.trim(), "admin");
        token.setRememberMe(false);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (UnknownAccountException ue) {
            return new Result(0, ResultInfo.ACCOUNT_OR_PWD_ERROR);
        } catch (Exception e) {
            System.out.println(e.toString());
            return Result.fail;
        }
        AuthResult authResult = new AuthResult(1000, "admin", "admin", "login");
        return new Result<AuthResult>().success(authResult);
    }

    /**
     * 注销接口
     * @return 返回注销Result信息
     */
    @RequestMapping(value = "/logout")
    @ResponseBody
    public Result logout() {
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
        } catch (Exception e) {
            return new Result<>().fail("注销失败, 后台出错");
        }
        return Result.success;
    }
}
