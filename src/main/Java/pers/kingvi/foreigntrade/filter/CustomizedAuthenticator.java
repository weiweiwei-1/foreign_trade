package pers.kingvi.foreigntrade.filter;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.AuthenticationStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;


@Component
public class CustomizedAuthenticator extends ModularRealmAuthenticator {

    /*@Autowired
    private CustomizedToken customizedToken;*/

    @Override
    public void setAuthenticationStrategy(AuthenticationStrategy authenticationStrategy) {
        AtLeastOneSuccessfulStrategy strategy = (AtLeastOneSuccessfulStrategy)authenticationStrategy;
        super.setAuthenticationStrategy(strategy);
    }

    @Override
    protected AuthenticationInfo doAuthenticate(AuthenticationToken authenticationToken) throws AuthenticationException {
        assertRealmsConfigured();
        CustomizedToken customizedToken = (CustomizedToken) authenticationToken;
        String loginType = customizedToken.getLoginType();
        Collection<Realm> realms = getRealms();
        Collection<Realm> typeRealms = new ArrayList<>();
        for (Realm realm : realms) {
            System.out.println(realm.getName());
            if (realm.getName().contains(loginType)) {
                typeRealms.add(realm);
            }

        }
        if (typeRealms.size() == 1) {
            return doSingleRealmAuthentication(typeRealms.iterator().next(), customizedToken);
        } else {
            return doMultiRealmAuthentication(typeRealms, customizedToken);
        }
    }
}