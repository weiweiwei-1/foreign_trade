package pers.kingvi.foreigntrade.freightagency.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.kingvi.foreigntrade.admin.dao.FriendApplyMapper;
import pers.kingvi.foreigntrade.admin.dao.FriendMapper;
import pers.kingvi.foreigntrade.admin.dao.UserMapper;
import pers.kingvi.foreigntrade.foreigntradesaleman.dao.ForeignTradeSalemanMapper;
import pers.kingvi.foreigntrade.freightagency.service.FaFriendApplyService;
import pers.kingvi.foreigntrade.po.*;
import pers.kingvi.foreigntrade.vo.FriendApplyVo;

import java.util.ArrayList;
import java.util.List;

@Service
public class FaFriendApplyServiceImpl implements FaFriendApplyService {

    @Autowired
    private FriendApplyMapper friendApplyMapper;

    @Autowired
    private ForeignTradeSalemanMapper foreignTradeSalemanMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private FriendMapper friendMapper;

    @Override
    public List<FriendApplyVo> selectByFaId(Long receiverId) {
        List<FriendApply> friendApplyList = friendApplyMapper.selectByReceiverId(receiverId);
        List<FriendApplyVo> friendApplyVoList = new ArrayList<>();
        List<Long> ftsIdList = new ArrayList<>();
        FriendApplyVo friendApplyVo = new FriendApplyVo();
        if (friendApplyList.size() > 0) {
            for (FriendApply friendApply : friendApplyList) {
                friendApplyVo.setSendTime(friendApply.getSendTime());
                friendApplyVo.setSenderId(friendApply.getSenderId());
                friendApplyVo.setSenderName(friendApplyVo.getSenderName());
                ftsIdList.add(friendApply.getSenderId());
                friendApplyVoList.add(friendApplyVo);
            }
            List<ForeignTradeSaleman> foreignTradeSalemanList = foreignTradeSalemanMapper.selectByFtsIdList(ftsIdList);
            for (int i = 0; i < friendApplyList.size(); i++) {
                friendApplyVoList.get(i).setPhoto(foreignTradeSalemanList.get(i).getPhoto());
            }
            return  friendApplyVoList;
        }
        return null;
    }

    @Override
    public int insertSelective(FriendApply friendApply) {
//        查询被申请者是否存在，不存在则返回0
        User user = userMapper.selectByPrimaryKey(friendApply.getReceiverId());
        if (user == null) {
            return 0;
        }
        Friend friendExist = new Friend(friendApply.getReceiverId(), friendApply.getSenderId());
//        查询是否已成为好友关系，存在则返回-1
        friendExist = friendMapper.selectFriend(friendExist);
        System.out.println(friendExist);
        if (friendExist != null) {
            return -1;
        }
//        查询是否其中某一方已提交过好友申请，存在则返回-2
        FriendApply friendApplyExist = friendApplyMapper.selectFriendApply(friendApply);
        if (friendApplyExist != null) {
            return -2;
        }
        if ("fts".equals(user.getUserType())) {
            friendApplyMapper.insertSelective(friendApply);
//            申请成功，返回插入id
            return friendApply.getId();
        }
//        若被申请者身份是货代而不是外贸员，返回-3
        return -3;
    }
}
