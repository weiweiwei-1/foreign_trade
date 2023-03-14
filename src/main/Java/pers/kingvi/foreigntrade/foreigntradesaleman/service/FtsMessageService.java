package pers.kingvi.foreigntrade.foreigntradesaleman.service;


import pers.kingvi.foreigntrade.bo.fts.FtsMsgListBo;
import pers.kingvi.foreigntrade.po.ForeignTradeSaleman;
import pers.kingvi.foreigntrade.po.Message;
import pers.kingvi.foreigntrade.vo.ReadAndUnReadMessageVo;

import java.util.List;

public interface FtsMessageService {
//    List<FtsMsgListBo> getMessageListByProuductId(Integer productId, Long faId);

    List<ReadAndUnReadMessageVo> getMessageList(Long receiverId);

    List<Message> selectMessageContent(Message message);

    int readAllMessages(Message message);
}
