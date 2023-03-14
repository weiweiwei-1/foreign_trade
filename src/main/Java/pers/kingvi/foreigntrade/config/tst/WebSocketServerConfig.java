package pers.kingvi.foreigntrade.config.tst;

import org.springframework.stereotype.Component;
import pers.kingvi.foreigntrade.config.WebSocketUserProperty;
import pers.kingvi.foreigntrade.util.fa.FaUtils;
import pers.kingvi.foreigntrade.util.fts.FtsUtils;

import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

@Component
public class WebSocketServerConfig extends ServerEndpointConfig.Configurator {
    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        // 将用户信息存储到socket的配置里
        WebSocketUserProperty webSocketUserProperty = null;
        if (FaUtils.getUserVo() != null) {
            webSocketUserProperty = new WebSocketUserProperty(FaUtils.getUserVo().getId(), FaUtils.getUserVo().getName());
        } else if (FtsUtils.getUserVo() != null){
            webSocketUserProperty = new WebSocketUserProperty(FtsUtils.getUserVo().getId(), FtsUtils.getUserVo().getName());
        }
        sec.getUserProperties().put("user", webSocketUserProperty == null ? new WebSocketUserProperty(0L, "") : webSocketUserProperty);
        super.modifyHandshake(sec, request, response);
    }
}
