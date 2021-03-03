package pers.kingvi.foreigntrade.foreigntradesaleman.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.kingvi.foreigntrade.admin.dao.ProductInformationVerifyMapper;
import pers.kingvi.foreigntrade.foreigntradesaleman.dao.ForeignTradeSalemanMapper;
import pers.kingvi.foreigntrade.foreigntradesaleman.dao.ProductInformationMapper;
import pers.kingvi.foreigntrade.foreigntradesaleman.service.ProductInformationService;
import pers.kingvi.foreigntrade.po.ProductInformation;
import pers.kingvi.foreigntrade.po.ProductInformationVerify;
import pers.kingvi.foreigntrade.vo.PageBeanVo;

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
        if (status == 1) {
           return productInformationVerifyMapper.insertSelective(productInformationVerify);
        }
        return 0;
    }

    @Override
    public List<ProductInformation> selectByFtsId(Long ftsId) {
        return productInformationMapper.selectByFtsId(ftsId);
    }

    @Override
    public PageBeanVo<ProductInformation> selectByCriteria(String condition, String text, Integer currentPage, Integer perPageRecord) {
        ProductInformation productInformation = new ProductInformation();
        List<ProductInformation> productInformationList;
        int count;
        int start = (currentPage-1)*perPageRecord;
        int end = perPageRecord;
        PageBeanVo<ProductInformation> pageBeanVo = new PageBeanVo<>();
        pageBeanVo.setCurrentPage(currentPage);
        pageBeanVo.setPerPageRecord(perPageRecord);
        switch (condition) {
            case "外贸名":
                productInformation.setFtsName(text);
                count =  productInformationMapper.selectCountByCriteria(productInformation);
                productInformationList = productInformationMapper.selectByCriteria(productInformation, start, end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(productInformationList);
                return pageBeanVo;
            case "产品名":
                productInformation.setProductName(text);
                count =  productInformationMapper.selectCountByCriteria(productInformation);
                productInformationList = productInformationMapper.selectByCriteria(productInformation, start, end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(productInformationList);
                return pageBeanVo;
            case "发货城市":
                productInformation.setOrigin(text);
                count =  productInformationMapper.selectCountByCriteria(productInformation);
                productInformationList = productInformationMapper.selectByCriteria(productInformation, start, end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(productInformationList);
                return pageBeanVo;
            case "客户地址":
                productInformation.setDestination(text);
                count =  productInformationMapper.selectCountByCriteria(productInformation);
                productInformationList = productInformationMapper.selectByCriteria(productInformation, start, end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(productInformationList);
                return pageBeanVo;
            case "备注":
                productInformation.setRemark(text);
                count = productInformationMapper.selectCountByCriteria(productInformation);
                productInformationList = productInformationMapper.selectByCriteria(productInformation, start, end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(productInformationList);
                return pageBeanVo;
            case "全文索引":
                productInformationList = productInformationMapper.selectFullIndex(text,start,end);
                count = productInformationMapper.selectCountByFullIndex(text);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(productInformationList);
                return pageBeanVo;
            default:break;
        }
        return null;
    }

    @Override
    public PageBeanVo<ProductInformation> selectByFullIndex(String text, Integer currentPage, Integer perPageRecord) {
        int count = productInformationMapper.selectCountByFullIndex(text);
        int start = (currentPage-1)*perPageRecord;
        int end = perPageRecord;
        List<ProductInformation> productInformationList = productInformationMapper.selectFullIndex(text, start, end);
        PageBeanVo<ProductInformation> pageBeanVo = new PageBeanVo<>();
        pageBeanVo.setBeanList(productInformationList);
        pageBeanVo.setCurrentPage(currentPage);
        pageBeanVo.setPerPageRecord(perPageRecord);
        pageBeanVo.setTotalRecord(count);
        pageBeanVo.setPageCount(perPageRecord, count);
        return pageBeanVo;
    }

    @Override
    public PageBeanVo<ProductInformation> selectByList(List<Integer> idList, Integer currentPage, Integer perPageRecord) {
        int count = idList.size();
        int start = (currentPage-1)*perPageRecord;
        int end = perPageRecord;
        List<ProductInformation> productInformationList = productInformationMapper.selectByList(idList, start, end);
        PageBeanVo<ProductInformation> pageBeanVo = new PageBeanVo<>();
        pageBeanVo.setBeanList(productInformationList);
        pageBeanVo.setCurrentPage(currentPage);
        pageBeanVo.setPerPageRecord(perPageRecord);
        pageBeanVo.setTotalRecord(count);
        pageBeanVo.setPageCount(perPageRecord, count);
        return pageBeanVo;
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
