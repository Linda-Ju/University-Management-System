package com.company.controlers;

import com.company.dbhelper.DbConnection;
import com.company.helpers.OutputMessage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserController {
    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;
//selection options can be added- such as review all users and select users by access lvl
   /*
   Since users are automatically not sure that we need new user registration option
   Also user can be deleted on cascade with the person, so not sure if we need delete option
   Only thing that we might need is password change and find user by username so the admin could
    remind password to users, but I'm not sure since there is no sensable data there
    */

    public static void findUserByUsername() {//can access only from admin panel
        System.out.print("\nEnter the username: ");
        String username = scanner.next().trim();
        try {
            ps = DbConnection.user().prepareStatement("SELECT * FROM users WHERE username ='" + username + "'");
            rs = ps.executeQuery();
            System.out.println("\n====================================");
            System.out.printf("%-3.5s %-9.12s %-10.10s %-20.24s%n", "id", "username", "password", "access lvl");
            System.out.println("------------------------------------");
            String userID = null;
            while (rs.next()) {
                userID = rs.getString("id");
                System.out.printf("%-3.5s %-9.12s %-10.10s %-20.24s%n", userID, rs.getString("username"),
                        rs.getString("password"), rs.getString("access"));
                System.out.println("====================================");
            }
            if (userID == null) {
                System.out.println("Such user doesn't exists.\n");
            }
        } catch (SQLException throwables) {
//            throwables.printStackTrace();
            OutputMessage.error();
            findUserByUsername();
        }
    }

    public static void changeUserPassword() {
        // request username from user
        System.out.print("\nEnter your username: ");
        String login = scanner.next().trim();

        System.out.print("\nEnter your old password: ");
        String password = scanner.next().trim();

        try {
            ps = DbConnection.user().prepareStatement("SELECT * FROM users WHERE username = '" + login + "' AND password = '" + password + "';");
            rs = ps.executeQuery();
            //set variable for validation
            String passwordCheck;

            // Check if provided username exists in database
            if (rs.next()) {
                System.out.println("Username excepted.");

                //asking for password from user
                System.out.print("\nEnter your new password: ");
                String password1 = scanner.next().trim();

                System.out.print("\nRepeat your new password once again: ");
                String password2 = scanner.next().trim();

                //check if user is able to type password twice correctly
                if (password1.equals(password2)) {
                    try {
                        ps = DbConnection.user().prepareStatement("UPDATE users SET password = '" + password1 + "' WHERE username ='" + login + "'");
                        ps.execute();
                        System.out.println("The password has been updated.");
                    } catch (Exception e) {
//                        e.printStackTrace();
                        OutputMessage.error();
                        changeUserPassword();
                    }
                } else {
                    System.out.print("\nDo you wish to start over? Y/N : ");
                    String proceed = scanner.next().trim().toUpperCase();
                    if (proceed.equals("Y")) {
                        changeUserPassword();
                    } else {
                        System.out.println("Redirecting to start menu UsC82");
                    }
                }
            }
        } catch (Exception e) {
//            e.printStackTrace();
            OutputMessage.error();

        }
    }

    public static void findUsersByAccess() {
        System.out.println("\n1. Admin");
        System.out.println("2. Administrator");
        System.out.println("3. Lecturer");
        System.out.println("4. Student");
        System.out.println("5. All");
        System.out.println("X. Exit");

        System.out.print("\nSelect an option: \t");
        String option = scanner.next().toUpperCase();
        String access;
        switch (option) {
            case "1":
                access = "admin";
                break;
            case "2":
                access = "administration";
                break;
            case "3":
                access = "lecturer";
                break;
            case "4":
                access = "student";
                break;
            case "5":
                access = "%%";
                break;
            case "X":
                access = null;
                OutputMessage.redirecting();
                break;
            default:
                access = null;
                OutputMessage.invalidInput();

        }
        if (access != null) {
            try {
                ps = DbConnection.user().prepareStatement(" SELECT * FROM users WHERE access LIKE '" + access + "' order by username");
                rs = ps.executeQuery();
                System.out.println("\n" + access.toUpperCase() + " access level: ".toUpperCase());
                System.out.println("\n===================");
                System.out.printf("%-3.5s %-9.12s %-10.10s%n", "#", "username", "password");
                System.out.println("-------------------");
                int count = 1;
                while (rs.next()) {
                    System.out.printf("%-3.5s %-9.12s %-10.10s%n", count, rs.getString("username"),
                            rs.getString("password"));
                    count++;
                }
                System.out.println("===================");
            } catch (SQLException throwables) {
//                throwables.printStackTrace();
                OutputMessage.error();

            }
        }
    }
}//end of class
