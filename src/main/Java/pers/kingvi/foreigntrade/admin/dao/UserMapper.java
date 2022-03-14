package pers.kingvi.foreigntrade.admin.dao;

import pers.kingvi.foreigntrade.po.User;

import java.util.List;

public interface UserMapper {
    int insert(User user);  //直接插入用户

    int insertSelective(User user);   //选择插入用户

    User selectByPrimaryKey(Long userId);    //根据主键选择用户信息

    User selectByUserAccount(String userAccount);    //根据账号选择用户

    List<User> selectByIdList(List<Long> id);

    int updateByPrimaryKey(User user);      //直接更新

    int updateByPrimaryKeySelective(User user);       //选择更新

    int deleteByPrimaryKey(Long userId);          //根据主键删除用户，注销用户

    int deleteByAccount(String userAccount);      //根据账号删除用户

}
