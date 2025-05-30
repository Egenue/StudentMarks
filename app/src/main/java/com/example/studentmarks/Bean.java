package com.example.studentmarks;

public class Bean {

    private String strCat;
    private String strStudentName;
    private String strMarks;
    private String strSubject;
    private String strstudent_regNo;
    private String strsubjectCode;
    private String strTotal;
        public Bean(){

    }

    public Bean(String strStudentName, String strsubject_code, String strCat, String strTotal, String strMarks, String strSubject, String strstudent_regNo) {
        this.strStudentName = strStudentName;
        this.strsubjectCode = strsubject_code;
        this.strCat = strCat;
        this.strMarks = strMarks;
        this.strSubject = strSubject;
        this.strstudent_regNo = strstudent_regNo;
        this.strTotal = strTotal;
    }

    public String getStrstudent_regNo() {
        return strstudent_regNo;
    }

    public void setStrstudent_regNo(String strstudent_regNo) {
        this.strstudent_regNo = strstudent_regNo;
    }

    public String getStrStudentName() {
        return strStudentName;
    }

    public void setStrStudentName(String strStudentName) {
        this.strStudentName = strStudentName;
    }

    public String getStrMarks() {
        return strMarks;
    }

    public void setStrMarks(String strMarks) {
        this.strMarks = strMarks;
    }

    public String getStrSubject() {
        return strSubject;
    }

    public void setStrSubject(String strSubject) {
        this.strSubject = strSubject;
    }

    public String getStrsubjectCode() {
        return strsubjectCode;
    }

    public void setStrsubjectCode(String strsubjectCode) {
        this.strsubjectCode = strsubjectCode;
    }

    public String getStrTotal() {
        return strTotal;
    }

    public void setStrTotal(String strTotal) {
        this.strTotal = strTotal;
    }

    public String getStrCat() {
        return strCat;
    }

    public void setStrCat(String strCat) {
        this.strCat = strCat;
    }
}