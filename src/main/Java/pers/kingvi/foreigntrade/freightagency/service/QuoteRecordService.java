package pers.kingvi.foreigntrade.freightagency.service;

import pers.kingvi.foreigntrade.po.QuoteRecord;
import pers.kingvi.foreigntrade.vo.fa.FaQuoteRecordVo;
import pers.kingvi.foreigntrade.vo.fa.QuoteProductVo;
import pers.kingvi.foreigntrade.vo.fa.QuoteRecordProductVo;

import java.util.List;
import java.util.Map;

public interface QuoteRecordService {
    int insertSelective(QuoteRecord quoteRecord, Long faId);

    Map<String, String> insertSelectiveReturn(QuoteRecord quoteRecord);

    List<FaQuoteRecordVo> selectByFaId(Long faId);

    List<QuoteRecord> selectByProductId(Integer productId);

    List<QuoteProductVo> selectQuoteListByFtsId(Long faId, Long ftsId);

    QuoteRecord selectByPrimaryKey(Integer faId);

    QuoteRecord selectByProductIdAndFaId(QuoteRecord quoteRecord);

    int deleteQuoteRecordById(Integer id, Integer faId);

}
