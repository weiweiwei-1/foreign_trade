package pers.kingvi.foreigntrade.test.mapperTest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import pers.kingvi.foreigntrade.admin.dao.ForeignTradeSalemanDemandVerifyMapper;
import pers.kingvi.foreigntrade.po.ForeignTradeSalemanDemandVerify;

import java.io.InputStream;
import java.util.List;

public class ForeignTradeSalemanDemandVerifyMapperTest {
    private ForeignTradeSalemanDemandVerifyMapper foreignTradeSalemanDemandVerifyMapper;

    private ForeignTradeSalemanDemandVerify foreignTradeSalemanDemandVerify;

    private SqlSession sqlSession;

    @Before
    public void setUp() throws Exception {
        String resource = "config/sqlmap-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        foreignTradeSalemanDemandVerifyMapper = sqlSession.getMapper(ForeignTradeSalemanDemandVerifyMapper.class);
        foreignTradeSalemanDemandVerify =  new ForeignTradeSalemanDemandVerify();
    }
    @Test
    public void testInsert() {
        foreignTradeSalemanDemandVerify.setFtsId(9L);
        foreignTradeSalemanDemandVerify.setFtsName("小威");
        foreignTradeSalemanDemandVerify.setFtsCity("广州");
        foreignTradeSalemanDemandVerify.setFtsCompany("海抗");
        foreignTradeSalemanDemandVerify.setMainBusiness("津巴布韦来了");
        foreignTradeSalemanDemandVerify.setDemandDescription("活动优惠时总共持续8天");
        foreignTradeSalemanDemandVerify.setPhone("13430190171");
        foreignTradeSalemanDemandVerify.setWeChat("13129529539");
        foreignTradeSalemanDemandVerify.setEmail("2198626335@qq.com");
        foreignTradeSalemanDemandVerify.setSendTime("2021-2-14");
        foreignTradeSalemanDemandVerify.setVerifyStatus("0");
        foreignTradeSalemanDemandVerifyMapper.insert(foreignTradeSalemanDemandVerify);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void insertSelective() {
        foreignTradeSalemanDemandVerify.setFtsName("kingvi");
        foreignTradeSalemanDemandVerify.setFtsId(11L);
        foreignTradeSalemanDemandVerify.setFtsCity("adfafdadf");
        foreignTradeSalemanDemandVerify.setFtsCompany("曾庆威");
        foreignTradeSalemanDemandVerify.setMainBusiness("深圳");
        foreignTradeSalemanDemandVerify.setDemandDescription("afdafadfa");
//        foreignTradeSalemanDemandVerify.setPhone("13129529539");
        foreignTradeSalemanDemandVerify.setWeChat("1430190171");
//        foreignTradeSalemanDemandVerify.setEmail("2198626335@qq.com");
        foreignTradeSalemanDemandVerify.setSendTime("2021-2-14");
        foreignTradeSalemanDemandVerifyMapper.insertSelective(foreignTradeSalemanDemandVerify);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectByPrimaryKey() {
        foreignTradeSalemanDemandVerify = foreignTradeSalemanDemandVerifyMapper.selectByPrimaryKey(4);
        System.out.println(foreignTradeSalemanDemandVerify);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectAll() {
        List<ForeignTradeSalemanDemandVerify> foreignTradeSalemanDemandVerifyList = foreignTradeSalemanDemandVerifyMapper.selectAll();
        System.out.println(foreignTradeSalemanDemandVerifyList);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectByFtsId() {
        List<ForeignTradeSalemanDemandVerify> foreignTradeSalemanDemandVerifyList = foreignTradeSalemanDemandVerifyMapper.selectByFtsId(9L);
        System.out.println(foreignTradeSalemanDemandVerifyList);
    }

    @Test
    public void selectByIdAndFtsId() {
        foreignTradeSalemanDemandVerify = foreignTradeSalemanDemandVerifyMapper.selectByPrimaryKeyAndFtsId(2,9L);
        System.out.println(foreignTradeSalemanDemandVerify);
    }

    @Test
    public void deleteByPrimaryKey() {
        foreignTradeSalemanDemandVerifyMapper.deleteByPrimaryKey(2);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteByPrimaryKeyAndFtsId() {
        foreignTradeSalemanDemandVerifyMapper.deleteByPrimaryKeyAndFtsId(4,11L);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateByPrimaryKeySelective() {
        foreignTradeSalemanDemandVerify.setId(1);
        foreignTradeSalemanDemandVerify.setFtsName("kingvi");
        foreignTradeSalemanDemandVerify.setFtsCity("abc");
        foreignTradeSalemanDemandVerify.setFtsCompany("曾庆威");
        foreignTradeSalemanDemandVerify.setMainBusiness("");
        foreignTradeSalemanDemandVerify.setDemandDescription("afdafadfa");
//        foreignTradeSalemanDemandVerify.setName("Kingvi");
        foreignTradeSalemanDemandVerifyMapper.updateByPrimaryKeySelective(foreignTradeSalemanDemandVerify);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateByPrimaryKey() {
        foreignTradeSalemanDemandVerify.setId(4);
        foreignTradeSalemanDemandVerify.setFtsName("kingvi");
        foreignTradeSalemanDemandVerify.setFtsCity("adfafdadf");
        foreignTradeSalemanDemandVerify.setFtsCompany("曾庆威");
        foreignTradeSalemanDemandVerify.setMainBusiness("深圳");
        foreignTradeSalemanDemandVerify.setDemandDescription("afdafadfa");
//        foreignTradeSalemanDemandVerify.setName("Kingvi");
        foreignTradeSalemanDemandVerifyMapper.updateByPrimaryKey(foreignTradeSalemanDemandVerify);  //出现错误
        sqlSession.commit();
        sqlSession.close();
    }
}
