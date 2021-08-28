package com.company.controlers;
///THIS IS COPY FROM OTHER PROJECT, NEEDS TO BE UPDATED

import com.company.dbhelper.DbConnection;

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

            System.out.println("id \t  username \t password \t access lvl");

            while (rs.next()) {
                System.out.println(rs.getInt("id") + " \t " +
                        rs.getString("username") + " \t " + rs.getString("password") + " \t " + rs.getString("access"));
                System.out.println("");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void changeUserPassword() {
        // request username from user
        System.out.print("\nEnter your username: ");
        String login = scanner.next().trim();

        System.out.print("\nEnter your old password: ");
        String password = scanner.next().trim();

        try {
            ps = DbConnection.user().prepareStatement("SELECT * FROM users WHERE username = '" + login + " AND password = '" + password + "';");
            rs = ps.executeQuery();
            //set variable for validation
            String passwordCheck;

            // Check if provided username exists in database
            if (rs.next()) {
                System.out.println("Username excepted.");

                //asking for password from user
                System.out.print("\nEnter password: ");
                String password1 = scanner.next().trim();

                System.out.print("\nRetype your password: ");
                String password2 = scanner.next().trim();

                //check if user is able to type password twice correctly
                if (password1.equals(password2)) {
                    try {
                        ps = DbConnection.user().prepareStatement("UPDATE users SET last_name = '" + password1 + "' WHERE username ='" + login + "'");
                        ps.execute();
                        System.out.println("successfully updated");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.print("\nDo you wish to start over? Y/N");
                    String proceed = scanner.next().trim().toUpperCase();
                    if (proceed.equals("Y")) {
                        changeUserPassword();
                    } else {
                        System.out.println("Redirecting to start menu");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Redirecting to start menu");
        }
    }
}//end of class
