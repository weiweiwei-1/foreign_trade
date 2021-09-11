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
        return friendApplyMapper.insert(friendApply);
    }

    //发送好友申请
    @Override
    public int insertSelective(FriendApply friendApply) {
        User user = userMapper.selectByPrimaryKey(friendApply.getReceiverId());
        Friend friend =  new Friend();
        friend.setUserId(friendApply.getReceiverId());
        friend.setFriendId(friendApply.getSenderId());
        friend = friendMapper.selectFriend(friend);
        FriendApply friendApply1 = friendApplyMapper.selectFriendApply(friendApply);
        if (user != null && friend == null && friendApply1 == null) {
            if ("fts".equals(user.getUserType())) {
                ForeignTradeSaleman foreignTradeSaleman = foreignTradeSalemanMapper.selectByPrimaryKey(user.getUserId());
                if (foreignTradeSaleman != null) {
                    friendApplyMapper.insert(friendApply);
                    return friendApply.getId();
                }
            } else if ("fa".equals(user.getUserType())){
                FreightAgency freightAgency = freightAgencyMapper.selectByPrimaryKey(user.getUserId());
                if (freightAgency != null) {
                    friendApplyMapper.insert(friendApply);
                }
            }

        }
        return 0;
    }

    //同意好友申请
    @Override
    public int permitApply(FriendApply friendApply) {
        Friend friend = new Friend();
        User sender = userMapper.selectByPrimaryKey(friendApply.getSenderId());
        friendApply = friendApplyMapper.selectFriendApply(friendApply);
        if (friendApply != null && sender != null) {
            User receiver = userMapper.selectByPrimaryKey(friendApply.getReceiverId());
            if ("fts".equals(receiver.getUserType())) {
                ForeignTradeSaleman foreignTradeSaleman = foreignTradeSalemanMapper.selectByPrimaryKey(receiver.getUserId());
                friend.setUserId(receiver.getUserId());
                friend.setUserMark(foreignTradeSaleman.getName());
                friend.setFriendId(friendApply.getSenderId());
                friend.setFriendMark(friendApply.getSenderName());
                friendMapper.insertSelective(friend);
                return friendApplyMapper.deleteFriend(friendApply);
            } else if ("fa".equals(receiver.getUserType())) {
                FreightAgency freightAgency = freightAgencyMapper.selectByPrimaryKey(receiver.getUserId());
                friend.setUserId(friendApply.getSenderId());
                friend.setUserMark(friendApply.getSenderName());
                friend.setFriendId(receiver.getUserId());
                friend.setFriendMark(freightAgency.getName());
                friendMapper.insertSelective(friend);
                return friendApplyMapper.deleteFriend(friendApply);
            }
        }
        return 0;
    }

    //查看好友申请信息
    @Override
    public FriendApplyVo selectBySenderId(FriendApply friendApply) {
        User sender = userMapper.selectByPrimaryKey(friendApply.getSenderId());
        FriendApplyVo friendApplyVo =  new FriendApplyVo();
        friendApply = friendApplyMapper.selectFriendApply(friendApply);
        if (friendApply != null && sender != null) {
            if ("fts".equals(sender.getUserType())) {
                ForeignTradeSaleman foreignTradeSaleman = foreignTradeSalemanMapper.selectByPrimaryKey(sender.getUserId());
                friendApplyVo.setSenderId(sender.getUserId());
                friendApplyVo.setSenderName(friendApply.getSenderName());
                friendApplyVo.setSendTime(friendApplyVo.getSendTime());
                friendApplyVo.setPhoto(foreignTradeSaleman.getPhoto());
                friendApplyVo.setCity(foreignTradeSaleman.getCity());
                friendApplyVo.setCompany(foreignTradeSaleman.getCompany());
                friendApplyVo.setCompanyLink(foreignTradeSaleman.getStoreLink());
                friendApplyVo.setMainBusiness(foreignTradeSaleman.getIndustry());
            } else if ("fa".equals(sender.getUserType())) {
                FreightAgency freightAgency = freightAgencyMapper.selectByPrimaryKey(sender.getUserId());
                friendApplyVo.setSenderId(sender.getUserId());
                friendApplyVo.setSenderName(friendApply.getSenderName());
                friendApplyVo.setSendTime(friendApplyVo.getSendTime());
                friendApplyVo.setPhoto(freightAgency.getPhoto());
                friendApplyVo.setCity(freightAgency.getCity());
                friendApplyVo.setCompany(freightAgency.getCompany());
                friendApplyVo.setCompanyLink(freightAgency.getCompanyLink());
                friendApplyVo.setMainBusiness(freightAgency.getMainBussinessScope());
            }
            friendApplyVo.setSenderId(friendApply.getSenderId());
//            friendApplyVo.set
        }
        return null;
    }

    @Override
    public FriendApply selectFriendApply(FriendApply friendApply) {
        return friendApplyMapper.selectFriendApply(friendApply);
    }


    //查询好友申请列表
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
            if ("fa".equals(user.getUserType())) {
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



    //拒绝好友申请
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
