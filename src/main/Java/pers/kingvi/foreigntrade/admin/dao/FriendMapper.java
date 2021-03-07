package pers.kingvi.foreigntrade.admin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pers.kingvi.foreigntrade.po.Friend;
import pers.kingvi.foreigntrade.po.FriendExample;
import pers.kingvi.foreigntrade.vo.FriendVo;

public interface FriendMapper {
    int countByExample(FriendExample example);

    int deleteByExample(FriendExample example);

    int deleteByPrimaryKey(Integer id);   //根据主键id删除好友，基本不用

    int deleteFriend(Friend friend);

    int insert(Friend record);     //直接插入

    int insertSelective(Friend record);    //选择插入

    List<Friend> selectByExampleWithRowbounds(FriendExample example, RowBounds rowBounds);

    List<Friend> selectByExample(FriendExample example);

    Friend selectByPrimaryKey(Integer id);      //根据主键查询

    List<FriendVo> selectFriendListByUserId(Long userId);    //根据用户id查询好友信息列表

    Friend selectFriendMarkAndAddTime(Friend friend);       //根据用户和好友id查询好友备注和添加时间

    Friend selectFriend(Friend friend);       //根据用户id和好友id查询是否有好友联系

    int updateByExampleSelective(@Param("record") Friend record, @Param("example") FriendExample example);

    int updateByExample(@Param("record") Friend record, @Param("example") FriendExample example);

    int updateByPrimaryKeySelective(Friend record);      //根据主键选择更新

    int updateByPrimaryKey(Friend record);             //直接更新

    int updateFriendMark(Friend friend);            //更新数据库中friendMark字段,用户id为user_id字段

    int updateUserMark(Friend friend);               //更新数据库中userMark字段,用户为id为friend_id字段
}