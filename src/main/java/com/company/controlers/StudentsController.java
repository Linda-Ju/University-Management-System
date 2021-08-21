package com.company.controlers;

import com.company.dbhelper.DbConnection;
import com.company.objects.Student;

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

                    String password = EmployeesController.getRandomNumberString();
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

        System.out.println("\nDo you wish to edit this data Y/N");
        String option = scanner.next().trim();
        if (option.equals("Y")) {


            System.out.println("Enter edited name");
            String update = scanner.next().trim();
            System.out.println("");


            try {

                ps = DbConnection.user().prepareStatement("UPDATE students SET name = '" + update + "' WHERE id =" + id);
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

    public static void editStudentSurname(){
        int id = getStudentByID().getId();

        System.out.println("\nDo you wish to edit this data Y/N");
        String option = scanner.next().trim();
        if (option.equals("Y")) {


            System.out.println("Enter edited surname");
            String update = scanner.next().trim();
            System.out.println("");


            try {

                ps = DbConnection.user().prepareStatement("UPDATE students SET surname = '" + update + "' WHERE id =" + id);
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

    public static void editStudentFaculty(){
        int id = getStudentByID().getId();

        System.out.println("\nDo you wish to edit this data Y/N");
        String option = scanner.next().trim();
        if (option.equals("Y")) {


            System.out.println("Enter new faculty");
            String update = scanner.next().trim();
            System.out.println("");


            try {

                ps = DbConnection.user().prepareStatement("UPDATE students SET faculty = '" + update + "' WHERE id =" + id);
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

    //need to check on database column name, group doesn't work so well
    public static void editStudentGroup(){
        int id = getStudentByID().getId();

        System.out.println("\nDo you wish to edit this data Y/N");
        String option = scanner.next().trim();
        if (option.equals("Y")) {


            System.out.println("Enter edited group");
            String update = scanner.next().trim();
            System.out.println("");


            try {

                ps = DbConnection.user().prepareStatement("UPDATE students SET 'group' = '" + update + "' WHERE id = " + id);
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

    public static void deleteStudent(){

        int id = getStudentByID().getId();

        System.out.println("\nDo you wish to delete this data Y/N");
        String option = scanner.next().trim();
        System.out.println("");
        if (option.equals("Y")) {
            try {

                ps = DbConnection.user().prepareStatement("DELETE FROM students WHERE id = " + id);
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

    public static void selectStudentsBySurname(){
        System.out.println("\nEnter the student's surname: ");
        String surname = scanner.next().trim();
        System.out.println("");

        try {
            ps = DbConnection.user().prepareStatement("SELECT * FROM students WHERE surname = '" + surname +"'");
            rs = ps.executeQuery();

            System.out.println("id \t  name  \t surname \t faculty \t group");


            while (rs.next()) {

                System.out.println(rs.getInt("id") + " \t " + rs.getString("name") + " \t " +
                        rs.getString("surname") + " \t " + rs.getString("faculty") + " \t " + rs.getString("group"));
                System.out.println("");

            }

        }


        catch (SQLException throwables) {
            throwables.printStackTrace();

        }

    }

    public static void selectStudentsByFaculty(){
        System.out.println("\nEnter faculty: ");
        String faculty = scanner.next().trim();
        System.out.println("");

        try {
            ps = DbConnection.user().prepareStatement("SELECT * FROM students WHERE faculty = '" + faculty +"'");
            rs = ps.executeQuery();

            System.out.println("id \t  name  \t surname \t faculty \t group");

            while (rs.next()) {

                System.out.println(rs.getInt("id") + " \t " + rs.getString("name") + " \t " +
                        rs.getString("surname") + " \t " + rs.getString("faculty") + " \t " + rs.getString("group"));
                System.out.println("");

            }

        }


        catch (SQLException throwables) {
            throwables.printStackTrace();

        }

    }

    public static Student getStudentByID() {
        System.out.println("\nEnter the student's id: ");
        int id = scanner.nextInt();
        System.out.println("");

        try {
            ps = DbConnection.user().prepareStatement("SELECT * FROM students WHERE id =" + id);
            rs = ps.executeQuery();

            System.out.println("id \t  name  \t surname \t faculty \t group");

            int studentsID;
            String name;
            String surname;
            String faculty;
            String group;
            Student student = new Student();
            while (rs.next()) {
                studentsID = rs.getInt("id");
                name = rs.getString("name");
                surname = rs.getString("surname");
                faculty = rs.getString("faculty");
                group = rs.getString("group");
                student.setId(studentsID);

                System.out.println(studentsID + " \t " + name + " \t " + surname + " \t " + faculty + " \t " + group);
                System.out.println("");

            }
            return student;


        }


        catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

    }

}
