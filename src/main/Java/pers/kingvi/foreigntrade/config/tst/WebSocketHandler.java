package pers.kingvi.foreigntrade.config.tst;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;
import pers.kingvi.foreigntrade.config.WebSocketUserProperty;
import pers.kingvi.foreigntrade.config.WebSocketUtils;
import pers.kingvi.foreigntrade.config.tst.WebSocketServerConfig;

import pers.kingvi.foreigntrade.po.Message;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;


@Component
@ServerEndpoint(value="/websocket/socketServer",configurator = WebSocketServerConfig.class)
public class WebSocketHandler {

    private Gson gson = new Gson();

    @OnOpen
    public void onOpen(Session session) {
        WebSocketUserProperty webSocketUserProperty = (WebSocketUserProperty)session.getUserProperties().get("user");
        if (webSocketUserProperty.getUserId() != 0L) {
            WebSocketUtils.put(webSocketUserProperty.getUserId(), session);
        }
        System.out.println(WebSocketUtils.getWebsocketSession());
        for (Long key: WebSocketUtils.getWebsocketSession().keySet()){
            System.out.println("在线的用户id为：" + WebSocketUtils.get(key));
        }
//       将上线的消息发送给所有的在线好友
    }

    @OnMessage
    public void onMessage(Session session, String message) {
        WebSocketUserProperty webSocketUserProperty = (WebSocketUserProperty) session.getUserProperties().get("user");
        System.out.println("用户id为:" + webSocketUserProperty.getUserId());
        Message message2 = JSON.parseObject(message, Message.class);
        System.out.println("session为：" + session);
        System.out.println("sessionId为：" + session.getId());
        System.out.println("解析的消息是：" + message2.toString());
        switch (message2.getMessageType()) {
            case "ping": Message message1 = new Message("pang");
                session.getAsyncRemote().sendText(gson.toJson(message1));
                break;
            case "hasRead":
                Message message3 = new Message("hasRead");
                session.getAsyncRemote().sendText(gson.toJson(message3));
                break;
        }
    }

    @OnClose
    public void onClose(Session session) throws Exception {
        System.out.println("断开练级");
        try {
            WebSocketUserProperty webSocketUserProperty = (WebSocketUserProperty) session.getUserProperties().get("user");
            if (webSocketUserProperty.getUserId() != 0L) {
                WebSocketUtils.removeSession(webSocketUserProperty.getUserId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @OnError
    public void OnError(Session session, Throwable error) throws Exception{
        WebSocketUserProperty webSocketUserProperty = (WebSocketUserProperty) session.getUserProperties().get("user");
        if(WebSocketUtils.getWebsocketSession().containsKey(webSocketUserProperty.getUserId())) {
            WebSocketUtils.removeSession(webSocketUserProperty.getUserId());
//            将下线的消息发送给所有的在线好友
        };
        error.printStackTrace();
        System.out.println("cuowu");
    }
}
