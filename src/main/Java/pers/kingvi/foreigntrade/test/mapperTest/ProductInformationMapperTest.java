package pers.kingvi.foreigntrade.test.mapperTest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import pers.kingvi.foreigntrade.foreigntradesaleman.dao.ProductInformationMapper;
import pers.kingvi.foreigntrade.po.ProductInformation;

import java.io.InputStream;
import java.util.List;

public class ProductInformationMapperTest {
    private ProductInformationMapper productInformationMapper;

    private ProductInformation productInformation;

    private SqlSession sqlSession;

    @Before
    public void setUp() throws Exception {
        String resource = "config/sqlmap-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        productInformationMapper = sqlSession.getMapper(ProductInformationMapper.class);
        productInformation =  new ProductInformation();
    }
    @Test
    public void testInsert() {
        productInformation.setFtsId(9L);
        productInformation.setFtsName("曾庆威啦啦啦啦");
        productInformation.setPhoto("me.png");
        productInformation.setProductName("耳机");
        productInformation.setOrigin("杭州");
        productInformation.setDestination("英国");
        productInformation.setWeight(99.5);
        productInformation.setSendTime("2021-2-14");
        productInformation.setVerifyStatus("0");
        productInformation.setCharger("是");
        productInformation.setRealOrder("否");
        productInformation.setQuoteCount(15);
        productInformationMapper.insert(productInformation);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void insertSelective() {
        productInformation.setFtsId(10L);
        productInformation.setFtsName("合肥工业大学的学生啦");
        productInformation.setPhoto("me.png");
        productInformation.setProductName("筋膜枪");
        productInformation.setOrigin("广州");
        productInformation.setDestination("非洲");
        productInformation.setWeight(99.5);
//        productInformation.setSendTime("2021-2-14");
        productInformation.setVerifyStatus("0");
        productInformation.setCharger("否");
        productInformation.setRealOrder("否");
        productInformation.setQuoteCount(15);
        productInformationMapper.insertSelective(productInformation);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectByPrimaryKey() {
        productInformation = productInformationMapper.selectByPrimaryKey(1);
        System.out.println(productInformation);
    }

    @Test
    public void selectByFtsId() {
        List<ProductInformation> productInformationList = productInformationMapper.selectByFtsId(10L);
        System.out.println(productInformationList);
    }

    @Test
    public void selectByIdAndFtsId() {
        productInformation.setId(2);
        productInformation.setFtsId(10L);
//        ProductInformation productInformation1 =  new ProductInformation();
        productInformation = productInformationMapper.selectByPrimaryKeyAndFtsId(2,10L);
        System.out.println(productInformation);
    }

    @Test
    public void deleteByPrimaryKey() {
        productInformationMapper.deleteByPrimaryKey(4);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteByPrimaryKeyAndFtsId() {
        productInformationMapper.deleteByPrimaryKeyAndFtsId(3,10L);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateByPrimaryKeySelective() {
        productInformation.setId(1);
        productInformation.setFtsName("kingvi");
        productInformationMapper.updateByPrimaryKeySelective(productInformation);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateByPrimaryKey() {
        productInformation.setId(5);
        productInformation.setFtsName("kingvi");
//        productInformation.setName("Kingvi");
        productInformationMapper.updateByPrimaryKey(productInformation);  //出现错误
        sqlSession.commit();
        sqlSession.close();
    }

}
