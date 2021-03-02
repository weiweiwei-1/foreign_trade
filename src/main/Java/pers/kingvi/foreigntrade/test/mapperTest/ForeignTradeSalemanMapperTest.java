package pers.kingvi.foreigntrade.test.mapperTest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.kingvi.foreigntrade.foreigntradesaleman.dao.ForeignTradeSalemanDemandMapper;
import pers.kingvi.foreigntrade.foreigntradesaleman.dao.ForeignTradeSalemanMapper;
import pers.kingvi.foreigntrade.po.ForeignTradeSaleman;

import java.io.InputStream;


public class ForeignTradeSalemanMapperTest {

    private ForeignTradeSalemanMapper foreignTradeSalemanMapper;

    private ForeignTradeSaleman foreignTradeSaleman;

    private SqlSession sqlSession;

    @Before
    public void setUp() throws Exception {
        String resource = "config/sqlmap-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        foreignTradeSalemanMapper = sqlSession.getMapper(ForeignTradeSalemanMapper.class);
        foreignTradeSaleman =  new ForeignTradeSaleman();
    }
    @Test
    public void testInsert() {
        foreignTradeSaleman.setId(15L);
        foreignTradeSaleman.setAccount("125511124");
        foreignTradeSaleman.setCompany("海康");
        foreignTradeSaleman.setName("曾庆威");
        foreignTradeSaleman.setCity("广州");
        foreignTradeSaleman.setPhoto("afdafadfa");
        foreignTradeSaleman.setPassword("afdafaf");
        foreignTradeSaleman.setDemandCount(90);
        foreignTradeSaleman.setSendProductCount(90);
        foreignTradeSaleman.setUserStatus("1");
        foreignTradeSaleman.setRegisterTime("2021-2-14");
        foreignTradeSalemanMapper.insert(foreignTradeSaleman);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void insertSlective() {
        foreignTradeSaleman.setAccount("13129419539");
        foreignTradeSaleman.setPassword("19960529zqw");
        foreignTradeSaleman.setCompany("中兴");
        foreignTradeSaleman.setPhoto("me.jpg");
        foreignTradeSaleman.setName("Kingvi");
        foreignTradeSaleman.setCity("深圳");
        foreignTradeSalemanMapper.insertSelective(foreignTradeSaleman);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectByPrimaryKey() {
        foreignTradeSaleman = foreignTradeSalemanMapper.selectByPrimaryKey(2L);
        System.out.println(foreignTradeSaleman.getId());
    }

    @Test
    public void deleteByPrimaryKey() {
        foreignTradeSalemanMapper.deleteByPrimaryKey(1L);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateByPrimaryKeySelective() {
        foreignTradeSaleman.setId(2L);
        foreignTradeSaleman.setAccount("12345");
        foreignTradeSaleman.setPassword("325456456");
        foreignTradeSaleman.setCompany("");
        foreignTradeSaleman.setPhoto("me.jpg");
        foreignTradeSaleman.setName("");
//        foreignTradeSaleman.setName("Kingvi");
        foreignTradeSaleman.setCity("深圳");
        foreignTradeSalemanMapper.updateByPrimaryKeySelective(foreignTradeSaleman);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateByPrimaryKey() {
        foreignTradeSaleman.setId(2L);
        foreignTradeSaleman.setAccount("12345");
        foreignTradeSaleman.setPassword("325456456");
        foreignTradeSaleman.setCompany("中兴");
        foreignTradeSaleman.setPhoto("me.jpg");
//        foreignTradeSaleman.setName("Kingvi");
        foreignTradeSaleman.setCity("深圳");
        foreignTradeSalemanMapper.updateByPrimaryKey(foreignTradeSaleman);  //出现错误
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void decreaseDemandCount() {
        System.out.println(foreignTradeSalemanMapper.decreaseDemandCount(2L));
        sqlSession.commit();
        sqlSession.close();
    }

}
