package pers.kingvi.foreigntrade.admin.service;

import pers.kingvi.foreigntrade.po.FreightAgencyRecommendVerify;
import pers.kingvi.foreigntrade.vo.PageBeanVo;

import java.util.List;

public interface FreightAgencyRecommendVerifyService {
    int insertSelective(FreightAgencyRecommendVerify farv);    //发布需求，插入审核表中

    FreightAgencyRecommendVerify selectByPrimaryKey(Integer id);      //根据主键查询

    List<FreightAgencyRecommendVerify> selectByFaId(Long faId);     //根据外贸员id查询需求列表

    FreightAgencyRecommendVerify selectByFaIdSingle(Long faId);

    List<FreightAgencyRecommendVerify> selectAll();

    int updateByFaId(FreightAgencyRecommendVerify freightAgencyRecommendVerify);

    PageBeanVo<FreightAgencyRecommendVerify> selectPageByFaId(Long faId, Integer currentPage, Integer perPageRecord);    //获取外贸员需求页面

    FreightAgencyRecommendVerify selectByPrimaryKeyAndFaId(Integer id, Long faId);     //根据id和外贸id查询具体需求信息

    FreightAgencyRecommendVerify selectByBean(FreightAgencyRecommendVerify freightAgencyRecommendVerify);     //同上，只有id和faId非空

    int deleteByPrimaryKey(Integer id);        //根据id删除信息

    int deleteByPrimaryKeyAndFaId(Integer id, Long faId);        //根据id和外贸id删除信息

    int deleteByBean(FreightAgencyRecommendVerify FreightAgencyRecommendVerify);          //同上，id和外贸id不为空

    int permitFaRecommend(Integer id, Long faId);

    int rejectRecommend(Integer id);

    PageBeanVo<FreightAgencyRecommendVerify> selectByCriteria(String condition, String text, Integer currentPage, Integer perPageRecord);         //根据条件和输入信息模糊查询，返回页面

    PageBeanVo<FreightAgencyRecommendVerify> selectFullIndex(String text, Integer currentPage, Integer perPageRecord);          //全文索引，返回页面

    PageBeanVo<FreightAgencyRecommendVerify> selectByList(List<Integer> idList, Integer currentPage, Integer perPageRecord);         //根据地址没有显示结果，随机选择外贸id，根据id列表查询需求信息
}
