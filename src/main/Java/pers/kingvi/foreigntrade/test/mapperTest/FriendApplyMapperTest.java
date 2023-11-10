package pers.kingvi.foreigntrade.test.mapperTest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import pers.kingvi.foreigntrade.admin.dao.FriendApplyMapper;
import pers.kingvi.foreigntrade.po.Friend;
import pers.kingvi.foreigntrade.po.FriendApply;

import java.io.InputStream;
import java.util.List;

public class FriendApplyMapperTest {

        private FriendApplyMapper friendApplyMapper;

        private FriendApply friendApply;

        private SqlSession sqlSession;

        @Before
        public void setUp() throws Exception {
            String resource = "config/sqlmap-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
            friendApplyMapper = sqlSession.getMapper(FriendApplyMapper.class);
            friendApply =  new FriendApply();
        }
        @Test
        public void testInsert() {
            friendApply.setSenderId(6L);
            friendApply.setReceiverId(3L);
//        friendApply.setSendTime("2021-2-1");
            friendApply.setSenderName("Kingvi");
            friendApplyMapper.insert(friendApply);
            sqlSession.commit();
            sqlSession.close();
        }

        @Test
        public void insertSelective() {
            friendApply.setSenderId(6L);
            friendApply.setReceiverId(8L);
//        friendApply.setSendTime("2021-2-1");
            friendApply.setSenderName("Kingvi");
            friendApplyMapper.insert(friendApply);
            sqlSession.commit();
            sqlSession.close();
        }

        @Test
        public void selectByPrimaryKey() {
            friendApply = friendApplyMapper.selectByPrimaryKey(1);
            System.out.println(friendApply);
        }

    @Test
    public void selectByReceiverId() {
        List<FriendApply> friendApplyList = friendApplyMapper.selectByReceiverId(3L);
        System.out.println(friendApplyList);
    }

    @Test
    public void selectFriendApply() {
            friendApply.setSenderId(4L);
            friendApply.setReceiverId(3L);
         friendApply = friendApplyMapper.selectFriendApply(friendApply);
        System.out.println(friendApply);
    }

        @Test
        public void updateByPrimaryKeySelective() {

            sqlSession.commit();
            sqlSession.close();
        }

        @Test
        public void updateByPrimaryKey() {

            sqlSession.commit();
            sqlSession.close();
        }

    @Test
    public void deleteByPrimaryKey() {
            friendApplyMapper.deleteByPrimaryKey(2);
            sqlSession.commit();
            sqlSession.close();
    }

    @Test
    public void deleteFriend() {
            friendApply.setSenderId(4L);
            friendApply.setReceiverId(6L);
            friendApplyMapper.deleteFriendApply(friendApply);
        sqlSession.commit();
        sqlSession.close();
    }

}
