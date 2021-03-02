package pers.kingvi.foreigntrade.admin.service.serviceImpl;

import org.springframework.stereotype.Service;
import pers.kingvi.foreigntrade.admin.service.FriendService;
import pers.kingvi.foreigntrade.po.ForeignTradeSaleman;
import pers.kingvi.foreigntrade.po.FreightAgency;
import pers.kingvi.foreigntrade.vo.FriendVo;


@Service
public class FriendServiceImpl implements FriendService {
    @Override
    public FriendVo selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public ForeignTradeSaleman showFtsDetailByFriendId(Integer id, Integer ftsId) {
        return null;
    }

    @Override
    public FreightAgency showFaDetailByFriendId(Integer id, Integer faId) {
        return null;
    }

    @Override
    public ForeignTradeSaleman showDetailByFriendId(Integer id, Integer ftsId) {
        return null;
    }

    @Override
    public int updateFriendMark(Integer userId, Integer friendId, String mark) {
        return 0;
    }

    @Override
    public int updateFtsMark(Integer faId, Integer ftsId, String mark) {
        return 0;
    }

    @Override
    public int updateFaMark(Integer ftsId, Integer faId, String mark) {
        return 0;
    }

    @Override
    public int deleteFaFriend(Integer ftsId, Integer faId) {
        return 0;
    }

    @Override
    public int deleteFtsFriend(Integer faId, Integer ftsId) {
        return 0;
    }
}
