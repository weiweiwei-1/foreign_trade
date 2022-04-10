package pers.kingvi.foreigntrade.util.fa;

import org.apache.shiro.SecurityUtils;
import pers.kingvi.foreigntrade.po.FreightAgency;

public class FaUtils {
    public static FreightAgency getUserVo() {
        return (FreightAgency)SecurityUtils.getSubject().getPrincipal();
    }
}
