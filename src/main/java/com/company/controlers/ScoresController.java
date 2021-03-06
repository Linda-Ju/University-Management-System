package com.company.controlers;

import com.company.dbhelper.DbConnection;
import com.company.helpers.OutputMessage;
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
// get individual average score by every subject(tip for SQL:select subject, avg(id) as score from scores where student_id = ** group by subject)
// get individual average (tip for SQL: select avg(t.score) from (select username, avg(id) as score from users scores student_id = ** group by access) as t)
// get average for all students(can be used for scholarship and budget places)
    public static void addNewScore() {

        String strDate = SantasLittleHelpers.dateFormat();

        String subjectName = SantasLittleHelpers.subjectCases();

        if (subjectName != null) {
            System.out.print("\nEnter the student's ID: ");
            int studentID = scanner.nextInt();

            System.out.print("\nEnter the lecturer's ID: ");
            int lecturerID = scanner.nextInt();

            System.out.print("\nEnter the score: ");
            int score = scanner.nextInt();

            try {
                ps = DbConnection.user().prepareStatement("INSERT INTO scores(subject, lecturers_id, student_id, score, submitted) " +
                        "VALUES ('" + subjectName + "', " + lecturerID + ", " + studentID + ", " + score + ", '" + strDate + "')");
                ps.execute();
                System.out.println("New score has been added.");
            } catch (Exception e) {
//                e.printStackTrace();
                OutputMessage.error();

            }
        } else {
            System.out.print("\nDo you wish to submit another score? Y/N : ");
            String proceed = scanner.next().trim().toUpperCase();
            if (proceed.equals("Y")) {
                addNewScore();
            } else {
                System.out.println("Redirecting to start menu...");
            }
        }
    }


    //case null missing
    public static void deleteScore() {
        String subjectName = SantasLittleHelpers.subjectCases();

        try {
            System.out.print("\nEnter the student's ID: ");
            int studentID = scanner.nextInt();

            System.out.print("\nEnter a lecturer's ID: ");
            String lecturerID = scanner.next();

            System.out.print("\nEnter the date (dd/mm/yyyy): ");
            String date = scanner.next();
            ps = DbConnection.user().prepareStatement("DELETE FROM scores WHERE subject = '" + subjectName +
                    "' AND student_id = " + studentID + " AND lecturers_id = " + lecturerID + " AND submitted = '" + date + "'");
            ps.execute();
            System.out.println("Successfully deleted score!");
        } catch (Exception e) {
//            e.printStackTrace();
            OutputMessage.error();

        }
    }

    public static void editScore() {
        String subjectName = SantasLittleHelpers.subjectCases();

        if (subjectName != null) {

            System.out.print("\nEnter the student's ID: ");
            int studentID = scanner.nextInt();

            System.out.print("\nEnter the day assignment was submitted (dd.mm.yyyy): ");
            String date = scanner.next();

            System.out.print("\nEnter a lecturer's ID: ");
            int lecturersID = scanner.nextInt();

            System.out.print("\nEnter a new score: ");
            int score = scanner.nextInt();

            try {
                ps = DbConnection.user().prepareStatement("UPDATE scores SET score = " + score + " WHERE subject = '" + subjectName + "'  AND student_id = " + studentID + " AND submitted = '" + date + "' AND lecturers_id = " + lecturersID);
                ps.execute();
                System.out.println("Successfully edited score!");
            } catch (Exception e) {
//                e.printStackTrace();
                OutputMessage.error();

            }
        }
    }

    public static void selectStudentScoresBySubject() {
        String subjectName = SantasLittleHelpers.subjectCases();

        if (subjectName != null) {
            try {
                System.out.print("\nEnter the student's ID: ");
                int studentID = scanner.nextInt();

                ps = DbConnection.user().prepareStatement("SELECT score, submitted FROM scores WHERE student_id = " + studentID + " AND subject = '" + subjectName + "' ORDER BY submitted DESC");
                rs = ps.executeQuery();
                int score;
                String date;
                System.out.println("\nSelected subject: " + subjectName);

                System.out.println("\n========================");
                System.out.printf("%-7.7s %-20.20s%n", "score", "submission date");
                System.out.println("------------------------");
                while (rs.next()) {
                    score = rs.getInt("score");
                    date = rs.getString("submitted");
                    System.out.printf("%-7.7s %-20.20s%n ", score, date);
                }
                System.out.println("=======================");
            } catch (Exception e) {
                //               e.printStackTrace();
                OutputMessage.error();

            }
        }
    }
}
