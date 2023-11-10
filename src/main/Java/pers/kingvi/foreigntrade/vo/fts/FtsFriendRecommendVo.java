package pers.kingvi.foreigntrade.vo.fts;

import com.alibaba.druid.sql.visitor.functions.Char;
import com.baomidou.mybatisplus.annotations.TableId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class FtsFriendRecommendVo {

    @JsonSerialize(using = ToStringSerializer.class)
    @TableId
    private Long id;

    private String name;

    private String photo;

    private char onlineStatus;

    public FtsFriendRecommendVo() {

    }

    public char getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(char onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public FtsFriendRecommendVo(String name, String photo) {
        this.name = name;
        this.photo = photo;
    }

    public FtsFriendRecommendVo(Long id, String name, String photo, char onlineStatus) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.onlineStatus = onlineStatus;
    }

    public FtsFriendRecommendVo(Long id, String name, String photo) {
        this.id = id;
        this.name = name;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
