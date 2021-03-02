package pers.kingvi.foreigntrade.admin.service;

import pers.kingvi.foreigntrade.po.ProductInformationVerify;

public interface ProductInformationVerifyService {
    int permitVerify(ProductInformationVerify productInformationVerify);

    int rejectVerify(ProductInformationVerify productInformationVerify);
}
