package pers.kingvi.foreigntrade.vo.fts;

import java.util.List;

public class ProductInfoVo {
//    产品id
    private Integer id;
//    产品名
    private String productName;
//    产品图
    private String photo;
//    发布时间
    private String sendTime;
//    剩余报价数
    private Integer quoteCount;
//    产品对应的报价列表
    private List<QuoteRecordVo> quoteList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public Integer getQuoteCount() {
        return quoteCount;
    }

    public void setQuoteCount(Integer quoteCount) {
        this.quoteCount = quoteCount;
    }

    public List<QuoteRecordVo> getQuoteList() {
        return quoteList;
    }

    public void setQuoteList(List<QuoteRecordVo> quoteList) {
        this.quoteList = quoteList;
    }

    public ProductInfoVo(Integer id, String productName, String photo, String sendTime, Integer quoteCount, List<QuoteRecordVo> quoteList) {
        this.id = id;
        this.productName = productName;
        this.photo = photo;
        this.sendTime = sendTime;
        this.quoteCount = quoteCount;
        this.quoteList = quoteList;
    }
}
