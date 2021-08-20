package com.company.controlers;

import com.company.dbhelper.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class StudentsController {
    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static void addNewStudent() {


        System.out.println("Enter the student's name: ");
        String name = scanner.next();
        System.out.println("");

        System.out.println("Enter the student's surname: ");
        String surname = scanner.next();
        System.out.println("");

        System.out.println("Enter the student's faculty: ");
        String faculty = scanner.next();
        System.out.println("");

        System.out.println("Enter the student's group: ");
        String group = scanner.next();
        System.out.println("");

        try {
            ps = DbConnection.user().prepareStatement("INSERT INTO students(name, surname, faculty, 'group')" +
                    "VALUES ('" + name + "', '" + surname + "' , '" + faculty + "', '" + group + "')");

            ps.execute();
            System.out.println("New student has been added to database");
            System.out.println("");


        } catch (Exception e) {
            e.printStackTrace();

        }


//        System.out.println("Welcome message");
////not sure that we need part with passwords here, it easier to write default randomizer
//        System.out.println("Enter password: ");
//        String password1 = scanner.next().trim();
//        System.out.println("");
//
//        System.out.println("Retype your password: ");
//        String password2 = scanner.next().trim();
//        System.out.println("");
        String password1 = "qwerty";
        String password2 = "qwerty";

        //check if user is able to type password twice correctly
        if (password1.equals(password2)) {//delete if double check isn't needed
            try {
                ps = DbConnection.user().prepareStatement("SELECT * FROM students WHERE name = '" + name +
                        "' AND surname = '" + surname + "' AND 'group' = '" + group + "';");

                rs = ps.executeQuery();


                while (rs.next()) {

                    int employeesID = rs.getInt("id");

                    String login = name.substring(0, 3) + surname.substring(0, 3) + employeesID;//

                    try {
                        ps = DbConnection.user().prepareStatement("INSERT INTO users(username, password, access)" +
                                "VALUES ('" + login + "', '" + password1 + "', student)");

                        ps.execute();
                    } catch (Exception e) {
                        e.printStackTrace();

                    }
                }


            } catch (Exception e) {
                e.printStackTrace();

            }//delete below if double check password isn'r needed anymore
        } else {
            System.out.println("Password doesn't match");
            System.out.println("");

        }
    }
}
