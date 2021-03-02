package pers.kingvi.foreigntrade.foreigntradesaleman.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.kingvi.foreigntrade.admin.dao.UserMapper;
import pers.kingvi.foreigntrade.foreigntradesaleman.dao.ForeignTradeSalemanMapper;
import pers.kingvi.foreigntrade.foreigntradesaleman.service.ForeignTradeSalemanService;
import pers.kingvi.foreigntrade.po.ForeignTradeSaleman;
import pers.kingvi.foreigntrade.po.User;
import pers.kingvi.foreigntrade.vo.PageBeanVo;
import java.util.List;

@Service
public class ForeignTradeSalemanServiceImpl implements ForeignTradeSalemanService {

    @Autowired
    private ForeignTradeSalemanMapper foreignTradeSalemanMapper;

    @Autowired
    private UserMapper userMapper;
    @Override
    public int insertSelective(ForeignTradeSaleman fts) {
        try {
            User user = userMapper.selectByUserAccount(fts.getAccount());
            if (user == null) {
                foreignTradeSalemanMapper.insertSelective(fts);
                user = new User();
                user.setUserId(fts.getId());
                user.setUserType("外贸员");
                user.setUserAccount(fts.getAccount());
                userMapper.insertSelective(user);
            }
             return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public ForeignTradeSaleman selectByPrimaryKey(Long id) {
        return foreignTradeSalemanMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ForeignTradeSaleman fts) {
        return foreignTradeSalemanMapper.updateByPrimaryKeySelective(fts);
    }

    @Override
    public int closeAccountByFtsId(Long id, String password, String secretSecurity) {
        return foreignTradeSalemanMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        userMapper.deleteByPrimaryKey(id);
        return foreignTradeSalemanMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageBeanVo<ForeignTradeSaleman> selectByParam(String condition, String text, Integer currentPage, Integer perPageRecord) {
        PageBeanVo<ForeignTradeSaleman> pageBeanVo = new PageBeanVo<>();
        int start = (currentPage-1)*perPageRecord;
        int end = perPageRecord;
        List<ForeignTradeSaleman> foreignTradeSalemanList = foreignTradeSalemanMapper.selectByParam(text,start,end);
        int count = foreignTradeSalemanMapper.selectCountByParam(text);
        pageBeanVo.setPerPageRecord(perPageRecord);
        pageBeanVo.setCurrentPage(currentPage);
        pageBeanVo.setPageCount(perPageRecord, count);
        pageBeanVo.setBeanList(foreignTradeSalemanList);
        pageBeanVo.setTotalRecord(count);
        return pageBeanVo;
    }

    @Override
    public PageBeanVo<ForeignTradeSaleman> selectByCriteria(String condition, String text, Integer currentPage, Integer perPageRecord) {
        ForeignTradeSaleman foreignTradeSaleman = new ForeignTradeSaleman();
        List<ForeignTradeSaleman> foreignTradeSalemanList;
        int count;
        int start = (currentPage-1)*perPageRecord;
        int end = perPageRecord;
        PageBeanVo<ForeignTradeSaleman> pageBeanVo = new PageBeanVo<>();
        pageBeanVo.setCurrentPage(currentPage);
        pageBeanVo.setPerPageRecord(perPageRecord);
        switch (condition) {
            case "账号":
                foreignTradeSaleman.setAccount(text);
                count =  foreignTradeSalemanMapper.selectCountByCriteria(foreignTradeSaleman);
                foreignTradeSalemanList = foreignTradeSalemanMapper.selectByCriteria(foreignTradeSaleman, start, end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(foreignTradeSalemanList);
                return pageBeanVo;
            case "公司":
                foreignTradeSaleman.setCompany(text);
                count =  foreignTradeSalemanMapper.selectCountByCriteria(foreignTradeSaleman);
                foreignTradeSalemanList = foreignTradeSalemanMapper.selectByCriteria(foreignTradeSaleman, start, end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(foreignTradeSalemanList);
                return pageBeanVo;
            case "城市":
                foreignTradeSaleman.setCity(text);
                count =  foreignTradeSalemanMapper.selectCountByCriteria(foreignTradeSaleman);
                foreignTradeSalemanList = foreignTradeSalemanMapper.selectByCriteria(foreignTradeSaleman, start, end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(foreignTradeSalemanList);
                return pageBeanVo;
            case "姓名":
                foreignTradeSaleman.setName(text);
                count =  foreignTradeSalemanMapper.selectCountByCriteria(foreignTradeSaleman);
                foreignTradeSalemanList = foreignTradeSalemanMapper.selectByCriteria(foreignTradeSaleman, start, end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(foreignTradeSalemanList);
                return pageBeanVo;
            case "行业":
                foreignTradeSaleman.setIndustry(text);
                count = foreignTradeSalemanMapper.selectCountByCriteria(foreignTradeSaleman);
                foreignTradeSalemanList = foreignTradeSalemanMapper.selectByCriteria(foreignTradeSaleman, start, end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(foreignTradeSalemanList);
                return pageBeanVo;
            case "主要产品":
                foreignTradeSaleman.setMainProduct(text);
                count = foreignTradeSalemanMapper.selectCountByCriteria(foreignTradeSaleman);
                foreignTradeSalemanList = foreignTradeSalemanMapper.selectByCriteria(foreignTradeSaleman, start, end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(foreignTradeSalemanList);
                return pageBeanVo;
            case "微信":
                foreignTradeSaleman.setWeChat(text);
                count = foreignTradeSalemanMapper.selectCountByCriteria(foreignTradeSaleman);
                foreignTradeSalemanList = foreignTradeSalemanMapper.selectByCriteria(foreignTradeSaleman, start, end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(foreignTradeSalemanList);
                return pageBeanVo;
            case "手机":
                foreignTradeSaleman.setPhone(text);
                count = foreignTradeSalemanMapper.selectCountByCriteria(foreignTradeSaleman);
                foreignTradeSalemanList = foreignTradeSalemanMapper.selectByCriteria(foreignTradeSaleman, start, end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(foreignTradeSalemanList);
                return pageBeanVo;
            case "邮件":
                foreignTradeSaleman.setEmail(text);
                count = foreignTradeSalemanMapper.selectCountByCriteria(foreignTradeSaleman);
                foreignTradeSalemanList = foreignTradeSalemanMapper.selectByCriteria(foreignTradeSaleman, start, end);
                pageBeanVo.setTotalRecord(count);
                pageBeanVo.setPageCount(perPageRecord, count);
                pageBeanVo.setBeanList(foreignTradeSalemanList);
                return pageBeanVo;
            default:break;
        }
        return null;
    }

    @Override
    public PageBeanVo<ForeignTradeSaleman> selectFullIndex(String text, Integer currentPage, Integer perPageRecord) {
        int count = foreignTradeSalemanMapper.selectCountByFullIndex(text);
        int start = (currentPage-1)*perPageRecord;
        int end = perPageRecord;
        List<ForeignTradeSaleman> foreignTradeSalemanList = foreignTradeSalemanMapper.selectFullIndex(text, start, end);
        PageBeanVo<ForeignTradeSaleman> pageBeanVo = new PageBeanVo<>();
        pageBeanVo.setBeanList(foreignTradeSalemanList);
        pageBeanVo.setCurrentPage(currentPage);
        pageBeanVo.setPerPageRecord(perPageRecord);
        pageBeanVo.setTotalRecord(count);
        pageBeanVo.setPageCount(perPageRecord, count);
        return pageBeanVo;
    }

    @Override
    public PageBeanVo<ForeignTradeSaleman> selectByList(List<Long> idList, Integer currentPage, Integer perPageRecord) {
        int count = idList.size();
        int start = (currentPage-1)*perPageRecord;
        int end = perPageRecord;
        List<ForeignTradeSaleman> foreignTradeSalemanList = foreignTradeSalemanMapper.selectByList(idList, start, end);
        PageBeanVo<ForeignTradeSaleman> pageBeanVo = new PageBeanVo<>();
        pageBeanVo.setBeanList(foreignTradeSalemanList);
        pageBeanVo.setCurrentPage(currentPage);
        pageBeanVo.setPerPageRecord(perPageRecord);
        pageBeanVo.setTotalRecord(count);
        pageBeanVo.setPageCount(perPageRecord, count);
        return pageBeanVo;
    }
}
