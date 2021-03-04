package pers.kingvi.foreigntrade.admin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pers.kingvi.foreigntrade.po.ProductInformation;
import pers.kingvi.foreigntrade.po.ProductInformationVerify;
import pers.kingvi.foreigntrade.po.ProductInformationVerifyExample;

public interface ProductInformationVerifyMapper {
    int countByExample(ProductInformationVerifyExample example);

    int deleteByExample(ProductInformationVerifyExample example);

    int deleteByPrimaryKey(Integer id);       //根据主键删除

    int deleteByPrimaryKeyAndFtsId(@Param("id") Integer id, @Param("ftsId") Long ftsId);      //根据id和外贸id删除产品记录

    int deleteByProductInformationVerify(ProductInformationVerify productInformationVerify);

    int insert(ProductInformationVerify record);     //直接插入

    int insertSelective(ProductInformationVerify record);     //选择插入

    List<ProductInformationVerify> selectByFtsId(@Param("ftsId") Long ftsId);       //根据外贸id查询所有的货物信息

    ProductInformationVerify selectByPrimaryKeyAndFtsId(@Param("id") Integer id, @Param("ftsId") Long ftsId);       //根据id和货代id查询具体的货物记录

    ProductInformationVerify selectByProductInformationVerify(ProductInformationVerify productInformationVerify);        //同上

    List<ProductInformationVerify> selectByCriteria(@Param("pi") ProductInformationVerify pi, @Param("start") Integer start, @Param("end") Integer end);     //根据条件查询页面结果

    int selectCountByCriteria(@Param("pi") ProductInformationVerify productInformationVerify);     //根据条件查询页面结果数量

    List<ProductInformationVerify> selectFullIndex(@Param("text") String text, @Param("start") Integer start, @Param("end") Integer end);    //全文索引某一页结果

    int selectCountByFullIndex(@Param("text") String text);       //全文索引某一页结果数量

    List<ProductInformationVerify> selectByList(@Param("idList") List<Integer> idList, @Param("start") Integer start, @Param("end") Integer end);   //随机选择某一页，系统随机匹配

    List<ProductInformationVerify> selectByExampleWithRowbounds(ProductInformationVerifyExample example, RowBounds rowBounds);

    List<ProductInformationVerify> selectByExample(ProductInformationVerifyExample example);

    ProductInformationVerify selectByPrimaryKey(Integer id);       //根据主键查询

    int updateByExampleSelective(@Param("record") ProductInformationVerify record, @Param("example") ProductInformationVerifyExample example);

    int updateByExample(@Param("record") ProductInformationVerify record, @Param("example") ProductInformationVerifyExample example);

    int updateByPrimaryKeySelective(ProductInformationVerify record);      //选择更新

    int updateByPrimaryKey(ProductInformationVerify record);            //直接更新
}