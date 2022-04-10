package pers.kingvi.foreigntrade.util.fts;

import org.apache.shiro.SecurityUtils;
import pers.kingvi.foreigntrade.po.ForeignTradeSaleman;

public class FtsUtils {
    public static ForeignTradeSaleman getUserVo() {
        return (ForeignTradeSaleman)SecurityUtils.getSubject().getPrincipal();
    }
}
