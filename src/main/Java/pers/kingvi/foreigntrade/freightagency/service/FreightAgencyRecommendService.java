package pers.kingvi.foreigntrade.freightagency.service;

import pers.kingvi.foreigntrade.po.ForeignTradeSaleman;
import pers.kingvi.foreigntrade.po.ForeignTradeSalemanDemand;
import pers.kingvi.foreigntrade.po.FreightAgencyRecommend;
import pers.kingvi.foreigntrade.vo.ForeignTradeSalemanDemandPage;
import pers.kingvi.foreigntrade.vo.FreightAgencyRecommendPage;

public interface FreightAgencyRecommendService {
    int insertSelective(FreightAgencyRecommend freightAgencyRecommend);

    FreightAgencyRecommend selectByPrimaryKeyAndUserId(Integer id, Integer userId);

    FreightAgencyRecommendPage<FreightAgencyRecommend> findByCurrentPageAndKeyWords(Integer currentPage, String keyWords);

    int deleteByPrimaryKey(Integer id);

    int deleteByPrimaryKeyAndFarId(Integer id, Integer userId);
}
