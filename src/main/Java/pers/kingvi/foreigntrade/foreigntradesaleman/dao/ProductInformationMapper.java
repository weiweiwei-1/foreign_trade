package pers.kingvi.foreigntrade.foreigntradesaleman.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pers.kingvi.foreigntrade.po.ProductInformation;
import pers.kingvi.foreigntrade.po.ProductInformationExample;

public interface ProductInformationMapper {
    int countByExample(ProductInformationExample example);

    int deleteByExample(ProductInformationExample example);

    int deleteByPrimaryKey(Integer id);   //根据id删除

    int deleteByPrimaryKeyAndFtsId(@Param("id") Integer id, @Param("ftsId") Long ftsId);   //根据id和外贸id删除产品记录

    int deleteByProductInformation(ProductInformation productInformation);

    int insert(ProductInformation record);       //直接插入

    int insertSelective(ProductInformation record);   //选择插入记录

    List<ProductInformation> selectByExampleWithRowbounds(ProductInformationExample example, RowBounds rowBounds);

    List<ProductInformation> selectByExample(ProductInformationExample example);

    ProductInformation selectByPrimaryKey(Integer id);    //根据主键id 查询货物信息

//    ProductInformation selectByPrimaryKeyAndFtsId(@Param("id") Integer id, @Param("ftsId") Long ftsId);   //根据id和货代id查询具体的货物记录

    List<ProductInformation> selectByFtsId(@Param("ftsId") Long ftsId);       //根据外贸id查询所有的货物信息

    ProductInformation selectByPrimaryKeyAndFtsId(@Param("id") Integer id, @Param("ftsId") Long ftsId);       //根据id和货代id查询具体的货物记录

    ProductInformation selectByProductInformation(ProductInformation productInformation);

    int updateByExampleSelective(@Param("record") ProductInformation record, @Param("example") ProductInformationExample example);

    int updateByExample(@Param("record") ProductInformation record, @Param("example") ProductInformationExample example);

    int updateByPrimaryKeySelective(ProductInformation record);      //选择更新记录

    int updateByPrimaryKey(ProductInformation record);          //直接更新记录
}