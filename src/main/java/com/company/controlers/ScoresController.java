package com.company.controlers;

import com.company.dbhelper.DbConnection;
import com.company.helpers.SantasLittleHelpers;
import com.company.menu.SubMenu;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ScoresController {
    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;
    //need to think about getScoresByStudentsID, that method can be used for edit method,
    //but it must pass subjectName, studentsID so the only thing that will be needed
    // for submission change - date and lecturersID(that can be sign automatically
    //if we figure out proper login method)
//needs a couple of methods:
// get individual average score by every subject
// get individual average
// get average for all students(can be used for scholarship and budget places)
    public static void addNewScore() {

        String strDate = SantasLittleHelpers.dateFormat();

        System.out.print("Enter the student's ID: ");
        int studentID = scanner.nextInt();
        System.out.println("");

        System.out.print("Enter the lecturer's ID: ");
        int lecturerID = scanner.nextInt();
        System.out.println("");

        System.out.print("Enter a score: ");
        int score = scanner.nextInt();
        System.out.println("");

        String subjectName = SantasLittleHelpers.subjectCases();

        if (subjectName != null) {
            try {
                ps = DbConnection.user().prepareStatement("INSERT INTO scores(subject, lecturers_id, student_id, score, submitted) " +
                        "VALUES ('" + subjectName + "', " + lecturerID + ", " + studentID + ", " + score + ", '" + strDate + "')");
                ps.execute();
                System.out.println("New score has been added");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Do you wish to start over Y/N");
            String proceed = scanner.next().trim().toUpperCase();
            if (proceed.equals("Y")) {
                addNewScore();
            } else {
                System.out.println("Redirecting to start menu");
                SubMenu.scoreSubMenu();
            }
        }
    }

    public static void deleteScore() {

        System.out.print("Enter the student's ID: ");
        int studentID = scanner.nextInt();
        System.out.println("");

        System.out.print("Enter a lecturer's ID: ");
        String lecturerID = scanner.next();
        System.out.println("");

        System.out.print("Enter the date (dd/MM/yyyy): ");
        String date = scanner.next();

        String subjectName = SantasLittleHelpers.subjectCases();

        try {
            ps = DbConnection.user().prepareStatement("DELETE FROM scores WHERE subject = '" + subjectName +
                    "' AND student_id = " + studentID + " AND lecturers_id = " + lecturerID + " AND submitted = '" + date + "'");
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

        System.out.print("Enter the day assignment was submitted : ");
        String date = scanner.next();
        System.out.println("");

        System.out.print("Enter a lecturer's ID: ");
        int lecturersID = scanner.nextInt();
        System.out.println("");

        String subjectName = SantasLittleHelpers.subjectCases();

        if (subjectName != null) {
            System.out.print("Enter a new score: ");
            int score = scanner.nextInt();
            System.out.println("");

            try {
                ps = DbConnection.user().prepareStatement("UPDATE scores SET score = " + score + " WHERE subject = '" + subjectName + "'  AND student_id = " + studentID + " AND submitted = '" + date + "' AND lecturers_id = " + lecturersID);
                ps.execute();
                System.out.println("Successfully edited score!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Do you wish to start over Y/N");
            String proceed = scanner.next().trim().toUpperCase();
            if (proceed.equals("Y")) {
                editScore();
            } else {
                System.out.println("Redirecting to start menu");
                SubMenu.scoreSubMenu();
            }
        }
    }

    public static void getScoresBySubjectAndStudentID() {
        System.out.print("Enter the student's ID: ");
        int studentID = scanner.nextInt();
        System.out.println("");

        String subjectName = SantasLittleHelpers.subjectCases();

        try {
            ps = DbConnection.user().prepareStatement("SELECT score, submitted FROM scores WHERE student_id = " + studentID + " AND subject = '" + subjectName + "'");
            rs = ps.executeQuery();
            int score;
            String date;
            System.out.println(subjectName);
            System.out.println(" score \t submission date");
            while (rs.next()) {
                score = rs.getInt("score");
                date = rs.getString("submitted");
                System.out.println(score + "\t" + date );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
