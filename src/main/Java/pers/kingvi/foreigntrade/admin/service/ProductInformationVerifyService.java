package pers.kingvi.foreigntrade.admin.service;

import pers.kingvi.foreigntrade.po.ProductInformationVerify;
import pers.kingvi.foreigntrade.vo.PageBeanVo;

import java.util.List;

public interface ProductInformationVerifyService {
    List<ProductInformationVerify> selectAllProductList();

    //管理员审核通过
    int permitLaunch(ProductInformationVerify ProductInformationVerify);

    //另一种审核接口，通过id查询产品信息进行操作
    int permitProduct(Integer id);

    int rejectProduct(Integer id);

    int sendProductQuery(ProductInformationVerify productInformationVerify, Long ftsId);

    List<ProductInformationVerify> selectByFtsId(Long ftsId);

    int insertSelective(ProductInformationVerify productInformationVerify);

    PageBeanVo<ProductInformationVerify> selectByCriteria(String condition, String text, Integer currentPage, Integer perPageRecord);

    PageBeanVo<ProductInformationVerify> selectByFullIndex(String text, Integer currentPage, Integer perPageRecord);

    PageBeanVo<ProductInformationVerify> selectByList(List<Integer> idList, Integer currentPage, Integer perPageRecord);

    ProductInformationVerify selectByIdAndFtsId(Integer id, Long ftsId);

    ProductInformationVerify selectByProductInformationVerify(ProductInformationVerify ProductInformationVerify);

    int deleteByPrimaryKey(Integer id);

    int deleteByIdAndFtsId(Integer id, Long ftsId);

    int deleteByProductInformationVerify(ProductInformationVerify ProductInformationVerify);
}
