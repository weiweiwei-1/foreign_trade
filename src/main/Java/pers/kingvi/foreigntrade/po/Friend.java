package pers.kingvi.foreigntrade.po;

public class Friend {
    private Integer id;

    private Long userId;

    private Long friendId;

    private String userMark;

    private String friendMark;

    private String addTime;

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public Integer getId() {
        return id;

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFriendId() {
        return friendId;
    }

    public void setFriendId(Long friendId) {
        this.friendId = friendId;
    }

    public String getUserMark() {
        return userMark;
    }

    public void setUserMark(String userMark) {
        this.userMark = userMark == null ? null : userMark.trim();
    }

    public String getFriendMark() {
        return friendMark;
    }

    public void setFriendMark(String friendMark) {
        this.friendMark = friendMark == null ? null : friendMark.trim();
    }

    @Override
    public String toString() {
        return "FriendVo{" +
                "id=" + id +
                ", userId=" + userId +
                ", friendId=" + friendId +
                ", userMark='" + userMark + '\'' +
                ", friendMark='" + friendMark + '\'' +
                ", addTime='" + addTime + '\'' +
                '}';
    }
}