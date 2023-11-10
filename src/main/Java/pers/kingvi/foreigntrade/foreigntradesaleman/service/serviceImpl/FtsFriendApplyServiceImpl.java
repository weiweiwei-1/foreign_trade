package pers.kingvi.foreigntrade.foreigntradesaleman.service.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import pers.kingvi.foreigntrade.admin.dao.FriendApplyMapper;
import pers.kingvi.foreigntrade.admin.dao.FriendMapper;
import pers.kingvi.foreigntrade.admin.dao.MessageMapper;
import pers.kingvi.foreigntrade.admin.dao.UserMapper;
import pers.kingvi.foreigntrade.config.WebSocketUtils;
import pers.kingvi.foreigntrade.foreigntradesaleman.service.FtsFriendApplyService;
import pers.kingvi.foreigntrade.freightagency.dao.FreightAgencyMapper;
import pers.kingvi.foreigntrade.po.*;
import pers.kingvi.foreigntrade.util.fts.FtsUtils;
import pers.kingvi.foreigntrade.vo.FriendApplyVo;
import pers.kingvi.foreigntrade.vo.ReadAndUnReadMessageVo;
import pers.kingvi.foreigntrade.vo.ReadAndUnReadMessageVoImpl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FtsFriendApplyServiceImpl implements FtsFriendApplyService {

    @Autowired
    private FriendApplyMapper friendApplyMapper;

    @Autowired
    private FreightAgencyMapper freightAgencyMapper;

    @Autowired
    private FriendMapper friendMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public List<FriendApplyVo> selectByFtsId(Long receiverId) {
        List<FriendApply> friendApplyList = friendApplyMapper.selectByReceiverId(receiverId);
        List<FriendApplyVo> friendApplyVoList = new ArrayList<>();
        List<Long> faIdList = new ArrayList<>();
        FriendApplyVo friendApplyVo = new FriendApplyVo();
        if (friendApplyList.size() > 0) {
            for (FriendApply friendApply : friendApplyList) {
                friendApplyVo.setSendTime(friendApply.getSendTime());
                friendApplyVo.setSenderId(friendApply.getSenderId());
                friendApplyVo.setSenderName(friendApplyVo.getSenderName());
                faIdList.add(friendApply.getSenderId());
                friendApplyVoList.add(friendApplyVo);
            }
            List<FreightAgency> freightAgencyList = freightAgencyMapper.selectByFaIdList(faIdList);
            for (int i = 0; i < friendApplyList.size(); i++) {
                friendApplyVoList.get(i).setPhoto(freightAgencyList.get(i).getPhoto());
            }
            return  friendApplyVoList;
        }
        return null;
    }

    @Override
    public int insertSelective(FriendApply friendApply) throws IOException {
//        User user = userMapper.selectByPrimaryKey(friendApply.getReceiverId());
        FreightAgency user = freightAgencyMapper.selectByPrimaryKey(friendApply.getReceiverId());
        if (user == null) {
//        查询的被申请者账号不存在
            return -3;
        }
        FriendApply friendApplyRes = friendApplyMapper.selectFriendApplySingle(friendApply);
        if (friendApplyRes != null) {
//            已经发送好友申请
            return -2;
        }
        Friend friend = new Friend(friendApply.getReceiverId(), friendApply.getSenderId());
        friend = friendMapper.selectFriend(friend);
        if (friend != null) {
//            已经是好友关系
            return 0;
        }
        friendApplyRes = new FriendApply(friendApply.getReceiverId(), friendApply.getSenderId());
        friendApplyRes = friendApplyMapper.selectFriendApplySingle(friendApplyRes);
//        fa已发送过好友申请，则删除对应的好友申请记录，然后将好友关系插入列表中
        if (friendApplyRes != null) {
            Long ftsId = friendApplyRes.getReceiverId();
            Long faId = friendApplyRes.getSenderId();
            FreightAgency freightAgency = freightAgencyMapper.selectByPrimaryKey(faId);
            friend = new Friend();
            friend.setFtsId(ftsId);
            friend.setFaId(faId);
            friend.setFtsMark(FtsUtils.getUserVo().getName());
            friend.setFaMark(freightAgency.getName());
            System.setProperty("user.timezone", "Asia/Kolkata");
            // 获得系统时间
            Date date = new Date();
            // 将时间格式转换成符合Timestamp要求的格式
            String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
            Message message = new Message(ftsId, faId, "我们已经是好友了，开始聊天吧~");
            friendMapper.insertSelective(friend);
            friendApplyMapper.deleteFriendApply(friendApplyRes);
            messageMapper.insertSelective(message);
//            fts同意好友申请，则结果发给fa，身份信息应该是fts
            if (WebSocketUtils.hasConnection(faId)) {
                ReadAndUnReadMessageVoImpl readAndUnReadMessageVo = new ReadAndUnReadMessageVoImpl();
                readAndUnReadMessageVo.setMessageType ("addFriend");
                readAndUnReadMessageVo.setFriendId(ftsId);

                readAndUnReadMessageVo.setFriendPhoto(FtsUtils.getUserVo().getPhoto());
                readAndUnReadMessageVo.setUnReadMessageCount(1);
                readAndUnReadMessageVo.setContent(message.getContent());
                readAndUnReadMessageVo.setSendTime(nowTime);
                WebSocketUtils.get(faId).sendMessage(new TextMessage(JSONObject.toJSONString(readAndUnReadMessageVo)));
            }
            return 1;
        }
//        若第一次添加，则直接选择插入
        friendApplyMapper.insertSelective(friendApply);
        return 2;
    }
}
