package pers.kingvi.foreigntrade.admin.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.kingvi.foreigntrade.admin.dao.UserMapper;
import pers.kingvi.foreigntrade.admin.service.UserService;
import pers.kingvi.foreigntrade.po.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int insertSelective(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public User selectByPrimaryKey(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public User selectByUserAccount(String userAccount) {
        return userMapper.selectByUserAccount(userAccount);
    }

    @Override
    public int updateByPrimaryKey(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public int updateByPrimaryKeySelective(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }
}
