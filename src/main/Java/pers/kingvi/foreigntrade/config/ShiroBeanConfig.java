package pers.kingvi.foreigntrade.config;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.session.mgt.ExecutorServiceSessionValidationScheduler;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import pers.kingvi.foreigntrade.filter.AuthorizeRealm;
import pers.kingvi.foreigntrade.filter.ShiroFormAuthenticationFilter;

import javax.servlet.Filter;
import java.util.LinkedHashMap;

@Component
public class ShiroBeanConfig {
    @Autowired
    private ShiroFormAuthenticationFilter shiroFormAuthenticationFilter;

    @Autowired
    private AuthorizeRealm myRealms;

    @Bean(name = "cookie")
    public static SimpleCookie getSimpleCookie() {
        SimpleCookie simpleCookie = new SimpleCookie();
        simpleCookie.setHttpOnly(true);
        simpleCookie.setMaxAge(604800);
        return simpleCookie;
    }

    @Bean(name = "rememberMeManager")
    public static CookieRememberMeManager getRememberMeManager() {
        CookieRememberMeManager rememberMeManager = new CookieRememberMeManager();
        rememberMeManager.setCipherKey(Base64.decode("2AvVhdsgUs0FSA3SDFAdag=="));
        rememberMeManager.setCookie(getSimpleCookie());
        return rememberMeManager;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getSecurityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myRealms);
        securityManager.setRememberMeManager(getRememberMeManager());
        return securityManager;
    }

    @Bean(name = "sessionValidationScheduler")
    public static ExecutorServiceSessionValidationScheduler getSessionValidationScheduler() {
        ExecutorServiceSessionValidationScheduler executorServiceSessionValidationScheduler = new ExecutorServiceSessionValidationScheduler();
        executorServiceSessionValidationScheduler.setInterval(1800000);
        return executorServiceSessionValidationScheduler;
    }

    @Bean(name = "sessionManager")
    public static DefaultWebSessionManager getSessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setGlobalSessionTimeout(3600000);
        sessionManager.setDeleteInvalidSessions(true);
        sessionManager.setSessionValidationSchedulerEnabled(true);
        sessionManager.setSessionValidationScheduler(getSessionValidationScheduler());
        sessionManager.setSessionIdUrlRewritingEnabled(true);
        return sessionManager;
    }

    @Bean(name = "shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getshiroFilterFactoryBean() {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        LinkedHashMap<String, Filter> filterMap = new LinkedHashMap<>();
        filterMap.put("roles", shiroFormAuthenticationFilter);
        filterMap.put("authc", shiroFormAuthenticationFilter);
        shiroFilterFactoryBean.setFilters(filterMap);
        shiroFilterFactoryBean.setSecurityManager(getSecurityManager());
        LinkedHashMap<String, String> urlMap = new LinkedHashMap<>();
        urlMap.put("/ChatPage/login", "anon");
        urlMap.put("/ChatPage/register", "anon");
//        urlMap.put("/ChatPage/**", "authc");
        urlMap.put("/AddUser/**", "authc");
        urlMap.put("/Friend/**", "authc,roles[admin]");
        urlMap.put("/Message/**", "authc");
        urlMap.put("/User/**", "authc");
        urlMap.put("/**", "anon");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(urlMap);
        return shiroFilterFactoryBean;
    }

}
