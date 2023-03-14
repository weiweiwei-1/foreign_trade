package pers.kingvi.foreigntrade.admin.service;

import pers.kingvi.foreigntrade.po.Admin;

public interface AdminService {
    int insertSelective(Admin admin);

    Admin selectByAccount(String account);

    Admin selectByAccountAndPwd(Admin admin);
}
