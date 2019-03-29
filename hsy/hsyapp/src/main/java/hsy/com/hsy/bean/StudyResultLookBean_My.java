package hsy.com.hsy.bean;

public class StudyResultLookBean_My {

    String chinese;
    String manth;
    String engLish;
    String sport;
    String art;
    String music;
    String technology;
    String currency;

    public StudyResultLookBean_My(String chinese, String manth, String engLish, String sport, String art, String music, String technology, String currency) {
        this.chinese = chinese;
        this.manth = manth;
        this.engLish = engLish;
        this.sport = sport;
        this.art = art;
        this.music = music;
        this.technology = technology;
        this.currency = currency;
    }

    public String getChinese() {
        return chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }

    public String getManth() {
        return manth;
    }

    public void setManth(String manth) {
        this.manth = manth;
    }

    public String getEngLish() {
        return engLish;
    }

    public void setEngLish(String engLish) {
        this.engLish = engLish;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getArt() {
        return art;
    }

    public void setArt(String art) {
        this.art = art;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
