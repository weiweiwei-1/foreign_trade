package pers.kingvi.foreigntrade.vo;

//import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.util.Date;

public class ReadAndUnReadMessageVo {
    private Integer id;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long friendId;

    private String friendPhoto;

    private String friendMark;

    private Integer unReadMessageCount;

    private String content;

    private String sendTime;

    public ReadAndUnReadMessageVo() {

    }

    public ReadAndUnReadMessageVo(Integer id, String content, String sendTime) {
        this.id = id;
        this.content = content;
        this.sendTime = sendTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getFriendId() {
        return friendId;
    }

    public void setFriendId(Long friendId) {
        this.friendId = friendId;
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

    public Integer getUnReadMessageCount() {
        return unReadMessageCount;
    }

    public void setUnReadMessageCount(Integer unReadMessageCount) {
        this.unReadMessageCount = unReadMessageCount;
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
        return "ReadAndUnReadMessageVo{" +
                "id=" + id +
                ", friendId=" + friendId +
                ", friendPhoto='" + friendPhoto + '\'' +
                ", friendMark='" + friendMark + '\'' +
                ", unReadMessageCount=" + unReadMessageCount +
                ", content='" + content + '\'' +
                ", sendTime=" + sendTime +
                '}';
    }
}
