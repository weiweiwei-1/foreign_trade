package pers.kingvi.foreigntrade.admin.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.kingvi.foreigntrade.admin.dao.FriendMapper;
import pers.kingvi.foreigntrade.admin.dao.UserMapper;
import pers.kingvi.foreigntrade.admin.service.FriendService;
import pers.kingvi.foreigntrade.foreigntradesaleman.dao.ForeignTradeSalemanMapper;
import pers.kingvi.foreigntrade.freightagency.dao.FreightAgencyMapper;
import pers.kingvi.foreigntrade.po.ForeignTradeSaleman;
import pers.kingvi.foreigntrade.po.FreightAgency;
import pers.kingvi.foreigntrade.po.Friend;
import pers.kingvi.foreigntrade.po.User;
import pers.kingvi.foreigntrade.vo.FriendVo;
import pers.kingvi.foreigntrade.vo.UserDetailVo;

import java.util.ArrayList;
import java.util.List;


@Service
public class FriendServiceImpl implements FriendService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private FriendMapper friendMapper;

    @Autowired
    private ForeignTradeSalemanMapper foreignTradeSalemanMapper;

    @Autowired
    private FreightAgencyMapper freightAgencyMapper;

    @Override
    public Friend selectByPrimaryKey(Integer id) {
        return friendMapper.selectByPrimaryKey(id);

    }

    @Override
    public List<FriendVo> selectById(Long id) {
        User user = userMapper.selectByPrimaryKey(id);
        List<Long> idList =  new ArrayList<>();
        List<FriendVo> friendList = friendMapper.selectFriendListByUserId(id);
        if (friendList.size() > 0) {
            for (FriendVo friendvo : friendList) {
                idList.add(friendvo.getFriendId());
            }
            //如果用户是外贸，则取货代的信息
            if ("fts".equals(user.getUserType())) {
                List<FreightAgency> freightAgencyList = freightAgencyMapper.selectByFaIdList(idList);
                try {
                    for (int i = 0; i < friendList.size(); i++) {
                        friendList.get(i).setAddress(freightAgencyList.get(i).getCity());
                        friendList.get(i).setCompany(freightAgencyList.get(i).getCompany());
                        friendList.get(i).setMainBusiness(freightAgencyList.get(i).getMainBussinessScope());
                        friendList.get(i).setPhoto(freightAgencyList.get(i).getPhoto());
                    }
                    System.out.println(friendList);
                    return friendList;
                } catch (IndexOutOfBoundsException e) {
                    return null;
                }
            } else if ("fa".equals(user.getUserType())) {
                List<ForeignTradeSaleman> foreignTradeSalemanList = foreignTradeSalemanMapper.selectByFtsIdList(idList);
                try {
                    for (int i = 0; i < friendList.size(); i++) {
                        friendList.get(i).setAddress(foreignTradeSalemanList.get(i).getCity());
                        friendList.get(i).setCompany(foreignTradeSalemanList.get(i).getCompany());
                        friendList.get(i).setMainBusiness(foreignTradeSalemanList.get(i).getIndustry());
                        friendList.get(i).setPhoto(foreignTradeSalemanList.get(i).getPhoto());
                    }
                    System.out.println(friendList);
                    return friendList;
                } catch (IndexOutOfBoundsException e) {
                    return null;
                }
            }
        }
        return null;
    }

    @Override
    public ForeignTradeSaleman showFtsDetailByFriendId(Long ftsId) {
        return foreignTradeSalemanMapper.selectByPrimaryKey(ftsId);
    }

    @Override
    public FreightAgency showFaDetailByFriendId(Long faId) {
        return freightAgencyMapper.selectByPrimaryKey(faId);
    }

    @Override
    public UserDetailVo showUserDetailByFriendId(Long fId) {
        User user =  userMapper.selectByPrimaryKey(fId);
        if ("fa".equals(user.getUserType())) {
            UserDetailVo<FreightAgency> userDetailVo = new UserDetailVo<>();
            List<FreightAgency> freightAgency =  freightAgencyMapper.selectById(fId);
            userDetailVo.setBeanList(freightAgency);
            return userDetailVo;
        } else if ("fts".equals(user.getUserType())) {
            UserDetailVo<ForeignTradeSaleman> userDetailVo = new UserDetailVo<>();
            List<ForeignTradeSaleman> foreignTradeSalemanList =  foreignTradeSalemanMapper.selectById(fId);
            userDetailVo.setBeanList(foreignTradeSalemanList);
            return userDetailVo;
        }
        return null;
    }

    @Override
    public int updateFriendMark(Long id, Long friendId, String friendMark) {
        User user = userMapper.selectByPrimaryKey(id);
        if (user != null) {
            Friend friend = new Friend();
            friend.setUserId(id);
            friend.setFriendId(friendId);
            friend = friendMapper.selectFriend(friend);
            if (friend != null) {
                //如果用户是货代，那么更改外贸的信息,id为faId也即friendId,friendId为ftsId也即userId
                if ("fa".equals(user.getUserType())) {
                    friend.setUserId(friendId);
                    friend.setFriendId(id);
                    friend.setUserMark(friendMark);
                    return friendMapper.updateFriend(friend);
                    //如果用户是外贸，那么更改货代的信息，id为ftsId也即userId,friendId为faId也即friendId
                } else if ("fts".equals(user.getUserType())) {
                    friend.setUserId(id);
                    friend.setFriendId(friendId);
                    friend.setFriendMark(friendMark);
                    return friendMapper.updateFriend(friend);
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        }
        return 0;
    }

    @Override
    public int updateFtsMark(Friend friend) {
        friend = friendMapper.selectFriend(friend);
        if (friend != null) {
            friendMapper.updateUserMark(friend);
        }
        return 0;
    }

    @Override
    public int updateFaMark(Friend friend) {
        friend = friendMapper.selectFriend(friend);
        if (friend != null) {
            return friendMapper.updateFriendMark(friend);
        }
        return 0;
    }

    @Override
    public int deleteFriend(Friend friend) {
        friend = friendMapper.selectFriend(friend);
        if (friend != null) {
            return friendMapper.deleteFriend(friend);
        }
        return 0;
    }
}
