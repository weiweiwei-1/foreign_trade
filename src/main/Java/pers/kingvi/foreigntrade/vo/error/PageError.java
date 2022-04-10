package pers.kingvi.foreigntrade.vo.error;

public class PageError {
    //页面数错误
    private String pageCountError;
    //搜索条件错误
    private String searchError;

    public PageError(String pageCountError, String searchError) {
        this.pageCountError = pageCountError;
        this.searchError = searchError;
    }

    public String getPageCountError() {
        return pageCountError;
    }

    public void setPageCountError(String pageCountError) {
        this.pageCountError = pageCountError;
    }

    public String getSearchError() {
        return searchError;
    }

    public void setSearchError(String searchError) {
        this.searchError = searchError;
    }
}
