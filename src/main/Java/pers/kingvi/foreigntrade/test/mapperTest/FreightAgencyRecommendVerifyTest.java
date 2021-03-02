package pers.kingvi.foreigntrade.test.mapperTest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import pers.kingvi.foreigntrade.admin.dao.FreightAgencyRecommendVerifyMapper;
import pers.kingvi.foreigntrade.po.FreightAgencyRecommendVerify;

import java.io.InputStream;
import java.util.List;

public class FreightAgencyRecommendVerifyTest {
    private FreightAgencyRecommendVerifyMapper freightAgencyRecommendVerifyMapper;

    private FreightAgencyRecommendVerify freightAgencyRecommendVerify;

    private SqlSession sqlSession;

    @Before
    public void setUp() throws Exception {
        String resource = "config/sqlmap-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        freightAgencyRecommendVerifyMapper = sqlSession.getMapper(FreightAgencyRecommendVerifyMapper.class);
        freightAgencyRecommendVerify =  new FreightAgencyRecommendVerify();
    }
    @Test
    public void testInsert() {
//        freightAgencyRecommendVerify.setId(14990L);
        freightAgencyRecommendVerify.setFaId(3L);
        freightAgencyRecommendVerify.setFaName("威少");
        freightAgencyRecommendVerify.setFaCompany("飞誉国际物流");
        freightAgencyRecommendVerify.setCompanyLink("weichat.online");
        freightAgencyRecommendVerify.setFaCity("广州");
        freightAgencyRecommendVerify.setKeyWords("广州美国");
        freightAgencyRecommendVerify.setMainBusiness("津巴布韦非常渠道获取数据和其他渠道");
        freightAgencyRecommendVerify.setDescription("仅仅20个足够吗");
        freightAgencyRecommendVerify.setActivityPhoto("me.jap");
        freightAgencyRecommendVerify.setPhone("13430171");
        freightAgencyRecommendVerify.setWeChat("Kingvi_optimus");
        freightAgencyRecommendVerify.setEmail("2198626335@qq.com");
        freightAgencyRecommendVerify.setSendTime("2012-1-21");
        freightAgencyRecommendVerify.setVerifyStatus("0");
        freightAgencyRecommendVerifyMapper.insert(freightAgencyRecommendVerify);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void insertSelective() {
        freightAgencyRecommendVerify.setFaId(6L);
        freightAgencyRecommendVerify.setFaName("威Kingvi");
        freightAgencyRecommendVerify.setFaCompany("未知名的公司物流");
        freightAgencyRecommendVerify.setCompanyLink("weichat.online");
        freightAgencyRecommendVerify.setFaCity("深圳");
        freightAgencyRecommendVerify.setKeyWords("非洲纯电池，最多20个");
        freightAgencyRecommendVerify.setMainBusiness("电子消费品");
        freightAgencyRecommendVerify.setDescription("具体描述");
        freightAgencyRecommendVerify.setActivityPhoto("me.jap");
//        freightAgencyRecommendVerify.setPhone("13430171");
        freightAgencyRecommendVerify.setWeChat("Kingvi_optimus");
//        freightAgencyRecommendVerify.setEmail("2198626335@qq.com");
//        freightAgencyRecommendVerify.setSendTime("2012-1-21");
//        freightAgencyRecommendVerify.setVerifyStatus("0");
        freightAgencyRecommendVerifyMapper.insertSelective(freightAgencyRecommendVerify);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectByPrimaryKey() {
        freightAgencyRecommendVerify = freightAgencyRecommendVerifyMapper.selectByPrimaryKey(2);
        System.out.println(freightAgencyRecommendVerify);
    }

    @Test
    public void selectByPrimaryKeyAndFaId() {
        freightAgencyRecommendVerify = freightAgencyRecommendVerifyMapper.selectByPrimaryKeyAndFaId(2,9L);
        System.out.println(freightAgencyRecommendVerify);
    }

    @Test
    public void selectByFaId() {
        List<FreightAgencyRecommendVerify> freightAgencyRecommendVerifyList= freightAgencyRecommendVerifyMapper.selectByFaId(3L);
        System.out.println(freightAgencyRecommendVerifyList);
    }


    @Test
    public void deleteByPrimaryKey() {
        freightAgencyRecommendVerifyMapper.deleteByPrimaryKey(3);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteByPrimaryKeyAndFaId() {
        freightAgencyRecommendVerifyMapper.deleteByPrimaryKeyAndFaId(2,4L);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateByPrimaryKeySelective() {
        freightAgencyRecommendVerify.setId(2);
//        freightAgencyRecommendVerify.setName("weiweiwei");
//        freightAgencyRecommendVerify.updateByPrimaryKeySelective(freightAgencyRecommendVerify);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateByPrimaryKey() {
//        freightAgencyRecommendVerify.setName("Kingvi");
//        freightAgencyRecommendVerifyMapper.updateByPrimaryKey(freightAgencyRecommendVerify);
        sqlSession.commit();
        sqlSession.close();
    }
}
