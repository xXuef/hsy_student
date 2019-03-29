package hsy.com.hsy.bean;

public class FourParamenterBean {

    String sum;
    String equally;
    String classRanking;
    String schoolRanking;

    public FourParamenterBean(String sum, String equally, String classRanking, String schoolRanking) {
        this.sum = sum;
        this.equally = equally;
        this.classRanking = classRanking;
        this.schoolRanking = schoolRanking;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getEqually() {
        return equally;
    }

    public void setEqually(String equally) {
        this.equally = equally;
    }

    public String getClassRanking() {
        return classRanking;
    }

    public void setClassRanking(String classRanking) {
        this.classRanking = classRanking;
    }

    public String getSchoolRanking() {
        return schoolRanking;
    }

    public void setSchoolRanking(String schoolRanking) {
        this.schoolRanking = schoolRanking;
    }
}
