package pers.kingvi.foreigntrade.admin.service;

import pers.kingvi.foreigntrade.po.ProductInformationVerify;
import pers.kingvi.foreigntrade.vo.PageBeanVo;

import java.util.List;

public interface ProductInformationVerifyService {
    int insertSelective(ProductInformationVerify ProductInformationVerify);

    List<ProductInformationVerify> selectByFtsId(Long ftsId);

    PageBeanVo<ProductInformationVerify> selectByCriteria(String condition, String text, Integer currentPage, Integer perPageRecord);

    PageBeanVo<ProductInformationVerify> selectByFullIndex(String text, Integer currentPage, Integer perPageRecord);

    PageBeanVo<ProductInformationVerify> selectByList(List<Integer> idList, Integer currentPage, Integer perPageRecord);

    ProductInformationVerify selectByIdAndFtsId(Integer id, Long ftsId);

    ProductInformationVerify selectByProductInformationVerify(ProductInformationVerify ProductInformationVerify);

    int deleteByPrimaryKey(Integer id);

    int deleteByIdAndFtsId(Integer id, Long ftsId);

    int deleteByProductInformationVerify(ProductInformationVerify ProductInformationVerify);
}
