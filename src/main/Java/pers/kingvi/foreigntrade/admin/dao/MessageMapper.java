package pers.kingvi.foreigntrade.admin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pers.kingvi.foreigntrade.po.Message;
import pers.kingvi.foreigntrade.po.MessageExample;
import pers.kingvi.foreigntrade.vo.ReadAndUnReadMessageVo;
import pers.kingvi.foreigntrade.vo.UnReadMessageVo;

public interface MessageMapper {
    int countByExample(MessageExample example);

    int deleteByExample(MessageExample example);

    int deleteByPrimaryKey(Integer id);   //根据主键删除具体的消息记录

    int insert(Message record);     //直接插入消息

    int insertSelective(Message record);   //选择插入消息

    List<Message> selectByExampleWithRowbounds(MessageExample example, RowBounds rowBounds);

    List<Message> selectByExample(MessageExample example);

    Message selectByPrimaryKey(Integer id);      //根据主键查询具体某一条消息，不太用

    List<Message> selectAll(Message message);        //根据senderId和receiverId查询所有消息记录

    List<Message> selectLastAmount(@Param("message") Message message, @Param("amount") Integer amount);

    List<UnReadMessageVo> selectUnReadMessage(Long userId);   //主要获取未读消息的个数

    List<ReadAndUnReadMessageVo> selectReadAndUnReadMessage(Long userId);    //消息列表显示详情

    int updateByExampleSelective(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByExample(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByPrimaryKeySelective(Message record);       //选择更新消息，基本不用

    int updateByPrimaryKey(Message record);        //直接更新消息，基本不用

    int updateMessages(Message message);         //读消息，将消息的状态设置为1

}