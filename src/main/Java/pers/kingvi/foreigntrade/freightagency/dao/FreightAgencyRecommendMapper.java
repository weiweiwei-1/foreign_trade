package pers.kingvi.foreigntrade.freightagency.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pers.kingvi.foreigntrade.po.ForeignTradeSalemanDemand;
import pers.kingvi.foreigntrade.po.FreightAgencyRecommend;
import pers.kingvi.foreigntrade.po.FreightAgencyRecommendExample;

public interface FreightAgencyRecommendMapper {
    int countByExample(FreightAgencyRecommendExample example);

    int deleteByExample(FreightAgencyRecommendExample example);

    int deleteByPrimaryKey(Integer id);    //根据主键删除

    int deleteByIdAndFaId(@Param("id") Integer id, @Param("faId") Long faId);  //根据主键和货代id删除推荐信息

    int insert(FreightAgencyRecommend record);    //直接插入信息

    int insertSelective(FreightAgencyRecommend record);  //选择插入信息

    List<FreightAgencyRecommend> selectByExampleWithRowbounds(FreightAgencyRecommendExample example, RowBounds rowBounds);

    List<FreightAgencyRecommend> selectByExample(FreightAgencyRecommendExample example);

    FreightAgencyRecommend selectByPrimaryKey(Integer id);  //根据主键查询信息

    FreightAgencyRecommend selectByPrimaryKeyAndFaId(@Param("id") Integer id, @Param("faId") Long faId);   //根据主键和货代id查询信息

    ForeignTradeSalemanDemand selectByBean(ForeignTradeSalemanDemand foreignTradeSalemanDemand);    //同上

    List<FreightAgencyRecommend> selectByFaId(Long faId);

    int selectCountByFtsId(Long ftsId);      //根据外贸id查询发布需求数量

    List<ForeignTradeSalemanDemand> selectByCriteria(@Param("ftsd") ForeignTradeSalemanDemand ftsd, @Param("start") Integer start, @Param("end") Integer end);

    int selectCountByCriteria(ForeignTradeSalemanDemand ftsd);

    List<ForeignTradeSalemanDemand> selectFullIndex(@Param("text") String text, @Param("start") Integer start, @Param("end") Integer end);         //全文索引

    int selectCountByFullIndex(@Param("text") String text);

    List<ForeignTradeSalemanDemand> selectByList(@Param("idList") List<Integer> idList, @Param("start") Integer start, @Param("end") Integer end);      //如果地址没有查询结果，默认随机系统选择

    int updateByExampleSelective(@Param("record") FreightAgencyRecommend record, @Param("example") FreightAgencyRecommendExample example);

    int updateByExample(@Param("record") FreightAgencyRecommend record, @Param("example") FreightAgencyRecommendExample example);

    int updateByPrimaryKeySelective(FreightAgencyRecommend record);

    int updateByPrimaryKey(FreightAgencyRecommend record);
}