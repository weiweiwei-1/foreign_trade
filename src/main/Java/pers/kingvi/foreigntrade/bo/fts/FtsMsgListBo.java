package pers.kingvi.foreigntrade.bo.fts;

public class FtsMsgListBo {

    private Integer id;

    private Long senderId;

    private Long receiverId;

    private String content;

    private String sendTime;

    private int unReadCount;

    public FtsMsgListBo() {
    }

    public FtsMsgListBo(Integer id, Long senderId, Long receiverId, String content, String sendTime, int unReadCount) {
        this.id = id;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.content = content;
        this.sendTime = sendTime;
        this.unReadCount = unReadCount;
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
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public int getUnReadCount() {
        return unReadCount;
    }

    public void setUnReadCount(int unReadCount) {
        this.unReadCount = unReadCount;
    }
}
