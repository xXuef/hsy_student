package hsy.com.hsy.bean.table;


public class SpecialtyTable {

    String studyType;
    String subjectType;
    String subjectName;
    String detailed;

    public SpecialtyTable(String studyType, String subjectType, String subjectName, String detailed) {
        this.studyType = studyType;
        this.subjectType = subjectType;
        this.subjectName = subjectName;
        this.detailed = detailed;
    }

    public String getStudyType() {
        return studyType;
    }

    public void setStudyType(String studyType) {
        this.studyType = studyType;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getDetailed() {
        return detailed;
    }

    public void setDetailed(String detailed) {
        this.detailed = detailed;
    }
}
