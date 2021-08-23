package com.company.controlers;

import com.company.dbhelper.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ScoresController {
    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static boolean addNewScore() {

        System.out.println("Enter the student's id: ");
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

        System.out.println("Enter a score: ");
        int score = scanner.nextInt();
        System.out.println("");

        switch (subject) {
            case 1:
                try {
                    ps = DbConnection.user().prepareStatement("INSERT INTO scores(score) VALUES " + score + " WHERE students_id=" + studentID + "AND subject= Mathematics");
                    ps.execute();
                    System.out.println("New score has been added");
                    System.out.println("");
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            case 2:
                try {
                    ps = DbConnection.user().prepareStatement("INSERT INTO scores(score) VALUES " + score + " WHERE students_id=" + studentID + "AND subject= Physics");
                    ps.execute();
                    System.out.println("New score has been added");
                    System.out.println("");
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            case 3:
                try {
                    ps = DbConnection.user().prepareStatement("INSERT INTO scores(score) VALUES " + score + " WHERE students_id=" + studentID + "AND subject= Chemistry");
                    ps.execute();
                    System.out.println("New score has been added");
                    System.out.println("");
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            case 4:
                try {
                    ps = DbConnection.user().prepareStatement("INSERT INTO scores(score) VALUES " + score + " WHERE students_id=" + studentID + "AND subject= History");
                    ps.execute();
                    System.out.println("New score has been added");
                    System.out.println("");
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            case 5:
                try {
                    ps = DbConnection.user().prepareStatement("INSERT INTO scores(score) VALUES " + score + " WHERE students_id=" + studentID + "AND subject= Spanish");
                    ps.execute();
                    System.out.println("New score has been added");
                    System.out.println("");
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            case 6:
                try {
                    ps = DbConnection.user().prepareStatement("INSERT INTO scores(score) VALUES " + score + " WHERE students_id=" + studentID + "AND subject= English");
                    ps.execute();
                    System.out.println("New score has been added");
                    System.out.println("");
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            default:
                System.out.println("Invalid input, try again!");
        }
        return false;
    }
}

