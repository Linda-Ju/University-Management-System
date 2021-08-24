package com.company.objects;

public class Score {
    String subject;
    int lecturers_id;
    int student_id;
    int score;
    String date;

    public Score(){}

    public Score(String subject, int lecturers_id, int student_id, int score, String date) {
        this.subject = subject;
        this.lecturers_id = lecturers_id;
        this.student_id = student_id;
        this.score = score;
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getLecturers_id() {
        return lecturers_id;
    }

    public void setLecturers_id(int lecturers_id) {
        this.lecturers_id = lecturers_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
