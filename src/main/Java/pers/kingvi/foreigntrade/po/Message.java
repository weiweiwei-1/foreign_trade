package pers.kingvi.foreigntrade.po;

public class Message {
    private Integer id;

    private Long senderId;

    private Long receiverId;

    private String content;

    private String sendTime;

    private String status;

    private String messageType;

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", senderId=" + senderId +
                ", receiverId=" + receiverId +
                ", content='" + content + '\'' +
                ", sendTime='" + sendTime + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}