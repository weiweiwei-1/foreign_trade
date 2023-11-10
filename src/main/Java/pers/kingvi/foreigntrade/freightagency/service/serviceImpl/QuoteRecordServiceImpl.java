package pers.kingvi.foreigntrade.freightagency.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.kingvi.foreigntrade.admin.dao.QuoteRecordMapper;
import pers.kingvi.foreigntrade.freightagency.service.FreightAgencyService;
import pers.kingvi.foreigntrade.freightagency.service.QuoteRecordService;
import pers.kingvi.foreigntrade.foreigntradesaleman.dao.ForeignTradeSalemanMapper;
import pers.kingvi.foreigntrade.foreigntradesaleman.dao.ProductInformationMapper;
import pers.kingvi.foreigntrade.freightagency.dao.FreightAgencyMapper;
import pers.kingvi.foreigntrade.po.FreightAgency;
import pers.kingvi.foreigntrade.po.ProductInformation;
import pers.kingvi.foreigntrade.po.QuoteRecord;
import pers.kingvi.foreigntrade.vo.fa.FaQuoteRecordVo;
import pers.kingvi.foreigntrade.vo.fa.QuoteProductVo;
import pers.kingvi.foreigntrade.vo.fa.QuoteRecordProductVo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class QuoteRecordServiceImpl implements QuoteRecordService {

    @Autowired
    private QuoteRecordMapper quoteRecordMapper;

    @Autowired
    private ForeignTradeSalemanMapper foreignTradeSalemanMapper;

    @Autowired
    private ProductInformationMapper productInformationMapper;

    @Autowired
    private FreightAgencyMapper freightAgencyMapper;

    //发送报价，先判断是否报过，然后判断是否报完,
    @Override
    public int insertSelective(QuoteRecord quoteRecord, Long faId) {
        QuoteRecord quoteRecordRes = quoteRecordMapper.selectByProductIdAndFaId(quoteRecord);
        //若已有报价记录，返回-2
        if (quoteRecordRes != null) {
            return -2;
        } else {
            FreightAgency freightAgency = freightAgencyMapper.selectByPrimaryKey(faId);
            //若报价次数已经为0，则返回
            if (freightAgency.getSendQuoteCount() == 0) {
                return -3;
            }
            ProductInformation productInformation = productInformationMapper.selectByPrimaryKey(quoteRecord.getProductId());
            if (productInformation == null) {
                //没有该条产品信息，返回-1
                return -1;
            } else if (productInformation.getQuoteCount() == 0) {
                //产品剩余报价为0，返回0
                return 0;
            } else {
                //未出现任何异常，返回1
                freightAgencyMapper.decreaseSendQuoteCount(faId);
                productInformationMapper.decreaseQuoteCount(quoteRecord.getProductId());
                quoteRecordMapper.insertSelective(quoteRecord);
                return 1;
            }
        }

    }

    @Override
    public Map<String, String> insertSelectiveReturn(QuoteRecord quoteRecord) {
        return null;
    }

    @Override
    public QuoteRecord selectByPrimaryKey(Integer faId) {
        return null;
    }

    @Override
    public QuoteRecord selectByProductIdAndFaId(QuoteRecord quoteRecord) {
        return quoteRecordMapper.selectByProductIdAndFaId(quoteRecord);
    }

    @Override
    public List<FaQuoteRecordVo> selectByFaId(Long faId) {
        List<Long> productIdList = quoteRecordMapper.selectByPidList(faId);
        if (productIdList.size() != 0) {
            List<ProductInformation> productInformationList = productInformationMapper.selectByPidList(productIdList);
            List<FaQuoteRecordVo> faQuoteRecordVoList = new ArrayList<>();
            if (productInformationList.size() != 0) {
                Iterator<ProductInformation> iterator = productInformationList.iterator();
                while (iterator.hasNext()) {
                    ProductInformation productInformation = iterator.next();
                    faQuoteRecordVoList.add(new FaQuoteRecordVo(productInformation.getId(), productInformation.getFtsId(),productInformation.getPhoto(), productInformation.getProductName(), productInformation.getOrigin(), productInformation.getDestinationCountry(), productInformation.getSendTime(), productInformation.getWeight(), productInformation.getRealOrder()));
                }
                return faQuoteRecordVoList;
            }
        }
        return null;
    }

    @Override
    public List<QuoteRecord> selectByProductId(Integer productId) {
        return quoteRecordMapper.selectByProductId(productId);
    }

    @Override
    public List<QuoteProductVo> selectQuoteListByFtsId(Long faId, Long ftsId) {
        return quoteRecordMapper.selectQuoteListByFtsId(faId, ftsId);
    }

    @Override
    public int deleteQuoteRecordById(Integer id, Integer faId) {
        return 0;
    }
}
