package pers.kingvi.foreigntrade.config;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import pers.kingvi.foreigntrade.admin.service.MessageService;
import pers.kingvi.foreigntrade.foreigntradesaleman.service.ForeignTradeSalemanService;
import pers.kingvi.foreigntrade.foreigntradesaleman.service.FtsMessageService;
import pers.kingvi.foreigntrade.freightagency.service.FreightAgencyService;
import pers.kingvi.foreigntrade.po.ForeignTradeSaleman;
import pers.kingvi.foreigntrade.po.FreightAgency;
import pers.kingvi.foreigntrade.po.Message;
import pers.kingvi.foreigntrade.vo.ReadMsgVo;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class MyWebSocketHandler extends TextWebSocketHandler {

    @Autowired
    private ForeignTradeSalemanService foreignTradeSalemanService;

    @Autowired
    private FreightAgencyService freightAgencyService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private FtsMessageService ftsMessageService;

    private static final Map<String, WebSocketSession> map = new HashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        Long userId = (Long) session.getAttributes().get("id");
        WebSocketUtils.put(userId, session);
        WebSocketUtils.putMatchType(userId, (String) session.getAttributes().get("type"));
    }

    @Override
    protected void handleTextMessage(WebSocketSession webSocketSession, TextMessage textMessage) throws IOException {
        Long senderId = (Long) webSocketSession.getAttributes().get("id");
        String authType = (String) webSocketSession.getAttributes().get("type");
        JSONObject jo = JSONObject.parseObject(textMessage.getPayload());
        String messageType = (String) jo.get("messageType");
        Message message;
        if (GlobalControlUtils.isChatStatus() || messageType.equals("ping")) {
            switch (messageType) {
                case "ping":
                    System.out.println("收到ping" + senderId);
                    message = new Message("pang");
                    System.out.println("发送pang");
                    webSocketSession.sendMessage(new TextMessage(JSONObject.toJSONString(message)));
                    break;
                case "sendMessage":
                    String messageContent = (String) jo.get("content");
                    message = JSONObject.parseObject(textMessage.getPayload(), Message.class);
                    Long receiverId = message.getReceiverId();
                    if ("fa".equals(authType)) {
//                    若发送者是货代，接收者必须是外贸
                        ForeignTradeSaleman foreignTradeSaleman = foreignTradeSalemanService.selectByPrimaryKey(receiverId);
                        if (foreignTradeSaleman != null) {
                            Message faMessage = new Message(senderId, receiverId, messageContent);
                            faMessage.setStatus("0");
                            int sendRes = messageService.insertFaMessage(faMessage);
//                        数据库成功插入消息，若fa在线，websocket发送消息
                            if (sendRes != 0) {
                                if (WebSocketUtils.hasConnection(senderId)) {
                                    Message messageRes = new Message();
                                    messageRes.setMessageType("sendSuccess");
                                    if (messageContent.trim().length() > 20) {
                                        messageContent = messageContent.substring(0, 20);
                                    }
                                    messageRes.setReceiverId(receiverId);
                                    messageRes.setContent(messageContent);
                                    webSocketSession.sendMessage(new TextMessage(JSONObject.toJSONString(messageRes)));
                                }
                                if (WebSocketUtils.hasConnection(receiverId)) {
                                    faMessage.setMessageType("sendMessage");
                                    faMessage.setSendTime((String) jo.get("sendTime"));
                                    faMessage.setStatus("0");
                                    WebSocketUtils.get(receiverId).sendMessage(new TextMessage(JSONObject.toJSONString(faMessage)));
                                }
                            } else if (WebSocketUtils.hasConnection(senderId)) {
                                Message faMsg = new Message();
                                faMsg.setMessageType("sendFail");
                                webSocketSession.sendMessage(new TextMessage(JSONObject.toJSONString(faMsg)));
                            }
                        }
                    } else {
//                    发送者是外贸，则接收者必须是货代
                        FreightAgency freightAgency = freightAgencyService.selectByPrimaryKey(receiverId);
                        if (freightAgency != null) {
                            Message ftsMessage = new Message(senderId, receiverId, messageContent);
                            ftsMessage.setStatus("0");
                            int sendRes = messageService.insertFtsMessage(ftsMessage);
                            if (sendRes != 0) {
                                if (WebSocketUtils.hasConnection(senderId)) {
                                    Message messageRes = new Message();
                                    messageRes.setMessageType("sendSuccess");
                                    if (messageContent.trim().length() > 20) {
                                        messageContent = messageContent.substring(0, 20);
                                    }
                                    messageRes.setReceiverId(receiverId);
                                    messageRes.setContent(messageContent);
                                    webSocketSession.sendMessage(new TextMessage(JSONObject.toJSONString(messageRes)));
                                }
                                if (WebSocketUtils.hasConnection(receiverId)) {
                                    ftsMessage.setMessageType("sendMessage");
                                    ftsMessage.setSendTime((String) jo.get("sendTime"));
                                    ftsMessage.setStatus("0");
                                    WebSocketUtils.get(receiverId).sendMessage(new TextMessage(JSONObject.toJSONString(ftsMessage)));
                                }
                            } else if (WebSocketUtils.hasConnection(senderId)) {
                                Message faMsg = new Message();
                                faMsg.setMessageType("sendFail");
                                webSocketSession.sendMessage(new TextMessage(JSONObject.toJSONString(faMsg)));
                            }
                        }
                    }
                    break;
                case "readMessage":
                    ReadMsgVo readMsgVo = JSONObject.parseObject(textMessage.getPayload(), ReadMsgVo.class);
                    Long senderId2 = readMsgVo.getReceiverId();
                    if (WebSocketUtils.hasConnection(senderId2) && "list".equals(readMsgVo.getOrigin())) {
                        WebSocketUtils.get(senderId).sendMessage(new TextMessage(JSONObject.toJSONString(readMsgVo)));
                    }
                    if ("window".equals(readMsgVo.getOrigin())) {
//                    receiverId2为消息数据库实际发送者，senderId为向后台发送读消息的用户，
                        Message message2 = new Message(senderId, senderId);
                        if ("fts".equals(authType)) {
                            ftsMessageService.readAllMessages(message2);
                        }

                    }
                    break;
            }
        } else {
            message = new Message("unChat");
            if (WebSocketUtils.hasConnection(senderId)) {
                WebSocketUtils.get(senderId).sendMessage(new TextMessage(JSONObject.toJSONString(message)));
            }
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        Long id = (Long) session.getAttributes().get("id");
        WebSocketUtils.removeSession(id);
        WebSocketUtils.removeMatchType(id);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        Long id = (Long) session.getAttributes().get("id");
        if (session.isOpen()) {
            session.close();
        }
        WebSocketUtils.removeSession(id);
        WebSocketUtils.removeMatchType(id);
    }

    private void sendMessageToUsers(String message, WebSocketSession webSocketSession) {
        for (String id : map.keySet()) {
            try {
                if (map.get(id).isOpen() && !map.get(id).equals(webSocketSession)) {
                    map.get(id).sendMessage(new TextMessage(message));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void sendMessageToUser(String username, String message) {
        if (map.get(username) != null) {
            if (map.get(username).isOpen()) {
                try {
                    map.get(username).sendMessage(new TextMessage(message));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}