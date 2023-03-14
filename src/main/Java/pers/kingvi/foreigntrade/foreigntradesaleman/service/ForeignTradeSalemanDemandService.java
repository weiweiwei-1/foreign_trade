package pers.kingvi.foreigntrade.foreigntradesaleman.service;

import pers.kingvi.foreigntrade.po.ForeignTradeSalemanDemand;
import pers.kingvi.foreigntrade.po.ForeignTradeSalemanDemandVerify;
import pers.kingvi.foreigntrade.vo.PageBeanVo;

import java.util.List;

public interface ForeignTradeSalemanDemandService {
    int insertSelective(ForeignTradeSalemanDemandVerify ftsd);       //发布需求，插入审核表中

    ForeignTradeSalemanDemand selectByPrimaryKey(Integer id);      //根据主键查询

    List<ForeignTradeSalemanDemand> selectByFtsId(Long ftsId);     //根据外贸员id查询需求列表

    PageBeanVo<ForeignTradeSalemanDemand> selectPageByFtsId(Long ftsId, Integer currentPage, Integer perPageRecord);      //获取外贸员需求页面

    ForeignTradeSalemanDemand selectByPrimaryKeyAndFtsId(Integer id, Long ftsId);      //根据id和外贸id查询具体需求信息

    ForeignTradeSalemanDemand selectByBean(ForeignTradeSalemanDemand foreignTradeSalemanDemand);     //同上，只有id和ftsId非空

    int deleteByPrimaryKey(Integer id);       //根据id删除信息

    int deleteByPrimaryKeyAndFtsId(Integer id, Long ftsId);     //根据id和外贸id删除信息

    int deleteByBean(ForeignTradeSalemanDemand foreignTradeSalemanDemand);   //同上，id和外贸id不为空

    PageBeanVo<ForeignTradeSalemanDemand> selectByCompany(String company, Integer currentPage, Integer perPageRecord);    //根据公司信息模糊查询，返回页面

    PageBeanVo<ForeignTradeSalemanDemand> selectByFtsCity(String city, Integer currentPage, Integer perPageRecord);     //根据城市信息模糊查询，返回页面

    PageBeanVo<ForeignTradeSalemanDemand> selectByMainBusiness(String mainBusiness, Integer currentPage, Integer perPageRecord);     //根据主营业务信息模糊查询，返回页面

    PageBeanVo<ForeignTradeSalemanDemand> selectByFtsName(String ftsName, Integer currentPage, Integer perPageRecord);     //根据外贸名称信息模糊查询，返回页面

    PageBeanVo<ForeignTradeSalemanDemand> selectByCriteria(String condition, String text, Integer currentPage, Integer perPageRecord);     //根据条件和输入信息模糊查询，返回页面

    PageBeanVo<ForeignTradeSalemanDemand> selectFullIndex(String text, Integer currentPage, Integer perPageRecord);     //全文索引，返回页面

    PageBeanVo<ForeignTradeSalemanDemand> selectByList(List<Integer> idList, Integer currentPage, Integer perPageRecord);     //根据地址没有显示结果，随机选择外贸id，根据id列表查询需求信息
}