package pers.kingvi.foreigntrade.foreigntradesaleman.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pers.kingvi.foreigntrade.po.ForeignTradeSalemanDemand;
import pers.kingvi.foreigntrade.po.ForeignTradeSalemanDemandExample;

public interface ForeignTradeSalemanDemandMapper {
    int countByExample(ForeignTradeSalemanDemandExample example);

    int deleteByExample(ForeignTradeSalemanDemandExample example);

    int deleteByPrimaryKey(Integer id);   //根据id删除记录

    int deleteByPrimaryKeyAndFtsId(@Param("id") Integer id, @Param("ftsId") Long ftsId);      //根据id和外贸id删除记录

    int deleteByBean(ForeignTradeSalemanDemand foreignTradeSalemanDemand);     //同上

    int insert(ForeignTradeSalemanDemand record);   //直接插入记录

    int insertSelective(ForeignTradeSalemanDemand record);   //选择插入记录

    List<ForeignTradeSalemanDemand> selectByExampleWithRowbounds(ForeignTradeSalemanDemandExample example, RowBounds rowBounds);

    List<ForeignTradeSalemanDemand> selectByExample(ForeignTradeSalemanDemandExample example);

    ForeignTradeSalemanDemand selectByPrimaryKey(Integer id);    // 根据id查询需求记录

    List<ForeignTradeSalemanDemand> selectByFtsId(Long ftsId);   //根据外贸id查询已发布的所有需求表

    int selectCountByFtsId(Long ftsId);      //根据外贸id查询发布需求数量

    ForeignTradeSalemanDemand selectByPrimaryKeyAndFtsId(@Param("id") Integer id, @Param("ftsId") Long ftsId);  //根据id和外贸id查询具体的某一条需求记录

    ForeignTradeSalemanDemand selectByBean(ForeignTradeSalemanDemand foreignTradeSalemanDemand);    //同上

    int selectCountByCriteria(ForeignTradeSalemanDemand ftsd);         //根据条件查询结果数量

    List<ForeignTradeSalemanDemand> selectByCompany(@Param("company") String company, @Param("start") Integer start, @Param("end") Integer end);

    List<ForeignTradeSalemanDemand> selectByCity(@Param("company") String city, @Param("start") Integer start, @Param("end") Integer end);

    List<ForeignTradeSalemanDemand> selectByMainBusiness(@Param("mainBusiness") String mainBusiness, @Param("start") Integer start, @Param("end") Integer end);

    List<ForeignTradeSalemanDemand> selectByFtsName(@Param("ftsName") String ftsName, @Param("start") Integer start, @Param("end") Integer end);   //根据姓名查询

    List<ForeignTradeSalemanDemand> selectByCriteria(@Param("ftsd") ForeignTradeSalemanDemand ftsd, @Param("start") Integer start, @Param("end") Integer end);

    List<ForeignTradeSalemanDemand> selectFullIndex(@Param("text") String text, @Param("start") Integer start, @Param("end") Integer end);         //全文索引

    int selectCountByFullIndex(@Param("text") String text);

    List<ForeignTradeSalemanDemand> selectByList(@Param("idList") List<Integer> idList, @Param("start") Integer start, @Param("end") Integer end);      //如果地址没有查询结果，默认随机系统选择

    int updateByExampleSelective(@Param("record") ForeignTradeSalemanDemand record, @Param("example") ForeignTradeSalemanDemandExample example);

    int updateByExample(@Param("record") ForeignTradeSalemanDemand record, @Param("example") ForeignTradeSalemanDemandExample example);

    int updateByPrimaryKeySelective(ForeignTradeSalemanDemand record);   //根据id更新记录

    int updateByPrimaryKey(ForeignTradeSalemanDemand record);          //根据id选择更新记录，一般不用
}