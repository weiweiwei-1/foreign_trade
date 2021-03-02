package pers.kingvi.foreigntrade.admin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pers.kingvi.foreigntrade.po.FriendApply;
import pers.kingvi.foreigntrade.po.FriendApplyExample;

public interface FriendApplyMapper {
    int countByExample(FriendApplyExample example);

    int deleteByExample(FriendApplyExample example);

    int deleteByPrimaryKey(Integer id);   //根据主键删除

    int deleteFriend(FriendApply friendApply);    //根据自身id和好友申请id拒绝好友申请同意

    int insert(FriendApply record);     //直接插入

    int insertSelective(FriendApply record);     //选择插入

    List<FriendApply> selectByExampleWithRowbounds(FriendApplyExample example, RowBounds rowBounds);

    List<FriendApply> selectByExample(FriendApplyExample example);

    FriendApply selectByPrimaryKey(Integer id);       //根据主键查询

    FriendApply selectFriendApply(FriendApply friendApply);   //根据接收者id和发送者id查询

    List<FriendApply> selectByReceiverId(Long receiverId);      //根据被申请者id查询好友申请信息

    int updateByExampleSelective(@Param("record") FriendApply record, @Param("example") FriendApplyExample example);

    int updateByExample(@Param("record") FriendApply record, @Param("example") FriendApplyExample example);

    int updateByPrimaryKeySelective(FriendApply record);    //选择更新，基本不用

    int updateByPrimaryKey(FriendApply record);          //直接更新，基本不用
}