package pers.kingvi.foreigntrade.admin.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pers.kingvi.foreigntrade.admin.dao.AdminMapper;
import pers.kingvi.foreigntrade.admin.service.AdminService;
import pers.kingvi.foreigntrade.po.Admin;
@Controller
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public int insertSelective(Admin admin) {
        return adminMapper.insertSelective(admin);
    }

    @Override
    public Admin selectByAccount(String account) {
        return adminMapper.selectByAccount(account);
    }

    @Override
    public Admin selectByAccountAndPwd(Admin admin) {
        return adminMapper.selectByAccountAndPwd(admin);
    }
}
