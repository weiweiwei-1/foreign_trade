package pers.kingvi.foreigntrade.freightagency.service.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import pers.kingvi.foreigntrade.admin.dao.FriendApplyMapper;
import pers.kingvi.foreigntrade.admin.dao.FriendMapper;
import pers.kingvi.foreigntrade.admin.dao.MessageMapper;
import pers.kingvi.foreigntrade.config.WebSocketUtils;
import pers.kingvi.foreigntrade.foreigntradesaleman.service.ForeignTradeSalemanService;
import pers.kingvi.foreigntrade.freightagency.dao.FaFriendMapper;
import pers.kingvi.foreigntrade.freightagency.service.FaFriendService;
import pers.kingvi.foreigntrade.po.*;
import pers.kingvi.foreigntrade.util.fa.FaUtils;
import pers.kingvi.foreigntrade.vo.ReadAndUnReadMessageVoImpl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class FaFriendServiceImpl implements FaFriendService {

    @Autowired
    private FaFriendMapper faFriendMapper;

    @Autowired
    private FriendApplyMapper friendApplyMapper;

    @Autowired
    private FriendMapper friendMapper;

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private ForeignTradeSalemanService foreignTradeSalemanService;

    @Override
    public Friend selectFriend(Friend friend) {
        return faFriendMapper.selectFriend(friend);
    }

    @Override
    public List<Friend> selectFriendList(Long faId) {
        return faFriendMapper.selectFriendList(faId);
    }

    @Override
    public List<ForeignTradeSaleman> selectByCondition(String condition) {
        return faFriendMapper.selectByCondition(condition);
    }

    @Override
    public int permitFriend(Long faId, Long ftsId, String ftsMark) throws IOException {
        Friend friend = new Friend(faId, ftsId);
        friend = friendMapper.selectFriend(friend);
        if (friend != null) {
//            0为已经是好友关系
            friendApplyMapper.deleteFriendApply(new FriendApply(faId, ftsId));
            return -1;
        }
        FriendApply friendApply = new FriendApply(ftsId, faId);
        friendApply = friendApplyMapper.selectFriendApplySingle(friendApply);
        if (friendApply == null) {
//            没有该项申请，返回0
            return 0;
        } else {
//            通过好友申请，删除申请记录，将好友关系插入数据库中
            friendApplyMapper.deleteFriendApply(friendApply);
            friend = new Friend();
            friend.setFaId(faId);
            friend.setFtsId(ftsId);
            friend.setFaMark(FaUtils.getUserVo().getName());
            friend.setFtsMark(ftsMark);
            // 获得系统时间
            Date date = new Date();
            // 将时间格式转换成符合Timestamp要求的格式
            String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
            Message message = new Message(faId, ftsId, "我们已经是好友了，开始聊天吧~");
            messageMapper.insertSelective(message);
            if (WebSocketUtils.hasConnection(ftsId)) {
                ReadAndUnReadMessageVoImpl readAndUnReadMessageVo = new ReadAndUnReadMessageVoImpl();
                readAndUnReadMessageVo.setMessageType ("addFriend");
                readAndUnReadMessageVo.setFriendId(faId);
                readAndUnReadMessageVo.setFriendMark(FaUtils.getUserVo().getName());
                readAndUnReadMessageVo.setFriendPhoto(FaUtils.getUserVo().getPhoto());
                readAndUnReadMessageVo.setUnReadMessageCount(1);
                readAndUnReadMessageVo.setContent(message.getContent());
                readAndUnReadMessageVo.setSendTime(nowTime);
                WebSocketUtils.get(ftsId).sendMessage(new TextMessage(JSONObject.toJSONString(readAndUnReadMessageVo)));
            }
            return friendMapper.insertSelective(friend);
        }
    }

    @Override
    public int updateFtsMark(Friend friend) {
        return friendMapper.updateFriendMark(friend);
    }

    @Override
    public int deleteFriend(Friend friend) {
        return friendMapper.deleteFriend(friend);
    }
}
