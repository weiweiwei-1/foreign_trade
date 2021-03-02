package pers.kingvi.foreigntrade.admin.service;

import pers.kingvi.foreigntrade.po.LoginRecord;

public interface LoginRecordService {
    LoginRecord selectById(Integer id);

    LoginRecord selectByUserId(Integer userId);

    int updateByUserId(LoginRecord loginRecord);
}
