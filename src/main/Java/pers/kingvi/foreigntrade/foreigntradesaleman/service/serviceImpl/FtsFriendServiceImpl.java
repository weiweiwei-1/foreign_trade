package pers.kingvi.foreigntrade.foreigntradesaleman.service.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import pers.kingvi.foreigntrade.admin.dao.FriendApplyMapper;
import pers.kingvi.foreigntrade.admin.dao.FriendMapper;
import pers.kingvi.foreigntrade.admin.dao.MessageMapper;
import pers.kingvi.foreigntrade.admin.service.FriendService;
import pers.kingvi.foreigntrade.config.WebSocketUtils;
import pers.kingvi.foreigntrade.foreigntradesaleman.dao.FtsFriendMapper;
import pers.kingvi.foreigntrade.foreigntradesaleman.service.ForeignTradeSalemanService;
import pers.kingvi.foreigntrade.foreigntradesaleman.service.FtsFriendService;
import pers.kingvi.foreigntrade.freightagency.dao.FreightAgencyMapper;
import pers.kingvi.foreigntrade.freightagency.service.FreightAgencyService;
import pers.kingvi.foreigntrade.po.*;
import pers.kingvi.foreigntrade.util.Result;
import pers.kingvi.foreigntrade.util.fa.FaUtils;
import pers.kingvi.foreigntrade.util.fts.FtsUtils;
import pers.kingvi.foreigntrade.vo.ReadAndUnReadMessageVoImpl;
import pers.kingvi.foreigntrade.vo.fts.FtsFriendInfoDetailVo;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class FtsFriendServiceImpl implements FtsFriendService {

    @Autowired
    private FriendMapper friendMapper;

    @Autowired
    private FtsFriendMapper ftsFriendMapper;

    @Autowired
    private FriendApplyMapper friendApplyMapper;

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public Friend selectFriend(Friend friend) {
        return ftsFriendMapper.selectFriend(friend);
    }

    @Override
    public List<Friend> selectFriendList(Long ftsId) {
        return ftsFriendMapper.selectFriendList(ftsId);
    }

    @Override
    public List<FreightAgency> selectByCondition(String condition) {
        return ftsFriendMapper.selectByCondition(condition);
    }

    @Override
    public int permitFriend(Long faId, Long ftsId, String faMark) throws IOException {
        Friend friend = new Friend(faId, ftsId);
        friend = friendMapper.selectFriend(friend);
        if (friend != null) {
//            0为已经是好友关系
            friendApplyMapper.deleteFriendApply(new FriendApply(faId, ftsId));
            return -1;
        }
        FriendApply friendApply = new FriendApply(faId, ftsId);
        friendApply = friendApplyMapper.selectFriendApplySingle(friendApply);
        if (friendApply == null) {
//            没有该项申请，返回0
            return 0;
        } else {
//            通过好友申请，删除申请记录，将好友关系插入数据库中
            friendApplyMapper.deleteFriendApply(friendApply);
//            ForeignTradeSaleman foreignTradeSaleman = .selectByPrimaryKey(faId);
            friend = new Friend();
            friend.setFaId(faId);
            friend.setFtsId(ftsId);
            friend.setFaMark(faMark);
            friend.setFtsMark(FtsUtils.getUserVo().getName());
            System.setProperty("user.timezone", "Asia/Kolkata");
            // 获得系统时间
            Date date = new Date();
            // 将时间格式转换成符合Timestamp要求的格式
            String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
            Message message = new Message(ftsId, faId, "我们已经是好友了，开始聊天吧~");
            messageMapper.insertSelective(message);
            if (WebSocketUtils.hasConnection(faId)) {
                ReadAndUnReadMessageVoImpl readAndUnReadMessageVo = new ReadAndUnReadMessageVoImpl();
                readAndUnReadMessageVo.setMessageType ("addFriend");
                readAndUnReadMessageVo.setFriendId(ftsId);
                readAndUnReadMessageVo.setFriendMark(FtsUtils.getUserVo().getName());
                readAndUnReadMessageVo.setFriendPhoto(FtsUtils.getUserVo().getPhoto());
                readAndUnReadMessageVo.setUnReadMessageCount(1);
                readAndUnReadMessageVo.setContent(message.getContent());
                readAndUnReadMessageVo.setSendTime(nowTime);
                WebSocketUtils.get(faId).sendMessage(new TextMessage(JSONObject.toJSONString(readAndUnReadMessageVo)));
            }
            return friendMapper.insertSelective(friend);
        }
    }

    @Override
    public int updateFaMark(Friend friend) {
        return friendMapper.updateUserMark(friend);
    }

    @Override
    public int deleteFriend(Friend friend) {
        return friendMapper.deleteFriend(friend);
    }
}
