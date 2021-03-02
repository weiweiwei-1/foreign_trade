package pers.kingvi.foreigntrade.admin.service;

import pers.kingvi.foreigntrade.po.ForeignTradeSalemanDemandVerify;

public interface ForeignTradeSalemanDemandVerifyService {
    int permitVerify(ForeignTradeSalemanDemandVerify foreignTradeSalemanDemandVerify);

    int rejectVerify(Integer id);

}
