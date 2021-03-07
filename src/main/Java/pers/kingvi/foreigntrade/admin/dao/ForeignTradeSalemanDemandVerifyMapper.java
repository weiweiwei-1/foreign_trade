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

    int deleteByPrimaryKeyAndFtsId(@Param("id") Integer id, @Param("ftsId") Long ftsId);       //根据id和货代id删除记录

    int deleteByBean(ForeignTradeSalemanDemandVerify foreignTradeSalemanDemandVerify);         //根据bean删除

    int insert(ForeignTradeSalemanDemandVerify record);           //直接插入记录

    int insertSelective(ForeignTradeSalemanDemandVerify record);         //选择插入记录

    List<ForeignTradeSalemanDemandVerify> selectByExampleWithRowbounds(ForeignTradeSalemanDemandVerifyExample example, RowBounds rowBounds);

    List<ForeignTradeSalemanDemandVerify> selectByExample(ForeignTradeSalemanDemandVerifyExample example);

    ForeignTradeSalemanDemandVerify selectByPrimaryKey(Integer id);       // 根据id查询需求记录

    List<ForeignTradeSalemanDemandVerify> selectByFtsId(Long ftsId);   //根据外贸id查询已发布的所有需求表

    ForeignTradeSalemanDemandVerify selectByPrimaryKeyAndFtsId(@Param("id") Integer id, @Param("ftsId") Long ftsId);  //根据id和外贸id查询具体的某一条需求记录

    ForeignTradeSalemanDemandVerify selectByBean(ForeignTradeSalemanDemandVerify foreignTradeSalemanDemandVerify);

    List<ForeignTradeSalemanDemandVerify> selectAll(@Param("start") Integer start, @Param("end") Integer end);         //查询所有待审核的记录

    int selectCountByAll();       //查询所有待审核记录的数量

    List<ForeignTradeSalemanDemandVerify> selectByCriteria(@Param("ftsd") ForeignTradeSalemanDemandVerify ftsd, @Param("start") Integer start, @Param("end") Integer end);

    int selectCountByCriteria(ForeignTradeSalemanDemandVerify ftsd);         //根据条件查询结果数量

    List<ForeignTradeSalemanDemandVerify> selectFullIndex(@Param("text") String text, @Param("start") Integer start, @Param("end") Integer end);         //全文索引

    int selectCountByFullIndex(@Param("text") String text);

    List<ForeignTradeSalemanDemandVerify> selectByList(@Param("idList") List<Integer> idList, @Param("start") Integer start, @Param("end") Integer end);   //随机选择某一页数量，系统随机匹配

    int updateByExampleSelective(@Param("record") ForeignTradeSalemanDemandVerify record, @Param("example") ForeignTradeSalemanDemandVerifyExample example);

    int updateByExample(@Param("record") ForeignTradeSalemanDemandVerify record, @Param("example") ForeignTradeSalemanDemandVerifyExample example);

    int updateByPrimaryKeySelective(ForeignTradeSalemanDemandVerify record);          //根据id更新记录

    int updateByPrimaryKey(ForeignTradeSalemanDemandVerify record);          //根据id选择更新记录，一般不用


}