package pers.kingvi.foreigntrade.foreigntradesaleman.service;

import pers.kingvi.foreigntrade.po.Friend;

//****约定userId是货代，friendId是外贸员

public interface FtsFriendService {
    Friend selectFriend(Friend friend);
}
