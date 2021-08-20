package com.company.controlers;

import com.company.dbhelper.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentsController {
    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static void addNewStudent() {


        System.out.println("\nEnter the student's name: ");
        String name = scanner.next();


        System.out.println("\nEnter the student's surname: ");
        String surname = scanner.next();


        System.out.println("\nEnter the student's faculty: ");
        String faculty = scanner.next();


        System.out.println("\nEnter the student's group: ");
        String group = scanner.next();


        try {
            ps = DbConnection.user().prepareStatement("INSERT INTO students(name, surname, faculty, 'group')" +
                    "VALUES ('" + name + "', '" + surname + "' , '" + faculty + "', '" + group + "')");

            ps.execute();
            System.out.println("\nNew student has been added to database. Generating account..");



        } catch (Exception e) {
            e.printStackTrace();

        }


//        System.out.println("Welcome message");


            try {
                ps = DbConnection.user().prepareStatement("SELECT * FROM students WHERE name = '" + name +
                        "' AND surname = '" + surname + "' AND 'group' = '" + group + "';");

                rs = ps.executeQuery();


                while (rs.next()) {

                    int studentsID = rs.getInt("id");

                    String password = EmployeesController.getRandomNumberString();
                    String login = name.substring(0, 3) + surname.substring(0, 3) + studentsID;//

                    try {
                        ps = DbConnection.user().prepareStatement("INSERT INTO users(username, password, access)" +
                                "VALUES ('" + login + "', '" + password + "', student)");
                        ps.execute();
                        System.out.println("New account has been set.\n Username: " + login + "\n Password: " + password +
                                "\n\n Don't forget to write those down.");
                    } catch (Exception e) {
                        e.printStackTrace();

                    }
                    try {
                        ps = DbConnection.user().prepareStatement("SELECT * FROM users WHERE username = '" + login +"';");
                        rs = ps.executeQuery();
                        while(rs.next()){
                            int usersID = rs.getInt("id");

                            try{
                                ps = DbConnection.user().prepareStatement("UPDATE students SET user_id = "+ usersID +" WHERE id =" + studentsID);
                                ps.execute();

                            } catch (Exception e) {
                                e.printStackTrace();

                            }

                        }

                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }


            } catch (Exception e) {
                e.printStackTrace();

            }
    }
}
