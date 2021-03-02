package pers.kingvi.foreigntrade.freightagency.service;

import pers.kingvi.foreigntrade.po.FriendApply;
import pers.kingvi.foreigntrade.vo.FriendApplyVo;

import java.util.List;

public interface FaFriendApplyService {

    List<FriendApplyVo> selectByFaId(Long receiverId);
}
