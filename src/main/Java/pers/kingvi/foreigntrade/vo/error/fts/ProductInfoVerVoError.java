package pers.kingvi.foreigntrade.vo.error.fts;

public class ProductInfoVerVoError {
    private String photoErr;
    private String productNameErr;
    private String originErr;
    private String destinationCountryErr;
    private String postcodeErr;
    private String weightErr;
    private String volumnErr;
    private String timeRequirementErr;
    private String realOrderErr;
    private String chargerErr;
    private String certificateErr;
    private String destinationErr;
    private String remarkErr;

    public ProductInfoVerVoError() {

    }

    public ProductInfoVerVoError(String fileErr, String productNameErr, String originErr, String destinationCountryErr, String postcodeErr, String weightErr, String volumnErr, String timeRequirementErr, String realOrderErr, String chargerErr, String certificateErr, String destinationErr, String remarkErr) {
        this.photoErr = fileErr;
        this.productNameErr = productNameErr;
        this.originErr = originErr;
        this.destinationCountryErr = destinationCountryErr;
        this.postcodeErr = postcodeErr;
        this.weightErr = weightErr;
        this.volumnErr = volumnErr;
        this.timeRequirementErr = timeRequirementErr;
        this.realOrderErr = realOrderErr;
        this.chargerErr = chargerErr;
        this.certificateErr = certificateErr;
        this.destinationErr = destinationErr;
        this.remarkErr = remarkErr;
    }

    public String getPhotoErr() {
        return photoErr;
    }

    public void setPhotoErr(String photoErr) {
        this.photoErr = photoErr;
    }

    public String getProductNameErr() {
        return productNameErr;
    }

    public void setProductNameErr(String productNameErr) {
        this.productNameErr = productNameErr;
    }

    public String getOriginErr() {
        return originErr;
    }

    public void setOriginErr(String originErr) {
        this.originErr = originErr;
    }

    public String getDestinationCountryErr() {
        return destinationCountryErr;
    }

    public void setDestinationCountryErr(String destinationCountryErr) {
        this.destinationCountryErr = destinationCountryErr;
    }

    public String getPostcodeErr() {
        return postcodeErr;
    }

    public void setPostcodeErr(String postcodeErr) {
        this.postcodeErr = postcodeErr;
    }

    public String getWeightErr() {
        return weightErr;
    }

    public void setWeightErr(String weightErr) {
        this.weightErr = weightErr;
    }

    public String getVolumnErr() {
        return volumnErr;
    }

    public void setVolumnErr(String volumnErr) {
        this.volumnErr = volumnErr;
    }

    public String getTimeRequirementErr() {
        return timeRequirementErr;
    }

    public void setTimeRequirementErr(String timeRequirementErr) {
        this.timeRequirementErr = timeRequirementErr;
    }

    public String getRealOrderErr() {
        return realOrderErr;
    }

    public void setRealOrderErr(String realOrderErr) {
        this.realOrderErr = realOrderErr;
    }

    public String getChargerErr() {
        return chargerErr;
    }

    public void setChargerErr(String chargerErr) {
        this.chargerErr = chargerErr;
    }

    public String getCertificateErr() {
        return certificateErr;
    }

    public void setCertificateErr(String certificateErr) {
        this.certificateErr = certificateErr;
    }

    public String getDestinationErr() {
        return destinationErr;
    }

    public void setDestinationErr(String destinationErr) {
        this.destinationErr = destinationErr;
    }

    public String getRemarkErr() {
        return remarkErr;
    }

    public void setRemarkErr(String remarkErr) {
        this.remarkErr = remarkErr;
    }
}
