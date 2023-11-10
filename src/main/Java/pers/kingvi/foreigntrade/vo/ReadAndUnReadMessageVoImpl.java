package pers.kingvi.foreigntrade.vo;

public class ReadAndUnReadMessageVoImpl extends ReadAndUnReadMessageVo{
    private String messageType;

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public ReadAndUnReadMessageVoImpl() {

    }

    public ReadAndUnReadMessageVoImpl(String messageType) {
        this.messageType = messageType;
    }

    public ReadAndUnReadMessageVoImpl(Long friendId, String friendPhoto, String friendMark, Integer unReadMessageCount, String content, String sendTime, String messageType) {
        super(friendId, friendPhoto, friendMark, unReadMessageCount, content, sendTime);
        this.messageType = messageType;
    }
}
