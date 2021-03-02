package pers.kingvi.foreigntrade.test.mapperTest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import pers.kingvi.foreigntrade.admin.dao.FriendMapper;
import pers.kingvi.foreigntrade.po.Friend;


import java.io.InputStream;
import java.util.List;

public class FriendMapperTest {
    private FriendMapper friendMapper;

    private Friend friend;

    private SqlSession sqlSession;

    @Before
    public void setUp() throws Exception {
        String resource = "config/sqlmap-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        friendMapper = sqlSession.getMapper(FriendMapper.class);
        friend =  new Friend();
    }
    @Test
    public void testInsert() {
        friend.setFriendId(1L);
        friend.setUserId(2L);
        friend.setUserMark("威少");
        friend.setFriendMark("晓丹");
        friendMapper.insert(friend);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void insertSelective() {
        friend.setFriendId(1L);
        friend.setUserId(2L);
        friend.setUserMark("威少");
        friend.setFriendMark("晓丹");
        friendMapper.insertSelective(friend);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectByPrimaryKey() {
        friend = friendMapper.selectByPrimaryKey(1);
        System.out.println(friend);
    }

    @Test
    public void selectFriendListByUserId() {
        List<Friend> friendList = friendMapper.selectFriendListByUserId(3L);
        System.out.println(friendList);
    }

    @Test
    public void selectFriendMarkAndAddTime() {
        Friend friend1 =  new Friend();
        friend1.setUserId(2L);
        friend1.setFriendId(3L);
        friend = friendMapper.selectFriendMarkAndAddTime(friend1);
        System.out.println(friend);
    }

    @Test
    public void updateFriendMark() {
        Friend friend =  new Friend();
        friend.setUserId(2L);
        friend.setFriendId(4L);
        friend.setFriendMark("威少");
        friendMapper.updateFriendMark(friend);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUserMark() {
        Friend friend =  new Friend();
        friend.setUserId(2L);
        friend.setFriendId(4L);
        friend.setFriendMark("威威威威");
        friendMapper.updateFriendMark(friend);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteFriend() {
        friend.setFriendId(2L);
        friend.setUserId(4L);
        friendMapper.deleteFriend(friend);
        sqlSession.commit();
        sqlSession.close();
    }


}
