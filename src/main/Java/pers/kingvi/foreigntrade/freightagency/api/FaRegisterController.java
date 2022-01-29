package pers.kingvi.foreigntrade.freightagency.api;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.kingvi.foreigntrade.test.basetest.User;
import pers.kingvi.foreigntrade.util.Result;

import java.awt.image.RescaleOp;

@Controller
@RequestMapping(value = "/fa/user")
public class FaRegisterController {

    @RequestMapping(value = "/register")
    @ResponseBody
    public Result register(String email, String password, String password_confirm, String code, String adb) {
        String emailError = null;
        String passwordError = null;
        String codeError = null;
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        System.out.println("sessionId为：" + session.getId());
        if (email == null) {
            System.out.println("null");
        }
        if (email.equals("") ) {
            System.out.println("为空字符");
        }
        System.out.println(email);
        System.out.println("adb为:" + adb);
        User user = new User();
        user.setAddress("梅州");
        user.setAge(16);
        return new Result<>(user);
    }

}
