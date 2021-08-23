package com.company.login;

import com.company.dbhelper.DbConnection;
import com.company.menu.Menu;
import com.company.objects.Objects;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {
    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;




    public static void userLogin() {
        System.out.println("Welcome to website!");//Welcome message
        System.out.println("");

        //request username from user
        System.out.println("Enter your username: ");
        String login = scanner.next().trim();
        System.out.println("");


        try {
            ps = DbConnection.user().prepareStatement("SELECT * FROM users WHERE username = '" + login + "';");

            rs = ps.executeQuery();

            //set variable for validation
            String passwordCheck;


            // Check if provided username exists in database
            if (rs.next()) {
                System.out.println("Username accepted.");
                System.out.println("");

                //asking for password from user
                System.out.println("Enter your password: ");
                String password = scanner.next().trim();
                System.out.println("");

                passwordCheck = rs.getString("password");

                //Check if password is correct
                boolean correct = password.equals(passwordCheck);
                if (correct) {
                    System.out.println("Access granted.");

                    String access = rs.getString("access");

                        switch (access) {
                            case "admin":
                                Menu.adminMainMenu();
                                break;
                            case "administration":
                                Menu.administrationMainMenu();
                                break;
                            case "lecturer":
                                Menu.lectorAccessMenu();
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
                System.out.println("");
            } else {
                System.out.println("Username doesn't exist");
                System.out.println("");

            }


        } catch (Exception e) {
            e.printStackTrace();

        }

    }



    }

