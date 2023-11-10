package pers.kingvi.foreigntrade.filter;

import org.apache.shiro.authz.Authorizer;
import org.apache.shiro.authz.ModularRealmAuthorizer;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;
import pers.kingvi.foreigntrade.po.Admin;

import java.util.*;

/**
 * 自定义realm授权，通过login登录所添加的getName()选择
 */
@Component
public class CustomizedAuthorizer extends ModularRealmAuthorizer {

    @Override
    public boolean hasRole(PrincipalCollection principals, String roleIdentifier) {
        assertRealmsConfigured();
        Set<String> realmNames = principals.getRealmNames();
        //获取realm的名字
        String realmName = realmNames.iterator().next();
        for (Realm realm : getRealms()) {
            if (!(realm instanceof Authorizer)) continue;
            //通过匹配名字getName授予角色
            if(realmName.equals("fts")) {
                if (realm instanceof FtsRealm) {
                    return ((FtsRealm) realm).hasRole(principals, roleIdentifier);
                }
            }
            if (realmName.equals("fa")) {
                if (realm instanceof FaRealm) {
                    return ((FaRealm) realm).hasRole(principals, roleIdentifier);
                }
            }
            if (realmName.equals("admin")) {
                if (realm instanceof AdminRealm) {
                    return ((AdminRealm) realm).hasRole(principals, roleIdentifier);
                }
            }
        }
        return false;
    }
}
