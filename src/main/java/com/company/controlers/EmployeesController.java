package com.company.controlers;

import com.company.dbhelper.DbConnection;
import com.company.objects.Objects;

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

    public static void editEmployeeName(){
        int id = getEmployeeByID().getId();

        System.out.println("\nDo you wish to edit this data Y/N");
        String option = scanner.next().trim();
        if (option.equals("Y")) {


            System.out.println("Enter edited name");
            String update = scanner.next().trim();
            System.out.println("");


            try {

                ps = DbConnection.user().prepareStatement("UPDATE employees SET first_name = '" + update + "' WHERE id =" + id);
                ps.execute();


                System.out.println("successfully updated");
                System.out.println("");


            } catch (Exception e) {
                e.printStackTrace();

            }


        } else {
            System.out.println("Person data remains unchanged");
        }

    }

    public static void editEmployeeSurname(){
        int id = getEmployeeByID().getId();

        System.out.println("\nDo you wish to edit this data Y/N");
        String option = scanner.next().trim();
        if (option.equals("Y")) {


            System.out.println("Enter edited surname");
            String update = scanner.next().trim();
            System.out.println("");


            try {

                ps = DbConnection.user().prepareStatement("UPDATE employees SET last_name = '" + update + "' WHERE id =" + id);
                ps.execute();


                System.out.println("successfully updated");
                System.out.println("");


            } catch (Exception e) {
                e.printStackTrace();

            }


        } else {
            System.out.println("Person data remains unchanged");
        }

    }

    public static void editEmployeePosition(){
        int id = getEmployeeByID().getId();

        System.out.println("\nDo you wish to edit this data Y/N");
        String option = scanner.next().trim();
        if (option.equals("Y")) {


            System.out.println("Enter new position");
            String update = scanner.next().trim();



            try {

                ps = DbConnection.user().prepareStatement("UPDATE employees SET position = '" + update + "' WHERE id =" + id);
                ps.execute();


                System.out.println("successfully updated");
                System.out.println("");


            } catch (Exception e) {
                e.printStackTrace();

            }


        } else {
            System.out.println("Person data remains unchanged");
        }

    }

    public static void deleteEmployee(){

        int id = getEmployeeByID().getId();

        System.out.println("\nDo you wish to delete this data Y/N");
        String option = scanner.next().trim();
        System.out.println("");
        if (option.equals("Y")) {
            try {

                ps = DbConnection.user().prepareStatement("DELETE FROM employees WHERE id = " + id);
                ps.execute();

                System.out.println("successfully removed to database");
                System.out.println("");


            } catch (Exception e) {
                e.printStackTrace();
            }


        } else {
            System.out.println("Person remained in database");
            System.out.println("");
        }


    }

    public static Objects getEmployeeByID() {
        System.out.println("\nEnter the employee's id: ");
     int id = scanner.nextInt();
    System.out.println("");

    try {
        ps = DbConnection.user().prepareStatement("SELECT * FROM employees WHERE id =" + id);
        rs = ps.executeQuery();

            System.out.println("id \t  name  \t surname \t position ");

            int employeeID;

            Objects employee = new Objects();
        while (rs.next()) {
                employeeID = rs.getInt("id");
;

                System.out.println(employeeID + " \t " + rs.getString("first_name") + " \t " + rs.getString("last_name") + " \t " + rs.getString("position"));
                System.out.println("");

        }
            return employee;


    }


     catch (SQLException throwables) {
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
