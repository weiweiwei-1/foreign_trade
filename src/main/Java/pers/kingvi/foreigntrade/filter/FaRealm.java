package pers.kingvi.foreigntrade.filter;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.kingvi.foreigntrade.freightagency.service.FreightAgencyService;
import pers.kingvi.foreigntrade.po.FreightAgency;
import pers.kingvi.foreigntrade.util.ResultInfo;

@Component
public class FaRealm extends AuthorizingRealm {

    @Autowired
    private FreightAgencyService freightAgencyService;

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        CustomizedToken token = (CustomizedToken) authenticationToken;
        String account = (String)token.getPrincipal();
        String password = String.valueOf(token.getPassword());
        System.out.println("邮箱为：" + account);
        System.out.println("密码为：" + password);
        FreightAgency freightAgency = freightAgencyService.selectByAccount(account);
        if (freightAgency == null) {
            throw new UnknownAccountException(ResultInfo.EMAIL_NOT_EXIST);
        } else if (!password.equals(freightAgency.getPassword())) {
            throw new IncorrectCredentialsException(ResultInfo.PASSWORD_ERROR);
        }
        //将登录用户信息的密码置为空, 防止意外操作后台返回用户密码
        freightAgency.setPassword("");
        return new SimpleAuthenticationInfo(freightAgency, password, account);
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRole("fa");
        return info;
    }
}
