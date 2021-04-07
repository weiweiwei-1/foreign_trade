package pers.kingvi.foreigntrade.admin.service;

import pers.kingvi.foreigntrade.po.Message;

import java.util.List;

public interface MessageService {
    int insertMessage(Message message);     //发送消息，将消息记录插入数据库中, 总插入方法

    int insertFtsMessage(Message message);      //外贸发送消息，使用该方法

    int insertFaMessage(Message message);        //货代发送消息，使用该方法

    int insertMessageById(Long id, Long receiverId, String content, String sendTime);

    List<Message> selectAllMessages(Long id, Long friendId);    //显示所有消息记录

    List<Message> selectLastThirtyMessage(Long id, Long friendId);     //显示最后30条消息记录

    List<Message> selectLastFiftyMessage(Long id, Long friendId);      //显示最后50条消息记录

    int deleteMessageByPrimaryKey(Long id, Long friendId);    //根据id删除消息记录，可以删除半小时以内的自己发送的消息内容（需要关联自己的id才能进行删除）。

    int deleteAllMessages(Long id, Long friendId);

}
