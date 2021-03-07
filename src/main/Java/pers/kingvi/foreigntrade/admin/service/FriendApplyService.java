package pers.kingvi.foreigntrade.admin.service;

import pers.kingvi.foreigntrade.po.FriendApply;
import pers.kingvi.foreigntrade.vo.FriendApplyVo;

import java.util.List;

public interface FriendApplyService {

    int insert(FriendApply friendApply);

    int insertSelective(FriendApply friendApply);

    int permitApply(FriendApply friendApply);

    FriendApplyVo selectBySenderId(FriendApply friendApply);

    FriendApply selectFriendApply(FriendApply friendApply);

    List<FriendApplyVo> selectByReceiverId(Long receiverId);

    int deleteFriendApply(FriendApply friendApply);

}
