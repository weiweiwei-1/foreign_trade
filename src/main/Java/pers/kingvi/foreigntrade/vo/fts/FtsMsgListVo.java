package pers.kingvi.foreigntrade.vo.fts;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class FtsMsgListVo {

    @JsonSerialize(using = ToStringSerializer.class)
    @TableId(type = IdType.AUTO)
    private Long senderId;

    @JsonSerialize(using = ToStringSerializer.class)
    @TableId(type = IdType.AUTO)
    private Long receiverId;

    private String photo;

    private String senderName;

    private String content;

    private String sendTime;

    private int unReadCount;

    public FtsMsgListVo() {

    }

    public FtsMsgListVo(Long senderId, Long receiverId, String photo, String senderName, String content, String sendTime, int unReadCount) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.photo = photo;
        this.senderName = senderName;
        this.content = content;
        this.sendTime = sendTime;
        this.unReadCount = unReadCount;
    }

    public FtsMsgListVo(Long senderId, Long receiverId, String photo, String senderName) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.photo = photo;
        this.senderName = senderName;
    }

    public FtsMsgListVo(Long senderId, Long receiverId, String content, String sendTime, int unReadCount) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.content = content;
        this.sendTime = sendTime;
        this.unReadCount = unReadCount;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
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
