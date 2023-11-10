package pers.kingvi.foreigntrade.vo.error.fa;

public class RecommendVoError {
//    图片错误提示
    private String photoError;
//    关键词错误提示
    private String keyWordsError;
//    描述错误提示
    private String descriptionError;

    public String getPhotoError() {
        return photoError;
    }

    public void setPhotoError(String photoError) {
        this.photoError = photoError;
    }

    public String getKeyWordsError() {
        return keyWordsError;
    }

    public void setKeyWordsError(String keyWordsError) {
        this.keyWordsError = keyWordsError;
    }

    public String getDescriptionError() {
        return descriptionError;
    }

    public void setDescriptionError(String descriptionError) {
        this.descriptionError = descriptionError;
    }

    public RecommendVoError() {

    }

    public RecommendVoError(String photoError, String keyWordsError, String descriptionError) {
        this.photoError = photoError;
        this.keyWordsError = keyWordsError;
        this.descriptionError = descriptionError;
    }
}
