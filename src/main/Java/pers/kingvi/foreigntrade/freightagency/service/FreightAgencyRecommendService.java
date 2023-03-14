package pers.kingvi.foreigntrade.freightagency.service;

import pers.kingvi.foreigntrade.po.FreightAgencyRecommend;
import pers.kingvi.foreigntrade.po.FreightAgencyRecommendVerify;
import pers.kingvi.foreigntrade.vo.PageBeanVo;

import java.util.List;

public interface FreightAgencyRecommendService {
    int insertSelective(FreightAgencyRecommendVerify farv);    //发布需求，插入审核表中

    FreightAgencyRecommend selectByPrimaryKey(Integer id);      //根据主键查询

    List<FreightAgencyRecommend> selectByFaId(Long faId);     //根据外贸员id查询需求列表

    PageBeanVo<FreightAgencyRecommend> selectPageByFaId(Long faId, Integer currentPage, Integer perPageRecord);    //获取外贸员需求页面

    FreightAgencyRecommend selectByPrimaryKeyAndFaId(Integer id, Long faId);     //根据id和外贸id查询具体需求信息

    FreightAgencyRecommend selectByBean(FreightAgencyRecommend freightAgencyRecommend);     //同上，只有id和faId非空

    int deleteByPrimaryKey(Integer id);        //根据id删除信息

    int deleteByPrimaryKeyAndFaId(Integer id, Long faId);        //根据id和外贸id删除信息

    int deleteByBean(FreightAgencyRecommend freightAgencyRecommend);          //同上，id和外贸id不为空

    PageBeanVo<FreightAgencyRecommend> selectByCriteria(String condition, String text, Integer currentPage, Integer perPageRecord);         //根据条件和输入信息模糊查询，返回页面

    PageBeanVo<FreightAgencyRecommend> selectFullIndex(String text, Integer currentPage, Integer perPageRecord);          //全文索引，返回页面

    PageBeanVo<FreightAgencyRecommend> selectByList(List<Integer> idList, Integer currentPage, Integer perPageRecord);         //根据地址没有显示结果，随机选择外贸id，根据id列表查询需求信息
}
