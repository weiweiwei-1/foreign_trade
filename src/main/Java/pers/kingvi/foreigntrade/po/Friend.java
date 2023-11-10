package pers.kingvi.foreigntrade.po;

import pers.kingvi.foreigntrade.vo.LoginInfo;

public class Friend {
    private Integer id;

    //约定userId为faId
    private Long faId;

    //约定friendId为ftsId
    private Long ftsId;

    private String faMark;

    private String ftsMark;

    private String addTime;

    public Friend() {

    }

    public Friend(Long faId, Long ftsId) {
        this.faId = faId;
        this.ftsId = ftsId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getFaId() {
        return faId;
    }

    public void setFaId(Long faId) {
        this.faId = faId;
    }

    public Long getFtsId() {
        return ftsId;
    }

    public void setFtsId(Long ftsId) {
        this.ftsId = ftsId;
    }

    public String getFaMark() {
        return faMark;
    }

    public void setFaMark(String faMark) {
        this.faMark = faMark;
    }

    public String getFtsMark() {
        return ftsMark;
    }

    public void setFtsMark(String ftsMark) {
        this.ftsMark = ftsMark;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

}