package pers.kingvi.foreigntrade.test.mapperTest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import pers.kingvi.foreigntrade.admin.dao.UserMapper;
import pers.kingvi.foreigntrade.po.User;

import java.io.InputStream;

public class UserMapperTest {
    private UserMapper userMapper;

    private User user;

    private SqlSession sqlSession;

    @Before
    public void setUp() throws Exception {
        String resource = "config/sqlmap-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
        user = new User();
    }
    @Test
    public void testInsert() {
        user.setUserId(4L);
        user.setUserAccount("134dreqwr71");
        user.setUserType("fts");
        user.setCreateTime("2021-2-19");
        userMapper.insert(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void insertSelective() {
        user.setUserId(9L);
        user.setUserAccount("131296495");
        user.setUserType("fa");
//        user.setCreateTime("2021-2-23");
        userMapper.insert(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectByPrimaryKey() {
        user = userMapper.selectByPrimaryKey(2L);
        System.out.println(user);
    }

    @Test
    public void selectByUserAccount() {
        user = userMapper.selectByUserAccount("13430190171");
        System.out.println(user);
    }


    @Test
    public void updateByPrimaryKey() {
        user.setUserId(5464654L);
        user.setUserAccount("1454");
        user.setUserType("fs");
//        user.setCreateTime("");
        userMapper.updateByPrimaryKey(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateByPrimaryKeySelective() {
        user.setUserId(5464654L);
        user.setUserAccount("12464");
        user.setUserType("fts");
        user.setCreateTime("2021-2-23");
        userMapper.updateByPrimaryKeySelective(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteByPrimaryKey() {
        user.setUserId(2L);
        userMapper.deleteByPrimaryKey(user.getUserId());
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteByAccount() {
        userMapper.deleteByAccount("13400171");
        sqlSession.commit();
        sqlSession.close();
    }
}
