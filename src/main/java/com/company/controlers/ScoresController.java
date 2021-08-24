package com.company.controlers;

import com.company.dbhelper.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ScoresController {
    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static void addNewScore() {

        System.out.println("Enter the student's ID: ");
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

        System.out.print("Enter the day assignment was submitted : ");
        String submitted = scanner.next();

        System.out.println("Enter a score: ");
        int score = scanner.nextInt();
        System.out.println("");

        switch (subject) {
            case 1:
                try {
                    ps = DbConnection.user().prepareStatement("INSERT INTO scores(score, submitted) VALUES " + score + ", '" + submitted + "' WHERE students_id=" + studentID + "AND subject= Mathematics");
                    ps.execute();
                    System.out.println("New score has been added");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    ps = DbConnection.user().prepareStatement("INSERT INTO scores(score, submitted) VALUES " + score + ", '" + submitted + "' WHERE students_id=" + studentID + "AND subject= Physics");
                    ps.execute();
                    System.out.println("New score has been added");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                try {
                    ps = DbConnection.user().prepareStatement("INSERT INTO scores(score, submitted) VALUES " + score + ", '" + submitted + "' WHERE students_id=" + studentID + "AND subject= Chemistry");
                    ps.execute();
                    System.out.println("New score has been added");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 4:
                try {
                    ps = DbConnection.user().prepareStatement("INSERT INTO scores(score, submitted) VALUES " + score + ", '" + submitted + "' WHERE students_id=" + studentID + "AND subject= History");
                    ps.execute();
                    System.out.println("New score has been added");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 5:
                try {
                    ps = DbConnection.user().prepareStatement("INSERT INTO scores(score, submitted) VALUES " + score + ", '" + submitted + "' WHERE students_id=" + studentID + "AND subject= Spanish");
                    ps.execute();
                    System.out.println("New score has been added");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 6:
                try {
                    ps = DbConnection.user().prepareStatement("INSERT INTO scores(score, submitted) VALUES " + score + ", '" + submitted + "' WHERE students_id=" + studentID + "AND subject= English");
                    ps.execute();
                    System.out.println("New score has been added");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Invalid input, try again!");
        }
    }

    public static void deleteScore() {

        System.out.println("Enter the student's ID: ");
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

        System.out.print("Enter the day assignment was submitted : ");
        String submitted = scanner.next();

        System.out.println("Enter a lecturer's ID: ");
        String lecturerID = scanner.next();
        System.out.println("");

        switch (subject) {
            case 1:
                try {
                    ps = DbConnection.user().prepareStatement("DELETE FROM scores WHERE subject= Mathematics AND students_id=" + studentID + " AND lecturer_id=" + lecturerID + "AND submitted=" + submitted);
                    ps.execute();
                    System.out.println("Successfully deleted score!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    ps = DbConnection.user().prepareStatement("DELETE FROM scores WHERE subject= Physics AND students_id=" + studentID + " AND lecturer_id=" + lecturerID + "AND submitted=" + submitted);
                    ps.execute();
                    System.out.println("Successfully deleted score!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                try {
                    ps = DbConnection.user().prepareStatement("DELETE FROM scores WHERE subject= Chemistry AND students_id=" + studentID + " AND lecturer_id=" + lecturerID + "AND submitted=" + submitted);
                    ps.execute();
                    System.out.println("Successfully deleted score!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 4:
                try {
                    ps = DbConnection.user().prepareStatement("DELETE FROM scores WHERE subject= History AND students_id=" + studentID + " AND lecturer_id=" + lecturerID + "AND submitted=" + submitted);
                    ps.execute();
                    System.out.println("Successfully deleted score!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 5:
                try {
                    ps = DbConnection.user().prepareStatement("DELETE FROM scores WHERE subject= English AND students_id=" + studentID + " AND lecturer_id=" + lecturerID + "AND submitted=" + submitted);
                    ps.execute();
                    System.out.println("Successfully deleted score!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 6:
                try {
                    ps = DbConnection.user().prepareStatement("DELETE FROM scores WHERE subject= Spanish AND students_id=" + studentID + " AND lecturer_id=" + lecturerID + "AND submitted=" + submitted);
                    ps.execute();
                    System.out.println("Successfully deleted score!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Invalid input, try again!");
        }
    }

    public static void editScore() {

        System.out.println("Enter the student's ID: ");
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

        System.out.print("Enter the day assignment was submitted : ");
        String submitted = scanner.next();

        System.out.println("Enter a lecturer's ID: ");
        int score = scanner.nextInt();
        System.out.println("");

        switch (subject) {
            case 1:
                try {
                    ps = DbConnection.user().prepareStatement("UPDATE scores SET score = " + score + "WHERE subject= Mathematics AND students_id=" + studentID + "submitted=" + submitted);
                    ps.execute();
                    System.out.println("Successfully edited score!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    ps = DbConnection.user().prepareStatement("UPDATE scores SET score = " + score + "WHERE subject= Physics AND students_id=" + studentID + "submitted=" + submitted);
                    ps.execute();
                    System.out.println("Successfully edited score!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                try {
                    ps = DbConnection.user().prepareStatement("UPDATE scores SET score = " + score + "WHERE subject= Chemistry AND students_id=" + studentID + "submitted=" + submitted);
                    ps.execute();
                    System.out.println("Successfully edited score!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 4:
                try {
                    ps = DbConnection.user().prepareStatement("UPDATE scores SET score = " + score + "WHERE subject= History AND students_id=" + studentID + "submitted=" + submitted);
                    ps.execute();
                    System.out.println("Successfully edited score!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 5:
                try {
                    ps = DbConnection.user().prepareStatement("UPDATE scores SET score = " + score + "WHERE subject= English AND students_id=" + studentID + "submitted=" + submitted);
                    ps.execute();
                    System.out.println("Successfully edited score!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 6:
                try {
                    ps = DbConnection.user().prepareStatement("UPDATE scores SET score = " + score + "WHERE subject= Spanish AND students_id=" + studentID + "submitted=" + submitted);
                    ps.execute();
                    System.out.println("Successfully edited score!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Invalid input, try again!");
        }
    }

    public static void getScoreByStudentID() {
        System.out.println("Enter the student's ID: ");
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

        switch (subject) {
            case 1:
                try {
                    ps = DbConnection.user().prepareStatement("SELECT * FROM scores WHERE students_id = " + studentID + "AND subject= Mathematics");
                    ps.execute();
                    System.out.println("score \t submitted");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    ps = DbConnection.user().prepareStatement("SELECT * FROM scores WHERE students_id = " + studentID + "AND subject= Physics");
                    ps.execute();
                    System.out.println("score \t submitted");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                try {
                    ps = DbConnection.user().prepareStatement("SELECT * FROM scores WHERE students_id = " + studentID + "AND subject= Chemistry");
                    ps.execute();
                    System.out.println("score \t submitted");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 4:
                try {
                    ps = DbConnection.user().prepareStatement("SELECT * FROM scores WHERE students_id = " + studentID + "AND subject= History");
                    ps.execute();
                    System.out.println("score \t submitted");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 5:
                try {
                    ps = DbConnection.user().prepareStatement("SELECT * FROM scores WHERE students_id = " + studentID + "AND subject= English");
                    ps.execute();
                    System.out.println("score \t submitted");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 6:
                try {
                    ps = DbConnection.user().prepareStatement("SELECT * FROM scores WHERE students_id = " + studentID + "AND subject= Spanish");
                    ps.execute();
                    System.out.println("score \t submitted");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Invalid input, try again!");
        }
    }
}
