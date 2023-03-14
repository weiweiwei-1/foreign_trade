package pers.kingvi.foreigntrade.vo;

import java.util.Date;

public class UnReadMessageVo {
    private int id;

    private int unReadMessageCount;

    private Long friendId;

    private Long receiverId;

    private String friendPhoto;

    private String friendMark;

    private String content;

    private String sendTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUnReadMessageCount() {
        return unReadMessageCount;
    }

    public void setUnReadMessageCount(int unReadMessageCount) {
        this.unReadMessageCount = unReadMessageCount;
    }

    public Long getFriendId() {
        return friendId;
    }

    public void setFriendId(Long friendId) {
        this.friendId = friendId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public String getFriendPhoto() {
        return friendPhoto;
    }

    public void setFriendPhoto(String friendPhoto) {
        this.friendPhoto = friendPhoto;
    }

    public String getFriendMark() {
        return friendMark;
    }

    public void setFriendMark(String friendMark) {
        this.friendMark = friendMark;
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

    @Override
    public String toString() {
        return "UnReadMessageVo{" +
                "id=" + id +
                ", unReadMessageCount=" + unReadMessageCount +
                ", friendId=" + friendId +
                ", receiverId=" + receiverId +
                ", friendPhoto='" + friendPhoto + '\'' +
                ", friendMark='" + friendMark + '\'' +
                ", content='" + content + '\'' +
                ", sendTime=" + sendTime +
                '}';
    }
}
