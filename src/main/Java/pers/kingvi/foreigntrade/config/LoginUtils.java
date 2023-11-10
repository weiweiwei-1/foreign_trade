package pers.kingvi.foreigntrade.config;

import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;
import org.apache.shiro.session.Session;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LoginUtils {
//    保存登录的faId和sessionId
    public static Map<String, Long> SESSION_ID = new HashMap<>();
//    保存登录的session
    public static Map<Long, Session> LOGIN_SESSION = new ConcurrentHashMap<>();

    public static Map<String, Long> getSessionId() {
        return SESSION_ID;
    }

    public static void setSessionId(Map<String, Long> sessionId) {
        SESSION_ID = sessionId;
    }

    public static void put(Long id, Session session){
        LOGIN_SESSION.put(id, session);
    }

    public static Map<Long, Session> getWebsocketSession() {
        return LOGIN_SESSION;
    }

    public static void putSessionId(String sessionId, Long id) {
        SESSION_ID.put(sessionId, id);
    }

    public static void removeSessionId(String sessionId) {
        SESSION_ID.remove(sessionId);
    }

    public static Long getId(String sessionId) {
        return SESSION_ID.get(sessionId);
    }

    public static boolean containsSessionId(String sessionId) {
        return SESSION_ID.containsKey(sessionId);
    }

    public static Session get(Long key) {
        return LOGIN_SESSION.get(key);
    }

    public static void removeSession(Long key) {
        LOGIN_SESSION.remove(key);
    }

    public static boolean containsKey(Long id) {
        return LOGIN_SESSION.containsKey(id);
    }
}
