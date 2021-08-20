package com.company.login;//package com.company.login;
//
//
//import com.company.dbhelper.DbConnection;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.Scanner;
//
//public class Login {
//    private static Scanner scanner = new Scanner(System.in);
//    private static PreparedStatement ps;
//    private static ResultSet rs;
//    //table users
//
//
//    public static void userLogin() {
//        System.out.println("Hello, you!");//Welcome message
//        System.out.println("");
//
//        //request username from user
//        System.out.println("Enter your username: ");
//        String login = scanner.next().trim();
//        System.out.println("");
//
//
//
//        try {
//          ps = DbConnection.user().prepareStatement("SELECT * FROM users WHERE username = '" + login + "';");
//
//            rs = ps.executeQuery();
//
//            //set variable for validation
//            String  passwordCheck;
//
//
//         // Check if provided username exists in database
//            if (rs.next()) {
//                System.out.println("Username excepted.");
//                System.out.println("");
//
//                //asking for password from user
//                System.out.println("Enter your password: ");
//                String password = scanner.next().trim();
//                System.out.println("");
//
//                passwordCheck = rs.getString("password");
//
//                //Check if password is correct
//                boolean correct = password.equals(passwordCheck);
//                if(correct) {
//                        System.out.println("Access granted.");
//                    System.out.println("");
//
//                    } else {
//                        System.out.println("Login failed. Check password");
//                    System.out.println("");
//                    }
//                } else {
//                System.out.println("Username doesn't exists");
//                System.out.println("");
//
//            }
//            Menu.mainMenu();
//
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//    }
//
//
//
//    }//end of test
//
