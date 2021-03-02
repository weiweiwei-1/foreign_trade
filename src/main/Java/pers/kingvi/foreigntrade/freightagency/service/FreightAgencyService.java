package pers.kingvi.foreigntrade.freightagency.service;

import pers.kingvi.foreigntrade.po.FreightAgency;
import pers.kingvi.foreigntrade.po.FreightAgency;
import pers.kingvi.foreigntrade.vo.PageBeanVo;

import java.util.List;
import java.util.Map;

public interface FreightAgencyService {

    int insertSelective(FreightAgency fa);     //注册账号

    FreightAgency selectByPrimaryKey(Long id);   //根据id查询账号

    int updateByPrimaryKeySelective(FreightAgency fa);      //选择更新

    int closeAccountByFaId(Long Id, String password, String secretSecurity);     //注销账号，也就是删除账号

    int deleteByPrimaryKey(Long id);     //通过id删除账号

    PageBeanVo<FreightAgency> selectByParam(String condition, String text, Integer currentPage, Integer perPageRecord);    //好友查询页面

    PageBeanVo<FreightAgency> selectByCriteria(String condition, String text, Integer currentPage, Integer perPageRecord);    //条件查询页面

    PageBeanVo<FreightAgency> selectFullIndex(String text, Integer currentPage, Integer perPageRecord);    // 全文索引页面

    PageBeanVo<FreightAgency> selectByList(List<Long> idList, Integer currentPage, Integer perPageRecord);       //随机匹配页面

}
