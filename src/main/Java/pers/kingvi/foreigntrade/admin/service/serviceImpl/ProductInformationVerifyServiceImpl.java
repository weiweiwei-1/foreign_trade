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
        return productInformationVerifyMapper.selectByFtsId(ftsId);
    }

    @Override
    public PageBeanVo<ProductInformationVerify> selectByCriteria(String condition, String text, Integer currentPage, Integer perPageRecord) {
        ProductInformationVerify productInformationVerify = new ProductInformationVerify();
        List<ProductInformationVerify> productInformationVerifyList;
        int count;
        int start = (currentPage-1)*perPageRecord;
        int end = perPageRecord;
        PageBeanVo<ProductInformationVerify> pageBeanVo = new PageBeanVo<>();
        pageBeanVo.setCurrentPage(currentPage);
        pageBeanVo.setPerPageRecord(perPageRecord);
        switch (condition) {
            case "外贸名":
                productInformationVerify.setFtsName(text);
                count =  productInformationVerifyMapper.selectCountByCriteria(productInformationVerify);
                productInformationVerifyList = productInformationVerifyMapper.selectByCriteria(productInformationVerify, start, end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(productInformationVerifyList);
                return pageBeanVo;
            case "产品名":
                productInformationVerify.setProductName(text);
                count =  productInformationVerifyMapper.selectCountByCriteria(productInformationVerify);
                productInformationVerifyList = productInformationVerifyMapper.selectByCriteria(productInformationVerify, start, end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(productInformationVerifyList);
                return pageBeanVo;
            case "发货城市":
                productInformationVerify.setOrigin(text);
                count =  productInformationVerifyMapper.selectCountByCriteria(productInformationVerify);
                productInformationVerifyList = productInformationVerifyMapper.selectByCriteria(productInformationVerify, start, end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(productInformationVerifyList);
                return pageBeanVo;
            case "客户地址":
                productInformationVerify.setDestination(text);
                count =  productInformationVerifyMapper.selectCountByCriteria(productInformationVerify);
                productInformationVerifyList = productInformationVerifyMapper.selectByCriteria(productInformationVerify, start, end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(productInformationVerifyList);
                return pageBeanVo;
            case "备注":
                productInformationVerify.setRemark(text);
                count = productInformationVerifyMapper.selectCountByCriteria(productInformationVerify);
                productInformationVerifyList = productInformationVerifyMapper.selectByCriteria(productInformationVerify, start, end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(productInformationVerifyList);
                return pageBeanVo;
            case "全文索引":
                productInformationVerifyList = productInformationVerifyMapper.selectFullIndex(text,start,end);
                count = productInformationVerifyMapper.selectCountByFullIndex(text);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(productInformationVerifyList);
                return pageBeanVo;
            default:break;
        }
        return null;
    }

    @Override
    public PageBeanVo<ProductInformationVerify> selectByFullIndex(String text, Integer currentPage, Integer perPageRecord) {
        int count = productInformationVerifyMapper.selectCountByFullIndex(text);
        int start = (currentPage-1)*perPageRecord;
        int end = perPageRecord;
        List<ProductInformationVerify> productInformationVerifyList = productInformationVerifyMapper.selectFullIndex(text, start, end);
        PageBeanVo<ProductInformationVerify> pageBeanVo = new PageBeanVo<>();
        pageBeanVo.setBeanList(productInformationVerifyList);
        pageBeanVo.setCurrentPage(currentPage);
        pageBeanVo.setPerPageRecord(perPageRecord);
        pageBeanVo.setTotalRecord(count);
        pageBeanVo.setPageCount(perPageRecord, count);
        return pageBeanVo;
    }

    @Override
    public PageBeanVo<ProductInformationVerify> selectByList(List<Integer> idList, Integer currentPage, Integer perPageRecord) {
        int count = idList.size();
        int start = (currentPage-1)*perPageRecord;
        int end = perPageRecord;
        List<ProductInformationVerify> productInformationVerifyList = productInformationVerifyMapper.selectByList(idList, start, end);
        PageBeanVo<ProductInformationVerify> pageBeanVo = new PageBeanVo<>();
        pageBeanVo.setBeanList(productInformationVerifyList);
        pageBeanVo.setCurrentPage(currentPage);
        pageBeanVo.setPerPageRecord(perPageRecord);
        pageBeanVo.setTotalRecord(count);
        pageBeanVo.setPageCount(perPageRecord, count);
        return pageBeanVo;
    }

    @Override
    public ProductInformationVerify selectByIdAndFtsId(Integer id, Long ftsId) {
        return null;
    }

    @Override
    public ProductInformationVerify selectByProductInformationVerify(ProductInformationVerify productInformationVerify) {
        return productInformationVerifyMapper.selectByProductInformationVerify(productInformationVerify);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return productInformationVerifyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByIdAndFtsId(Integer id, Long ftsId) {
        return productInformationVerifyMapper.deleteByPrimaryKeyAndFtsId(id, ftsId);
    }

    @Override
    public int deleteByProductInformationVerify(ProductInformationVerify productInformationVerify) {
        return productInformationVerifyMapper.deleteByProductInformationVerify(productInformationVerify);
    }
}
