package pers.kingvi.foreigntrade.admin.service;

import pers.kingvi.foreigntrade.po.ForeignTradeSaleman;
import pers.kingvi.foreigntrade.po.FreightAgency;
import pers.kingvi.foreigntrade.vo.FriendVo;

public interface FriendService {
    FriendVo selectByPrimaryKey(Integer id);

    ForeignTradeSaleman showFtsDetailByFriendId(Integer id, Integer ftsId);

    FreightAgency showFaDetailByFriendId(Integer id, Integer faId);   //判断类型，如果是外贸员，使用该方法，显示货代的信息

    ForeignTradeSaleman showDetailByFriendId(Integer id, Integer ftsId);   //判断类型，如果是货代，使用该方法，显示外贸员的信息

    int updateFriendMark(Integer userId, Integer friendId, String mark);

    int updateFtsMark(Integer faId, Integer ftsId, String mark);   //从货代的角度出发，修改好友外贸员的备注，如果判断自身是货代类型，使用该接口

    int updateFaMark(Integer ftsId, Integer faId, String mark);

    int deleteFaFriend(Integer ftsId, Integer faId); //判断自身类型，如果是外贸员，那么执行该方法，删除货代。

    int deleteFtsFriend(Integer faId, Integer ftsId);  //判断自身类型，如果是货代，执行该方法，删除外贸员

}
