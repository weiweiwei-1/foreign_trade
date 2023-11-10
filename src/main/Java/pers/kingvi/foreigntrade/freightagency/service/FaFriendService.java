package pers.kingvi.foreigntrade.freightagency.service;

import pers.kingvi.foreigntrade.po.ForeignTradeSaleman;
import pers.kingvi.foreigntrade.po.Friend;

import java.io.IOException;
import java.util.List;

public interface FaFriendService {
    Friend selectFriend(Friend friend);

    List<Friend> selectFriendList(Long faId);

    List<ForeignTradeSaleman> selectByCondition(String condition);

    int permitFriend(Long faId, Long ftsId, String ftsMark) throws IOException;

    int updateFtsMark(Friend friend);

    int deleteFriend(Friend friend);


}
