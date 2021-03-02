package pers.kingvi.foreigntrade.admin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pers.kingvi.foreigntrade.po.ProductInformationVerify;
import pers.kingvi.foreigntrade.po.ProductInformationVerifyExample;

public interface ProductInformationVerifyMapper {
    int countByExample(ProductInformationVerifyExample example);

    int deleteByExample(ProductInformationVerifyExample example);

    int deleteByPrimaryKey(Integer id);    //根据主键删除

    int insert(ProductInformationVerify record);     //直接插入

    int insertSelective(ProductInformationVerify record);     //选择插入

    List<ProductInformationVerify> selectByExampleWithRowbounds(ProductInformationVerifyExample example, RowBounds rowBounds);

    List<ProductInformationVerify> selectByExample(ProductInformationVerifyExample example);

    ProductInformationVerify selectByPrimaryKey(Integer id);       //根据主键查询

    int updateByExampleSelective(@Param("record") ProductInformationVerify record, @Param("example") ProductInformationVerifyExample example);

    int updateByExample(@Param("record") ProductInformationVerify record, @Param("example") ProductInformationVerifyExample example);

    int updateByPrimaryKeySelective(ProductInformationVerify record);      //选择更新

    int updateByPrimaryKey(ProductInformationVerify record);            //直接更新
}