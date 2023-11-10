package pers.kingvi.foreigntrade.foreigntradesaleman.service;

import pers.kingvi.foreigntrade.po.FriendApply;
import pers.kingvi.foreigntrade.vo.FriendApplyVo;

import java.io.IOException;
import java.util.List;


public interface FtsFriendApplyService {

    List<FriendApplyVo> selectByFtsId(Long receiverId);

    int insertSelective(FriendApply friendApply) throws IOException;

}
