package pers.kingvi.foreigntrade.test.basetest;

import org.junit.Test;

public class PageTest1 {


    @Test
    public void testPage() {
        PageBean pageBean = new PageBean();
        pageBean.setTotalRecord(1000);
        pageBean.setPageRecord(10);
        pageBean.setPageCount(10, 1000);
        System.out.println(pageBean.getPageCount());
    }

    @Test
    public void testDouble() {
        int b=12;
        Double a = 12d;
    }
}
