package com.company.login;

import com.company.dbhelper.DbConnection;
import com.company.helpers.OutputMessage;
import com.company.menu.Menu;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Login {
    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;


    public static void userLogin() {
        System.out.println("Welcome to the website!");//Welcome message

        //request username from user
        System.out.print("\nEnter your username: ");
        String input = scanner.next().trim();

        System.out.print("\nEnter your password: ");
        String password = scanner.next().trim();

        //checking login before connecting to database.
        String login = null;
        if (input.toCharArray().length < 12) {
            login = input;
        } else {
            System.out.println("Login failed. Check password");
        }
        try {
            ps = DbConnection.user().prepareStatement("SELECT * FROM users WHERE username = '" + login + "';");
            rs = ps.executeQuery();
            //set variable for validation
            String passwordCheck;

            //asking for password from user
            while (rs.next()) {
                passwordCheck = rs.getString("password");
                //Check if password is correct
                boolean correct = password.equals(passwordCheck);
                if (correct) {
                    System.out.println("Access granted.\n");

                    String access = rs.getString("access");
                    switch (access) {
                        case "admin":
                            Menu.adminMainMenu();
                            break;
                        case "administration":
                            Menu.administrationMainMenu();
                            break;
                        case "lecturer":
                            Menu.lecturerAccessMenu();
                            break;
                        case "student":
                            Menu.studentAccessMenu();
                            break;
                        default:
                            System.out.println("You don't have an access. Please contact administration for more details!");
                    }
                } else {
                    System.out.println("Login failed. Check password");
                }
            }
        } catch (Exception e) {
//            e.printStackTrace();
            OutputMessage.error();
            userLogin();
        }
    }
}
