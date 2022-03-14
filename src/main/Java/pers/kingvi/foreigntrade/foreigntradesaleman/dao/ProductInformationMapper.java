package pers.kingvi.foreigntrade.foreigntradesaleman.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pers.kingvi.foreigntrade.po.ForeignTradeSaleman;
import pers.kingvi.foreigntrade.po.FreightAgency;
import pers.kingvi.foreigntrade.po.ProductInformation;
import pers.kingvi.foreigntrade.po.ProductInformationExample;
import pers.kingvi.foreigntrade.vo.PageBeanVo;

//接口方法中，start为数据库查询的limit函数，end为
public interface ProductInformationMapper {
    int countByExample(ProductInformationExample example);

    int deleteByExample(ProductInformationExample example);

    int deleteByPrimaryKey(Integer id);   //根据id删除

    int deleteByPrimaryKeyAndFtsId(@Param("id") Integer id, @Param("ftsId") Long ftsId);   //根据id和外贸id删除产品记录

    int deleteByProductInformation(ProductInformation productInformation);

    int insert(ProductInformation record);       //直接插入

    int insertSelective(ProductInformation record);   //选择插入记录

    int selectAllCount();

    List<ProductInformation> selectByExampleWithRowbounds(ProductInformationExample example, RowBounds rowBounds);

    List<ProductInformation> selectByExample(ProductInformationExample example);

    ProductInformation selectByPrimaryKey(Integer id);    //根据主键id 查询货物信息

//    ProductInformation selectByPrimaryKeyAndFtsId(@Param("id") Integer id, @Param("ftsId") Long ftsId);   //根据id和货代id查询具体的货物记录

    List<ProductInformation> selectByFtsId(@Param("ftsId") Long ftsId);       //根据外贸id查询所有的货物信息

    ProductInformation selectByPrimaryKeyAndFtsId(@Param("id") Integer id, @Param("ftsId") Long ftsId);       //根据id和货代id查询具体的货物记录

    ProductInformation selectByProductInformation(ProductInformation productInformation);        //同上

    List<ProductInformation> selectByCriteria(@Param("pi") ProductInformation pi, @Param("start") Integer start, @Param("end") Integer end);     //根据条件查询页面结果

    List<ProductInformation> selectBySelective(@Param("pi") ProductInformation pi);       //选择字段查询数据库

    List<ProductInformation> selectBesideList(@Param("idList") List<Integer> list, @Param("start") Integer start, @Param("end") Integer end);       //查询不包括列表的数据记录，返回对应的页面，相应函数需根据

    int selectCountByCriteria(@Param("pi") ProductInformation pi);     //根据条件查询页面结果的所有记录数量

    List<ProductInformation> selectFullIndex(@Param("text") String text, @Param("start") Integer start, @Param("end") Integer end);    //全文索引某一页结果

    int selectCountByFullIndex(@Param("text") String text);    //全文索引某一页结果数量

    List<ProductInformation> selectByList(@Param("idList") List<Integer> idList, @Param("start") Integer start, @Param("end") Integer end);   //系统默认页面，随机选择id进行查询，返回对应页数的记录

    List<ProductInformation> selectByNewestRecord(@Param("start") Integer start, @Param("end") Integer end);

    int updateByExampleSelective(@Param("record") ProductInformation record, @Param("example") ProductInformationExample example);

    int updateByExample(@Param("record") ProductInformation record, @Param("example") ProductInformationExample example);

    int updateByPrimaryKeySelective(ProductInformation record);       //选择更新记录

    int updateByPrimaryKey(ProductInformation record);           //直接更新记录

    int decreaseQuoteCount(Integer id);          //减少报价数量


}