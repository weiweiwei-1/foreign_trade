package pers.kingvi.foreigntrade.foreigntradesaleman.service;

import pers.kingvi.foreigntrade.po.ForeignTradeSaleman;
import pers.kingvi.foreigntrade.vo.PageBeanVo;
import pers.kingvi.foreigntrade.vo.fts.FtsUpdateVo;

import java.util.List;

public interface ForeignTradeSalemanService {
    int insertSelective(ForeignTradeSaleman fts);     //注册账号

    ForeignTradeSaleman selectByPrimaryKey(Long id);   //根据id查询账号

    ForeignTradeSaleman selectByAccount(String account);   //根据账号查询信息

    int updateByPrimaryKey(FtsUpdateVo ftsUpdateVo);       //直接更新

    int updateByPrimaryKeySelective(ForeignTradeSaleman fts);      //选择更新

    int resetSendProductCount(Integer productCount);         //重置发送货物数

    int closeAccountByFtsId(Long Id, String password, String secretSecurity);     //注销账号，也就是删除账号

    int deleteByPrimaryKey(Long id);     //通过id删除账号

    List<ForeignTradeSaleman> selectByIdList(List<Long> ftsIdList);

    PageBeanVo<ForeignTradeSaleman> selectByParam(String condition, String text, Integer currentPage, Integer perPageRecord);      //好友查询页面，非管理员页面

    PageBeanVo<ForeignTradeSaleman> selectByCriteria(String condition, String text, Integer currentPage, Integer perPageRecord);    //条件查询页面

    PageBeanVo<ForeignTradeSaleman> selectFullIndex(String text, Integer currentPage, Integer perPageRecord);    // 全文索引页面，管理员页面

    PageBeanVo<ForeignTradeSaleman> selectByList(List<Long> idList, Integer currentPage, Integer perPageRecord);       //随机匹配页面

}
