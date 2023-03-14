package pers.kingvi.foreigntrade.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import pers.kingvi.foreigntrade.admin.service.UserService;
import pers.kingvi.foreigntrade.po.Message;
import pers.kingvi.foreigntrade.po.User;


import javax.json.Json;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class MyWebSocketHandler extends TextWebSocketHandler {
    @Autowired
    private UserService userService;

    private static final Map<String,WebSocketSession> map = new HashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        Long userId = (Long) session.getAttributes().get("id");
//        建立连接后保存WebSocketSession到map映射变量中
        WebSocketUtils.put(userId, session);
        System.out.println("OnOpen后：");
        System.out.println("当前用户的id为：" + userId);
        System.out.println("目前的所有用户有:");
        for (Long id : WebSocketUtils.getWebsocketSession().keySet()) {
            System.out.println(id);
        }
//        System.out.println("用户 " + username + " Connection Established");
//        session.sendMessage(new TextMessage(username + " connect"));
    }

    @Override
    protected void handleTextMessage(WebSocketSession webSocketSession, TextMessage textMessage) throws IOException {
//        String username=(Long)webSocketSession.getAttributes().get("id");
        Long senderId = (Long) webSocketSession.getAttributes().get("id");
//        System.out.println("senderId为：" + senderId);
//        System.out.println("原来发送消息：" + textMessage);
//        System.out.println("解析后的payLoad消息：" + textMessage.getPayload());
//        Message message = JSON.parseObject(textMessage);
        JSONObject jo=JSONObject.parseObject(textMessage.getPayload());
//        System.out.println("接收者为"+jo.get("id"));
        Message message1 = new Message("pang");
        webSocketSession.sendMessage(new TextMessage(JSONObject.toJSONString(message1)));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status){
        String username = (String) session.getAttributes().get("username");
        System.out.println("OnClosed后:");
        System.out.println("用户 " + username + " Connection closed. Status: " + status);
        map.remove(username);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        String username = (String) session.getAttributes().get("username");
        if (session.isOpen()) {
            session.close();
        }
        System.out.println("OnError后：");
        System.out.println("用户: " + username + " websocket connection closed......");
        map.remove(username);
    }
    private void sendMessageToUsers(String message,WebSocketSession webSocketSession) {

        for (String id : map.keySet()) {
            try {
                if (map.get(id).isOpen()&&!map.get(id).equals(webSocketSession)) {
                    map.get(id).sendMessage(new TextMessage(message));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void sendMessageToUser(String username, String message) {
        if(map.get(username)!=null){
            if(map.get(username).isOpen()){
                try {
                    map.get(username).sendMessage(new TextMessage(message));
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}