package pers.kingvi.foreigntrade.config;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.ExecutorServiceSessionValidationScheduler;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import pers.kingvi.foreigntrade.filter.*;
import pers.kingvi.foreigntrade.po.User;

import javax.servlet.Filter;
import java.util.*;

@Component
@Configuration
public class ShiroBeanConfig {
    @Autowired
    private ShiroFormAuthenticationFilter shiroFormAuthenticationFilter;

    @Autowired
    private FaRealm faRealm;

    @Autowired
    private FtsRealm ftsRealm;

    @Autowired
    private AdminRealm adminRealm;

    @Autowired
    private CustomizedAuthenticator customizedAuthenticator;

    @Autowired
    private CustomizedAuthorizer customizedAuthorizer;

    @Bean(name = "cookie")
    public static SimpleCookie getSimpleCookie() {
        SimpleCookie simpleCookie = new SimpleCookie("myCookie");
        simpleCookie.setHttpOnly(true);
        simpleCookie.setMaxAge(604800);
        return simpleCookie;
    }

    @Bean(name = "rememberMe")
    public static CookieRememberMeManager getRememberMeManager() {
        CookieRememberMeManager rememberMeManager = new CookieRememberMeManager();
//        Base64.decode("6ZmI6I2j5Y+R5aSn5ZOlAA==")
        rememberMeManager.setCipherKey(Base64.decode("2AvVhdsgUs0FSA3SDFAdag=="));
        rememberMeManager.setCookie(getSimpleCookie());
        return rememberMeManager;
    }

    @Bean(name = "authenticator")
    public CustomizedAuthenticator getCustomizedAuthenticator() {
        return customizedAuthenticator;
    }

    @Bean(name = "authorizer")
    public CustomizedAuthorizer getCustomizedAuthorizer() {
        return customizedAuthorizer;
    }

    @Bean(name = "sessionValidationScheduler")
    public static ExecutorServiceSessionValidationScheduler getSessionValidationScheduler() {
        ExecutorServiceSessionValidationScheduler executorServiceSessionValidationScheduler = new ExecutorServiceSessionValidationScheduler();
        executorServiceSessionValidationScheduler.setInterval(3600000);
        return executorServiceSessionValidationScheduler;
    }

    @Bean(name = "sessionManager")
    public static MyWebSessionManager getSessionManager() {
        MyWebSessionManager sessionManager = new MyWebSessionManager();
//        sessionManager.setGlobalSessionTimeout(3600000);
//        List<SessionListener> listeners = new ArrayList<>();
        //需要添加自己实现的会话监听器
//        listeners.add(new UserSessionListener());
        //添加会话监听器给sessionManager管理
//        sessionManager.setSessionListeners(listeners);
        sessionManager.setGlobalSessionTimeout(3600000);
        sessionManager.setDeleteInvalidSessions(true);
        sessionManager.setSessionValidationSchedulerEnabled(true);
        sessionManager.setSessionValidationScheduler(getSessionValidationScheduler());
        sessionManager.setSessionIdUrlRewritingEnabled(true);
//        sessionManager.setSessionIdCookie(getSimpleCookie());
//        sessionManager.setSessionIdCookieEnabled(true);
        return sessionManager;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getSecurityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        Collection<Realm> realms = new ArrayList<>();
        realms.add(faRealm);
        realms.add(ftsRealm);
        realms.add(adminRealm);
        securityManager.setAuthorizer(getCustomizedAuthorizer());
        securityManager.setAuthenticator(getCustomizedAuthenticator());
        securityManager.setRealms(realms);
        securityManager.setRememberMeManager(getRememberMeManager());
//        securityManager.setSessionManager(getSessionManager());
        return securityManager;
    }

    @Bean(name = "shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean() {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        LinkedHashMap<String, Filter> filterMap = new LinkedHashMap<>();
        filterMap.put("roles", shiroFormAuthenticationFilter);
        filterMap.put("authc", shiroFormAuthenticationFilter);
        shiroFilterFactoryBean.setFilters(filterMap);
        shiroFilterFactoryBean.setSecurityManager(getSecurityManager());
        LinkedHashMap<String, String> urlMap = new LinkedHashMap<>();
        urlMap.put("/vivivi/user/login", "anon");
        urlMap.put("/user/user-status", "anon");
        urlMap.put("/fts/user/register", "anon");
        urlMap.put("/fts/user/login", "anon");
        urlMap.put("/fts/recommend/list", "anon");
        urlMap.put("/fts/recommend/list/condition", "anon");
        urlMap.put("/fts/friend/recommend", "anon");
        urlMap.put("/fts/friend/recommend/condition", "anon");
        urlMap.put("/fts/friend/recommend/info", "anon");
        urlMap.put("/fts/friend/apply/count", "anon");
        urlMap.put("/fts/message/count", "anon");
        urlMap.put("/fts/product/count", "anon");
        urlMap.put("/fa/user/register", "anon");
        urlMap.put("/fa/user/login", "anon");
        urlMap.put("/fa/product/list", "anon");
        urlMap.put("/fa/product/list/condition", "anon");
        urlMap.put("/fa/friend/recommend", "anon");
        urlMap.put("/fa/friend/recommend/condition", "anon");
        urlMap.put("/fa/friend/recommend/info", "anon");
        urlMap.put("/fa/friend/apply/count", "anon");
        urlMap.put("/fa/message/count", "anon");
        urlMap.put("/fa/quote/count", "anon");
        urlMap.put("/fts/**", "authc, roles[fts]");
        urlMap.put("/fa/**", "authc, roles[fa]");
        urlMap.put("/vivivi/**", "authc, roles[admin]");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(urlMap);
        return shiroFilterFactoryBean;
    }
}
