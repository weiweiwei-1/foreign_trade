package pers.kingvi.foreigntrade.freightagency.service.serviceImpl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.kingvi.foreigntrade.admin.dao.FreightAgencyRecommendVerifyMapper;
import pers.kingvi.foreigntrade.freightagency.dao.FreightAgencyMapper;
import pers.kingvi.foreigntrade.freightagency.dao.FreightAgencyRecommendMapper;
import pers.kingvi.foreigntrade.freightagency.service.FreightAgencyRecommendService;
import pers.kingvi.foreigntrade.po.FreightAgencyRecommend;
import pers.kingvi.foreigntrade.po.FreightAgencyRecommendVerify;
import pers.kingvi.foreigntrade.po.ProductInformation;
import pers.kingvi.foreigntrade.vo.PageBeanVo;

import java.util.ArrayList;
import java.util.Collections;
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
    public FreightAgencyRecommend selectByFaIdSingle(Long faId) {
        return freightAgencyRecommendMapper.selectByFaIdSingle(faId);
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

 /*   @Override
    public FreightAgencyRecommend selectByBean(FreightAgencyRecommend freightAgencyRecommend) {
        return freightAgencyRecommendMapper.selectByBean(freightAgencyRecommend);
    }*/

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
    public PageBeanVo<FreightAgencyRecommend> selectByCityRecommend(String city, Integer currentPage, Integer perPageRecord) {
        int start = (currentPage - 1) * perPageRecord;
        int end = perPageRecord;
        List<FreightAgencyRecommend> freightAgencyRecommendList;
        //页面数小于1，返回空
        if (currentPage < 1) {
            return null;
        }
        //总记录数
        int totalCount = freightAgencyRecommendMapper.selectAllCount();
        PageBeanVo<FreightAgencyRecommend> pageBeanVo = new PageBeanVo<>();
        pageBeanVo.setPageCount(perPageRecord, totalCount);
        pageBeanVo.setCurrentPage(currentPage);
        if (currentPage > pageBeanVo.getPageCount()) {
            return null;
        }
        if (StringUtils.isBlank(city)) {
            //若货代未更新地址，即地址为空，则首页显示的是数据库中最新插入的数据(系统默认页面)
            freightAgencyRecommendList = freightAgencyRecommendMapper.selectByNewestRecord(start, end);
            pageBeanVo.setBeanList(freightAgencyRecommendList);
            return pageBeanVo;
        } else {
            FreightAgencyRecommend far = new FreightAgencyRecommend();
            far.setFaCity(city);
            freightAgencyRecommendList = freightAgencyRecommendMapper.selectBySelective(far);
            //若按照地址查询的数据库记录为空，返回系统默认页面
            if (freightAgencyRecommendList.size() == 0) {
                freightAgencyRecommendList = freightAgencyRecommendMapper.selectByNewestRecord(start, end);
                pageBeanVo.setBeanList(freightAgencyRecommendList);
                return pageBeanVo;
            } else {
                //按城市查询的数据非空
                //非城市查询结果索引开始位置，也即城市查询结果的数值，在城市查询结果后面
                int citySearchCount = freightAgencyRecommendList.size();
                List<Integer> besideList = new ArrayList<>();
                for (FreightAgencyRecommend freightAgencyRecommend : freightAgencyRecommendList) {
                    besideList.add(freightAgencyRecommend.getId());
                }
                //除城市索引外添加的数据记录
                List<FreightAgencyRecommend> addList;
                //结果
                List<FreightAgencyRecommend> res = new ArrayList<>();
                //当前页第一条数据距离起始位置的长度
                int pageStart = start + 1;
                //当前页最后一条数据距离起始位置的长度
                int pageEnd = currentPage * perPageRecord;
                int startIndex;
                //城市搜索最后一条记录在当前页之前
                if (citySearchCount < pageStart) {
                    startIndex = start - citySearchCount;
                    res = freightAgencyRecommendMapper.selectBesideList(besideList, startIndex, perPageRecord);
                }
                //城市搜索最后一条记录在当前页
                if (pageStart <= citySearchCount && citySearchCount <= pageEnd) {
                    List<FreightAgencyRecommend> cityList = freightAgencyRecommendList.subList(start, citySearchCount);
                    addList = freightAgencyRecommendMapper.selectBesideList(besideList, 0, pageEnd - citySearchCount);
                    if (addList == null) {
                        res = cityList;
                    } else {
                        //合并城市搜索结果和非城市搜索结果
                        Collections.addAll(cityList, addList.toArray(new FreightAgencyRecommend[0]));
                        res = cityList;
                    }
                }
                //城市搜索最后一条记录在当前页之后
                if (citySearchCount > pageEnd) {
                    res = freightAgencyRecommendList.subList(start, pageEnd);
                }
                pageBeanVo.setBeanList(res);
                //返回页面数据
                return pageBeanVo;
            }
        }
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
        if (count > 0 && count % perPageRecord == 0 && currentPage > count / perPageRecord || count > 0 && count % perPageRecord != 0 && currentPage > count / perPageRecord + 1) {
            return null;
        }
        int start = (currentPage-1) * perPageRecord;
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
