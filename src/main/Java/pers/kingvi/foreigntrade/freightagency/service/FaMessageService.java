package pers.kingvi.foreigntrade.freightagency.service;

import pers.kingvi.foreigntrade.po.ForeignTradeSaleman;
import pers.kingvi.foreigntrade.po.Message;
import pers.kingvi.foreigntrade.vo.ReadAndUnReadMessageVo;

import java.util.List;

public interface FaMessageService {
    List<Message> getMessageListByProuductId(Integer productId, Long faId);

    List<Message> getMessageListBySenderId(Long senderId, Long receiverId);

    Long getFtsIdByProductId(Integer productId);

    ForeignTradeSaleman getFtsInfoByProductId(Integer productId);

    List<ReadAndUnReadMessageVo> getMessageList(Long receiverId);

    int readAllMessages(Message message);
}
