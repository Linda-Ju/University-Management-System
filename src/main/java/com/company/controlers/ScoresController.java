package com.company.controlers;

import com.company.dbhelper.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ScoresController {
    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static void addNewScore() {

        String strDate = dateFormat();

        System.out.print("Enter the student's ID: ");
        int studentID = scanner.nextInt();
        System.out.println("");

        System.out.print("Enter the lecturer's ID: ");
        int lecturerID = scanner.nextInt();
        System.out.println("");

        System.out.println("Choose a subject");
        System.out.println("1. Mathematics");
        System.out.println("2. Physics");
        System.out.println("3. Chemistry");
        System.out.println("4. History");
        System.out.println("5. English");
        System.out.println("6. Spanish");

        System.out.print("Select an option: ");
        int subject = scanner.nextInt();

        String subjectName = "";

        System.out.print("Enter a score: ");
        int score = scanner.nextInt();
        System.out.println("");

        switch (subject) {
            case 1:
                subjectName = "Mathematics";
                break;
            case 2:
                subjectName = "Physics";
                break;
            case 3:
                subjectName = "Chemistry";
                break;
            case 4:
                subjectName = "History";
                break;
            case 5:
                subjectName = "English";
                break;
            case 6:
                subjectName = "Spanish";
                break;
            default:
                System.out.println("Invalid input, try again!");
        }
        try {
            ps = DbConnection.user().prepareStatement("INSERT INTO scores(subject, lecturers_id, student_id, score, submitted) VALUES ('" + subjectName + "', " + lecturerID + ", " + studentID + ", " + score + ", '" + strDate + "')");
            ps.execute();
            System.out.println("New score has been added");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteScore() {

        System.out.print("Enter the student's ID: ");
        int studentID = scanner.nextInt();
        System.out.println("");

        System.out.println("Choose a subject");
        System.out.println("1. Mathematics");
        System.out.println("2. Physics");
        System.out.println("3. Chemistry");
        System.out.println("4. History");
        System.out.println("5. English");
        System.out.println("6. Spanish");

        System.out.print("Select an option: ");
        int subject = scanner.nextInt();

        String subjectName = "";

        System.out.print("Enter a lecturer's ID: ");
        String lecturerID = scanner.next();
        System.out.println("");

        System.out.print("Enter the date (dd/MM/yyyy): ");
        String date = scanner.next();

        switch (subject) {
            case 1:
                subjectName = "Mathematics";
                break;
            case 2:
                subjectName = "Physics";
                break;
            case 3:
                subjectName = "Chemistry";
                break;
            case 4:
                subjectName = "History";
                break;
            case 5:
                subjectName = "English";
                break;
            case 6:
                subjectName = "Spanish";
                break;
            default:
                System.out.println("Invalid input, try again!");
        }
        try {
            ps = DbConnection.user().prepareStatement("DELETE FROM scores WHERE subject = '" + subjectName + "' AND student_id = " + studentID + " AND lecturers_id = " + lecturerID + " AND submitted = '" + date + "'");
            ps.execute();
            System.out.println("Successfully deleted score!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void editScore() {

        System.out.print("Enter the student's ID: ");
        int studentID = scanner.nextInt();
        System.out.println("");

        System.out.println("Choose a subject");
        System.out.println("1. Mathematics");
        System.out.println("2. Physics");
        System.out.println("3. Chemistry");
        System.out.println("4. History");
        System.out.println("5. English");
        System.out.println("6. Spanish");

        System.out.print("Select an option: ");
        int subject = scanner.nextInt();
        String subjectName = "";

        System.out.print("Enter the day assignment was submitted : ");
        String date = scanner.next();
        System.out.println("");

        System.out.print("Enter a lecturer's ID: ");
        int lecturersID = scanner.nextInt();
        System.out.println("");

        System.out.print("Enter a new score: ");
        int score = scanner.nextInt();
        System.out.println("");

        switch (subject) {
            case 1:
                subjectName = "Mathematics";
                break;
            case 2:
                subjectName = "Physics";
                break;
            case 3:
                subjectName = "Chemistry";
                break;
            case 4:
                subjectName = "History";
                break;
            case 5:
                subjectName = "English";
                break;
            case 6:
                subjectName = "Spanish";
                break;
            default:
                System.out.println("Invalid input, try again!");
        }
        try {
            ps = DbConnection.user().prepareStatement("UPDATE scores SET score = " + score + " WHERE subject = '" + subjectName + "'  AND student_id = " + studentID + " AND submitted = '" + date + "' AND lecturers_id = " + lecturersID);
            ps.execute();
            System.out.println("Successfully edited score!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getScoreByStudentID() {
        System.out.print("Enter the student's ID: ");
        int studentID = scanner.nextInt();
        System.out.println("");

        System.out.println("Choose a subject");
        System.out.println("1. Mathematics");
        System.out.println("2. Physics");
        System.out.println("3. Chemistry");
        System.out.println("4. History");
        System.out.println("5. English");
        System.out.println("6. Spanish");
        System.out.println("");

        System.out.print("Select an option: ");
        int subject = scanner.nextInt();
        System.out.println("");
        String subjectName = "";

        switch (subject) {
            case 1:
                subjectName = "Mathematics";
                break;
            case 2:
                subjectName = "Physics";
                break;
            case 3:
                subjectName = "Chemistry";
                break;
            case 4:
                subjectName = "History";
                break;
            case 5:
                subjectName = "English";
                break;
            case 6:
                subjectName = "Spanish";
                break;
            default:
                System.out.println("Invalid input, try again!");
        }


        try {
            ps = DbConnection.user().prepareStatement("SELECT score, submitted FROM scores WHERE student_id = " + studentID + " AND subject = '" + subjectName + "'");
            rs = ps.executeQuery();
            int score;
            String date;
            while (rs.next()){
                score = rs.getInt("score");
                date = rs.getString("submitted");
                System.out.println(score + "\t" + date + "\t");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String dateFormat() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(date);
    }
}
