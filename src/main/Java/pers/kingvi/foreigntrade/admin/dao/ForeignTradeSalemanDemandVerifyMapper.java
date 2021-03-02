package pers.kingvi.foreigntrade.admin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pers.kingvi.foreigntrade.po.ForeignTradeSalemanDemand;
import pers.kingvi.foreigntrade.po.ForeignTradeSalemanDemandVerify;
import pers.kingvi.foreigntrade.po.ForeignTradeSalemanDemandVerifyExample;

public interface ForeignTradeSalemanDemandVerifyMapper {
    int countByExample(ForeignTradeSalemanDemandVerifyExample example);

    int deleteByExample(ForeignTradeSalemanDemandVerifyExample example);

    int deleteByPrimaryKey(Integer id);       //根据id删除记录

    int deleteByPrimaryKeyAndFtsId(@Param("id") Integer id, @Param("ftsId") Long ftsId);      //根据id和货代id删除记录

    int insert(ForeignTradeSalemanDemandVerify record);      //直接插入记录

    int insertSelective(ForeignTradeSalemanDemandVerify record);       //选择插入记录

    List<ForeignTradeSalemanDemandVerify> selectByExampleWithRowbounds(ForeignTradeSalemanDemandVerifyExample example, RowBounds rowBounds);

    List<ForeignTradeSalemanDemandVerify> selectByExample(ForeignTradeSalemanDemandVerifyExample example);

    ForeignTradeSalemanDemandVerify selectByPrimaryKey(Integer id);       // 根据id查询需求记录

    List<ForeignTradeSalemanDemandVerify> selectByFtsId(Long ftsId);   //根据外贸id查询已发布的所有需求表

    ForeignTradeSalemanDemandVerify selectByPrimaryKeyAndFtsId(@Param("id") Integer id, @Param("ftsId") Long ftsId);  //根据id和外贸id查询具体的某一条需求记录

    List<ForeignTradeSalemanDemandVerify> selectAll();         //查询所有待审核的记录

    int updateByExampleSelective(@Param("record") ForeignTradeSalemanDemandVerify record, @Param("example") ForeignTradeSalemanDemandVerifyExample example);

    int updateByExample(@Param("record") ForeignTradeSalemanDemandVerify record, @Param("example") ForeignTradeSalemanDemandVerifyExample example);

    int updateByPrimaryKeySelective(ForeignTradeSalemanDemandVerify record);          //根据id更新记录

    int updateByPrimaryKey(ForeignTradeSalemanDemandVerify record);          //根据id选择更新记录，一般不用
}