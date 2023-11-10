package pers.kingvi.foreigntrade.admin.service.serviceImpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.kingvi.foreigntrade.admin.dao.FreightAgencyRecommendVerifyMapper;
import pers.kingvi.foreigntrade.admin.service.FreightAgencyRecommendVerifyService;
import pers.kingvi.foreigntrade.freightagency.dao.FreightAgencyRecommendMapper;
import pers.kingvi.foreigntrade.po.FreightAgencyRecommend;
import pers.kingvi.foreigntrade.po.FreightAgencyRecommendVerify;
import pers.kingvi.foreigntrade.util.FileSet;
import pers.kingvi.foreigntrade.vo.PageBeanVo;

import java.io.File;
import java.util.List;

@Service
public class FreightAgencyRecommendVerifyServiceImpl implements FreightAgencyRecommendVerifyService {

    @Autowired
    private FreightAgencyRecommendVerifyMapper freightAgencyRecommendVerifyMapper;

    @Autowired
    private FreightAgencyRecommendMapper freightAgencyRecommendMapper;

    @Override
    public int insertSelective(FreightAgencyRecommendVerify farv) {
        return freightAgencyRecommendVerifyMapper.insertSelective(farv);
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
    public FreightAgencyRecommendVerify selectByFaIdSingle(Long faId) {
        return freightAgencyRecommendVerifyMapper.selectByFaIdSingle(faId);
    }

    @Override
    public List<FreightAgencyRecommendVerify> selectAll() {
        return freightAgencyRecommendVerifyMapper.selectAll();
    }

    @Override
    public int updateByFaId(FreightAgencyRecommendVerify freightAgencyRecommendVerify) {
        return freightAgencyRecommendVerifyMapper.updateByFaIdSelective(freightAgencyRecommendVerify);
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
    public int permitFaRecommend(Integer id, Long faId) {
        FreightAgencyRecommendVerify freightAgencyRecommendVerify = freightAgencyRecommendVerifyMapper.selectByPrimaryKey(id);
        if (freightAgencyRecommendVerify == null) {
            return 0;
        } else {
            FreightAgencyRecommend freightAgencyRecommend = freightAgencyRecommendMapper.selectByFaIdSingle(faId);
//            通过审核的记录为空
            String fileName = freightAgencyRecommendVerify.getActivityPhoto();
            File originFile = new File(FileSet.RECOMMEND_VERIFY_PATH + fileName);
            File aimFile = new File(FileSet.RECOMMEND_PATH + fileName);
            if (freightAgencyRecommend == null) {
                freightAgencyRecommend = new FreightAgencyRecommend();
                BeanUtils.copyProperties(freightAgencyRecommendVerify, freightAgencyRecommend);
                freightAgencyRecommend.setVerifyStatus("1");
                freightAgencyRecommend.setId(null);
                freightAgencyRecommendMapper.insertSelective(freightAgencyRecommend);
                freightAgencyRecommendVerifyMapper.deleteByPrimaryKey(freightAgencyRecommendVerify.getId());
                originFile.renameTo(aimFile);
                return 1;
            } else {
                Integer formerId = freightAgencyRecommend.getId();
                String oldFileName = freightAgencyRecommend.getActivityPhoto();
                BeanUtils.copyProperties(freightAgencyRecommendVerify, freightAgencyRecommend);
                freightAgencyRecommend.setId(formerId);
                freightAgencyRecommendMapper.updateByPrimaryKeySelective(freightAgencyRecommend);
                freightAgencyRecommendVerifyMapper.deleteByPrimaryKey(freightAgencyRecommendVerify.getId());
//                    审核通过磁盘和审核磁盘有相同文件名，则只需删除审核中磁盘记录即可
                if (aimFile.exists() && originFile.exists()) {
                    originFile.delete();
                } else {
//                    将审核磁盘对应的文件移动到审核通过磁盘
                    if (originFile.exists()) {
                        originFile.renameTo(aimFile);
                    }
                    File oldFile = new File(FileSet.RECOMMEND_VERIFY_PATH + oldFileName);
//                    将原审核通过的文件删除
                    oldFile.delete();
                }
                return 1;
            }
        }
    }

    @Override
    public int rejectRecommend(Integer id) {
        FreightAgencyRecommendVerify freightAgencyRecommendVerify = freightAgencyRecommendVerifyMapper.selectByPrimaryKey(id);
        if (freightAgencyRecommendVerify == null) {
            return 0;
        }
        String photo = freightAgencyRecommendVerify.getActivityPhoto();
        File file = new File(FileSet.RECOMMEND_VERIFY_PATH + photo);
        freightAgencyRecommendVerifyMapper.deleteByPrimaryKey(id);
        file.delete();
        return 1;
    }

    @Override
    public PageBeanVo<FreightAgencyRecommendVerify> selectByCriteria(String condition, String text, Integer currentPage, Integer perPageRecord) {
        FreightAgencyRecommendVerify freightAgencyRecommendVerify = new FreightAgencyRecommendVerify();
        List<FreightAgencyRecommendVerify> freightAgencyRecommendVerifyList;
        int count;
        int start = (currentPage-1) * perPageRecord;
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
