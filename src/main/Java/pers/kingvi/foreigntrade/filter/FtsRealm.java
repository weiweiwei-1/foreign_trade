package pers.kingvi.foreigntrade.filter;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.kingvi.foreigntrade.admin.service.UserService;
import pers.kingvi.foreigntrade.config.AccountNotMatchException;
import pers.kingvi.foreigntrade.foreigntradesaleman.service.ForeignTradeSalemanService;
import pers.kingvi.foreigntrade.po.ForeignTradeSaleman;
import pers.kingvi.foreigntrade.po.User;
import pers.kingvi.foreigntrade.util.ResultInfo;

@Component
public class FtsRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private ForeignTradeSalemanService foreignTradeSalemanService;

    {
        super.setName("fts");
    }

    //fts认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        CustomizedToken token = (CustomizedToken) authenticationToken;
        String account = (String)token.getPrincipal();
        String password = String.valueOf(token.getPassword());
        ForeignTradeSaleman fts = foreignTradeSalemanService.selectByAccount(account);
        User user = userService.selectByUserAccount(account);
        if (fts == null && user == null) {
            throw new UnknownAccountException(ResultInfo.EMAIL_NOT_EXIST);
        } else if (fts == null) {
            throw new AccountNotMatchException(ResultInfo.FA_LOGIN_ACCOUNT_REJECT);
        } else if (!password.equals(fts.getPassword())) {
            throw new IncorrectCredentialsException(ResultInfo.PASSWORD_ERROR);
        }
        //将登录用户信息的密码置为空, 防止意外操作后台返回用户密码
        fts.setPassword("");
        return new SimpleAuthenticationInfo(fts, password, getName());
    }

    //fts授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRole("fts");
        return info;
    }
}
