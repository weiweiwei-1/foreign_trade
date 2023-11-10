package pers.kingvi.foreigntrade.config;

import org.springframework.web.socket.WebSocketSession;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WebSocketUtils {
//    全局静态变量，保存所有已建立连接的WebSocketSession
    public static Map<Long, WebSocketSession> WEBSOCKET_SESSION = new ConcurrentHashMap<>();

    public static Map<Long, String> MATCH_TYPE = new ConcurrentHashMap<>();

    public static void putMatchType(Long id, String type) {
        MATCH_TYPE.put(id, type);
    }

    public static void removeMatchType(Long id) {
        MATCH_TYPE.remove(id);
    }

    public static boolean containsMatchId(Long id) {
        return MATCH_TYPE.containsKey(id);
    }

    public static String getMatchType(Long id) {
        return MATCH_TYPE.get(id);
    }

    public static void put(Long id, WebSocketSession session){
        WEBSOCKET_SESSION.put(id, session);
    }

    public static Map<Long, WebSocketSession> getWebsocketSession() {
        return WEBSOCKET_SESSION;
    }

    public static WebSocketSession get(Long key) {
        return WEBSOCKET_SESSION.get(key);
    }

    public static void removeSession(Long key) {
        WEBSOCKET_SESSION.remove(key);
    }

    public static boolean hasConnection(Long key) {
        return WEBSOCKET_SESSION.containsKey(key);
    }
}
