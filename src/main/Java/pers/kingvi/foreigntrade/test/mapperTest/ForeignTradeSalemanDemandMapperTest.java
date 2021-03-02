package pers.kingvi.foreigntrade.test.mapperTest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import pers.kingvi.foreigntrade.foreigntradesaleman.dao.ForeignTradeSalemanDemandMapper;
import pers.kingvi.foreigntrade.po.ForeignTradeSalemanDemand;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ForeignTradeSalemanDemandMapperTest {

    private ForeignTradeSalemanDemandMapper foreignTradeSalemanDemandMapper;

    private ForeignTradeSalemanDemand foreignTradeSalemanDemand;

    private SqlSession sqlSession;

    @Before
    public void setUp() throws Exception {
        String resource = "config/sqlmap-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        foreignTradeSalemanDemandMapper = sqlSession.getMapper(ForeignTradeSalemanDemandMapper.class);
        foreignTradeSalemanDemand =  new ForeignTradeSalemanDemand();
    }
    @Test
    public void testInsert() {
        foreignTradeSalemanDemand.setFtsId(9L);
        foreignTradeSalemanDemand.setFtsName("kingvi");
        foreignTradeSalemanDemand.setFtsCity("广州");
        foreignTradeSalemanDemand.setFtsCompany("中兴");
        foreignTradeSalemanDemand.setMainBusiness("美国");
        foreignTradeSalemanDemand.setDemandDescription("美国专线来了");
        foreignTradeSalemanDemand.setPhone("1234555");
        foreignTradeSalemanDemand.setWechat("1430190171");
        foreignTradeSalemanDemand.setEmail("2198626335@qq.com");
        foreignTradeSalemanDemand.setSendTime("2021-2-14");
        foreignTradeSalemanDemand.setVerifyStatus("0");
        foreignTradeSalemanDemandMapper.insert(foreignTradeSalemanDemand);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void insertSelective() {
        foreignTradeSalemanDemand.setFtsName("kingvi");
        foreignTradeSalemanDemand.setFtsId(11L);
        foreignTradeSalemanDemand.setFtsCity("adfafdadf");
        foreignTradeSalemanDemand.setFtsCompany("曾庆威");
        foreignTradeSalemanDemand.setMainBusiness("深圳");
        foreignTradeSalemanDemand.setDemandDescription("afdafadfa");
        foreignTradeSalemanDemand.setPhone("13129529539");
        foreignTradeSalemanDemand.setWechat("1430190171");
//        foreignTradeSalemanDemand.setEmail("2198626335@qq.com");
        foreignTradeSalemanDemand.setSendTime("2021-2-14");
        foreignTradeSalemanDemandMapper.insertSelective(foreignTradeSalemanDemand);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectByPrimaryKey() {
        foreignTradeSalemanDemand = foreignTradeSalemanDemandMapper.selectByPrimaryKey(1);
        System.out.println(foreignTradeSalemanDemand);
    }

    @Test
    public void selectByFtsId() {
        List<ForeignTradeSalemanDemand> foreignTradeSalemanDemandList = foreignTradeSalemanDemandMapper.selectByFtsId(9L);
        System.out.println(foreignTradeSalemanDemandList);
    }

    @Test
    public void selectByIdAndFtsId() {
        foreignTradeSalemanDemand = foreignTradeSalemanDemandMapper.selectByPrimaryKeyAndFtsId(3,9L);
        System.out.println(foreignTradeSalemanDemand);
    }

    @Test
    public void deleteByPrimaryKey() {
        foreignTradeSalemanDemandMapper.deleteByPrimaryKey(8);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteByPrimaryKeyAndFtsId() {
        foreignTradeSalemanDemandMapper.deleteByPrimaryKeyAndFtsId(3,9L);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateByPrimaryKeySelective() {
        foreignTradeSalemanDemand.setId(1);
        foreignTradeSalemanDemand.setFtsName("kingvi");
        foreignTradeSalemanDemand.setFtsCity("abc");
        foreignTradeSalemanDemand.setFtsCompany("曾庆威");
        foreignTradeSalemanDemand.setMainBusiness("");
        foreignTradeSalemanDemand.setDemandDescription("afdafadfa");
//        foreignTradeSalemanDemand.setName("Kingvi");
        foreignTradeSalemanDemandMapper.updateByPrimaryKeySelective(foreignTradeSalemanDemand);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateByPrimaryKey() {
        foreignTradeSalemanDemand.setId(4);
        foreignTradeSalemanDemand.setFtsName("kingvi");
        foreignTradeSalemanDemand.setFtsCity("adfafdadf");
        foreignTradeSalemanDemand.setFtsCompany("曾庆威");
        foreignTradeSalemanDemand.setMainBusiness("深圳");
        foreignTradeSalemanDemand.setDemandDescription("afdafadfa");
//        foreignTradeSalemanDemand.setName("Kingvi");
        foreignTradeSalemanDemandMapper.updateByPrimaryKey(foreignTradeSalemanDemand);  //出现错误
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectByList() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(5);
        List<ForeignTradeSalemanDemand> foreignTradeSalemanDemandList = foreignTradeSalemanDemandMapper.selectByList(list, 2,5);
        System.out.println(foreignTradeSalemanDemandList);
    }

    @Test
    public void selectByBean() {
        foreignTradeSalemanDemand.setId(4);
        foreignTradeSalemanDemand.setFtsId(8L);
        foreignTradeSalemanDemand =  foreignTradeSalemanDemandMapper.selectByBean(foreignTradeSalemanDemand);
        System.out.println(foreignTradeSalemanDemand);
    }
}


