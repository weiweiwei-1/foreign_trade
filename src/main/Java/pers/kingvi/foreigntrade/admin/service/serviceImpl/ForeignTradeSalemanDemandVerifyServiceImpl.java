package pers.kingvi.foreigntrade.admin.service.serviceImpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.kingvi.foreigntrade.admin.dao.ForeignTradeSalemanDemandVerifyMapper;
import pers.kingvi.foreigntrade.admin.service.ForeignTradeSalemanDemandVerifyService;
import pers.kingvi.foreigntrade.foreigntradesaleman.dao.ForeignTradeSalemanDemandMapper;
import pers.kingvi.foreigntrade.po.ForeignTradeSalemanDemand;
import pers.kingvi.foreigntrade.po.ForeignTradeSalemanDemandVerify;
import pers.kingvi.foreigntrade.vo.PageBeanVo;

import java.util.List;
@Service
public class ForeignTradeSalemanDemandVerifyServiceImpl implements ForeignTradeSalemanDemandVerifyService {

    @Autowired
    private ForeignTradeSalemanDemandVerifyMapper foreignTradeSalemanDemandVerifyMapper;

    @Autowired
    private ForeignTradeSalemanDemandMapper foreignTradeSalemanDemandMapper;

    @Override
    public int insertSelective(ForeignTradeSalemanDemandVerify ftsd) {
        ForeignTradeSalemanDemand foreignTradeSalemanDemand = new ForeignTradeSalemanDemand();
        foreignTradeSalemanDemandVerifyMapper.deleteByPrimaryKey(ftsd.getId());
        BeanUtils.copyProperties(ftsd,foreignTradeSalemanDemand);
        foreignTradeSalemanDemand.setVerifyStatus("1");
        return foreignTradeSalemanDemandMapper.insertSelective(foreignTradeSalemanDemand);

    }

    @Override
    public ForeignTradeSalemanDemandVerify selectByPrimaryKey(Integer id) {
        return foreignTradeSalemanDemandVerifyMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ForeignTradeSalemanDemandVerify> selectByFtsId(Long ftsId) {
        return foreignTradeSalemanDemandVerifyMapper.selectByFtsId(ftsId);
    }

    @Override
    public ForeignTradeSalemanDemandVerify selectByBean(ForeignTradeSalemanDemandVerify foreignTradeSalemanDemandVerify) {
        return foreignTradeSalemanDemandVerifyMapper.selectByBean(foreignTradeSalemanDemandVerify);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return foreignTradeSalemanDemandVerifyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByPrimaryKeyAndFtsId(Integer id, Long ftsId) {
        return foreignTradeSalemanDemandVerifyMapper.deleteByPrimaryKeyAndFtsId(id, ftsId);
    }

    @Override
    public int deleteByBean(ForeignTradeSalemanDemandVerify foreignTradeSalemanDemandVerify) {
        return foreignTradeSalemanDemandVerifyMapper.deleteByBean(foreignTradeSalemanDemandVerify);
    }

    @Override
    public PageBeanVo<ForeignTradeSalemanDemandVerify> selectAll(Integer currentPage, Integer perPageRecord) {
        PageBeanVo<ForeignTradeSalemanDemandVerify> pageBeanVo = new PageBeanVo<>();
        int start = (currentPage-1)*perPageRecord;
        int end = perPageRecord;
        int count = foreignTradeSalemanDemandVerifyMapper.selectCountByAll();
        List<ForeignTradeSalemanDemandVerify> foreignTradeSalemanDemandVerifyList = foreignTradeSalemanDemandVerifyMapper.selectAll(start, end);
        pageBeanVo.setBeanList(foreignTradeSalemanDemandVerifyList);
        pageBeanVo.setCurrentPage(currentPage);
        pageBeanVo.setPerPageRecord(perPageRecord);
        pageBeanVo.setTotalRecord(count);
        pageBeanVo.setPageCount(perPageRecord, count);
        return pageBeanVo;
    }

    @Override
    public PageBeanVo<ForeignTradeSalemanDemandVerify> selectByCriteria(String condition, String text, Integer currentPage, Integer perPageRecord) {
        ForeignTradeSalemanDemandVerify foreignTradeSalemanDemandVerify = new ForeignTradeSalemanDemandVerify();
        List<ForeignTradeSalemanDemandVerify> foreignTradeSalemanDemandVerifyList;
        int count;
        int start = (currentPage-1)*perPageRecord;
        int end = perPageRecord;
        PageBeanVo<ForeignTradeSalemanDemandVerify> pageBeanVo = new PageBeanVo<>();
        pageBeanVo.setCurrentPage(currentPage);
        pageBeanVo.setPerPageRecord(perPageRecord);
        switch (condition) {
            case "公司":
                foreignTradeSalemanDemandVerify.setFtsCompany(text);
                count =  foreignTradeSalemanDemandVerifyMapper.selectCountByCriteria(foreignTradeSalemanDemandVerify);
                foreignTradeSalemanDemandVerifyList = foreignTradeSalemanDemandVerifyMapper.selectByCriteria(foreignTradeSalemanDemandVerify, start, end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(foreignTradeSalemanDemandVerifyList);
                return pageBeanVo;
            case "城市":
                foreignTradeSalemanDemandVerify.setFtsCity(text);
                count =  foreignTradeSalemanDemandVerifyMapper.selectCountByCriteria(foreignTradeSalemanDemandVerify);
                foreignTradeSalemanDemandVerifyList = foreignTradeSalemanDemandVerifyMapper.selectByCriteria(foreignTradeSalemanDemandVerify, start, end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(foreignTradeSalemanDemandVerifyList);
                return pageBeanVo;
            case "主营业务":
                foreignTradeSalemanDemandVerify.setMainBusiness(text);
                count =  foreignTradeSalemanDemandVerifyMapper.selectCountByCriteria(foreignTradeSalemanDemandVerify);
                foreignTradeSalemanDemandVerifyList = foreignTradeSalemanDemandVerifyMapper.selectByCriteria(foreignTradeSalemanDemandVerify, start, end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(foreignTradeSalemanDemandVerifyList);
                return pageBeanVo;
            case "姓名":
                foreignTradeSalemanDemandVerify.setFtsName(text);
                count = foreignTradeSalemanDemandVerifyMapper.selectCountByCriteria(foreignTradeSalemanDemandVerify);
                foreignTradeSalemanDemandVerifyList = foreignTradeSalemanDemandVerifyMapper.selectByCriteria(foreignTradeSalemanDemandVerify, start, end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(foreignTradeSalemanDemandVerifyList);
                return pageBeanVo;
            case "全局索引":
                count = foreignTradeSalemanDemandVerifyMapper.selectCountByFullIndex(text);
                foreignTradeSalemanDemandVerifyList = foreignTradeSalemanDemandVerifyMapper.selectFullIndex(text,start,end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(foreignTradeSalemanDemandVerifyList);
                return pageBeanVo;
            default:break;
        }
        return null;
    }

    @Override
    public PageBeanVo<ForeignTradeSalemanDemandVerify> selectFullIndex(String text, Integer currentPage, Integer perPageRecord) {
        return null;
    }

    @Override
    public PageBeanVo<ForeignTradeSalemanDemandVerify> selectByList(List<Integer> idList, Integer currentPage, Integer perPageRecord) {
        return null;
    }
}
