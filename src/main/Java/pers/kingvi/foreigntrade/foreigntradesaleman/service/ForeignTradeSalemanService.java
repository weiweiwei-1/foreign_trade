package pers.kingvi.foreigntrade.foreigntradesaleman.service;

import pers.kingvi.foreigntrade.po.ForeignTradeSaleman;
import pers.kingvi.foreigntrade.po.ForeignTradeSalemanDemand;
import pers.kingvi.foreigntrade.po.FreightAgencyRecommend;
import pers.kingvi.foreigntrade.vo.ForeignTradeSalemanDemandPage;
import pers.kingvi.foreigntrade.vo.PageBeanVo;

import java.util.List;
import java.util.Map;

public interface ForeignTradeSalemanService {
    int insertSelective(ForeignTradeSaleman fts);     //注册账号

    ForeignTradeSaleman selectByPrimaryKey(Long id);   //根据id查询账号

    int updateByPrimaryKeySelective(ForeignTradeSaleman fts);      //选择更新

    int closeAccountByFtsId(Long Id, String password, String secretSecurity);     //注销账号，也就是删除账号

    int deleteByPrimaryKey(Long id);     //通过id删除账号

    PageBeanVo<ForeignTradeSaleman> selectByParam(String condition, String text, Integer currentPage, Integer perPageRecord);      //好友查询页面，非管理员页面

    PageBeanVo<ForeignTradeSaleman> selectByCriteria(String condition, String text, Integer currentPage, Integer perPageRecord);    //条件查询页面

    PageBeanVo<ForeignTradeSaleman> selectFullIndex(String text, Integer currentPage, Integer perPageRecord);    // 全文索引页面，管理员页面

    PageBeanVo<ForeignTradeSaleman> selectByList(List<Long> idList, Integer currentPage, Integer perPageRecord);       //随机匹配页面



}
