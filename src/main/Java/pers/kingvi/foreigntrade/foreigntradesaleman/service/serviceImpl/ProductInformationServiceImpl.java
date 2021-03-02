package pers.kingvi.foreigntrade.foreigntradesaleman.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.kingvi.foreigntrade.admin.dao.ProductInformationVerifyMapper;
import pers.kingvi.foreigntrade.foreigntradesaleman.dao.ForeignTradeSalemanMapper;
import pers.kingvi.foreigntrade.foreigntradesaleman.dao.ProductInformationMapper;
import pers.kingvi.foreigntrade.foreigntradesaleman.service.ProductInformationService;
import pers.kingvi.foreigntrade.po.ProductInformation;
import pers.kingvi.foreigntrade.po.ProductInformationVerify;

import java.util.List;

@Service
public class ProductInformationServiceImpl implements ProductInformationService {

    @Autowired
    private ForeignTradeSalemanMapper foreignTradeSalemanMapper;

    @Autowired
    private ProductInformationVerifyMapper productInformationVerifyMapper;

    @Autowired
    private ProductInformationMapper productInformationMapper;

    @Override
    public int insertSelective(ProductInformationVerify productInformationVerify) {
        int status = foreignTradeSalemanMapper.decreaseSendProductCount(productInformationVerify.getFtsId());
        if (status == 0) {
           return productInformationVerifyMapper.insertSelective(productInformationVerify);
        }
        return 0;
    }

    @Override
    public List<ProductInformation> selectByFtsId(Long ftsId) {
        return productInformationMapper.selectByFtsId(ftsId);
    }

    @Override
    public ProductInformation selectByIdAndFtsId(Integer id, Long ftsId) {
        return productInformationMapper.selectByPrimaryKeyAndFtsId(id, ftsId);
    }

    @Override
    public ProductInformation selectByProductInformation(ProductInformation productInformation) {
        return productInformationMapper.selectByProductInformation(productInformation);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return productInformationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByIdAndFtsId(Integer id, Long ftsId) {
        return productInformationMapper.deleteByPrimaryKeyAndFtsId(id, ftsId);
    }

    @Override
    public int deleteByProductInformation(ProductInformation productInformation) {
        return productInformationMapper.deleteByProductInformation(productInformation);
    }
}
