package pers.kingvi.foreigntrade.admin.dao;

import pers.kingvi.foreigntrade.po.Admin;

public interface AdminMapper {
    int insert(Admin admin);

    int insertSelective(Admin admin);

    Admin selectByPrimaryKey(Integer id);

    Admin selectByAccount(String account);

    Admin selectByAccountAndPwd(Admin admin);

    int updateByPrimaryKey(Admin admin);

    int updateByPrimaryKeySelective(Admin admin);

    int deleteByPrimaryKey(Integer id);
}
