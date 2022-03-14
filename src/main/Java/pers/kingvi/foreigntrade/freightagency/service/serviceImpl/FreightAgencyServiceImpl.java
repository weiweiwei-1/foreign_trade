package pers.kingvi.foreigntrade.freightagency.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.kingvi.foreigntrade.admin.dao.UserMapper;
import pers.kingvi.foreigntrade.freightagency.dao.FreightAgencyMapper;
import pers.kingvi.foreigntrade.freightagency.service.FreightAgencyService;

import pers.kingvi.foreigntrade.po.FreightAgency;
import pers.kingvi.foreigntrade.po.User;
import pers.kingvi.foreigntrade.vo.PageBeanVo;

import java.util.List;

@Service
public class FreightAgencyServiceImpl implements FreightAgencyService {

    @Autowired
    private FreightAgencyMapper freightAgencyMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insertSelective(FreightAgency fa) {
        freightAgencyMapper.insertSelective(fa);
        User user = new User();
        user.setUserId(fa.getId());
        user.setUserType("fa");
        user.setUserAccount(fa.getAccount());
        return userMapper.insertSelective(user);
    }

    @Override
    public FreightAgency selectByPrimaryKey(Long id) {
        return freightAgencyMapper.selectByPrimaryKey(id);
    }

    @Override
    public FreightAgency selectByAccount(String account) {
        return freightAgencyMapper.selectByAccount(account);
    }

    @Override
    public int updateByPrimaryKeySelective(FreightAgency fa) {
        return freightAgencyMapper.updateByPrimaryKeySelective(fa);
    }

    @Override
    public int closeAccountByFaId(Long Id, String password, String secretSecurity) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return freightAgencyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageBeanVo<FreightAgency> selectByParam(String condition, String text, Integer currentPage, Integer perPageRecord) {
        PageBeanVo<FreightAgency> pageBeanVo = new PageBeanVo<>();
        int start = (currentPage-1)*perPageRecord;
        int end = perPageRecord;
        List<FreightAgency> freightAgencyList = freightAgencyMapper.selectByParam(text,start,end);
        int count = freightAgencyMapper.selectCountByParam(text);
        pageBeanVo.setPerPageRecord(perPageRecord);
        pageBeanVo.setCurrentPage(currentPage);
        pageBeanVo.setPageCount(perPageRecord, count);
        pageBeanVo.setBeanList(freightAgencyList);
        pageBeanVo.setTotalRecord(count);
        return pageBeanVo;
    }

    @Override
    public PageBeanVo<FreightAgency> selectByCriteria(String condition, String text, Integer currentPage, Integer perPageRecord) {
        FreightAgency freightAgency = new FreightAgency();
        List<FreightAgency> freightAgencyList;
        int count;
        int start = (currentPage-1)*perPageRecord;
        int end = perPageRecord;
        PageBeanVo<FreightAgency> pageBeanVo = new PageBeanVo<>();
        pageBeanVo.setCurrentPage(currentPage);
        pageBeanVo.setPerPageRecord(perPageRecord);
        switch (condition) {
            case "账号":
                freightAgency.setAccount(text);
                count =  freightAgencyMapper.selectCountByCriteria(freightAgency);
                freightAgencyList = freightAgencyMapper.selectByCriteria(freightAgency, start, end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(freightAgencyList);
                return pageBeanVo;
            case "公司":
                freightAgency.setCompany(text);
                count =  freightAgencyMapper.selectCountByCriteria(freightAgency);
                freightAgencyList = freightAgencyMapper.selectByCriteria(freightAgency, start, end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(freightAgencyList);
                return pageBeanVo;
            case "城市":
                freightAgency.setCity(text);
                count =  freightAgencyMapper.selectCountByCriteria(freightAgency);
                freightAgencyList = freightAgencyMapper.selectByCriteria(freightAgency, start, end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(freightAgencyList);
                return pageBeanVo;
            case "姓名":
                freightAgency.setName(text);
                count =  freightAgencyMapper.selectCountByCriteria(freightAgency);
                freightAgencyList = freightAgencyMapper.selectByCriteria(freightAgency, start, end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(freightAgencyList);
                return pageBeanVo;
            case "行业":
                freightAgency.setMainBussinessScope(text);
                count = freightAgencyMapper.selectCountByCriteria(freightAgency);
                freightAgencyList = freightAgencyMapper.selectByCriteria(freightAgency, start, end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(freightAgencyList);
                return pageBeanVo;
            case "微信":
                freightAgency.setWeChat(text);
                count = freightAgencyMapper.selectCountByCriteria(freightAgency);
                freightAgencyList = freightAgencyMapper.selectByCriteria(freightAgency, start, end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(freightAgencyList);
                return pageBeanVo;
            case "手机":
                freightAgency.setPhone(text);
                count = freightAgencyMapper.selectCountByCriteria(freightAgency);
                freightAgencyList = freightAgencyMapper.selectByCriteria(freightAgency, start, end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(freightAgencyList);
                return pageBeanVo;
            case "邮件":
                freightAgency.setEmail(text);
                count = freightAgencyMapper.selectCountByCriteria(freightAgency);
                freightAgencyList = freightAgencyMapper.selectByCriteria(freightAgency, start, end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(freightAgencyList);
                return pageBeanVo;
            case "全文索引":
                freightAgencyList = freightAgencyMapper.selectByParam(text,start,end);
                count = freightAgencyMapper.selectCountByParam(text);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(freightAgencyList);
                return pageBeanVo;
            default:break;
        }
        return null;
    }

    @Override
    public PageBeanVo<FreightAgency> selectFullIndex(String text, Integer currentPage, Integer perPageRecord) {
        int count = freightAgencyMapper.selectCountByFullIndex(text);
        int start = (currentPage-1)*perPageRecord;
        int end = perPageRecord;
        List<FreightAgency> freightAgencyList = freightAgencyMapper.selectFullIndex(text, start, end);
        PageBeanVo<FreightAgency> pageBeanVo = new PageBeanVo<>();
        pageBeanVo.setBeanList(freightAgencyList);
        pageBeanVo.setCurrentPage(currentPage);
        pageBeanVo.setPerPageRecord(perPageRecord);
        pageBeanVo.setTotalRecord(count);
        pageBeanVo.setPageCount(perPageRecord, count);
        return pageBeanVo;
    }

    @Override
    public PageBeanVo<FreightAgency> selectByList(List<Long> idList, Integer currentPage, Integer perPageRecord) {
        int count = idList.size();
        int start = (currentPage-1)*perPageRecord;
        int end = perPageRecord;
        List<FreightAgency> freightAgencyList = freightAgencyMapper.selectByList(idList, start, end);
        PageBeanVo<FreightAgency> pageBeanVo = new PageBeanVo<>();
        pageBeanVo.setBeanList(freightAgencyList);
        pageBeanVo.setCurrentPage(currentPage);
        pageBeanVo.setPerPageRecord(perPageRecord);
        pageBeanVo.setTotalRecord(count);
        pageBeanVo.setPageCount(perPageRecord, count);
        return pageBeanVo;
    }
}
