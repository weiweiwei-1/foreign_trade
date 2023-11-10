package pers.kingvi.foreigntrade.admin.service.serviceImpl;

import com.mysql.cj.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.kingvi.foreigntrade.admin.dao.FriendApplyMapper;
import pers.kingvi.foreigntrade.admin.dao.FriendMapper;
import pers.kingvi.foreigntrade.admin.dao.UserMapper;
import pers.kingvi.foreigntrade.admin.service.FriendApplyService;
import pers.kingvi.foreigntrade.foreigntradesaleman.dao.ForeignTradeSalemanMapper;
import pers.kingvi.foreigntrade.freightagency.dao.FreightAgencyMapper;
import pers.kingvi.foreigntrade.po.*;
import pers.kingvi.foreigntrade.util.Result;
import pers.kingvi.foreigntrade.util.fts.FtsUtils;
import pers.kingvi.foreigntrade.vo.FriendApplyVo;
import sun.text.normalizer.CharTrie;

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
//        查询被申请的用户id是否存在
        User user = userMapper.selectByPrimaryKey(friendApply.getReceiverId());
        Friend friend =  new Friend();
        friend.setFaId(friendApply.getReceiverId());
        friend.setFtsId(friendApply.getSenderId());
//        查询是否已成为好友关系
        friend = friendMapper.selectFriend(friend);
//        查询是否其中某一方已提交过好友申请
        FriendApply friendApply1 = friendApplyMapper.selectFriendApply(friendApply);
        if (user != null && friend == null && friendApply1 == null) {
//            被申请者是外贸员
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
            if ("fts".equals(receiver.getUserType()) && sender.getUserType().equals("fa")) {
                ForeignTradeSaleman foreignTradeSaleman = foreignTradeSalemanMapper.selectByPrimaryKey(receiver.getUserId());
                friend.setFaId(sender.getUserId());
                friend.setFaMark(friendApply.getSenderName());
                friend.setFtsId(receiver.getUserId());
                friend.setFtsMark(foreignTradeSaleman.getName());
                friendMapper.insertSelective(friend);
                return friendApplyMapper.deleteFriendApply(friendApply);
            } else if ("fa".equals(receiver.getUserType()) && sender.getUserType().equals("fts")) {
                FreightAgency freightAgency = freightAgencyMapper.selectByPrimaryKey(receiver.getUserId());
                friend.setFaId(friendApply.getSenderId());
                friend.setFaMark(friendApply.getSenderName());
                friend.setFtsId(receiver.getUserId());
                friend.setFtsMark(freightAgency.getName());
                friendMapper.insertSelective(friend);
                return friendApplyMapper.deleteFriendApply(friendApply);
            }
        }
        return 0;
    }

    @Override
    public int sendFriendApply(FriendApply friendApply) {
        FriendApply friendApplyRes = friendApplyMapper.selectFriendApplySingle(friendApply);
        if (friendApplyRes != null) {
//            已经发送好友申请
            return -1;
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
            FreightAgency freightAgency = freightAgencyMapper.selectByPrimaryKey(friendApplyRes.getSenderId());
            friend = new Friend();
            friend.setFtsId(ftsId);
            friend.setFaId(faId);
            friend.setFtsMark(FtsUtils.getUserVo().getName());
            friend.setFaMark(freightAgency.getName());
            friendMapper.insertSelective(friend);
            friendApplyMapper.deleteFriendApply(friendApply);
            return 1;
        }
//        若第一次添加，则直接选择插入
        return friendApplyMapper.insertSelective(friendApply);
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

    @Override
    public FriendApply selectFriendApplySingle(FriendApply friendApply) {
        return friendApplyMapper.selectFriendApplySingle(friendApply);
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
                friendApplyVo.setSenderName(friendApply.getSenderName());
                idList.add(friendApply.getSenderId());
                friendApplyVoList.add(friendApplyVo);
            }
            User user = userMapper.selectByPrimaryKey(receiverId);
            if ("fa".equals(user.getUserType())) {
                List<ForeignTradeSaleman> foreignTradeSalemanList = foreignTradeSalemanMapper.selectByFtsIdList(idList);
                for (int i = 0; i < friendApplyList.size(); i++) {
                    friendApplyVoList.get(i).setPhoto(foreignTradeSalemanList.get(i).getPhoto());
                    friendApplyVoList.get(i).setName(foreignTradeSalemanList.get(i).getName());
                }
            } else {
                List<FreightAgency> freightAgencyList = freightAgencyMapper.selectByFaIdList(idList);
                for (int j = 0; j < friendApplyList.size(); j++) {
                    friendApplyVoList.get(j).setPhoto(freightAgencyList.get(j).getPhoto());
                    friendApplyVoList.get(j).setName(freightAgencyList.get(j).getName());
                }
            }
            return friendApplyVoList;
        }
        return friendApplyVoList;
    }



    //拒绝好友申请
    @Override
    public int deleteFriendApply(FriendApply friendApply) {
        friendApply = friendApplyMapper.selectFriendApply(friendApply);
        if (friendApply != null) {
            return friendApplyMapper.deleteFriendApply(friendApply);
        } else {
            return 0;
        }

    }
}
