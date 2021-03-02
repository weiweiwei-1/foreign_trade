package pers.kingvi.foreigntrade.vo;

import java.util.List;

public class ForeignTradeSalemanDemandPage<T> {
    private Integer currentPage;  //当前页码

    private Integer totalRecord;   //总记录数

    private Integer perPageRecord;    //每页记录数

    private Integer pageCount;        //总页数

    private List<T> ForeignTradeSalemanDemand;  //查询外贸推荐结果列表

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
        Integer result = totalRecord / perPageRecord;
        this.pageCount = totalRecord % perPageRecord == 0 ? result : result + 1;
    }

    public List<T> getForeignTradeSalemanDemand() {
        return ForeignTradeSalemanDemand;
    }

    public void setForeignTradeSalemanDemand(List<T> foreignTradeSalemanDemand) {
        ForeignTradeSalemanDemand = foreignTradeSalemanDemand;
    }
}
