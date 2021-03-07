package pers.kingvi.foreigntrade.freightagency.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.kingvi.foreigntrade.admin.dao.FreightAgencyRecommendVerifyMapper;
import pers.kingvi.foreigntrade.freightagency.dao.FreightAgencyMapper;
import pers.kingvi.foreigntrade.freightagency.dao.FreightAgencyRecommendMapper;
import pers.kingvi.foreigntrade.freightagency.service.FreightAgencyRecommendService;
import pers.kingvi.foreigntrade.po.FreightAgencyRecommend;
import pers.kingvi.foreigntrade.po.FreightAgencyRecommendVerify;
import pers.kingvi.foreigntrade.vo.PageBeanVo;

import java.util.List;

@Service
public class FreightAgencyRecommendServiceImpl implements FreightAgencyRecommendService {

    @Autowired
    private FreightAgencyRecommendMapper freightAgencyRecommendMapper;

    @Autowired
    private FreightAgencyRecommendVerifyMapper freightAgencyRecommendVerifyMapper;

    @Autowired
    private FreightAgencyMapper freightAgencyMapper;

    @Override
    public int insertSelective(FreightAgencyRecommendVerify farv) {
        int status = freightAgencyMapper.decreaseAdvertiseCount(farv.getFaId());
        if (status == 1) {
            return freightAgencyRecommendVerifyMapper.insertSelective(farv);
        }
        return 0;
    }

    @Override
    public FreightAgencyRecommend selectByPrimaryKey(Integer id) {
        return freightAgencyRecommendMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<FreightAgencyRecommend> selectByFaId(Long faId) {
        return freightAgencyRecommendMapper.selectByFaId(faId);
    }

    @Override
    public PageBeanVo<FreightAgencyRecommend> selectPageByFaId(Long faId, Integer currentPage, Integer perPageRecord) {
        PageBeanVo<FreightAgencyRecommend> pageBeanVo = new PageBeanVo<>();
        int count = freightAgencyRecommendMapper.selectCountByFaId(faId);
        List<FreightAgencyRecommend> freightAgencyRecommendList = freightAgencyRecommendMapper.selectByFaId(faId);
        pageBeanVo.setBeanList(freightAgencyRecommendList);
        pageBeanVo.setCurrentPage(currentPage);
        pageBeanVo.setPerPageRecord(perPageRecord);
        pageBeanVo.setTotalRecord(count);
        pageBeanVo.setPageCount(perPageRecord, count);
        return pageBeanVo;
    }

    @Override
    public FreightAgencyRecommend selectByPrimaryKeyAndFaId(Integer id, Long faId) {
        return freightAgencyRecommendMapper.selectByPrimaryKeyAndFaId(id, faId);
    }

    @Override
    public FreightAgencyRecommend selectByBean(FreightAgencyRecommend freightAgencyRecommend) {
        return freightAgencyRecommendMapper.selectByBean(freightAgencyRecommend);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return freightAgencyRecommendMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByPrimaryKeyAndFaId(Integer id, Long faId) {
        return freightAgencyRecommendMapper.deleteByIdAndFaId(id,faId);
    }

    @Override
    public int deleteByBean(FreightAgencyRecommend freightAgencyRecommend) {
        return freightAgencyRecommendMapper.deleteByBean(freightAgencyRecommend);
    }

    @Override
    public PageBeanVo<FreightAgencyRecommend> selectByCriteria(String condition, String text, Integer currentPage, Integer perPageRecord) {
        FreightAgencyRecommend freightAgencyRecommend = new FreightAgencyRecommend();
        List<FreightAgencyRecommend> freightAgencyRecommendList;
        int count;
        int start = (currentPage-1)*perPageRecord;
        int end = perPageRecord;
        PageBeanVo<FreightAgencyRecommend> pageBeanVo = new PageBeanVo<>();
        pageBeanVo.setCurrentPage(currentPage);
        pageBeanVo.setPerPageRecord(perPageRecord);
        switch (condition) {
            case "姓名":
                freightAgencyRecommend.setFaName(text);
                count =  freightAgencyRecommendMapper.selectCountByCriteria(freightAgencyRecommend);
                freightAgencyRecommendList = freightAgencyRecommendMapper.selectByCriteria(freightAgencyRecommend, start, end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(freightAgencyRecommendList);
                return pageBeanVo;
            case "公司":
                freightAgencyRecommend.setFaCompany(text);
                count =  freightAgencyRecommendMapper.selectCountByCriteria(freightAgencyRecommend);
                freightAgencyRecommendList = freightAgencyRecommendMapper.selectByCriteria(freightAgencyRecommend, start, end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(freightAgencyRecommendList);
                return pageBeanVo;
            case "城市":
                freightAgencyRecommend.setFaName(text);
                count =  freightAgencyRecommendMapper.selectCountByCriteria(freightAgencyRecommend);
                freightAgencyRecommendList = freightAgencyRecommendMapper.selectByCriteria(freightAgencyRecommend, start, end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(freightAgencyRecommendList);
                return pageBeanVo;
            case "主营业务":
                freightAgencyRecommend.setMainBusiness(text);
                count =  freightAgencyRecommendMapper.selectCountByCriteria(freightAgencyRecommend);
                freightAgencyRecommendList = freightAgencyRecommendMapper.selectByCriteria(freightAgencyRecommend, start, end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(freightAgencyRecommendList);
                return pageBeanVo;
            case "关键词":
                freightAgencyRecommend.setKeyWords(text);
                count = freightAgencyRecommendMapper.selectCountByCriteria(freightAgencyRecommend);
                freightAgencyRecommendList = freightAgencyRecommendMapper.selectByCriteria(freightAgencyRecommend, start, end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(freightAgencyRecommendList);
                return pageBeanVo;
            case "全局索引":
                count = freightAgencyRecommendMapper.selectCountByFullIndex(text);
                freightAgencyRecommendList = freightAgencyRecommendMapper.selectFullIndex(text,start,end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(freightAgencyRecommendList);
                return pageBeanVo;
            default:break;
        }
        return null;
    }

    @Override
    public PageBeanVo<FreightAgencyRecommend> selectFullIndex(String text, Integer currentPage, Integer perPageRecord) {
        int count = freightAgencyRecommendMapper.selectCountByFullIndex(text);
        int start = (currentPage-1)*perPageRecord;
        int end = perPageRecord;
        List<FreightAgencyRecommend> freightAgencyRecommendList = freightAgencyRecommendMapper.selectFullIndex(text, start, end);
        PageBeanVo<FreightAgencyRecommend> pageBeanVo = new PageBeanVo<>();
        pageBeanVo.setBeanList(freightAgencyRecommendList);
        pageBeanVo.setCurrentPage(currentPage);
        pageBeanVo.setPerPageRecord(perPageRecord);
        pageBeanVo.setTotalRecord(count);
        pageBeanVo.setPageCount(perPageRecord, count);
        return pageBeanVo;
    }

    @Override
    public PageBeanVo<FreightAgencyRecommend> selectByList(List<Integer> idList, Integer currentPage, Integer perPageRecord) {
        int count = idList.size();
        int start = (currentPage-1)*perPageRecord;
        int end = perPageRecord;
        List<FreightAgencyRecommend> freightAgencyRecommendList = freightAgencyRecommendMapper.selectByList(idList, start, end);
        PageBeanVo<FreightAgencyRecommend> pageBeanVo = new PageBeanVo<>();
        pageBeanVo.setBeanList(freightAgencyRecommendList);
        pageBeanVo.setCurrentPage(currentPage);
        pageBeanVo.setPerPageRecord(perPageRecord);
        pageBeanVo.setTotalRecord(count);
        pageBeanVo.setPageCount(perPageRecord, count);
        return pageBeanVo;
    }
}
