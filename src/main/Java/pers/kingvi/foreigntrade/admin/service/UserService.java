package pers.kingvi.foreigntrade.admin.service;

import pers.kingvi.foreigntrade.po.User;

public interface UserService {
    int insert(User user);

    int insertSelective(User user);

    User selectByPrimaryKey(Long userId);    //根据主键选择用户信息

    User selectByUserAccount(String userAccount);    //根据账号选择用户

    int updateByPrimaryKey(User user);      //直接更新

    int updateByPrimaryKeySelective(User user);       //选择更新

}
