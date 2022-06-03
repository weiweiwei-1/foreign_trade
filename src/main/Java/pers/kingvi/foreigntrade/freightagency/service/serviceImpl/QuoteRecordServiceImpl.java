package pers.kingvi.foreigntrade.admin.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.kingvi.foreigntrade.admin.dao.QuoteRecordMapper;
import pers.kingvi.foreigntrade.admin.service.QuoteRecordService;
import pers.kingvi.foreigntrade.foreigntradesaleman.dao.ForeignTradeSalemanMapper;
import pers.kingvi.foreigntrade.foreigntradesaleman.dao.ProductInformationMapper;
import pers.kingvi.foreigntrade.freightagency.dao.FreightAgencyMapper;
import pers.kingvi.foreigntrade.po.ForeignTradeSaleman;
import pers.kingvi.foreigntrade.po.ProductInformation;
import pers.kingvi.foreigntrade.po.QuoteRecord;
import pers.kingvi.foreigntrade.vo.QuoteRecordProductVo;

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

    //发送报价，先判断是否报过，然后判断是否报完，这是面向货代fa来说的
    @Override
    public int insertSelective(QuoteRecord quoteRecord) {
        QuoteRecord quoteRecord1 = quoteRecordMapper.selectByProductIdAndFaId(quoteRecord);
        if (quoteRecord1 != null) {
            return 0;
        } else {
            ProductInformation productInformation = productInformationMapper.selectByPrimaryKey(quoteRecord.getProductId());
            if (productInformation.getQuoteCount() >= 10) {
                return 0;
            } else {
                quoteRecordMapper.insert(quoteRecord);
                productInformationMapper.decreaseQuoteCount(quoteRecord.getProductId());
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
    public QuoteRecordProductVo selectByFaId(Integer faId) {
        return null;
    }

    @Override
    public int deleteQuoteRecordById(Integer id, Integer faId) {
        return 0;
    }
}
