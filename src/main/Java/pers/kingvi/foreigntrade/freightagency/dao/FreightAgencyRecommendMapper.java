package pers.kingvi.foreigntrade.freightagency.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pers.kingvi.foreigntrade.po.FreightAgencyRecommend;
import pers.kingvi.foreigntrade.po.FreightAgencyRecommendExample;
import pers.kingvi.foreigntrade.po.ProductInformation;

public interface FreightAgencyRecommendMapper {
    int countByExample(FreightAgencyRecommendExample example);

    int deleteByExample(FreightAgencyRecommendExample example);

    int deleteByPrimaryKey(Integer id);    //根据主键删除

    int deleteByIdAndFaId(@Param("id") Integer id, @Param("faId") Long faId);  //根据主键和货代id删除推荐信息

    int deleteByBean(FreightAgencyRecommend freightAgencyRecommend);

    int insert(FreightAgencyRecommend record);    //直接插入信息

    int insertSelective(FreightAgencyRecommend record);  //选择插入信息

    List<FreightAgencyRecommend> selectByExampleWithRowbounds(FreightAgencyRecommendExample example, RowBounds rowBounds);

    List<FreightAgencyRecommend> selectByExample(FreightAgencyRecommendExample example);

    FreightAgencyRecommend selectByPrimaryKey(Integer id);  //根据主键查询信息

    FreightAgencyRecommend selectByPrimaryKeyAndFaId(@Param("id") Integer id, @Param("faId") Long faId);   //根据主键和货代id查询信息

    List<FreightAgencyRecommend> selectBySelective(FreightAgencyRecommend freightAgencyRecommend);    //多条件查询

    List<FreightAgencyRecommend> selectBesideList(@Param("idList") List<Integer> list, @Param("start") Integer start, @Param("end") Integer end);       //查询不包括列表的数据记录，返回对应的页面，相应函数需根据

    FreightAgencyRecommend selectByFaIdSingle(Long faId);

    List<FreightAgencyRecommend> selectByFaId(Long faId);

    int selectAllCount();     //查询记录条数

    int selectCountByFaId(Long faId);      //根据外贸id查询发布需求数量

    List<FreightAgencyRecommend> selectByNewestRecord(@Param("start") Integer start, @Param("end") Integer end);  //查询最新记录

    List<FreightAgencyRecommend> selectByCriteria(@Param("record") FreightAgencyRecommend record, @Param("start") Integer start, @Param("end") Integer end);

    int selectCountByCriteria(FreightAgencyRecommend faId);

    List<FreightAgencyRecommend> selectFullIndex(@Param("text") String text, @Param("start") Integer start, @Param("end") Integer end);         //全文索引

    int selectCountByFullIndex(@Param("text") String text);

    List<FreightAgencyRecommend> selectByList(@Param("idList") List<Integer> idList, @Param("start") Integer start, @Param("end") Integer end);      //如果地址没有查询结果，默认随机系统选择

    int updateByExampleSelective(@Param("record") FreightAgencyRecommend record, @Param("example") FreightAgencyRecommendExample example);

    int updateByExample(@Param("record") FreightAgencyRecommend record, @Param("example") FreightAgencyRecommendExample example);

    int updateByPrimaryKeySelective(FreightAgencyRecommend record);      //选择更新

    int updateByPrimaryKey(FreightAgencyRecommend record);        //直接更新
}