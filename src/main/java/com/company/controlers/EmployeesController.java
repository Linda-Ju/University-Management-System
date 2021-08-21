package com.company.controlers;

import com.company.dbhelper.DbConnection;
import com.company.objects.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class EmployeesController {
    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static void addNewEmployee() {


        System.out.println("\nEnter the employee's name: ");
        String name = scanner.next();


        System.out.println("\nEnter the employee's surname: ");
        String surname = scanner.next();


        System.out.println("\nEnter the employee's position: ");
        String position = scanner.next();




        try {
            ps = DbConnection.user().prepareStatement("INSERT INTO employees(first_name, last_name, position)" +
                    "VALUES ('" + name + "', '" + surname + "' , '" + position + "')");

            ps.execute();
            System.out.println("\nData been added to database. Generating users account...\n");




        } catch (Exception e) {
            e.printStackTrace();

        }
            try {
                ps = DbConnection.user().prepareStatement("SELECT * FROM employees WHERE first_name = '" + name +
                        "' AND last_name = '" + surname + "' AND position = '" + position + "';");

                rs = ps.executeQuery();


                while(rs.next()) {

                    int employeesID = rs.getInt("id");
                    String login = name.substring(0, 3) + surname.substring(0, 3) + employeesID;//
                    String password = getRandomNumberString();

                    try {
                        ps = DbConnection.user().prepareStatement("INSERT INTO users(username, password, access)" +
                                "VALUES ('" + login + "', '" + password + "', '" + position + "')");

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
                                ps = DbConnection.user().prepareStatement("UPDATE employees SET user_id = "+ usersID +" WHERE id =" + employeesID);
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

public static Employee getEmployeeByID(){
    System.out.println("\nEnter the employee's id: ");
    int id = scanner.nextInt();
    System.out.println("");

    try {
        ps = DbConnection.user().prepareStatement("SELECT * FROM employees WHERE id =" + id);
        rs = ps.executeQuery();

        System.out.println("\nid \t  name  \t surname \t position ");


        String name;
        String surname;
        String position;
        Employee employee = new Employee();


        while(rs.next()){

            name = rs.getString("first_name");
            surname = rs.getString("last_name");
            position = rs.getString("position");



            employee.setId(id);


            System.out.println(id + " \t " + name + " \t " + surname + " \t " + position);
            System.out.println("");
        }
        return employee;


    } catch (SQLException throwables) {
        throwables.printStackTrace();
        return null;
    }
}


    public static String getRandomNumberString() {
        //Password generator
        // It will generate 6 digit random Number.
        // from 0 to 999999
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        // this will convert any number sequence into 6 character.
        return String.format("%06d", number);
    }
}
