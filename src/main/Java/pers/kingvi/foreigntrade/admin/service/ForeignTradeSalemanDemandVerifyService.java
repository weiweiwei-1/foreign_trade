package pers.kingvi.foreigntrade.admin.service;

import pers.kingvi.foreigntrade.po.ForeignTradeSalemanDemand;
import pers.kingvi.foreigntrade.po.ForeignTradeSalemanDemandVerify;
import pers.kingvi.foreigntrade.po.ForeignTradeSalemanDemandVerify;
import pers.kingvi.foreigntrade.vo.PageBeanVo;

import java.util.List;

public interface ForeignTradeSalemanDemandVerifyService {

    int insertSelective(ForeignTradeSalemanDemandVerify ftsd);    //发布需求，插入审核表中

    ForeignTradeSalemanDemandVerify selectByPrimaryKey(Integer id);      //根据主键查询

    List<ForeignTradeSalemanDemandVerify> selectByFtsId(Long ftsId);     //根据外贸员id查询需求列表

    ForeignTradeSalemanDemandVerify selectByBean(ForeignTradeSalemanDemandVerify ForeignTradeSalemanDemandVerify);     //同上，只有id和ftsId非空

    int deleteByPrimaryKey(Integer id);       //根据id删除信息

    int deleteByPrimaryKeyAndFtsId(Integer id, Long ftsId);     //根据id和外贸id删除信息

    int deleteByBean(ForeignTradeSalemanDemandVerify ForeignTradeSalemanDemandVerify);   //同上，id和外贸id不为空

    PageBeanVo<ForeignTradeSalemanDemandVerify> selectAll(Integer currentPage, Integer perPageRecord);     //查询所有结果

    PageBeanVo<ForeignTradeSalemanDemandVerify> selectByCriteria(String condition, String text, Integer currentPage, Integer perPageRecord);     //根据条件和输入信息模糊查询，返回页面

    PageBeanVo<ForeignTradeSalemanDemandVerify> selectFullIndex(String text, Integer currentPage, Integer perPageRecord);     //全文索引，返回页面

    PageBeanVo<ForeignTradeSalemanDemandVerify> selectByList(List<Integer> idList, Integer currentPage, Integer perPageRecord);    //随机选择匹配

}
