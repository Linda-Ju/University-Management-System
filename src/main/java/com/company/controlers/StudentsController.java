package com.company.controlers;

import com.company.dbhelper.DbConnection;
import com.company.helpers.SantasLittleHelpers;
import com.company.objects.Objects;

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





        try {
            ps = DbConnection.user().prepareStatement("INSERT INTO students(name, surname, faculty)" +
                    "VALUES ('" + name + "', '" + surname + "' , '" + faculty +  "')");

            ps.execute();
            System.out.println("\nNew student has been added to database. Generating account..");



        } catch (Exception e) {
            e.printStackTrace();

        }


//        System.out.println("Welcome message");


            try {
                ps = DbConnection.user().prepareStatement("SELECT * FROM students WHERE name = '" + name +
                        "' AND surname = '" + surname + "' AND faculty = '" + faculty + "';");

                rs = ps.executeQuery();


                while (rs.next()) {

                    int studentsID = rs.getInt("id");

                    String password = SantasLittleHelpers.getRandomNumberString();
                    String login = name.substring(0, 3) + surname.substring(0, 3) + studentsID;//

                    try {
                        ps = DbConnection.user().prepareStatement("INSERT INTO users(username, password, access)" +
                                "VALUES ('" + login + "', '" + password + "', 'student')");
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

    public static void editStudentName(){
        int id = getStudentByID().getId();

        System.out.println("\nDo you wish to edit this data: Y/N");
        String option = scanner.next().trim().toUpperCase();
        if (option.equals("Y")) {


            System.out.println("Enter edited name:");
            String update = scanner.next().trim();
            System.out.println("");


            try {

                ps = DbConnection.user().prepareStatement("UPDATE students SET name = '" + update + "' WHERE id =" + id);
                ps.execute();


                System.out.println("Successfully updated student's name.");
                System.out.println("");


            } catch (Exception e) {
                e.printStackTrace();

            }


        } else {
            System.out.println("The student's data remained unchanged. ");
        }

    }

    public static void editStudentSurname(){
        int id = getStudentByID().getId();

        System.out.println("\nDo you wish to edit this data Y/N");
        String option = scanner.next().trim().toUpperCase();
        if (option.equals("Y")) {


            System.out.println("Enter edited surname:");
            String update = scanner.next().trim();
            System.out.println("");


            try {

                ps = DbConnection.user().prepareStatement("UPDATE students SET surname = '" + update + "' WHERE id =" + id);
                ps.execute();


                System.out.println("Successfully updated student's surname.");
                System.out.println("");


            } catch (Exception e) {
                e.printStackTrace();

            }


        } else {
            System.out.println("The student's data remained unchanged.");
        }

    }

    public static void editStudentFaculty(){
        int id = getStudentByID().getId();

        System.out.println("\nDo you wish to edit this data Y/N");
        String option = scanner.next().trim().toUpperCase();
        if (option.equals("Y")) {


            System.out.println("Enter new faculty:");
            String update = scanner.next().trim();
            System.out.println("");


            try {

                ps = DbConnection.user().prepareStatement("UPDATE students SET faculty = '" + update + "' WHERE id =" + id);
                ps.execute();


                System.out.println("Successfully updated student's faculty.");
                System.out.println("");


            } catch (Exception e) {
                e.printStackTrace();

            }


        } else {
            System.out.println("The student's data remained unchanged.");
        }

    }

    public static void editStudentGroup(){
        int id = getStudentByID().getId();

        System.out.println("\nDo you wish to edit this data Y/N");
        String option = scanner.next().trim().toUpperCase();
        if (option.equals("Y")) {


            System.out.println("Enter new group:");
            String update = scanner.next().trim();
            System.out.println("");


            try {

                ps = DbConnection.user().prepareStatement("UPDATE students SET group_id = '" + update + "' WHERE id = " + id);
                ps.execute();


                System.out.println("Successfully updated student's group.");
                System.out.println("");


            } catch (Exception e) {
                e.printStackTrace();

            }


        } else {
            System.out.println("The student's data remained unchanged.");
        }

    }

    public static void deleteStudent(){

        int id = getStudentByID().getId();

        System.out.println("\nDo you wish to delete this data Y/N");
        String option = scanner.next().trim().toUpperCase();
        System.out.println("");
        if (option.equals("Y")) {
            try {
                ps = DbConnection.user().prepareStatement("SELECT * FROM employees WHERE id = " + id);

                rs = ps.executeQuery();


                while(rs.next()) {
                    String name = rs.getString("name");
                    String surname =rs.getString("surname");
                    String login = name.substring(0, 3) + surname.substring(0, 3) + id;//


                    try {
                        ps = DbConnection.user().prepareStatement("DELETE FROM users WHERE username = '" + login+ "'");
                        ps.execute();


                    } catch (Exception e) {
                        e.printStackTrace();

                    }


                }


            } catch (Exception e) {
                e.printStackTrace();}
            try {

                ps = DbConnection.user().prepareStatement("DELETE FROM students WHERE id = " + id);
                ps.execute();

                System.out.println("The student was successfully removed from the database.");
                System.out.println("");


            } catch (Exception e) {
                e.printStackTrace();
            }


        } else {
            System.out.println("The student stayed in the database.");
            System.out.println("");
        }


    }

    public static void selectStudentsBySurname(){
        System.out.println("\nEnter the student's surname: ");
        String surname = scanner.next().trim();
        System.out.println("");

        try {
            ps = DbConnection.user().prepareStatement("SELECT * FROM students WHERE surname = '" + surname +"'");
            rs = ps.executeQuery();

            System.out.printf("%-3.5s %-9.12s %-13.13s %-27.27s %-20.24s%n", "id", "name", "surname", "faculty", "group");


            while (rs.next()) {

                System.out.printf("%-3.5s %-9.12s %-13.13s %-27.27s %-20.20s%n", rs.getInt("id"), rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("faculty"),
                        rs.getString("group_id"));
                System.out.println("");

            }

        }


        catch (SQLException throwables) {
            throwables.printStackTrace();

        }

    }

    public static void selectStudentsByFaculty(){
        System.out.println("\nEnter the student's faculty: ");
        String faculty = scanner.nextLine().trim();
        System.out.println("");

        try {
            ps = DbConnection.user().prepareStatement("SELECT * FROM students WHERE faculty = '" + faculty +"'");
            rs = ps.executeQuery();

            System.out.printf("%-3.5s %-9.12s %-13.13s %-27.27s %-20.24s%n", "id", "name", "surname", "faculty", "group");

            while (rs.next()) {

                System.out.printf("%-3.5s %-9.12s %-13.13s %-27.27s %-20.20s%n", rs.getInt("id"), rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("faculty"),
                        rs.getString("group_id"));


            }

        }


        catch (SQLException throwables) {
            throwables.printStackTrace();

        }

    }

    public static void selectStudentsByGroup(){
        System.out.println("\nEnter the student's faculty: ");
        String faculty = scanner.nextLine().trim();
        System.out.println("\nEnter the student's group: ");
        String group = scanner.next().trim();
        System.out.println("");
        try {
            ps = DbConnection.user().prepareStatement("SELECT * FROM students WHERE faculty = '" + faculty +"' AND group_id = '"+ group + "'");
            rs = ps.executeQuery();

            System.out.printf("%-3.5s %-9.12s %-13.13s %-27.27s %-20.24s%n", "id", "name", "surname", "faculty", "group");

            while (rs.next()) {

                System.out.printf("%-3.5s %-9.12s %-13.13s %-27.27s %-20.20s%n", rs.getInt("id"), rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("faculty"),
                        rs.getString("group_id"));
                System.out.println("");

            }

        }


        catch (SQLException throwables) {
            throwables.printStackTrace();

        }

    }

    public static Objects getStudentByID() {
        System.out.println("\nEnter the student's id: ");
        int id = scanner.nextInt();
        System.out.println("");

        try {
            ps = DbConnection.user().prepareStatement("SELECT * FROM students WHERE id =" + id);
            rs = ps.executeQuery();

            System.out.printf("%-3.5s %-9.12s %-13.13s %-27.27s %-20.24s%n", "id", "name", "surname", "faculty", "group");

            int studentsID;

            Objects student = new Objects();
            while (rs.next()) {
                studentsID = rs.getInt("id");

                System.out.printf("%-3.5s %-9.12s %-13.13s %-27.27s %-20.20s%n", studentsID, rs.getString("name"),
                        rs.getString("surname"),
                       rs.getString("faculty"),
                        rs.getString("group_id"));
                System.out.println("");
                student.setId(studentsID);
            }
            return student;


        }


        catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

    }

}
