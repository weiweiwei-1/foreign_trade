package pers.kingvi.foreigntrade.po;

public class FriendApply {
    private Integer id;

    private Long senderId;

    private Long receiverId;

    private String senderName;

    private String sendTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName == null ? null : senderName.trim();
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public FriendApply() {

    }

    public FriendApply(Long senderId, Long receiverId) {
        this.senderId = senderId;
        this.receiverId = receiverId;
    }

    public FriendApply(Long receiverId, String senderName) {
        this.receiverId = receiverId;
        this.senderName = senderName;
    }

    public FriendApply(Long senderId, Long receiverId, String senderName) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.senderName = senderName;
    }

    @Override
    public String toString() {
        return "FriendApply{" +
                "id=" + id +
                ", senderId=" + senderId +
                ", receiverId=" + receiverId +
                ", senderName='" + senderName + '\'' +
                ", sendTime='" + sendTime + '\'' +
                '}';
    }
}