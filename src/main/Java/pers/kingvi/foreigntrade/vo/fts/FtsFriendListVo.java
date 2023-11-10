package pers.kingvi.foreigntrade.vo.fts;

import com.baomidou.mybatisplus.annotations.TableId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class FtsFriendListVo {
    @JsonSerialize(using = ToStringSerializer.class)
    @TableId
    private Long id;

    private String photo;

    private String friendMark;

    public FtsFriendListVo() {

    }

    public FtsFriendListVo(Long id, String photo, String friendMark) {
        this.id = id;
        this.photo = photo;
        this.friendMark = friendMark;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getFriendMark() {
        return friendMark;
    }

    public void setFriendMark(String friendMark) {
        this.friendMark = friendMark;
    }
}
