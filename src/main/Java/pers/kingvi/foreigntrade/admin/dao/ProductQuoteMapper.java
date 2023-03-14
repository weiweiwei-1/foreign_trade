package pers.kingvi.foreigntrade.admin.dao;

import org.apache.ibatis.annotations.Param;
import pers.kingvi.foreigntrade.vo.fa.QuoteRecordProductVo;

import java.util.List;

public interface ProductQuoteMapper {
    //连接查询，全表扫描，后续需要进行优化
    List<QuoteRecordProductVo> selectByFtsIdAndFaId(@Param("ftsId") Long ftsId, @Param("faId") Long faId);
}
