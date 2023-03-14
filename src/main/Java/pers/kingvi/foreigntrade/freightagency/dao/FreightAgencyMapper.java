package pers.kingvi.foreigntrade.freightagency.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pers.kingvi.foreigntrade.po.FreightAgency;
import pers.kingvi.foreigntrade.po.FreightAgency;
import pers.kingvi.foreigntrade.po.FreightAgencyExample;
import pers.kingvi.foreigntrade.vo.fa.FaUpdateVo;

public interface FreightAgencyMapper {
    int countByExample(FreightAgencyExample example);

    int deleteByExample(FreightAgencyExample example);

    int deleteByPrimaryKey(Long id);      //根据主键删除记录

    int insert(FreightAgency record);          //直接插入记录

    int insertSelective(FreightAgency record);   //选择插入记录

    List<FreightAgency> selectByExampleWithRowbounds(FreightAgencyExample example, RowBounds rowBounds);

    List<FreightAgency> selectByExample(FreightAgencyExample example);

    FreightAgency selectByPrimaryKey(Long id);         //根据主键id查询信息

    List<FreightAgency> selectById(Long id);

    FreightAgency selectByAccount(String account);      //根据账号查询

    List<FreightAgency> selectByFaIdList(@Param("faIdList") List<Long> faIdList);    //根据主键id列表查询货代信息

    FreightAgency selectByAccountAndPassword(@Param("account") String account, @Param("password") String password);  //根据账号密码查询

    int updateByExampleSelective(@Param("record") FreightAgency record, @Param("example") FreightAgencyExample example);

    int updateByExample(@Param("record") FreightAgency record, @Param("example") FreightAgencyExample example);

    int updateByPrimaryKeySelective(FreightAgency record);     //选择更新记录

    int updateByPrimaryKey(FaUpdateVo faUpdateVo);              //直接更新记录

    List<FreightAgency> selectByParam(@Param("param") String param, @Param("start") Integer start, @Param("end") Integer end);         //根据条件进行好友查询

    int selectCountByParam(String param);          //根据条件进行好友查询

    List<FreightAgency> selectByCriteria(@Param("fa") FreightAgency fa, @Param("start") Integer start, @Param("end") Integer end);   //根据条件查询某一页信息

    int selectCountByCriteria(FreightAgency fa);      //条件查询结果数

    List<FreightAgency> selectFullIndex(@Param("text") String text, @Param("start") Integer start, @Param("end") Integer end);    //全文索引某一页结果

    int selectCountByFullIndex(String text);        //全文索引结果数

    List<FreightAgency> selectByList(@Param("idList") List<Long> idList, @Param("start") Integer start, @Param("end") Integer end);   //随机选择某一页数量，系统随机匹配

    int decreaseSendQuoteCount(Long id);      //发送报价数量减1

    int decreaseAdvertiseCount(Long id);      //发送广告数量数量减1

    int resetSendQuoteCount(@Param("id") Long id, @Param("count") Integer count);   //根据用户id重置发送报价数

    int resetAdvertiseCount(@Param("id") Long id, @Param("count") Integer count);      //根据用户id重置广告需求数

    int resetAllSendQuoteCount(Integer count);      //重置所有发送报价数

    int resetAllAdvertiseCount(Integer count);      //重置所有广告需求数
}