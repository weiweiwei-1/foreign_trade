package pers.kingvi.foreigntrade.admin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pers.kingvi.foreigntrade.po.FreightAgencyRecommendVerify;
import pers.kingvi.foreigntrade.po.FreightAgencyRecommendVerifyExample;

public interface FreightAgencyRecommendVerifyMapper {
    int countByExample(FreightAgencyRecommendVerifyExample example);

    int deleteByExample(FreightAgencyRecommendVerifyExample example);

    int deleteByPrimaryKey(Integer id);   //根据主键删除

    int deleteByPrimaryKeyAndFaId(@Param("id") Integer id, @Param("faId") Long faId);

    int insert(FreightAgencyRecommendVerify record);     //直接插入

    int insertSelective(FreightAgencyRecommendVerify record);       //选择插入

    List<FreightAgencyRecommendVerify> selectByExampleWithRowbounds(FreightAgencyRecommendVerifyExample example, RowBounds rowBounds);

    List<FreightAgencyRecommendVerify> selectByExample(FreightAgencyRecommendVerifyExample example);

    FreightAgencyRecommendVerify selectByPrimaryKey(Integer id);   //根据主键查询

    List<FreightAgencyRecommendVerify> selectByFaId(Long faId);       //根据货代id查询

    FreightAgencyRecommendVerify selectByPrimaryKeyAndFaId(@Param("id") Integer id, @Param("faId") Long faId);    //根据id和货代id进行查询

    int updateByExampleSelective(@Param("record") FreightAgencyRecommendVerify record, @Param("example") FreightAgencyRecommendVerifyExample example);

    int updateByExample(@Param("record") FreightAgencyRecommendVerify record, @Param("example") FreightAgencyRecommendVerifyExample example);

    int updateByPrimaryKeySelective(FreightAgencyRecommendVerify record);       //选择更新

    int updateByPrimaryKey(FreightAgencyRecommendVerify record);          //直接更新
}