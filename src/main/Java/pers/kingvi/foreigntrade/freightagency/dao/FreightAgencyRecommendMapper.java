package pers.kingvi.foreigntrade.freightagency.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
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

    List<FreightAgencyRecommend> selectByFaId(Long faId);

    int updateByExampleSelective(@Param("record") FreightAgencyRecommend record, @Param("example") FreightAgencyRecommendExample example);

    int updateByExample(@Param("record") FreightAgencyRecommend record, @Param("example") FreightAgencyRecommendExample example);

    int updateByPrimaryKeySelective(FreightAgencyRecommend record);

    int updateByPrimaryKey(FreightAgencyRecommend record);
}