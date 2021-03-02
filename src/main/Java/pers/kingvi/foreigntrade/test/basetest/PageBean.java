package pers.kingvi.foreigntrade.test.basetest;

import org.springframework.stereotype.Component;

@Component
public class PageBean {
    private int pageRecord;

    private int totalRecord;

    private int pageCount;

    public int getPageRecord() {
        return pageRecord;
    }

    public void setPageRecord(int pageRecord) {
        this.pageRecord = pageRecord;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public void setPageCount(Integer pageRecord, Integer totalRecord) {
        int result = totalRecord / pageRecord;
        pageCount = totalRecord % pageRecord == 0 ? result : result + 1;
    }

    public int getPageCount() {
        return pageCount;
    }
}
