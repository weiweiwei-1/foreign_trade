package pers.kingvi.foreigntrade.foreigntradesaleman.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.kingvi.foreigntrade.admin.dao.ForeignTradeSalemanDemandVerifyMapper;
import pers.kingvi.foreigntrade.foreigntradesaleman.dao.ForeignTradeSalemanDemandMapper;
import pers.kingvi.foreigntrade.foreigntradesaleman.dao.ForeignTradeSalemanMapper;
import pers.kingvi.foreigntrade.foreigntradesaleman.service.ForeignTradeSalemanDemandService;
import pers.kingvi.foreigntrade.po.ForeignTradeSalemanDemand;
import pers.kingvi.foreigntrade.po.ForeignTradeSalemanDemandVerify;
import pers.kingvi.foreigntrade.vo.PageBeanVo;
import java.util.List;

@Service
public class ForeignTradeSalemanDemandServiceImpl implements ForeignTradeSalemanDemandService {

    @Autowired
    private ForeignTradeSalemanDemandVerifyMapper foreignTradeSalemanDemandVerifyMapper;

    @Autowired
    private ForeignTradeSalemanMapper foreignTradeSalemanMapper;

    @Autowired
    private ForeignTradeSalemanDemandMapper foreignTradeSalemanDemandMapper;

    @Override
    public int insertSelective(ForeignTradeSalemanDemandVerify ftsd) {
        int status = foreignTradeSalemanMapper.decreaseDemandCount(ftsd.getFtsId());
        if (status == 1) {
            return foreignTradeSalemanDemandVerifyMapper.insertSelective(ftsd);
        }
        return 0;
    }

    @Override
    public ForeignTradeSalemanDemand selectByPrimaryKey(Integer id) {
        return foreignTradeSalemanDemandMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ForeignTradeSalemanDemand> selectByFtsId(Long ftsId) {
        return foreignTradeSalemanDemandMapper.selectByFtsId(ftsId);
    }

    @Override
    public PageBeanVo<ForeignTradeSalemanDemand> selectPageByFtsId(Long ftsId, Integer currentPage, Integer perPageRecord) {
        PageBeanVo<ForeignTradeSalemanDemand> pageBeanVo = new PageBeanVo<>();
        int count = foreignTradeSalemanDemandMapper.selectCountByFtsId(ftsId);
        List<ForeignTradeSalemanDemand> foreignTradeSalemanDemandList = foreignTradeSalemanDemandMapper.selectByFtsId(ftsId);
        pageBeanVo.setBeanList(foreignTradeSalemanDemandList);
        pageBeanVo.setCurrentPage(currentPage);
        pageBeanVo.setPerPageRecord(perPageRecord);
        pageBeanVo.setTotalRecord(count);
        pageBeanVo.setPageCount(perPageRecord, count);
        return pageBeanVo;
    }

    @Override
    public ForeignTradeSalemanDemand selectByPrimaryKeyAndFtsId(Integer id, Long ftsId) {
        return foreignTradeSalemanDemandMapper.selectByPrimaryKeyAndFtsId(id, ftsId);
    }

    @Override
    public ForeignTradeSalemanDemand selectByBean(ForeignTradeSalemanDemand foreignTradeSalemanDemand) {
        return foreignTradeSalemanDemandMapper.selectByBean(foreignTradeSalemanDemand);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return foreignTradeSalemanDemandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByPrimaryKeyAndFtsId(Integer id, Long ftsId) {
        return foreignTradeSalemanDemandMapper.deleteByPrimaryKeyAndFtsId(id, ftsId);
    }

    @Override
    public int deleteByBean(ForeignTradeSalemanDemand foreignTradeSalemanDemand) {
        return foreignTradeSalemanDemandMapper.deleteByBean(foreignTradeSalemanDemand);
    }

    @Override
    public PageBeanVo<ForeignTradeSalemanDemand> selectByCompany(String company, Integer currentPage, Integer perPageRecord) {
        ForeignTradeSalemanDemand foreignTradeSalemanDemand = new ForeignTradeSalemanDemand();
        foreignTradeSalemanDemand.setFtsCompany(company);
        int count = foreignTradeSalemanDemandMapper.selectCountByCriteria(foreignTradeSalemanDemand);
        int start = (currentPage-1)*perPageRecord;
        int end = perPageRecord;
        List<ForeignTradeSalemanDemand> foreignTradeSalemanDemandList = foreignTradeSalemanDemandMapper.selectByCompany(company, start, end);
        PageBeanVo<ForeignTradeSalemanDemand> pageBeanVo = new PageBeanVo<>();
        pageBeanVo.setBeanList(foreignTradeSalemanDemandList);
        pageBeanVo.setCurrentPage(currentPage);
        pageBeanVo.setPerPageRecord(perPageRecord);
        pageBeanVo.setTotalRecord(count);
        pageBeanVo.setPageCount(perPageRecord, count);
        return pageBeanVo;
    }

    @Override
    public PageBeanVo<ForeignTradeSalemanDemand> selectByFtsCity(String city, Integer currentPage, Integer perPageRecord) {
        ForeignTradeSalemanDemand foreignTradeSalemanDemand = new ForeignTradeSalemanDemand();
        foreignTradeSalemanDemand.setFtsCity(city);
        int count = foreignTradeSalemanDemandMapper.selectCountByCriteria(foreignTradeSalemanDemand);
        int start = (currentPage-1)*perPageRecord;
        int end = perPageRecord;
        List<ForeignTradeSalemanDemand> foreignTradeSalemanDemandList = foreignTradeSalemanDemandMapper.selectByCriteria(foreignTradeSalemanDemand, start, end);
        PageBeanVo<ForeignTradeSalemanDemand> pageBeanVo = new PageBeanVo<>();
        pageBeanVo.setBeanList(foreignTradeSalemanDemandList);
        pageBeanVo.setCurrentPage(currentPage);
        pageBeanVo.setPerPageRecord(perPageRecord);
        pageBeanVo.setTotalRecord(count);
        pageBeanVo.setPageCount(perPageRecord, count);
        return pageBeanVo;
    }

    @Override
    public PageBeanVo<ForeignTradeSalemanDemand> selectByMainBusiness(String mainBusiness, Integer currentPage, Integer perPageRecord) {
        ForeignTradeSalemanDemand foreignTradeSalemanDemand = new ForeignTradeSalemanDemand();
        foreignTradeSalemanDemand.setMainBusiness(mainBusiness);
        int count = foreignTradeSalemanDemandMapper.selectCountByCriteria(foreignTradeSalemanDemand);
        int start = (currentPage-1)*perPageRecord;
        int end = perPageRecord;
        List<ForeignTradeSalemanDemand> foreignTradeSalemanDemandList = foreignTradeSalemanDemandMapper.selectByCriteria(foreignTradeSalemanDemand, start, end);
        PageBeanVo<ForeignTradeSalemanDemand> pageBeanVo = new PageBeanVo<>();
        pageBeanVo.setBeanList(foreignTradeSalemanDemandList);
        pageBeanVo.setCurrentPage(currentPage);
        pageBeanVo.setPerPageRecord(perPageRecord);
        pageBeanVo.setTotalRecord(count);
        pageBeanVo.setPageCount(perPageRecord, count);
        return pageBeanVo;
    }

    @Override
    public PageBeanVo<ForeignTradeSalemanDemand> selectByFtsName(String ftsName, Integer currentPage, Integer perPageRecord) {
        ForeignTradeSalemanDemand foreignTradeSalemanDemand = new ForeignTradeSalemanDemand();
        foreignTradeSalemanDemand.setFtsName(ftsName);
        int count = foreignTradeSalemanDemandMapper.selectCountByCriteria(foreignTradeSalemanDemand);
        int start = (currentPage-1)*perPageRecord;
        int end = perPageRecord;
        List<ForeignTradeSalemanDemand> foreignTradeSalemanDemandList = foreignTradeSalemanDemandMapper.selectByCriteria(foreignTradeSalemanDemand, start, end);
        PageBeanVo<ForeignTradeSalemanDemand> pageBeanVo = new PageBeanVo<>();
        pageBeanVo.setBeanList(foreignTradeSalemanDemandList);
        pageBeanVo.setCurrentPage(currentPage);
        pageBeanVo.setPerPageRecord(perPageRecord);
        pageBeanVo.setTotalRecord(count);
        pageBeanVo.setPageCount(perPageRecord, count);
        return pageBeanVo;
    }

    @Override
    public PageBeanVo<ForeignTradeSalemanDemand> selectByCriteria(String condition, String text, Integer currentPage, Integer perPageRecord) {
        ForeignTradeSalemanDemand foreignTradeSalemanDemand = new ForeignTradeSalemanDemand();
        List<ForeignTradeSalemanDemand> foreignTradeSalemanDemandList;
        int count;
        int start = (currentPage-1)*perPageRecord;
        int end = perPageRecord;
        PageBeanVo<ForeignTradeSalemanDemand> pageBeanVo = new PageBeanVo<>();
        pageBeanVo.setCurrentPage(currentPage);
        pageBeanVo.setPerPageRecord(perPageRecord);
        switch (condition) {
            case "公司":
                foreignTradeSalemanDemand.setFtsCompany(text);
                count =  foreignTradeSalemanDemandMapper.selectCountByCriteria(foreignTradeSalemanDemand);
                foreignTradeSalemanDemandList = foreignTradeSalemanDemandMapper.selectByCriteria(foreignTradeSalemanDemand, start, end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(foreignTradeSalemanDemandList);
                return pageBeanVo;
            case "城市":
                foreignTradeSalemanDemand.setFtsCity(text);
                count =  foreignTradeSalemanDemandMapper.selectCountByCriteria(foreignTradeSalemanDemand);
                foreignTradeSalemanDemandList = foreignTradeSalemanDemandMapper.selectByCriteria(foreignTradeSalemanDemand, start, end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(foreignTradeSalemanDemandList);
                return pageBeanVo;
            case "主营业务":
                foreignTradeSalemanDemand.setMainBusiness(text);
                count =  foreignTradeSalemanDemandMapper.selectCountByCriteria(foreignTradeSalemanDemand);
                foreignTradeSalemanDemandList = foreignTradeSalemanDemandMapper.selectByCriteria(foreignTradeSalemanDemand, start, end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(foreignTradeSalemanDemandList);
                return pageBeanVo;
            case "姓名":
                foreignTradeSalemanDemand.setFtsName(text);
                count = foreignTradeSalemanDemandMapper.selectCountByCriteria(foreignTradeSalemanDemand);
                foreignTradeSalemanDemandList = foreignTradeSalemanDemandMapper.selectByCriteria(foreignTradeSalemanDemand, start, end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(foreignTradeSalemanDemandList);
                return pageBeanVo;
            case "全局索引":
                count = foreignTradeSalemanDemandMapper.selectCountByFullIndex(text);
                foreignTradeSalemanDemandList = foreignTradeSalemanDemandMapper.selectFullIndex(text,start,end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(foreignTradeSalemanDemandList);
                return pageBeanVo;
            default:break;
        }
        return null;
    }

    @Override
    public PageBeanVo<ForeignTradeSalemanDemand> selectFullIndex(String text, Integer currentPage, Integer perPageRecord) {
        int count = foreignTradeSalemanDemandMapper.selectCountByFullIndex(text);
        int start = (currentPage-1)*perPageRecord;
        int end = perPageRecord;
        List<ForeignTradeSalemanDemand> foreignTradeSalemanDemandList = foreignTradeSalemanDemandMapper.selectFullIndex(text, start, end);
        PageBeanVo<ForeignTradeSalemanDemand> pageBeanVo = new PageBeanVo<>();
        pageBeanVo.setBeanList(foreignTradeSalemanDemandList);
        pageBeanVo.setCurrentPage(currentPage);
        pageBeanVo.setPerPageRecord(perPageRecord);
        pageBeanVo.setTotalRecord(count);
        pageBeanVo.setPageCount(perPageRecord, count);
        return pageBeanVo;
    }

    @Override
    public PageBeanVo<ForeignTradeSalemanDemand> selectByList(List<Integer> idList, Integer currentPage, Integer perPageRecord) {
        int count = idList.size();
        int start = (currentPage-1)*perPageRecord;
        int end = perPageRecord;
        List<ForeignTradeSalemanDemand> foreignTradeSalemanDemandList = foreignTradeSalemanDemandMapper.selectByList(idList, start, end);
        PageBeanVo<ForeignTradeSalemanDemand> pageBeanVo = new PageBeanVo<>();
        pageBeanVo.setBeanList(foreignTradeSalemanDemandList);
        pageBeanVo.setCurrentPage(currentPage);
        pageBeanVo.setPerPageRecord(perPageRecord);
        pageBeanVo.setTotalRecord(count);
        pageBeanVo.setPageCount(perPageRecord, count);
        return pageBeanVo;
    }
}
