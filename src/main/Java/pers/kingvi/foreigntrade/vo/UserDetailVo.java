package pers.kingvi.foreigntrade.vo;

import pers.kingvi.foreigntrade.po.ForeignTradeSaleman;

import java.util.List;

public class UserDetailVo<T> {
    private List<T> beanList;

    public List<T> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<T> beanList) {
        this.beanList = beanList;
    }
}
