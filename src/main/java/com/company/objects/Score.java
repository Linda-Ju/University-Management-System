package com.company.objects;

public class Score {
    private String subject;
    private int lecturerID;
    private int studentID;
    private int score;

    public Score() {
    }

    public Score(String subject, int lecturerID, int studentID, int score) {
        this.subject = subject;
        this.lecturerID = lecturerID;
        this.studentID = studentID;
        this.score = score;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getLecturerID() {
        return lecturerID;
    }

    public void setLecturerID(int lecturerID) {
        this.lecturerID = lecturerID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
