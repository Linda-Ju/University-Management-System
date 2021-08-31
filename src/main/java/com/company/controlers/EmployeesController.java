package com.company.controlers;

import com.company.dbhelper.DbConnection;
import com.company.helpers.OutputMessage;
import com.company.helpers.SantasLittleHelpers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeesController {
    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;
    //selection/edition can be done in single method by case option

    // method selectActiveLecturers can be added
// (SQL tip:select employees.first_name, employees.last_name, scores.subject from scores inner join employees on scores.lecturers_id = employees.id group by scores.lecturers_id;)


    public static void addNewEmployee() {

        System.out.print("\nEnter the employee's name: ");
        String name = scanner.next();


        System.out.print("\nEnter the employee's surname: ");
        String surname = scanner.next();


        System.out.print("\nEnter the employee's position: ");
        String position = scanner.next();

        try {
            ps = DbConnection.user().prepareStatement("INSERT INTO employees(first_name, last_name, position)" +
                    "VALUES ('" + name + "', '" + surname + "' , '" + position + "')");
            ps.execute();
            System.out.println("\nData been added to database. Generating users account...\n");
        } catch (Exception e) {
//            e.printStackTrace();
            OutputMessage.error();
            addNewEmployee();
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
//                    e.printStackTrace();
                    OutputMessage.error();
                    addNewEmployee();
                }
                try {
                    ps = DbConnection.user().prepareStatement("SELECT * FROM users WHERE username = '" + login + "';");
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        int usersID = rs.getInt("id");
                        try {
                            ps = DbConnection.user().prepareStatement("UPDATE employees SET user_id = " + usersID + " WHERE id = " + employeesID);
                            ps.execute();
                        } catch (Exception e) {
 //                           e.printStackTrace();
                            OutputMessage.error();
                            addNewEmployee();
                        }
                    }
                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
                    OutputMessage.error();
                    addNewEmployee();
                }
            }
        } catch (Exception e) {
//            e.printStackTrace();
            OutputMessage.error();
            addNewEmployee();
        }
    }

    public static void editEmployeeName() {
        int id = getEmployeeByID();

        System.out.print("\nDo you wish to edit this data? Y/N : ");
        String option = scanner.next().trim().toUpperCase();
        if (option.equals("Y")) {

            System.out.print("\nEnter new employee's name: ");
            String update = scanner.next().trim();

            try {
                ps = DbConnection.user().prepareStatement("UPDATE employees SET first_name = '" + update + "' WHERE id =" + id);
                ps.execute();
                System.out.println("\nSuccessfully updated employee's name.");
            } catch (Exception e) {
//                e.printStackTrace();
                OutputMessage.error();
                editEmployeeName();
            }
        } else {
            System.out.println("The employee's data remained unchanged.");
        }
    }

    public static void editEmployeeSurname() {
        int id = getEmployeeByID();

        System.out.print("\nDo you wish to edit this data? Y/N : ");
        String option = scanner.next().trim().toUpperCase();
        if (option.equals("Y")) {

            System.out.print("\nEnter new employee's surname: ");
            String update = scanner.next().trim();

            try {
                ps = DbConnection.user().prepareStatement("UPDATE employees SET last_name = '" + update + "' WHERE id =" + id);
                ps.execute();

                System.out.println("\nSuccessfully updated employee's surname.");

            } catch (Exception e) {
//                e.printStackTrace();
                OutputMessage.error();
                editEmployeeName();
            }
        } else {
            System.out.println("The employee's data remained unchanged.");
        }
    }

    public static void editEmployeePosition() {
        int id = getEmployeeByID();

        System.out.print("\nDo you wish to edit this data? Y/N : ");
        String option = scanner.next().trim().toUpperCase();
        if (option.equals("Y")) {

            System.out.println("Enter new employee's position.");
            String update = scanner.next().trim();

            try {
                ps = DbConnection.user().prepareStatement("UPDATE employees SET position = '" + update + "' WHERE id =" + id);
                ps.execute();

                System.out.println("\nSuccessfully updated employee's position.");

            } catch (Exception e) {
//                e.printStackTrace();
                OutputMessage.error();
                editEmployeePosition();
            }
        } else {
            System.out.println("The employee's data remained unchanged.");
        }
    }

    public static void deleteEmployee() {

        int id = getEmployeeByID();

        System.out.print("\nDo you wish to delete this data? Y/N : ");
        String option = scanner.next().trim().toUpperCase();
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
//                        e.printStackTrace();
                        OutputMessage.error();
                        deleteEmployee();
                    }
                }
            } catch (Exception e) {
//                e.printStackTrace();
                OutputMessage.error();
                deleteEmployee();
            }
            try {
                ps = DbConnection.user().prepareStatement("DELETE FROM employees WHERE id = " + id);
                ps.execute();

                System.out.println("\nThe employee was successfully removed from the database.");

            } catch (Exception e) {
//                e.printStackTrace();
                OutputMessage.error();
                deleteEmployee();
            }
        } else {
            System.out.println("The employee stayed in the database.");
        }
    }

    public static int getEmployeeByID() {
        System.out.print("\nEnter the employee's id: ");
        int check = scanner.nextInt();
        int id = 0;
        try {
            ps = DbConnection.user().prepareStatement("SELECT * FROM employees WHERE id =" + check);
            rs = ps.executeQuery();

            System.out.println("\n=====================================");
            System.out.printf("%-3.5s %-9.12s %-13.13s %-20.24s%n", "id", "name", "surname", "position");
            System.out.println("-------------------------------------");

            while (rs.next()) {
                id = rs.getInt("id");
                System.out.printf("%-3.5s %-9.12s %-13.13s %-20.24s%n", id, rs.getString("first_name"),
                        rs.getString("last_name"), rs.getString("position"));
                System.out.println("=====================================");
            }
        } catch (SQLException throwables) {
//            throwables.printStackTrace();
            OutputMessage.error();
            getEmployeeByID();
        }
        return id;
    }

    public static void selectEmployeeBySurname() {
        System.out.print("\nEnter the employee's surname: ");
        String searchValue = scanner.next().trim();

        try {
            ps = DbConnection.user().prepareStatement("SELECT * FROM employees WHERE last_name = '" + searchValue + "' ORDER BY first_name");
            rs = ps.executeQuery();

            System.out.println("\n=====================================");
            System.out.printf("%-3.5s %-9.12s %-13.13s %-20.24s%n", "id", "name", "surname", "position");
            System.out.println("-------------------------------------");
            while (rs.next()) {

                System.out.printf("%-3.5s %-9.12s %-13.13s %-20.24s%n", rs.getInt("id"), rs.getString("first_name"),
                        rs.getString("last_name"), rs.getString("position"));
                System.out.println("=====================================");
            }
        } catch (SQLException throwables) {
//            throwables.printStackTrace();
            OutputMessage.error();
            selectEmployeeBySurname();
        }
    }

    public static void selectEmployeeByPosition() {
        System.out.print("\nEnter the employee's position: ");
        String searchValue = scanner.next().trim();

        try {
            ps = DbConnection.user().prepareStatement("SELECT * FROM employees WHERE position= '" + searchValue + "' ORDER BY first_name");
            rs = ps.executeQuery();

            System.out.println("\n=====================================");
            System.out.printf("%-3.5s %-9.12s %-13.13s %-20.24s%n", "#", "name", "surname", "position");
            System.out.println("-------------------------------------");
            int count = 1;
            while (rs.next()) {
                System.out.printf("%-3.5s %-9.12s %-13.13s %-20.24s%n", count,
                        rs.getString("first_name"), rs.getString("last_name"),
                        rs.getString("position"));
                count++;
            }
            System.out.println("=====================================");
        } catch (SQLException throwables) {
//            throwables.printStackTrace();
            OutputMessage.error();
            selectEmployeeByPosition();
        }
    }

    public static void selectLecturersBySubject() {
        String subject = SantasLittleHelpers.subjectCases();

        if (subject != (null)) {
            try {
                ps = DbConnection.user().prepareStatement("SELECT DISTINCT employees.first_name, employees.last_name FROM scores INNER JOIN employees ON scores.lecturers_id = employees.id WHERE subject = '" + subject + "' ORDER BY employees.first_name");
                rs = ps.executeQuery();
                int count = 1;
                System.out.println("\n" + subject + " lecturers:");

                System.out.println("\n=======================");
                System.out.printf("%-3.5s %-9.12s %-13.13s %n", "#", "name", "surname");
                System.out.println("-----------------------");
                while (rs.next()) {
                    System.out.printf("%-3.5s %-9.12s %-13.13s %n", count, rs.getString("first_name"),
                            rs.getString("last_name"));
                    count++;
                }
                System.out.println("=======================");
            } catch (SQLException throwables) {
//                throwables.printStackTrace();
                OutputMessage.error();
                selectLecturersBySubject();
            }
        } else {
            System.out.print("\nDo you wish to start over? Y/N :  ");
            String proceed = scanner.next().trim().toUpperCase();

            if (proceed.equals("Y")) {
                selectLecturersBySubject();
            } else {
                System.out.println("Redirecting.. EmpC 286");
            }
        }
    }

    public static void selectLecturersByStudentGroup() {
        System.out.print("\nEnter the name of the group: ");
        String groupID = scanner.next().trim().toUpperCase();
        try {
            ps = DbConnection.user().prepareStatement("SELECT DISTINCT employees.first_name, employees.last_name, scores.subject FROM scores INNER JOIN employees ON scores.lecturers_id = employees.id LEFT JOIN students ON scores.student_id = students.id WHERE group_id = '" + groupID + "' ORDER BY scores.subject, employees.first_name");
            rs = ps.executeQuery();
            int count = 1;
            System.out.println("\nEntered group name is " + groupID + ".");

            System.out.println("\n=======================================");
            System.out.printf("%-3.5s %-9.12s %-13.13s %-20.24s%n", "#", "Name", "Surname", "Subject");
            System.out.println("---------------------------------------");
            while (rs.next()) {
                System.out.printf("%-3.5s %-9.12s %-13.13s %-20.24s%n", count, rs.getString("first_name"),
                        rs.getString("last_name"), rs.getString("subject"));
                count++;
            }
            System.out.println("=======================================");
        } catch (SQLException throwables) {
//            throwables.printStackTrace();
            OutputMessage.error();
            selectLecturersByStudentGroup();
        }
    }
}
