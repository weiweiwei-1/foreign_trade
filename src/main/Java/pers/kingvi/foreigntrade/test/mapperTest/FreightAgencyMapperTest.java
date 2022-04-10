package pers.kingvi.foreigntrade.test.mapperTest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import pers.kingvi.foreigntrade.freightagency.dao.FreightAgencyMapper;
import pers.kingvi.foreigntrade.po.FreightAgency;
import pers.kingvi.foreigntrade.vo.fa.FaUpdateVo;

import java.io.InputStream;


public class FreightAgencyMapperTest{
    private FreightAgencyMapper freightAgencyMapper;

    private FreightAgency freightAgency;

    private SqlSession sqlSession;

    private FaUpdateVo faUpdateVo;

    @Before
    public void setUp() throws Exception {
        String resource = "config/sqlmap-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        freightAgencyMapper = sqlSession.getMapper(FreightAgencyMapper.class);
        freightAgency =  new FreightAgency();
    }
    @Test
    public void testInsert() {
        freightAgency.setId(14990L);
        freightAgency.setAccount("13430190112");
        freightAgency.setPassword("19960529");
        freightAgency.setCompany("Kingvi");
        freightAgency.setCity("耳机");
        freightAgency.setName("杭州");
        freightAgency.setPhoto("me.jpg");
        freightAgency.setSendQuoteCount(15);
        freightAgency.setAdvertiseCount(30);
        freightAgency.setUserStatus("0");
        freightAgencyMapper.insert(freightAgency);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void insertSelective() {
        freightAgency.setId(6L);
        freightAgency.setAccount("134fsa424");
        freightAgency.setPassword("19960529");
        freightAgency.setCompany("Kingvi");
        freightAgency.setCity("耳机");
        freightAgency.setName("杭州");
        freightAgency.setPhoto("me.jpg");
        freightAgency.setSendQuoteCount(15);
        freightAgency.setAdvertiseCount(30);
        freightAgency.setUserStatus("0");
        freightAgencyMapper.insert(freightAgency);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectByPrimaryKey() {
        freightAgency = freightAgencyMapper.selectByPrimaryKey(2L);
        System.out.println(freightAgency);
    }

    @Test
    public void selectByAccount() {
        freightAgency = freightAgencyMapper.selectByAccount("13424");
        System.out.println(freightAgency);
    }

    @Test
    public void selectByAccountAndPassword() {
        freightAgency = freightAgencyMapper.selectByAccountAndPassword("134214324","19960529");
        System.out.println(freightAgency);
    }

    @Test
    public void deleteByPrimaryKey() {
        freightAgencyMapper.deleteByPrimaryKey(14990L);
        sqlSession.commit();
        sqlSession.close();
    }



    @Test
    public void updateByPrimaryKeySelective() {
        freightAgency.setId(2L);
        freightAgency.setName("weiweiwei");
        freightAgencyMapper.updateByPrimaryKeySelective(freightAgency);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateByPrimaryKey() {
        faUpdateVo .setId(4L);
//        faUpdateVo .setAccount("134qwer424");
//        faUpdateVo .setPassword("19960529");
        faUpdateVo.setCompany("庆威科技股份");
        faUpdateVo .setCity("深圳");
        faUpdateVo .setName("庆威");
        faUpdateVo .setPhoto("me.jpg");
//        faUpdateVo .setSendQuoteCount(15);
//        faUpdateVo.setAdvertiseCount(30);
//        faUpdateVo.setUserStatus("0");
//        fa.setName("Kingvi");
        freightAgencyMapper.updateByPrimaryKey(faUpdateVo);  //出现错误
        sqlSession.commit();
        sqlSession.close();
    }

}
