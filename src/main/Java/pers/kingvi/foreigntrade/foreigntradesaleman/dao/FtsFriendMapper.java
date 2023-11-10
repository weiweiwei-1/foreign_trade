package pers.kingvi.foreigntrade.foreigntradesaleman.dao;

import pers.kingvi.foreigntrade.po.FreightAgency;
import pers.kingvi.foreigntrade.po.Friend;

import java.util.List;

public interface FtsFriendMapper {
    Friend selectFriend(Friend friend);

    List<Friend> selectFriendList(Long ftsId);

    List<FreightAgency> selectByCondition(String condition);

}
