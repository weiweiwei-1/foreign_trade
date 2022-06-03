package pers.kingvi.foreigntrade.admin.service;

import pers.kingvi.foreigntrade.po.QuoteRecord;
import pers.kingvi.foreigntrade.vo.QuoteRecordProductVo;

import java.util.Map;

public interface QuoteRecordService {
    int insertSelective(QuoteRecord quoteRecord);

    Map<String, String> insertSelectiveReturn(QuoteRecord quoteRecord);

    QuoteRecord selectByPrimaryKey(Integer faId);

    QuoteRecordProductVo selectByFaId(Integer faId);

    int deleteQuoteRecordById(Integer id, Integer faId);
}
