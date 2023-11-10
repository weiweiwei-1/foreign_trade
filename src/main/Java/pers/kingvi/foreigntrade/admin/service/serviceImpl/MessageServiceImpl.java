package pers.kingvi.foreigntrade.admin.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.kingvi.foreigntrade.admin.dao.FriendMapper;
import pers.kingvi.foreigntrade.admin.dao.MessageMapper;
import pers.kingvi.foreigntrade.admin.dao.ProductQuoteMapper;
import pers.kingvi.foreigntrade.admin.dao.UserMapper;
import pers.kingvi.foreigntrade.admin.service.MessageService;
import pers.kingvi.foreigntrade.po.Friend;
import pers.kingvi.foreigntrade.po.Message;
import pers.kingvi.foreigntrade.po.User;
import pers.kingvi.foreigntrade.vo.fa.QuoteRecordProductVo;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private FriendMapper friendMapper;

    @Autowired
    ProductQuoteMapper productQuoteMapper;

    //发消息总方法
    @Override
    public int insertMessage(Message message) {
        Friend friend =  new Friend();
        friend.setFaId(message.getSenderId());
        friend.setFtsId(message.getReceiverId());
        friend = friendMapper.selectFriend(friend);
        if (friend !=null) {
            messageMapper.insert(message);
            return 1;
        } else {
            User user = userMapper.selectByPrimaryKey(message.getSenderId());
            //判断其中一个发送者身份，如果是外贸，那么选择接口
            if (user != null && "fts".equals(user.getUserType())) {
                List<QuoteRecordProductVo> quoteRecordProductVoList = productQuoteMapper.selectByFtsIdAndFaId(message.getSenderId(),message.getReceiverId());
                if (quoteRecordProductVoList != null) {
                    messageMapper.insert(message);
                    return 1;
                } else {
                    return 0;
                }
                //判断另外一个身份，如果是货代，那么选择接口
            } else if (user != null && "fa".equals(user.getUserType())) {
                List<QuoteRecordProductVo> quoteRecordProductVoList = productQuoteMapper.selectByFtsIdAndFaId(message.getReceiverId(), message.getSenderId());
                if (quoteRecordProductVoList != null) {
                    messageMapper.insert(message);
                    return 1;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        }
    }

    //发消息的是货代，那么senderId为faId
    @Override
    public int insertFtsMessage(Message message) {
        Friend friend = new Friend();
        friend.setFtsId(message.getSenderId());
        friend.setFaId(message.getReceiverId());
        friend = friendMapper.selectFriend(friend);
        if (friend != null) {
            messageMapper.insertSelective(message);
            return 1;
        } else {
            List<QuoteRecordProductVo> quoteRecordProductVoList = productQuoteMapper.selectByFtsIdAndFaId(message.getSenderId(), message.getReceiverId());
            if (quoteRecordProductVoList.size() != 0) {
                messageMapper.insertSelective(message);
                return 1;
            } else {
                return 0;
            }
        }
    }

    //发消息的是外贸，那么senderId为ftsId.
    @Override
    public int insertFaMessage(Message message) {
        Friend friend = new Friend();
        friend.setFaId(message.getSenderId());
        friend.setFtsId(message.getReceiverId());
        friend = friendMapper.selectByKey(friend);
        if (friend != null) {
            messageMapper.insertSelective(message);
            return 1;
        } else {
            List<QuoteRecordProductVo> quoteRecordProductVoList = productQuoteMapper.selectByFtsIdAndFaId(message.getReceiverId(), message.getSenderId());
            if (quoteRecordProductVoList.size() != 0) {
                messageMapper.insertSelective(message);
                return 1;
            } else {
                return 0;
            }
        }
    }

    //同上
    @Override
    public int insertMessageById(Long id, Long receiverId, String content, String sendTime) {
        Message message = new Message();
        message.setSenderId(id);
        message.setReceiverId(receiverId);
        message.setContent(content);
        message.setSendTime(sendTime);
        Friend friend = new Friend();
        friend.setFtsId(id);
        friend.setFaId(receiverId);
        friend = friendMapper.selectFriend(friend);
        if (friend != null) {
            messageMapper.insert(message);
            return 1;
        } else {
            User user = userMapper.selectByPrimaryKey(id);
            if (user != null && "fts".equals(user.getUserType())) {
                List<QuoteRecordProductVo> quoteRecordProductVoList = productQuoteMapper.selectByFtsIdAndFaId(id, receiverId);
                if (quoteRecordProductVoList != null) {
                    messageMapper.insert(message);
                    return 1;
                } else {
                    return 0;
                }
            } else if (user != null && "fa".equals(user.getUserType())) {
                List<QuoteRecordProductVo> quoteRecordProductVoList = productQuoteMapper.selectByFtsIdAndFaId(receiverId, id);
                if (quoteRecordProductVoList != null) {
                    messageMapper.insert(message);
                    return 1;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        }
    }

    @Override
    public List<Message> selectAllMessages(Long id, Long friendId) {
            Message message = new Message();
            message.setSenderId(id);
            message.setReceiverId(friendId);
            return messageMapper.selectAll(message);
    }

    @Override
    public List<Message> selectLastThirtyMessage(Long id, Long friendId) {
        Message message = new Message();
        message.setReceiverId(id);
        message.setSenderId(friendId);
        return messageMapper.selectLastAmount(message, 30);
    }

    @Override
    public List<Message> selectLastFiftyMessage(Long id, Long friendId) {
        Message message =  new Message();
        message.setSenderId(id);
        message.setReceiverId(friendId);
        return messageMapper.selectLastAmount(message, 50);
    }

    @Override
    public int deleteMessageByPrimaryKey(Long id, Long friendId) {
//        messageMapper.deleteByPrimaryKey(id);
        return 0;
    }

    @Override
    public int deleteAllMessages(Long id, Long friendId) {
        Message message = new Message();
        message.setSenderId(id);
        message.setReceiverId(friendId);
        return messageMapper.deleteAll(message);
    }
}
