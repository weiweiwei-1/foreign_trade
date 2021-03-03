package pers.kingvi.foreigntrade.admin.service.serviceImpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.kingvi.foreigntrade.admin.dao.ProductInformationVerifyMapper;
import pers.kingvi.foreigntrade.admin.service.ProductInformationVerifyService;
import pers.kingvi.foreigntrade.foreigntradesaleman.dao.ProductInformationMapper;
import pers.kingvi.foreigntrade.po.ProductInformation;
import pers.kingvi.foreigntrade.po.ProductInformationVerify;
import pers.kingvi.foreigntrade.vo.PageBeanVo;

import java.util.List;

@Service
public class ProductInformationVerifyServiceImpl implements ProductInformationVerifyService {

    @Autowired
    private ProductInformationVerifyMapper productInformationVerifyMapper;

    @Autowired
    private ProductInformationMapper productInformationMapper;

    @Override
    public int insertSelective(ProductInformationVerify productInformationVerify) {
        ProductInformation productInformation =  new ProductInformation();
        productInformationVerifyMapper.deleteByPrimaryKey(productInformationVerify.getId());
        BeanUtils.copyProperties(productInformationVerify,productInformation);
        productInformation.setVerifyStatus("1");
        productInformationMapper.insertSelective(productInformation);
        return 0;
    }

    @Override
    public List<ProductInformationVerify> selectByFtsId(Long ftsId) {
        return null;
    }

    @Override
    public PageBeanVo<ProductInformationVerify> selectByCriteria(String condition, String text, Integer currentPage, Integer perPageRecord) {
        return null;
    }

    @Override
    public PageBeanVo<ProductInformationVerify> selectByFullIndex(String text, Integer currentPage, Integer perPageRecord) {
        return null;
    }

    @Override
    public PageBeanVo<ProductInformationVerify> selectByList(List<Integer> idList, Integer currentPage, Integer perPageRecord) {
        return null;
    }

    @Override
    public ProductInformationVerify selectByIdAndFtsId(Integer id, Long ftsId) {
        return null;
    }

    @Override
    public ProductInformationVerify selectByProductInformationVerify(ProductInformationVerify ProductInformationVerify) {
        return null;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int deleteByIdAndFtsId(Integer id, Long ftsId) {
        return 0;
    }

    @Override
    public int deleteByProductInformationVerify(ProductInformationVerify ProductInformationVerify) {
        return 0;
    }
}
