package pers.kingvi.foreigntrade.test.mapperTest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import pers.kingvi.foreigntrade.admin.dao.MessageMapper;
import pers.kingvi.foreigntrade.po.Message;
import pers.kingvi.foreigntrade.vo.ReadAndUnReadMessageVo;
import pers.kingvi.foreigntrade.vo.UnReadMessageVo;

import java.io.InputStream;
import java.util.List;

public class MessageMapperTest {
    private MessageMapper messageMapper;

    private Message message;

    private SqlSession sqlSession;

    @Before
    public void setUp() throws Exception {
        String resource = "config/sqlmap-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        messageMapper = sqlSession.getMapper(MessageMapper.class);
        message = new Message();
    }
    @Test
    public void testInsert() {
        message.setSenderId(7L);
        message.setReceiverId(2L);
        message.setContent("测试");
//        message.setSendTime("2021-2-19");
        message.setStatus("0");
        messageMapper.insert(message);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void insertSelective() {
        message.setSenderId(3L);
        message.setReceiverId(2L);
        message.setContent("啦啦");
//        message.setSendTime("2021-2-19");
        message.setStatus("0");
        messageMapper.insert(message);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectByPrimaryKey() {
        message = messageMapper.selectByPrimaryKey(2);
        System.out.println(message);
    }

    @Test
    public void selectAll() {
        message.setSenderId(3L);
        message.setReceiverId(2L);
        List<Message> messageList= messageMapper.selectAll(message);
        System.out.println(messageList);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectLastAmount() {
        message.setSenderId(2L);
        message.setReceiverId(3L);
        List<Message> messageList= messageMapper.selectLastAmount(message,3);
        System.out.println(messageList);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectUnReadMessage() {
        List<UnReadMessageVo> unReadMessageVoList = messageMapper.selectUnReadMessage(3L);
        System.out.println(unReadMessageVoList);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectReadAndUnReadMessage() {
        List<ReadAndUnReadMessageVo> readAndUnReadMessageVoList = messageMapper.selectReadAndUnReadMessage(2L);
        System.out.println(readAndUnReadMessageVoList);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateMessages() {
        message.setSenderId(7L);
        message.setReceiverId(2L);
        messageMapper.updateMessages(message);
        sqlSession.commit();
        sqlSession.close();
    }

}
