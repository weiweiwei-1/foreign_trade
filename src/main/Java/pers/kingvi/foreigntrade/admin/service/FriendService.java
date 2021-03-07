package pers.kingvi.foreigntrade.admin.service;

import pers.kingvi.foreigntrade.po.ForeignTradeSaleman;
import pers.kingvi.foreigntrade.po.FreightAgency;
import pers.kingvi.foreigntrade.po.Friend;
import pers.kingvi.foreigntrade.vo.FriendVo;
import pers.kingvi.foreigntrade.vo.UserDetailVo;

import java.util.List;

public interface FriendService {
    Friend selectByPrimaryKey(Integer id);

    List<FriendVo> selectById(Long id);       //好友列表显示

    ForeignTradeSaleman showFtsDetailByFriendId(Long ftsId);      //判断类型，如果是货代，使用该方法，显示外贸员的信息

    FreightAgency showFaDetailByFriendId(Long faId);      //判断类型，如果是外贸员，使用该方法，显示货代的信息

    UserDetailVo showUserDetailByFriendId(Long fId);

    int updateFriendMark(Friend friend);

    int updateFtsMark(Friend friend);       //从货代的角度出发，修改好友外贸员的备注，如果判断自身是货代类型，使用该接口

    int updateFaMark(Friend friend);

    int deleteFaFriend(Friend friend);       //判断自身类型，如果是外贸员，那么执行该方法，删除货代。

    int deleteFtsFriend(Friend friend);       //判断自身类型，如果是货代，执行该方法，删除外贸员

}
