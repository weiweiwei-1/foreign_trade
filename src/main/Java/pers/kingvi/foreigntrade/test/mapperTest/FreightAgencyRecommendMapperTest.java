package pers.kingvi.foreigntrade.test.mapperTest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import pers.kingvi.foreigntrade.freightagency.dao.FreightAgencyRecommendMapper;
import pers.kingvi.foreigntrade.po.FreightAgencyRecommend;

import java.io.InputStream;
import java.util.List;

public class FreightAgencyRecommendMapperTest {

    private FreightAgencyRecommendMapper freightAgencyRecommendMapper;

    private FreightAgencyRecommend freightAgencyRecommend;

    private SqlSession sqlSession;

    @Before
    public void setUp() throws Exception {
        String resource = "config/sqlmap-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        freightAgencyRecommendMapper = sqlSession.getMapper(FreightAgencyRecommendMapper.class);
        freightAgencyRecommend =  new FreightAgencyRecommend();
    }
    @Test
    public void testInsert() {
//        freightAgencyRecommend.setId(14990L);
        freightAgencyRecommend.setFaId(3L);
        freightAgencyRecommend.setFaName("威少");
        freightAgencyRecommend.setFaCompany("飞誉国际物流");
        freightAgencyRecommend.setCompanyLink("weichat.online");
        freightAgencyRecommend.setFaCity("广州");
        freightAgencyRecommend.setKeyWords("广州美国");
        freightAgencyRecommend.setMainBusiness("韩国和东南亚");
        freightAgencyRecommend.setDescription("具体描述");
        freightAgencyRecommend.setActivityPhoto("me.jap");
        freightAgencyRecommend.setPhone("13430171");
        freightAgencyRecommend.setWeChat("Kingvi_optimus");
        freightAgencyRecommend.setEmail("2198626335@qq.com");
        freightAgencyRecommend.setSendTime("2012-1-21");
        freightAgencyRecommend.setVerifyStatus("0");
        freightAgencyRecommendMapper.insert(freightAgencyRecommend);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void insertSelective() {
        freightAgencyRecommend.setFaId(4L);
        freightAgencyRecommend.setFaName("威Kingvi");
        freightAgencyRecommend.setFaCompany("未知名的公司物流");
        freightAgencyRecommend.setCompanyLink("weichat.online");
        freightAgencyRecommend.setFaCity("深圳");
        freightAgencyRecommend.setKeyWords("广州美国东南亚欧美国家，最多20个");
        freightAgencyRecommend.setMainBusiness("电子消费品");
        freightAgencyRecommend.setDescription("具体描述");
        freightAgencyRecommend.setActivityPhoto("me.jap");
//        freightAgencyRecommend.setPhone("13430171");
        freightAgencyRecommend.setWeChat("Kingvi_optimus");
//        freightAgencyRecommend.setEmail("2198626335@qq.com");
//        freightAgencyRecommend.setSendTime("2012-1-21");
//        freightAgencyRecommend.setVerifyStatus("0");
        freightAgencyRecommendMapper.insertSelective(freightAgencyRecommend);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectByPrimaryKey() {
        freightAgencyRecommend = freightAgencyRecommendMapper.selectByPrimaryKey(2);
        System.out.println(freightAgencyRecommend);
    }

    @Test
    public void selectByPrimaryKeyAndFaId() {
        freightAgencyRecommend = freightAgencyRecommendMapper.selectByPrimaryKeyAndFaId(2,2L);
        System.out.println(freightAgencyRecommend);
    }

    @Test
    public void selectByFaId() {
        List<FreightAgencyRecommend> freightAgencyRecommendList= freightAgencyRecommendMapper.selectByFaId(3L);
        System.out.println(freightAgencyRecommendList);
    }


    @Test
    public void deleteByPrimaryKey() {
        freightAgencyRecommendMapper.deleteByPrimaryKey(1);
        sqlSession.commit();
        sqlSession.close();
    }



    @Test
    public void updateByPrimaryKeySelective() {
        freightAgencyRecommend.setId(2);
//        freightAgencyRecommend.setName("weiweiwei");
//        freightAgencyRecommend.updateByPrimaryKeySelective(FreightAgencyRecommend);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateByPrimaryKey() {
//        FreightAgencyRecommend.setName("Kingvi");
//        FreightAgencyRecommendMapper.updateByPrimaryKey(FreightAgencyRecommend);
        sqlSession.commit();
        sqlSession.close();
    }
}
