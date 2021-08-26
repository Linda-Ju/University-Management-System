package com.company.controlers;

import com.company.dbhelper.DbConnection;
import com.company.helpers.SantasLittleHelpers;
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


            while (rs.next()) {

                int employeesID = rs.getInt("id");
                String login = name.substring(0, 3) + surname.substring(0, 3) + employeesID;//
                String password = SantasLittleHelpers.getRandomNumberString();

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
                    ps = DbConnection.user().prepareStatement("SELECT * FROM users WHERE username = '" + login + "';");
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        int usersID = rs.getInt("id");

                        try {
                            ps = DbConnection.user().prepareStatement("UPDATE employees SET user_id = " + usersID + " WHERE id =" + employeesID);
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

    public static void editEmployeeName() {
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

    public static void editEmployeeSurname() {
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

    public static void editEmployeePosition() {
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

    public static void deleteEmployee() {

        int id = getEmployeeByID().getId();

        System.out.println("\nDo you wish to delete this data Y/N");
        String option = scanner.next().trim();
        System.out.println("");
        if (option.equals("Y")) {

            try {
                ps = DbConnection.user().prepareStatement("SELECT * FROM employees WHERE id = " + id);

                rs = ps.executeQuery();


                while (rs.next()) {
                    String name = rs.getString("first_name");
                    String surname = rs.getString("last_name");
                    String login = name.substring(0, 3) + surname.substring(0, 3) + id;//


                    try {
                        ps = DbConnection.user().prepareStatement("DELETE FROM users WHERE username = '" + login + "'");
                        ps.execute();


                    } catch (Exception e) {
                        e.printStackTrace();

                    }


                }


            } catch (Exception e) {
                e.printStackTrace();
            }
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

        try {
            ps = DbConnection.user().prepareStatement("SELECT * FROM employees WHERE id =" + id);
            rs = ps.executeQuery();

            System.out.println("id \t  name  \t surname \t position ");

            int employeeID;

            Objects employee = new Objects();
            while (rs.next()) {
                employeeID = rs.getInt("id");

                System.out.println(employeeID + " \t " + rs.getString("first_name") + " \t " + rs.getString("last_name") + " \t " + rs.getString("position"));
                employee.setId(employeeID);
            }
            return employee;


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

    }

    public static void getEmployeeBySurname() {
        System.out.println("\nEnter the employee's surname: ");
        String searchValue = scanner.next().trim();

        try {
            ps = DbConnection.user().prepareStatement("SELECT * FROM employees WHERE last_name = '" + searchValue + "'");
            rs = ps.executeQuery();

            System.out.println("id \t  name  \t surname \t position ");

            Objects employee = new Objects();
            while (rs.next()) {

                System.out.println(rs.getInt("id") + " \t " + rs.getString("first_name") + " \t " + rs.getString("last_name") + " \t " + rs.getString("position"));

            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void getEmployeeByPosition() {
        System.out.println("\nEnter the employee's position: ");
        String searchValue = scanner.next().trim();

        try {
            ps = DbConnection.user().prepareStatement("SELECT * FROM employees WHERE position= '" + searchValue + "'");
            rs = ps.executeQuery();

            System.out.println("id \t  name  \t surname \t position ");

            Objects employee = new Objects();
            while (rs.next()) {

                System.out.println(rs.getInt("id") + " \t " + rs.getString("first_name") + " \t " + rs.getString("last_name") + " \t " + rs.getString("position"));

            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    public static void getLecturersBySubject() {
        System.out.println("Choose a subject");
        System.out.println("1. Mathematics");
        System.out.println("2. Physics");
        System.out.println("3. Chemistry");
        System.out.println("4. History");
        System.out.println("5. English");
        System.out.println("6. Spanish");

        System.out.print("Choose option: ");
        int option = scanner.nextInt();
        String subject = null;
        switch (option) {
            case 1:
                subject = "Mathematics";
                break;
            case 2:
                subject = "Physics";
                break;
            case 3:
                subject = "Chemistry";
                break;
            case 4:
                subject = "History";
                break;
            case 5:
                subject = "English";
                break;
            case 6:
                subject = "Spanish";
                break;
            default:
                System.out.println("invalid option");
        }

        if (subject != (null)) {
            try {
                ps = DbConnection.user().prepareStatement("SELECT DISTINCT employees.first_name, employees.last_name FROM scores INNER JOIN employees ON scores.lecturers_id = employees.id WHERE subject = '" + subject + "'");
                rs = ps.executeQuery();
                System.out.println(subject);
                System.out.println("Name \t Surname");
                while (rs.next()) {
                    System.out.println(rs.getString("first_name") + " \t " +
                            rs.getString("last_name"));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();

            }
        } else {
            System.out.println("Do you wish to start over Y/N?");
            String proceed = scanner.next().trim();

            if (proceed.equals("Y")) {
                getLecturersBySubject();
            } else {
                System.out.println("redirecting to start menu");
            }

        }
    }


    public static void getLecturerByStudentGroup() {
        System.out.print("Type group: ");
        String groupID = scanner.next().trim();
        try {
            ps = DbConnection.user().prepareStatement("SELECT DISTINCT employees.first_name, employees.last_name, scores.subject FROM scores INNER JOIN employees ON scores.lecturers_id = employees.id LEFT JOIN students ON scores.student_id = students.id WHERE group_id = '" + groupID + "'");
            rs = ps.executeQuery();
            System.out.println(groupID);
            System.out.println("Name \t Surname \t Subject");
            while (rs.next()) {
                System.out.println(rs.getString("first_name") + " \t " +
                        rs.getString("last_name") + " \t " + rs.getString("subject"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
    }
}
