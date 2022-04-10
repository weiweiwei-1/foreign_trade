package pers.kingvi.foreigntrade.foreigntradesaleman.service.serviceImpl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.kingvi.foreigntrade.admin.dao.ProductInformationVerifyMapper;
import pers.kingvi.foreigntrade.foreigntradesaleman.dao.ForeignTradeSalemanMapper;
import pers.kingvi.foreigntrade.foreigntradesaleman.dao.ProductInformationMapper;
import pers.kingvi.foreigntrade.foreigntradesaleman.service.ProductInformationService;
import pers.kingvi.foreigntrade.po.ProductInformation;
import pers.kingvi.foreigntrade.po.ProductInformationVerify;
import pers.kingvi.foreigntrade.vo.PageBeanVo;

import java.util.*;

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
    public int selectAllCount() {
        return productInformationMapper.selectAllCount();
    }

    @Override
    public PageBeanVo<ProductInformation> selectByCriteria(java.lang.String condition, java.lang.String text, Integer currentPage, Integer perPageRecord) {
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
    public PageBeanVo<ProductInformation> selectByFullIndex(java.lang.String text, Integer currentPage, Integer perPageRecord) {
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
    public PageBeanVo<ProductInformation> selectByCityRecommend(java.lang.String city, Integer currentPage, Integer perPageRecord) {
        int start = (currentPage - 1) * perPageRecord;
        int end = perPageRecord;
        List<ProductInformation> productInformationList;
        //页面数小于1，
        if (currentPage < 1) {
            return null;
        }
        //总记录数
        int totalCount = productInformationMapper.selectAllCount();
        PageBeanVo<ProductInformation> pageBeanVo = new PageBeanVo<>();
        pageBeanVo.setPageCount(40, totalCount);
        pageBeanVo.setCurrentPage(currentPage);
        if (currentPage > pageBeanVo.getPageCount()) {
            return null;
        }
        if (StringUtils.isBlank(city)) {
            //如果货代未更新地址，即地址为空，则首页显示的是数据库中最新插入的数据
            productInformationList = productInformationMapper.selectByNewestRecord(start, end);
            pageBeanVo.setBeanList(productInformationList);
            return pageBeanVo;
        } else {
            ProductInformation pi = new ProductInformation();
            pi.setOrigin(city);
            productInformationList = productInformationMapper.selectBySelective(pi);
            //如果按照地址查询的数据库记录为空，返回系统默认页面
            if (productInformationList.size() == 0) {
                productInformationList = productInformationMapper.selectByNewestRecord(start, end);
                pageBeanVo.setBeanList(productInformationList);
                return pageBeanVo;
            } else {
                //按城市查询的数据非空
                //非城市查询结果索引开始位置，也即城市查询结果的数值，在城市查询结果后面
                int citySearchCount = productInformationList.size();
                List<Integer> besideList = new ArrayList<>();
                for (ProductInformation productInformation : productInformationList) {
                    besideList.add(productInformation.getId());
                }
                //除城市索引外添加的数据记录
                List<ProductInformation> addList;
                //结果
                List<ProductInformation> res = new ArrayList<>();
                //当前页第一条数据距离起始位置的长度
                int pageStart = start + 1;
                //当前页最后一条数据距离起始位置的长度
                int pageEnd = currentPage * perPageRecord;
                int startIndex;
                //城市搜索最后一条记录在当前页之前
                if (citySearchCount < pageStart) {
                    startIndex = start - citySearchCount;
                    res = productInformationMapper.selectBesideList(besideList, startIndex, perPageRecord);
                }
                //城市搜索最后一条记录在当前页
                if (pageStart <= citySearchCount && citySearchCount <= pageEnd) {
                    List<ProductInformation> cityList = productInformationList.subList(start, citySearchCount);
                    addList = productInformationMapper.selectBesideList(besideList, 0, pageEnd - citySearchCount);
                    if (addList == null) {
                        res = cityList;
                    } else {
                        //合并城市搜索结果和非城市搜索结果
                        Collections.addAll(cityList, addList.toArray(new ProductInformation[0]));
                        res = cityList;
                    }
                }
                //城市搜索最后一条记录在当前页之后
                if (citySearchCount > pageEnd) {
                    res = productInformationList.subList(start, pageEnd);
                }
                pageBeanVo.setBeanList(res);
                //返回页面数据
                return pageBeanVo;
            }
        }

    }

    @Override
    public PageBeanVo<ProductInformation> selectByList(List<Integer> idList, Integer currentPage, Integer perPageRecord) {
        int count = idList.size();
        int start = (currentPage-1) * perPageRecord;
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
