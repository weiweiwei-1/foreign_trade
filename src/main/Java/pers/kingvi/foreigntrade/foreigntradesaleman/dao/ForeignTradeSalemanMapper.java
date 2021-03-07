package pers.kingvi.foreigntrade.foreigntradesaleman.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pers.kingvi.foreigntrade.po.ForeignTradeSaleman;
import pers.kingvi.foreigntrade.po.ForeignTradeSalemanDemand;
import pers.kingvi.foreigntrade.po.ForeignTradeSalemanExample;

public interface ForeignTradeSalemanMapper {
    int countByExample(ForeignTradeSalemanExample example);

    int deleteByExample(ForeignTradeSalemanExample example);

    int deleteByPrimaryKey(Long id);   //主键删除

    int insert(ForeignTradeSaleman record);    //直接插入

    int insertSelective(ForeignTradeSaleman record);     //选择插入

    List<ForeignTradeSaleman> selectByExampleWithRowbounds(ForeignTradeSalemanExample example, RowBounds rowBounds);

    List<ForeignTradeSaleman> selectByExample(ForeignTradeSalemanExample example);

    ForeignTradeSaleman selectByPrimaryKey(Long id);     //主键查询

    List<ForeignTradeSaleman> selectById(Long id);

    List<ForeignTradeSaleman> selectByFtsIdList(List<Long> ftsList);    //根据主键列表查询外贸员信息

    List<ForeignTradeSaleman> selectByCriteria(@Param("fts") ForeignTradeSaleman fts, @Param("start") Integer start, @Param("end") Integer end);   //根据条件查询某一页信息

    int selectCountByCriteria(ForeignTradeSaleman fts);      //条件查询结果数量

    List<ForeignTradeSaleman> selectByParam(@Param("param") String param, @Param("start") Integer start, @Param("end") Integer end);      //根据条件进行好友查询

    int selectCountByParam(String param);      //好友结果查询数量

    List<ForeignTradeSaleman> selectFullIndex(@Param("text") String text, @Param("start") Integer start, @Param("end") Integer end);    //全文索引某一页结果

    int selectCountByFullIndex(String text);        //全文索引结果数量

    List<ForeignTradeSaleman> selectByList(@Param("idList") List<Long> idList, @Param("start") Integer start, @Param("end") Integer end);   //随机选择某一页数量，系统随机匹配

    ForeignTradeSaleman selectByAccount(String account);    //通过账号精确搜索

    ForeignTradeSaleman selectByName(String name);       //通过名字精确搜索

    List<ForeignTradeSaleman> selectAll(@Param("start") Integer start, @Param("end") Integer end);    //搜索所有结果的一页信息

    int updateByExampleSelective(@Param("record") ForeignTradeSaleman record, @Param("example") ForeignTradeSalemanExample example);

    int updateByExample(@Param("record") ForeignTradeSaleman record, @Param("example") ForeignTradeSalemanExample example);

    int updateByPrimaryKeySelective(ForeignTradeSaleman record);     //主键选择更新

    int updateByPrimaryKey(ForeignTradeSaleman record);       //主键非选择更新

    int decreaseSendProductCount(Long id);      //发送产品数量减1

    int decreaseDemandCount(Long id);      //发送需求数量数量减1

    int resetSendProductCount(@Param("id") Long id, @Param("count") Integer count);   //发送产品数量减1

    int resetDemandCount(@Param("id") Long id, @Param("count") Integer count);      //发送需求数量数量减1

    int resetAllSendProductCount(Integer count);      //发送产品数量减1

    int resetAllDemandCount(Integer count);       //发送需求数量数量减1
}