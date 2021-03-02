package pers.kingvi.foreigntrade.admin.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.kingvi.foreigntrade.admin.dao.FriendApplyMapper;
import pers.kingvi.foreigntrade.admin.dao.FriendMapper;
import pers.kingvi.foreigntrade.admin.dao.UserMapper;
import pers.kingvi.foreigntrade.admin.service.FriendApplyService;
import pers.kingvi.foreigntrade.foreigntradesaleman.dao.ForeignTradeSalemanMapper;
import pers.kingvi.foreigntrade.freightagency.dao.FreightAgencyMapper;
import pers.kingvi.foreigntrade.po.*;
import pers.kingvi.foreigntrade.vo.FriendApplyVo;

import java.util.ArrayList;
import java.util.List;

@Service
public class FriendApplyServiceImpl implements FriendApplyService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private FriendMapper friendMapper;

    @Autowired
    private FriendApplyMapper friendApplyMapper;

    @Autowired
    private ForeignTradeSalemanMapper foreignTradeSalemanMapper;

    @Autowired
    private FreightAgencyMapper freightAgencyMapper;

    @Override
    public int insert(FriendApply friendApply) {
        return 0;
    }

    @Override
    public int insertSelective(FriendApply friendApply) {
        User user = userMapper.selectByPrimaryKey(friendApply.getReceiverId());
        Friend friend =  new Friend();
        friend.setUserId(friendApply.getReceiverId());
        friend.setFriendId(friendApply.getSenderId());
        friend = friendMapper.selectFriend(friend);
        FriendApply friendApply1 = friendApplyMapper.selectFriendApply(friendApply);
        if (user != null && friend == null && friendApply1 == null) {
            friendApplyMapper.insert(friendApply);
            return friendApply.getId();
        }
        return 0;
    }

    @Override
    public FriendApply selectFriendApply(FriendApply friendApply) {
        return friendApplyMapper.selectFriendApply(friendApply);
    }

    @Override
    public List<FriendApplyVo> selectByReceiverId(Long receiverId) {
        List<FriendApply> friendApplyList = friendApplyMapper.selectByReceiverId(receiverId);
        List<FriendApplyVo> friendApplyVoList = new ArrayList<>();
        List<Long> idList = new ArrayList<>();
        if (friendApplyList.size() > 0) {
            for (FriendApply friendApply : friendApplyList) {
                FriendApplyVo friendApplyVo = new FriendApplyVo();
                friendApplyVo.setSendTime(friendApply.getSendTime());
                friendApplyVo.setSenderId(friendApply.getSenderId());
                friendApplyVo.setSenderName(friendApplyVo.getSenderName());
                idList.add(friendApply.getSenderId());
                friendApplyVoList.add(friendApplyVo);
            }
            User user = userMapper.selectByPrimaryKey(receiverId);
            if ("货代".equals(user.getUserType())) {
                List<ForeignTradeSaleman> foreignTradeSalemanList = foreignTradeSalemanMapper.selectByFtsIdList(idList);
                for (int i = 0; i < friendApplyList.size(); i++) {
                    friendApplyVoList.get(i).setPhoto(foreignTradeSalemanList.get(i).getPhoto());
                }
            } else {
                List<FreightAgency> freightAgencyList = freightAgencyMapper.selectByFaIdList(idList);
                for (int j = 0; j < friendApplyList.size(); j++) {
                    friendApplyVoList.get(j).setPhoto(freightAgencyList.get(j).getPhoto());
                }
            }
            return friendApplyVoList;
        }
        return null;
    }

    @Override
    public int deleteFriendApply(FriendApply friendApply) {
        friendApply = friendApplyMapper.selectFriendApply(friendApply);
        if (friendApply != null) {
            return friendApplyMapper.deleteFriend(friendApply);
        } else {
            return 0;
        }

    }
}
