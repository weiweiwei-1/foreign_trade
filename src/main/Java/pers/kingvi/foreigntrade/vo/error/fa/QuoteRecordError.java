package pers.kingvi.foreigntrade.vo.error.fa;

public class QuoteRecordError {
    private String productError;
    private String shippingWayError;
    private String priceError;
    private String arrangeTimeError;
    private String deliverTimeError;
    private String reMarkError;

    public QuoteRecordError(String productError, String shippingWayError, String priceError, String arrangeTimeError, String deliverTimeError, String reMarkError) {
        this.productError = productError;
        this.shippingWayError = shippingWayError;
        this.priceError = priceError;
        this.arrangeTimeError = arrangeTimeError;
        this.deliverTimeError = deliverTimeError;
        this.reMarkError = reMarkError;
    }

    public String getProductError() {
        return productError;
    }

    public void setProductError(String productError) {
        this.productError = productError;
    }

    public String getShippingWayError() {
        return shippingWayError;
    }

    public void setShippingWayError(String shippingWayError) {
        this.shippingWayError = shippingWayError;
    }

    public String getPriceError() {
        return priceError;
    }

    public void setPriceError(String priceError) {
        this.priceError = priceError;
    }

    public String getArrangeTimeError() {
        return arrangeTimeError;
    }

    public void setArrangeTimeError(String arrangeTimeError) {
        this.arrangeTimeError = arrangeTimeError;
    }

    public String getDeliverTimeError() {
        return deliverTimeError;
    }

    public void setDeliverTimeError(String deliverTimeError) {
        this.deliverTimeError = deliverTimeError;
    }

    public String getReMarkError() {
        return reMarkError;
    }

    public void setReMarkError(String reMarkError) {
        this.reMarkError = reMarkError;
    }
}
