package pers.kingvi.foreigntrade.admin.api;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.kingvi.foreigntrade.util.fts.FtsUtils;
import pers.kingvi.foreigntrade.util.fa.FaUtils;
import pers.kingvi.foreigntrade.util.ResultCode;
import pers.kingvi.foreigntrade.vo.AuthResult;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value = "/user-status")
    @ResponseBody
    public AuthResult getLoginStatus() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            if (subject.hasRole("fa")) {
                //返回fa的角色
                System.out.println(FaUtils.getUserVo().getName());
                return new AuthResult(ResultCode.AUTH_SUCCESS, "fa", FaUtils.getUserVo().getName(), "login");
            } else if (subject.hasRole("fts")) {
                //返回fts的角色
                return new AuthResult(ResultCode.AUTH_SUCCESS, "fts", FtsUtils.getUserVo().getName(), "login");
            } else if (subject.hasRole("admin")) {
                //返回admin的角色
                return new AuthResult(ResultCode.AUTH_SUCCESS, "admin", "weiweiwei", "login");
            }
        }
        return new AuthResult(ResultCode.AUTH_FAIL, "", "");
    }

}
