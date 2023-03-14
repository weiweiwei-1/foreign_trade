package pers.kingvi.foreigntrade.freightagency.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.kingvi.foreigntrade.freightagency.dao.FaFriendMapper;
import pers.kingvi.foreigntrade.freightagency.service.FaFriendService;
import pers.kingvi.foreigntrade.po.Friend;

@Service
public class FaFriendServiceImpl implements FaFriendService {

    @Autowired
    private FaFriendMapper faFriendMapper;

    @Override
    public Friend selectFriend(Friend friend) {
        return faFriendMapper.selectFriend(friend);
    }
}
