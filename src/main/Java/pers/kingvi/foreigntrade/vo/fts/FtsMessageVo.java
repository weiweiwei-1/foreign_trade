package pers.kingvi.foreigntrade.vo.fts;

public class FtsMessageVo {
    private Long ftsId;
    private String photo;
    private String name;

    public Long getFtsId() {
        return ftsId;
    }

    public void setFtsId(Long ftsId) {
        this.ftsId = ftsId;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FtsMessageVo() {

    }

    public FtsMessageVo(Long ftsId, String photo, String name) {
        this.ftsId = ftsId;
        this.photo = photo;
        this.name = name;
    }
}
