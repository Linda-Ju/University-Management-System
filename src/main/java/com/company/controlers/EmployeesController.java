package com.company.controlers;

import com.company.dbhelper.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class EmployeesController {
    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static void addNewEmployee() {


        System.out.println("Enter the employee's name: ");
        String name = scanner.next();
        System.out.println("");

        System.out.println("Enter the employee's surname: ");
        String surname = scanner.next();
        System.out.println("");

        System.out.println("Enter the employee's position: ");
        String position = scanner.next();
        System.out.println("");


        try {
            ps = DbConnection.user().prepareStatement("INSERT INTO employees(first_name, last_name, speciality)" +
                    "VALUES ('" + name + "', '" + surname + "' , '" + position + "')");

            ps.execute();
            System.out.println("New employee has been added to database");
            System.out.println("");



        } catch (Exception e) {
            e.printStackTrace();

        }


//        System.out.println("Do you wish use this data to create a user Y/N");

        System.out.println("Enter password: ");
        String password1 = scanner.next().trim();
        System.out.println("");

        System.out.println("Retype your password: ");
        String password2 = scanner.next().trim();
        System.out.println("");

        //check if user is able to type password twice correctly
        if(password1.equals(password2)){
            try {
                ps = DbConnection.user().prepareStatement("SELECT * FROM employees WHERE first_name = '" + name +
                        "' AND last_name = '" + surname + "' AND position = '" + position + "';");

                rs = ps.executeQuery();


                while(rs.next()) {

                    int employeesID = rs.getInt("id");

                    String login = name.substring(0, 3) + surname.substring(0, 3) + employeesID;//

                    try {
                        ps = DbConnection.user().prepareStatement("INSERT INTO users(username, password, access)" +
                                "VALUES ('" + login + "', '" + password1 + "', '" + position +"')");

                        ps.execute();
                    } catch (Exception e) {
                        e.printStackTrace();

                    }
                }


            } catch (Exception e) {
                e.printStackTrace();

            }
        } else {
            System.out.println("Password doesn't match");
            System.out.println("");

        }






    }
}
