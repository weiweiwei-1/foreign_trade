package pers.kingvi.foreigntrade.vo.fa;

public class FaMessageVo {
    private Long faId;
    private String photo;
    private String name;

    public FaMessageVo() {

    }

    public FaMessageVo(Long faId, String photo, String name) {
        this.faId = faId;
        this.photo = photo;
        this.name = name;
    }

    public Long getFaId() {
        return faId;
    }

    public void setFaId(Long faId) {
        this.faId = faId;
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
}
