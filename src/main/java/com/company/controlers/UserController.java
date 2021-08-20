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
    //table users

    private static boolean addNewUser() {
        System.out.println("New user registration");//Introduction
        System.out.println("");

        //ask user to provide username
        System.out.println("Enter username: ");
        String login = scanner.next().trim();
        System.out.println("");

        //Check if username is already taken
        try {
            ps = DbConnection.user().prepareStatement("SELECT * FROM users WHERE username = '" + login + "';");

            rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("This username is taken. Try '" + login + "1'.");
                System.out.println("");
                return false;

            } else {
                System.out.println("Username OK");
                System.out.println("");

                //ask user to provide password
                System.out.println("Enter password: ");
                String password1 = scanner.next().trim();
                System.out.println("");

                System.out.println("Retype your password: ");
                String password2 = scanner.next().trim();
                System.out.println("");

            //check if user is able to type password twice correctly
                if(password1.equals(password2)){
                    try {
                        ps = DbConnection.user().prepareStatement("INSERT INTO users(username, password)" +
                                "VALUES ('" + login + "', '" + password1 + "')");

                        ps.execute();
                        return true;

                    } catch (Exception e) {
                        e.printStackTrace();

                    }
                } else {
                    System.out.println("Password doesn't match");
                    System.out.println("");
                    return false;
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    return true;

    }

    public static void registerUser(){
        System.out.println(addNewUser() ? "Registration successful" : "Registration failed.");
        System.out.println("");
    }

}//end of class
