package pers.kingvi.foreigntrade.filter;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.kingvi.foreigntrade.admin.service.AdminService;
import pers.kingvi.foreigntrade.po.Admin;
import pers.kingvi.foreigntrade.util.ResultInfo;

@Component
public class AdminRealm extends AuthorizingRealm {

    @Autowired
    private AdminService adminService;

    {
        super.setName("admin");
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        CustomizedToken token = (CustomizedToken) authenticationToken;
        String account = (String)token.getPrincipal();
        String password = String.valueOf(token.getPassword());
        Admin adminParam = new Admin(account, password);
        Admin admin = adminService.selectByAccountAndPwd(adminParam);
        if (admin == null) {
            throw new UnknownAccountException(ResultInfo.ACCOUNT_OR_PWD_ERROR);
        }
        admin.setPassword("");
        return new SimpleAuthenticationInfo(admin, password, getName());
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRole("admin");
        return info;
    }

}
