package pers.kingvi.foreigntrade.vo.fa;

import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;

public class FaRecommendInfoVo {
//    活动照片
    private String activityPhoto;
//    关键词
    private String keyWords;
//    描述
    private String description;
//    标志,标志位为1,则审核表有记录，标志位为0，则审核表没有记录
    private String mark;

    public FaRecommendInfoVo() {

    }

    public FaRecommendInfoVo(String activityPhoto, String keyWords, String description, String mark) {
        this.activityPhoto = activityPhoto;
        this.keyWords = keyWords;
        this.description = description;
        this.mark = mark;
    }

    public String getActivityPhoto() {
        return activityPhoto;
    }

    public void setActivityPhoto(String activityPhoto) {
        this.activityPhoto = activityPhoto;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
