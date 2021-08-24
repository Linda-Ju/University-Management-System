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
   /*
   Since users are automatically not sure that we need new user registration option
   Also user can be deleted on cascade with the person, so not sure if we need delete option
   Only thing that we might need is password change and find user by username so the admin could
    remind password to users, but I'm not sure since there is no sensable data there
    */

    public static void findUserByUsername(){//can access only from admin panel
        System.out.println("\nEnter the username: ");
        String password = scanner.next().trim();


        try {
            ps = DbConnection.user().prepareStatement("SELECT * FROM users WHERE username ='" + password +"'");
            rs = ps.executeQuery();

            System.out.println("id \t  username \t password \t access lvl");

            while (rs.next()) {

                System.out.println(rs.getInt("id") + " \t " +
                        rs.getString("username") + " \t " + rs.getString("password")+ " \t " + rs.getString("access"));
                System.out.println("");

            }

        }


        catch (SQLException throwables) {
            throwables.printStackTrace();

        }

    }

    public static void changeUserPassword(){
       // request username from user
        System.out.println("Enter your username: ");
        String login = scanner.next().trim();
        System.out.println("");

        System.out.println("Enter your old password: ");
        String password = scanner.next().trim();
        System.out.println("");


        try {
          ps = DbConnection.user().prepareStatement("SELECT * FROM users WHERE username = '" + login + " AND password = '" + password +"';");

            rs = ps.executeQuery();

            //set variable for validation
            String  passwordCheck;


         // Check if provided username exists in database
            if (rs.next()) {
                System.out.println("Username excepted.");
                System.out.println("");

                //asking for password from user
                System.out.println("Enter password: ");
                String password1 = scanner.next().trim();
                System.out.println("");

                System.out.println("Retype your password: ");
                String password2 = scanner.next().trim();
                System.out.println("");

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
                    System.out.println("Password doesn't match");

                }
//            Menu.mainMenu();
            }


        } catch (Exception e) {
            e.printStackTrace();

        }
    }

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
