package pers.kingvi.foreigntrade.filter;

import pers.kingvi.foreigntrade.config.LoginUtils;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class UserSessionListener implements HttpSessionListener  {

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        if (httpSessionEvent.getSession().getAttribute("id") != null) {
            System.out.println("sessionId为：" + httpSessionEvent.getSession().getAttribute("id"));
            System.out.println("有效的session输出");
        } else {
            System.out.println("sessionId为：" + httpSessionEvent.getSession().getAttribute("id"));
        }
    }

//    监听session的销毁，当session销毁时，删除保存的用户登录状态
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        if (httpSessionEvent.getSession().getAttribute("id") != null) {
            Long key = (Long) httpSessionEvent.getSession().getAttribute("id");
            LoginUtils.removeSessionId(httpSessionEvent.getSession().getId());
            if (LoginUtils.LOGIN_SESSION.containsKey(key)) {
                LoginUtils.removeSession(key);
            }
        }
        System.out.println("session被销毁");
    }

}
