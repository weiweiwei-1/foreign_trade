package pers.kingvi.foreigntrade.foreigntradesaleman.service;

import pers.kingvi.foreigntrade.po.ProductInformation;
import pers.kingvi.foreigntrade.po.ProductInformationVerify;

import java.util.List;
import java.util.Map;

public interface ProductInformationService {
    int insertSelective(ProductInformationVerify productInformationVerify);

    List<ProductInformation> selectByFtsId(Long ftsId);

    ProductInformation selectByIdAndFtsId(Integer id, Long ftsId);

    ProductInformation selectByProductInformation(ProductInformation productInformation);

    int deleteByPrimaryKey(Integer id);

    int deleteByIdAndFtsId(Integer id, Long ftsId);

    int deleteByProductInformation(ProductInformation productInformation);
}
