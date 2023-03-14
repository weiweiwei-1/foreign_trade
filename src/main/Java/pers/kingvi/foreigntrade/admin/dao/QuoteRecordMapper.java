package pers.kingvi.foreigntrade.admin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pers.kingvi.foreigntrade.po.ProductInformation;
import pers.kingvi.foreigntrade.po.QuoteRecord;
import pers.kingvi.foreigntrade.po.QuoteRecordExample;

public interface QuoteRecordMapper {
    int countByExample(QuoteRecordExample example);

    int deleteByExample(QuoteRecordExample example);

    int deleteByPrimaryKey(Integer id);    //根据主键删除

    int insert(QuoteRecord record);       //直接插入

    int insertSelective(QuoteRecord record);       //选择插入

//    Long selectFtsIdByFaId(@Param("faId") Long faId);

    List<QuoteRecord> selectByProductIdAndFtsId(@Param("productId") Integer productId, @Param("ftsId") Long ftsId);  //根据产品id和外贸员id查询报价记录，面向的是外贸员,有faId

    List<ProductInformation> selectByFaId(Long faId);      //根据货代id查询产品信息，面向的是货代

    List<QuoteRecord> selectByExampleWithRowbounds(QuoteRecordExample example, RowBounds rowBounds);

    List<QuoteRecord> selectByExample(QuoteRecordExample example);

    QuoteRecord selectByPrimaryKey(Integer id);       //根据主键查询

    QuoteRecord selectByProductIdAndFaId(QuoteRecord quoteRecord);    //查看货代是否已经对货物进行报价

    int updateByExampleSelective(@Param("record") QuoteRecord record, @Param("example") QuoteRecordExample example);

    int updateByExample(@Param("record") QuoteRecord record, @Param("example") QuoteRecordExample example);

    int updateByPrimaryKeySelective(QuoteRecord record);     //基本不用

    int updateByPrimaryKey(QuoteRecord record);         //基本不用
}