package pers.kingvi.foreigntrade.vo;

import java.util.List;

public class PageBeanVo<T> {
    private Integer currentPage;  //当前页码

    private Integer totalRecord;   //总记录数

    private Integer perPageRecord;    //每页记录数

    private Integer pageCount;        //总记录数除以每页记录数后的总页数

    private String pageType;      //页面类型

    private boolean showStatus;     //页面显示状态

    private List<T> beanList;  //查询推荐结果列表

    public String getPageType() {
        return pageType;
    }

    public PageBeanVo() {

    }

    public PageBeanVo(String pageType, boolean showStatus) {
        this.pageType = pageType;
        this.showStatus = showStatus;
    }

    public void setPageType(String pageType) {
        this.pageType = pageType;
    }

    public boolean isShowStatus() {
        return showStatus;
    }

    public void setShowStatus(boolean showStatus) {
        this.showStatus = showStatus;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Integer totalRecord) {
        this.totalRecord = totalRecord;
    }

    public Integer getPerPageRecord() {
        return perPageRecord;
    }

    public void setPerPageRecord(Integer perPageRecord) {
        this.perPageRecord = perPageRecord;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer perPageRecord, Integer totalRecord) {
        this.perPageRecord = perPageRecord;
        this.totalRecord = totalRecord;
        int result = totalRecord / perPageRecord;
        pageCount = totalRecord % perPageRecord == 0 ? result : result + 1;
        pageCount = pageCount > 0 ? pageCount : 1;
    }

    public List<T> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<T> beanList) {
        this.beanList = beanList;
    }
}
