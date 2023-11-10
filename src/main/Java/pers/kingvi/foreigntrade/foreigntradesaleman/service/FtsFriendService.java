package pers.kingvi.foreigntrade.foreigntradesaleman.service;

import pers.kingvi.foreigntrade.po.FreightAgency;
import pers.kingvi.foreigntrade.po.Friend;

import java.io.IOException;
import java.util.List;

//****约定userId是货代，friendId是外贸员

public interface FtsFriendService {

    Friend selectFriend(Friend friend);

    List<Friend> selectFriendList(Long ftsId);

    List<FreightAgency> selectByCondition(String condition);

    int permitFriend(Long faId, Long ftsId, String faMark) throws IOException;

    int updateFaMark(Friend friend);

    int deleteFriend(Friend friend);

}
