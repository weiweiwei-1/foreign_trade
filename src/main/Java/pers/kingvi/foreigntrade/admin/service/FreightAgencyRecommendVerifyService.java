package pers.kingvi.foreigntrade.admin.service;

import pers.kingvi.foreigntrade.po.FreightAgencyRecommend;
import pers.kingvi.foreigntrade.po.FreightAgencyRecommendVerify;

public interface FreightAgencyRecommendVerifyService {
    int permitRecommend(FreightAgencyRecommendVerify freightAgencyRecommendVerify);

    int permitRecommendByPrimaryKey(Integer id);

    int rejectRecommend(Integer id);
}
