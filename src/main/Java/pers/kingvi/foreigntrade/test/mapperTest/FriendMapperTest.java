package pers.kingvi.foreigntrade.test.mapperTest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import pers.kingvi.foreigntrade.admin.dao.FriendMapper;
import pers.kingvi.foreigntrade.po.Friend;
import pers.kingvi.foreigntrade.vo.FriendVo;


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
        friend.setFtsId(1L);
        friend.setFaId(2L);
        friend.setFaMark("威少");
        friend.setFtsMark("晓丹");
        friendMapper.insert(friend);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void insertSelective() {
        friend.setFtsId(1L);
        friend.setFaId(2L);
        friend.setFaMark("威少");
        friend.setFtsMark("晓丹");
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
        List<FriendVo> friendList = friendMapper.selectFriendListByUserId(3L);
        System.out.println(friendList);
    }

    @Test
    public void selectFriendMarkAndAddTime() {
        Friend friend1 =  new Friend();
        friend1.setFaId(2L);
        friend1.setFtsId(3L);
        friend = friendMapper.selectFriendMarkAndAddTime(friend1);
        System.out.println(friend);
    }

    @Test
    public void updateFriendMark() {
        Friend friend =  new Friend();
        friend.setFaId(2L);
        friend.setFtsId(4L);
        friend.setFtsMark("威少");
        friendMapper.updateFriendMark(friend);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUserMark() {
        Friend friend =  new Friend();
        friend.setFaId(2L);
        friend.setFtsId(4L);
        friend.setFtsMark("威威威威");
        friendMapper.updateFriendMark(friend);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteFriend() {
        friend.setFtsId(2L);
        friend.setFaId(4L);
        friendMapper.deleteFriend(friend);
        sqlSession.commit();
        sqlSession.close();
    }


}
