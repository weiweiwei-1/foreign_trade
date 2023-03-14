package pers.kingvi.foreigntrade.admin.service;

import pers.kingvi.foreigntrade.po.ForeignTradeSaleman;
import pers.kingvi.foreigntrade.po.FreightAgency;
import pers.kingvi.foreigntrade.po.Friend;
import pers.kingvi.foreigntrade.vo.FriendVo;
import pers.kingvi.foreigntrade.vo.UserDetailVo;

import java.util.List;

public interface FriendService {
    Friend selectByPrimaryKey(Integer id);        //根据主键查询好友信息

    Friend selectFriend(Friend friend);

    List<FriendVo> selectById(Long id);       //好友列表显示

    ForeignTradeSaleman showFtsDetailByFriendId(Long ftsId);      //判断类型，如果是货代，使用该方法，显示外贸员的信息

    FreightAgency showFaDetailByFriendId(Long faId);      //判断类型，如果是外贸员，使用该方法，显示货代的信息

    UserDetailVo showUserDetailByFriendId(Long fId);        //上面两种方法结合，进行判断，如果

    int updateFriendMark(Long id, Long friendId, String friendMark);       //通过id和朋友id修改好友备注信息

    int updateFtsMark(Friend friend);       //从货代的角度出发，修改好友外贸员的备注，如果判断自身是货代类型，使用该接口

    int updateFaMark(Friend friend);        //从外贸的角度出发，修改修改好友货代的备注，如果判断自身是外贸类型，

    int deleteFriend(Friend friend);       //判断自身类型，如果是外贸员，删除货代,如果是货代，删除外贸员。

}
