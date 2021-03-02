package pers.kingvi.foreigntrade.vo;

public class FriendApplyVo {
    private String photo;

    private Long senderId;

    private String senderName;

    private String sendTime;

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    @Override
    public String toString() {
        return "FriendApplyVo{" +
                "photo='" + photo + '\'' +
                ", senderId=" + senderId +
                ", senderName='" + senderName + '\'' +
                ", sendTime='" + sendTime + '\'' +
                '}';
    }
}
