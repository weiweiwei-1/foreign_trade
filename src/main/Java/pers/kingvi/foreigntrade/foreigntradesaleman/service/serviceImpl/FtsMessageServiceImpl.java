package pers.kingvi.foreigntrade.foreigntradesaleman.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.kingvi.foreigntrade.admin.dao.FriendMapper;
import pers.kingvi.foreigntrade.admin.dao.MessageMapper;
import pers.kingvi.foreigntrade.foreigntradesaleman.service.FtsMessageService;
import pers.kingvi.foreigntrade.freightagency.dao.FreightAgencyMapper;
import pers.kingvi.foreigntrade.po.FreightAgency;
import pers.kingvi.foreigntrade.po.Friend;
import pers.kingvi.foreigntrade.po.Message;
import pers.kingvi.foreigntrade.vo.ReadAndUnReadMessageVo;
import pers.kingvi.foreigntrade.vo.UnReadMessageVo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FtsMessageServiceImpl implements FtsMessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private FreightAgencyMapper freightAgencyMapper;

    @Autowired
    private FriendMapper friendMapper;

    @Override
    public List<ReadAndUnReadMessageVo> getMessageList(Long userId) {
        List<Message> senderVoList = messageMapper.selectLastMessageListFromSenderId(userId);
        List<Message> receiverVoList = messageMapper.selectLastMessageListFromReceiverId(userId);
        List<UnReadMessageVo> unReadMessageVoList = messageMapper.selectUnReadMessage(userId);  //未读消息记录
        Map<Long, Integer> senderMap = new HashMap<>();  //senderMap存储senderId为userId时，receiverId对应的消息id
        Map<Long, Integer> receiverMap = new HashMap<>(); //receiverMap存储receiverId为userId时，senderId对应的消息id
        Map<Long, Integer> unReadMap = new HashMap<>();   //unReadMap存储receiverId为userId时，对应的未读消息数
        List<Integer> lastUnReadMessageIdList = new ArrayList<>(); //存储未读消息的最后一条id记录
        List<Integer> lastReadMessageIdList = new ArrayList<>();  //存储已读消息的最后一条记录
        for (Message message : senderVoList) {
            senderMap.put(message.getReceiverId(), message.getId());
        }
        for (Message message : receiverVoList) {
            receiverMap.put(message.getSenderId(), message.getId());
        }
        for (UnReadMessageVo unReadMessageVo: unReadMessageVoList) {
            unReadMap.put(unReadMessageVo.getFriendId(), unReadMessageVo.getUnReadMessageCount());
        }
        for (Map.Entry<Long, Integer> entry : receiverMap.entrySet()) {
            Long key = entry.getKey();
            int value = entry.getValue();
            if (senderMap.containsKey(key)) {
                //若receiverMap和senderMap有相同的记录，则选择id大的记录，同时将senderMap对应的记录删除
                if (value > senderMap.get(key)) {
                    if (unReadMap.containsKey(key)) {
                        lastUnReadMessageIdList.add(value);
                    } else {
                        lastReadMessageIdList.add(value);
                    }
                } else {
                    lastReadMessageIdList.add(receiverMap.get(key));
                }
                senderMap.remove(key);
            } else {
                //没有相同的记录，那么所有消息对应的receiver只有一人，通过判断未读消息个数决定将message id放到哪个list
                if (unReadMap.containsKey(key)) {
                    lastUnReadMessageIdList.add(value);
                } else {
                    lastReadMessageIdList.add(value);
                }
            }
        }
        //剩余的记录添加到已读列表
        for (Map.Entry<Long, Integer> entry : senderMap.entrySet()) {
            lastReadMessageIdList.add(entry.getValue());
        }
        List<Message> readMessageList = new ArrayList<>();
        List<Message> unReadMessageList = new ArrayList<>();
        if (lastReadMessageIdList.size() != 0) {
            readMessageList = messageMapper.selectMessageListByIdList(lastReadMessageIdList);
        }
        if (lastUnReadMessageIdList.size() != 0) {
            unReadMessageList = messageMapper.selectMessageListByIdList(lastUnReadMessageIdList);
        }
        List<Long> faIdList = new ArrayList<>();    //存储所有进行过交流的faId
        List<ReadAndUnReadMessageVo> messageVoList = new ArrayList<>();   //消息列表在浏览器显示时的映射
        //对ReadAndUnReadMessageVo依次添加消息属性,如消息内容，消息发送时间等，同时faIdList添加对应faId便于后续查询匹配消息发送者的昵称，照片等
        for (Message message : unReadMessageList) {
            ReadAndUnReadMessageVo readAndUnReadMessageVo = new ReadAndUnReadMessageVo(
                    message.getId(),
                    message.getContent(),
                    message.getSendTime()
            );
            readAndUnReadMessageVo.setFriendId(message.getSenderId());
            readAndUnReadMessageVo.setUnReadMessageCount(unReadMap.get(message.getSenderId()));
            faIdList.add(message.getSenderId());
            messageVoList.add(readAndUnReadMessageVo);
        }
        for (Message message : readMessageList) {
            ReadAndUnReadMessageVo readAndUnReadMessageVo = new ReadAndUnReadMessageVo(
                    message.getId(),
                    message.getContent(),
                    message.getSendTime()
            );
            //已读消息列表中，获取最后一条消息的faId，同时添加到faIdList中
            readAndUnReadMessageVo.setUnReadMessageCount(0);
            if (message.getSenderId().equals(userId)) {
                readAndUnReadMessageVo.setFriendId(message.getReceiverId());
                faIdList.add(message.getReceiverId());
            } else {
                readAndUnReadMessageVo.setFriendId(message.getSenderId());
                faIdList.add(message.getSenderId());
            }
            messageVoList.add(readAndUnReadMessageVo);
        }
        List<FreightAgency> freightAgencyList = new ArrayList<>();
        if (faIdList.size() != 0) {
            freightAgencyList = freightAgencyMapper.selectByFaIdList(faIdList);
        }
        //若FreightAgency查询结果列表长度与消息列表长度无法匹配，则后台查询出错，返回null值
        if (freightAgencyList.size() != messageVoList.size()) {
            return null;
        }
        //添加消息对话者的照片，昵称
        for (int i = 0; i < messageVoList.size(); i++) {
            FreightAgency freightAgency = freightAgencyList.get(i);
            Friend friend = new Friend(freightAgency.getId(), userId);
            friend = friendMapper.selectFriend(friend);
            if (friend != null) {
                messageVoList.get(i).setFriendMark(friend.getFaMark());
            } else {
                messageVoList.get(i).setFriendMark(freightAgency.getName());
            }
            messageVoList.get(i).setFriendPhoto(freightAgencyList.get(i).getPhoto());
        }
        System.out.println(messageVoList);
        return messageVoList;
    }

    @Override
    public int getUnReadMsgCount(Long receiverId) {
        List<UnReadMessageVo> unReadMessageVoList = messageMapper.selectUnReadMessage(receiverId);
        int unReadCount = 0;
        for (UnReadMessageVo unReadMessageVo : unReadMessageVoList) {
            unReadCount += unReadMessageVo.getUnReadMessageCount();
        }
        return unReadCount;
    }

    @Override
    public List<Message> selectMessageContent(Message message) {
        return messageMapper.selectAll(message);
    }

    @Override
    public int readAllMessages(Message message) {
        return messageMapper.updateMessages(message);
    }
}
