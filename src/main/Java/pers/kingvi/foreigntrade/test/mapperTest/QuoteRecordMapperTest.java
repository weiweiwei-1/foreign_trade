package pers.kingvi.foreigntrade.test.mapperTest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import pers.kingvi.foreigntrade.admin.dao.QuoteRecordMapper;
import pers.kingvi.foreigntrade.po.ProductInformation;
import pers.kingvi.foreigntrade.po.QuoteRecord;
import java.io.InputStream;
import java.util.List;

public class QuoteRecordMapperTest {
    private QuoteRecordMapper quoteRecordMapper;

    private QuoteRecord quoteRecord;

    private SqlSession sqlSession;

    @Before
    public void setUp() throws Exception {
        String resource = "config/sqlmap-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        quoteRecordMapper = sqlSession.getMapper(QuoteRecordMapper.class);
        quoteRecord = new QuoteRecord();
    }
    @Test
    public void testInsert() {
        quoteRecord.setFaId(5L);
        quoteRecord.setProductId(2);
        quoteRecord.setShippingWay("海运和空运");
        quoteRecord.setPrice(22323);
        quoteRecord.setArrangeTime("4-8天");
        quoteRecord.setDeliverTime("7-10天");
        quoteRecord.setRemark("备注");
        quoteRecord.setStatus("0");
        quoteRecordMapper.insert(quoteRecord);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void insertSelective() {
        quoteRecord.setFaId(4L);
        quoteRecord.setProductId(6);
        quoteRecord.setShippingWay("海运和空运");
        quoteRecord.setArrangeTime("4-8天");
        quoteRecord.setDeliverTime("7-10天");
        quoteRecord.setPrice(23243);
        quoteRecord.setRemark("备注");
        quoteRecord.setStatus("0");
        quoteRecordMapper.insertSelective(quoteRecord);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectByPrimaryKey() {
        quoteRecord = quoteRecordMapper.selectByPrimaryKey(2);
        System.out.println(quoteRecord);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectByProductIdAndFtsId() {
        List<QuoteRecord> quoteRecordList = quoteRecordMapper.selectByProductIdAndFtsId(1,9L);
        System.out.println(quoteRecordList);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectByFaId() {
        List<ProductInformation> productInformationList = quoteRecordMapper.selectByFaId(3L);
        System.out.println(productInformationList);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectByProductIdAndFaId() {
        quoteRecord.setFaId(6L);
        quoteRecord.setProductId(5);
        quoteRecord = quoteRecordMapper.selectByProductIdAndFaId(quoteRecord);
        System.out.println(quoteRecord);
        sqlSession.commit();
        sqlSession.close();
    }
}
