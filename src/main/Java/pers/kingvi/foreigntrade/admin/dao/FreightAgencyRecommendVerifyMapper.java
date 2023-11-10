package pers.kingvi.foreigntrade.admin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pers.kingvi.foreigntrade.po.FreightAgencyRecommend;
import pers.kingvi.foreigntrade.po.FreightAgencyRecommendVerify;
import pers.kingvi.foreigntrade.po.FreightAgencyRecommendVerifyExample;

public interface FreightAgencyRecommendVerifyMapper {
    int countByExample(FreightAgencyRecommendVerifyExample example);

    int deleteByExample(FreightAgencyRecommendVerifyExample example);

    int deleteByPrimaryKey(Integer id);   //根据主键删除

    int deleteByPrimaryKeyAndFaId(@Param("id") Integer id, @Param("faId") Long faId);

    int deleteByBean(FreightAgencyRecommendVerify record);

    int insert(FreightAgencyRecommendVerify record);     //直接插入

    int insertSelective(FreightAgencyRecommendVerify record);       //选择插入

    List<FreightAgencyRecommendVerify> selectByExampleWithRowbounds(FreightAgencyRecommendVerifyExample example, RowBounds rowBounds);

    List<FreightAgencyRecommendVerify> selectByExample(FreightAgencyRecommendVerifyExample example);

    List<FreightAgencyRecommendVerify> selectAll();      //查询待审核的所有优惠活动记录

    FreightAgencyRecommendVerify selectByPrimaryKey(Integer id);   //根据主键查询

    List<FreightAgencyRecommendVerify> selectByFaId(Long faId);       //根据货代id查询

    FreightAgencyRecommendVerify selectByFaIdSingle(Long faId);

    int selectCountByFaId(Long faId);      //根据外贸id查询发布需求数量

    FreightAgencyRecommendVerify selectByPrimaryKeyAndFaId(@Param("id") Integer id, @Param("faId") Long faId);    //根据id和货代id进行查询

    FreightAgencyRecommendVerify selectByBean(FreightAgencyRecommendVerify record);    //同上

    List<FreightAgencyRecommendVerify> selectByCriteria(@Param("record") FreightAgencyRecommendVerify record, @Param("start") Integer start, @Param("end") Integer end);

    int selectCountByCriteria(FreightAgencyRecommendVerify record);

    List<FreightAgencyRecommendVerify> selectFullIndex(@Param("text") String text, @Param("start") Integer start, @Param("end") Integer end);         //全文索引

    int selectCountByFullIndex(@Param("text") String text);

    List<FreightAgencyRecommendVerify> selectByList(@Param("idList") List<Integer> idList, @Param("start") Integer start, @Param("end") Integer end);      //如果地址没有查询结果，默认随机系统选择

    int updateByExampleSelective(@Param("record") FreightAgencyRecommendVerify record, @Param("example") FreightAgencyRecommendVerifyExample example);

    int updateByExample(@Param("record") FreightAgencyRecommendVerify record, @Param("example") FreightAgencyRecommendVerifyExample example);

    int updateByPrimaryKeySelective(FreightAgencyRecommendVerify record);       //选择更新

    int updateByFaIdSelective(FreightAgencyRecommendVerify record);

    int updateByPrimaryKey(FreightAgencyRecommendVerify record);          //直接更新
}