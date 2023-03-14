package pers.kingvi.foreigntrade.config;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Component
public class WebSocketHandshakeInterceptor implements HandshakeInterceptor {

    public boolean beforeHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Map<String, Object> attributes){
        if(((ServletServerHttpRequest) serverHttpRequest).getServletRequest().getSession(false) == null){
            System.out.println("Before Handshake");
            return false;
//            System.out.println("未知用户"+((ServletServerHttpRequest) serverHttpRequest).getServletRequest().getSession().getId()+"connected");
        }
        ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) serverHttpRequest;
        HttpSession session=servletRequest.getServletRequest().getSession(false);
        Long id = (Long) session.getAttribute("id");
        if (id == null) {
            return false;  //将用户标识放入参数列表后，下一步的websocket处理器可以读取这里面的数据
        }
        attributes.put("id", id);
        return true;
    }

    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler,Exception e) {
        System.out.println("After Handshake");
        System.out.println("连接者ID是："+((ServletServerHttpRequest)serverHttpRequest).getServletRequest().getSession(false).getAttribute("id"));
    }
}