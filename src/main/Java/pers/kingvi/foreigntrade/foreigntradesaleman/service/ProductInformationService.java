package pers.kingvi.foreigntrade.foreigntradesaleman.service;

import pers.kingvi.foreigntrade.po.ProductInformation;
import pers.kingvi.foreigntrade.po.ProductInformationVerify;
import pers.kingvi.foreigntrade.vo.PageBeanVo;

import java.util.List;
import java.util.Map;

public interface ProductInformationService {
    int insertSelective(ProductInformationVerify productInformationVerify);

    List<ProductInformation> selectByFtsId(Long ftsId);

    int selectAllCount();

    PageBeanVo<ProductInformation> selectByCriteria(String condition, String text, Integer currentPage, Integer perPageRecord);

    PageBeanVo<ProductInformation> selectByFullIndex(String text, Integer currentPage, Integer perPageRecord);

    PageBeanVo<ProductInformation> selectByList(List<Integer> idList, Integer currentPage, Integer perPageRecord);

    PageBeanVo<ProductInformation> selectByCityRecommend(String city, Integer currentPage, Integer perPageRecord);  //首页推荐，根据货物发货地首先选择

    ProductInformation selectByIdAndFtsId(Integer id, Long ftsId);

    ProductInformation selectByProductInformation(ProductInformation productInformation);

    int deleteByPrimaryKey(Integer id);

    int deleteByIdAndFtsId(Integer id, Long ftsId);

    int deleteByProductInformation(ProductInformation productInformation);
}
