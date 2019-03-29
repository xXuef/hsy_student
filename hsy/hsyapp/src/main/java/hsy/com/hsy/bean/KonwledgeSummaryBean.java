package hsy.com.hsy.bean;

public class KonwledgeSummaryBean {

    //知识点
    String konwledge;
    //分数
    String mark;
    //占比
    String proportion;
    //平均分
    String average;
    //平均得分率
    String average_score_rate;

    public KonwledgeSummaryBean(String konwledge, String mark, String proportion, String average, String average_score_rate) {
        this.konwledge = konwledge;
        this.mark = mark;
        this.proportion = proportion;
        this.average = average;
        this.average_score_rate = average_score_rate;
    }

    public String getKonwledge() {
        return konwledge;
    }

    public void setKonwledge(String konwledge) {
        this.konwledge = konwledge;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getProportion() {
        return proportion;
    }

    public void setProportion(String proportion) {
        this.proportion = proportion;
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public String getAverage_score_rate() {
        return average_score_rate;
    }

    public void setAverage_score_rate(String average_score_rate) {
        this.average_score_rate = average_score_rate;
    }
}
