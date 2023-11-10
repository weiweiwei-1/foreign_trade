package pers.kingvi.foreigntrade.freightagency.dao;

import pers.kingvi.foreigntrade.po.ForeignTradeSaleman;
import pers.kingvi.foreigntrade.po.Friend;

import java.util.List;

public interface FaFriendMapper {
    Friend selectFriend(Friend friend);

    List<Friend> selectFriendList(Long faId);

    List<ForeignTradeSaleman> selectByCondition(String condition);
}
