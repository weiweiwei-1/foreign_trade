package pers.kingvi.foreigntrade.admin.service.serviceImpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.kingvi.foreigntrade.admin.dao.FreightAgencyRecommendVerifyMapper;
import pers.kingvi.foreigntrade.admin.service.FreightAgencyRecommendVerifyService;
import pers.kingvi.foreigntrade.freightagency.dao.FreightAgencyRecommendMapper;
import pers.kingvi.foreigntrade.po.FreightAgencyRecommend;
import pers.kingvi.foreigntrade.po.FreightAgencyRecommendVerify;
import pers.kingvi.foreigntrade.vo.PageBeanVo;
import java.util.List;

@Service
public class FreightAgencyRecommendVerifyServiceImpl implements FreightAgencyRecommendVerifyService {

    @Autowired
    private FreightAgencyRecommendVerifyMapper freightAgencyRecommendVerifyMapper;

    @Autowired
    private FreightAgencyRecommendMapper freightAgencyRecommendMapper;

    @Override
    public int insertSelective(FreightAgencyRecommendVerify farv) {
        FreightAgencyRecommend freightAgencyRecommend = new FreightAgencyRecommend();
        freightAgencyRecommendVerifyMapper.deleteByPrimaryKey(farv.getId());
        BeanUtils.copyProperties(farv,freightAgencyRecommend);
        freightAgencyRecommend.setVerifyStatus("1");
        return freightAgencyRecommendMapper.insertSelective(freightAgencyRecommend);
    }

    @Override
    public FreightAgencyRecommendVerify selectByPrimaryKey(Integer id) {
        return freightAgencyRecommendVerifyMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<FreightAgencyRecommendVerify> selectByFaId(Long faId) {
        return freightAgencyRecommendVerifyMapper.selectByFaId(faId);
    }

    @Override
    public PageBeanVo<FreightAgencyRecommendVerify> selectPageByFaId(Long faId, Integer currentPage, Integer perPageRecord) {
        PageBeanVo<FreightAgencyRecommendVerify> pageBeanVo = new PageBeanVo<>();
        int count = freightAgencyRecommendVerifyMapper.selectCountByFaId(faId);
        List<FreightAgencyRecommendVerify> freightAgencyRecommendVerifyList = freightAgencyRecommendVerifyMapper.selectByFaId(faId);
        pageBeanVo.setBeanList(freightAgencyRecommendVerifyList);
        pageBeanVo.setCurrentPage(currentPage);
        pageBeanVo.setPerPageRecord(perPageRecord);
        pageBeanVo.setTotalRecord(count);
        pageBeanVo.setPageCount(perPageRecord, count);
        return pageBeanVo;
    }

    @Override
    public FreightAgencyRecommendVerify selectByPrimaryKeyAndFaId(Integer id, Long faId) {
        return freightAgencyRecommendVerifyMapper.selectByPrimaryKeyAndFaId(id, faId);
    }

    @Override
    public FreightAgencyRecommendVerify selectByBean(FreightAgencyRecommendVerify freightAgencyRecommendVerify) {
        return freightAgencyRecommendVerifyMapper.selectByBean(freightAgencyRecommendVerify);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return freightAgencyRecommendVerifyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByPrimaryKeyAndFaId(Integer id, Long faId) {
        return freightAgencyRecommendVerifyMapper.deleteByPrimaryKeyAndFaId(id, faId);
    }

    @Override
    public int deleteByBean(FreightAgencyRecommendVerify freightAgencyRecommendVerify) {
        return freightAgencyRecommendVerifyMapper.deleteByBean(freightAgencyRecommendVerify);
    }

    @Override
    public PageBeanVo<FreightAgencyRecommendVerify> selectByCriteria(String condition, String text, Integer currentPage, Integer perPageRecord) {
        FreightAgencyRecommendVerify freightAgencyRecommendVerify = new FreightAgencyRecommendVerify();
        List<FreightAgencyRecommendVerify> freightAgencyRecommendVerifyList;
        int count;
        int start = (currentPage-1)*perPageRecord;
        int end = perPageRecord;
        PageBeanVo<FreightAgencyRecommendVerify> pageBeanVo = new PageBeanVo<>();
        pageBeanVo.setCurrentPage(currentPage);
        pageBeanVo.setPerPageRecord(perPageRecord);
        switch (condition) {
            case "姓名":
                freightAgencyRecommendVerify.setFaName(text);
                count =  freightAgencyRecommendVerifyMapper.selectCountByCriteria(freightAgencyRecommendVerify);
                freightAgencyRecommendVerifyList = freightAgencyRecommendVerifyMapper.selectByCriteria(freightAgencyRecommendVerify, start, end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(freightAgencyRecommendVerifyList);
                return pageBeanVo;
            case "公司":
                freightAgencyRecommendVerify.setFaCompany(text);
                count =  freightAgencyRecommendVerifyMapper.selectCountByCriteria(freightAgencyRecommendVerify);
                freightAgencyRecommendVerifyList = freightAgencyRecommendVerifyMapper.selectByCriteria(freightAgencyRecommendVerify, start, end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(freightAgencyRecommendVerifyList);
                return pageBeanVo;
            case "城市":
                freightAgencyRecommendVerify.setFaName(text);
                count =  freightAgencyRecommendVerifyMapper.selectCountByCriteria(freightAgencyRecommendVerify);
                freightAgencyRecommendVerifyList = freightAgencyRecommendVerifyMapper.selectByCriteria(freightAgencyRecommendVerify, start, end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(freightAgencyRecommendVerifyList);
                return pageBeanVo;
            case "主营业务":
                freightAgencyRecommendVerify.setMainBusiness(text);
                count =  freightAgencyRecommendVerifyMapper.selectCountByCriteria(freightAgencyRecommendVerify);
                freightAgencyRecommendVerifyList = freightAgencyRecommendVerifyMapper.selectByCriteria(freightAgencyRecommendVerify, start, end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(freightAgencyRecommendVerifyList);
                return pageBeanVo;
            case "关键词":
                freightAgencyRecommendVerify.setKeyWords(text);
                count = freightAgencyRecommendVerifyMapper.selectCountByCriteria(freightAgencyRecommendVerify);
                freightAgencyRecommendVerifyList = freightAgencyRecommendVerifyMapper.selectByCriteria(freightAgencyRecommendVerify, start, end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(freightAgencyRecommendVerifyList);
                return pageBeanVo;
            case "全局索引":
                count = freightAgencyRecommendVerifyMapper.selectCountByFullIndex(text);
                freightAgencyRecommendVerifyList = freightAgencyRecommendVerifyMapper.selectFullIndex(text,start,end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(freightAgencyRecommendVerifyList);
                return pageBeanVo;
            default:break;
        }
        return null;
    }

    @Override
    public PageBeanVo<FreightAgencyRecommendVerify> selectFullIndex(String text, Integer currentPage, Integer perPageRecord) {
        int count = freightAgencyRecommendVerifyMapper.selectCountByFullIndex(text);
        int start = (currentPage-1)*perPageRecord;
        int end = perPageRecord;
        List<FreightAgencyRecommendVerify> freightAgencyRecommendVerifyList = freightAgencyRecommendVerifyMapper.selectFullIndex(text, start, end);
        PageBeanVo<FreightAgencyRecommendVerify> pageBeanVo = new PageBeanVo<>();
        pageBeanVo.setBeanList(freightAgencyRecommendVerifyList);
        pageBeanVo.setCurrentPage(currentPage);
        pageBeanVo.setPerPageRecord(perPageRecord);
        pageBeanVo.setTotalRecord(count);
        pageBeanVo.setPageCount(perPageRecord, count);
        return pageBeanVo;
    }

    @Override
    public PageBeanVo<FreightAgencyRecommendVerify> selectByList(List<Integer> idList, Integer currentPage, Integer perPageRecord) {
        int count = idList.size();
        int start = (currentPage-1)*perPageRecord;
        int end = perPageRecord;
        List<FreightAgencyRecommendVerify> freightAgencyRecommendVerifyList = freightAgencyRecommendVerifyMapper.selectByList(idList, start, end);
        PageBeanVo<FreightAgencyRecommendVerify> pageBeanVo = new PageBeanVo<>();
        pageBeanVo.setBeanList(freightAgencyRecommendVerifyList);
        pageBeanVo.setCurrentPage(currentPage);
        pageBeanVo.setPerPageRecord(perPageRecord);
        pageBeanVo.setTotalRecord(count);
        pageBeanVo.setPageCount(perPageRecord, count);
        return pageBeanVo;
    }
}
