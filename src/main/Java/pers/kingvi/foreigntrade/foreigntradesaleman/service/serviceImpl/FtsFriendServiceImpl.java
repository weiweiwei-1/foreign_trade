package pers.kingvi.foreigntrade.foreigntradesaleman.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.kingvi.foreigntrade.admin.dao.FriendMapper;
import pers.kingvi.foreigntrade.admin.service.FriendService;
import pers.kingvi.foreigntrade.foreigntradesaleman.dao.FtsFriendMapper;
import pers.kingvi.foreigntrade.foreigntradesaleman.service.FtsFriendService;
import pers.kingvi.foreigntrade.po.Friend;

@Service
public class FtsFriendServiceImpl implements FtsFriendService {

    @Autowired
    private FriendMapper friendMapper;

    @Autowired
    private FtsFriendMapper ftsFriendMapper;

    @Override
    public Friend selectFriend(Friend friend) {
        return ftsFriendMapper.selectFriend(friend);
    }
}
