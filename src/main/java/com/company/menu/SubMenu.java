package com.company.menu;

import com.company.controlers.*;

import java.util.Scanner;

public class SubMenu {
    private static Scanner scanner = new Scanner(System.in);

    public static void userSubMenu() {
        System.out.println("What do you want to do?");

        System.out.println("1. Remind password");
        System.out.println("2. Change password");
        System.out.println("3. See users by access level");
        System.out.print("Select an option");
        String option = scanner.next().toUpperCase();

        switch (option) {
            case "1":
                UserController.findUserByUsername();
                break;
            case "2":
                UserController.changeUserPassword();
                break;
            case "3":
                UserController.findUsersByAccess();
                break;
            case "X":
                System.out.println("End of session. User logout.");
                break;
            default:
                System.out.println("Invalid option, try again\n");
                userSubMenu();
        }
    }

    public static void studentSubMenu() {

        System.out.println("Student data:\n");

        System.out.println("1. Add new student");
        System.out.println("2. Edit name ");
        System.out.println("3. Edit surname");
        System.out.println("4. Change faculty");
        System.out.println("5. Change group");
        System.out.println("6. Delete student\n");

        System.out.print("Select an option");
        String option = scanner.next().toUpperCase();

        switch (option) {
            case "1":
                StudentsController.addNewStudent();
                break;
            case "2":
                StudentsController.editStudentName();
                break;
            case "3":
                StudentsController.editStudentSurname();
                break;
            case "4":
                StudentsController.editStudentFaculty();
                break;
            case "5":
                StudentsController.editStudentGroup();
                break;
            case "6":
                StudentsController.deleteStudent();
                break;
            case "X":
                System.out.println("End of session. User logout.");
                break;
            default:
                System.out.println("Invalid option, try again\n");
                studentSubMenu();
        }
    }

    public static void employeeSubMenu() {

        System.out.println("Employee data:\n");

        System.out.println("1. Add new employee");
        System.out.println("2. Edit name ");
        System.out.println("3. Edit surname");
        System.out.println("4. Change position");
        System.out.println("5. Delete employee\n");

        System.out.print("\nSelect an option");
        String option = scanner.next().toUpperCase();

        switch (option) {
            case "1":
                EmployeesController.addNewEmployee();
                break;
            case "2":
                EmployeesController.editEmployeeName();
                break;
            case "3":
                EmployeesController.editEmployeeSurname();
                break;
            case "4":
                EmployeesController.editEmployeePosition();
                break;
            case "5":
                EmployeesController.deleteEmployee();
                break;
            case "X":
                System.out.println("End of session. User logout.");
                break;
            default:
                System.out.println("Invalid option, try again\n");
                employeeSubMenu();
        }
    }

    public static void eventSubMenu() {

        System.out.println("Event data:\n");

        System.out.println("1. Add new event");
        System.out.println("2. Edit label ");
        System.out.println("3. Change date");
        System.out.println("4. Edit description");
        System.out.println("5. Delete student\n");
        System.out.println("Select an option");
        String option = scanner.next().toUpperCase();

        switch (option) {
            case "1":
                EventsController.addNewEvent();
                break;
            case "2":
                EventsController.editEventLabel();
                break;
            case "3":
                EventsController.editEventDate();
                break;
            case "4":
                EventsController.editEventDescription();
                break;
            case "5":
                EventsController.deleteEvent();
                break;
            case "X":
                System.out.println("End of session. User logout.");
                break;
            default:
                System.out.println("Invalid option, try again\n");
                eventSubMenu();
        }
    }

    public static void scoreSubMenu() {

        System.out.println("Scores data:\n");

        System.out.println("1. Add new score");
        System.out.println("2. Edit score");
        System.out.println("3. Delete score \n");

        System.out.println("Select an option");
        String option = scanner.next().toUpperCase();

        switch (option) {
            case "1":
                ScoresController.addNewScore();
                break;
            case "2":
                ScoresController.editScore();
                break;
            case "3":
                ScoresController.deleteScore();
                break;
            case "X":
                System.out.println("End of session. User logout.");
                break;
            default:
                System.out.println("Invalid option, try again\n");
                scoreSubMenu();
        }
    }

    public static void observeData() {

        System.out.println("What do you want to see?\n");

        System.out.println("1. Employee");
        System.out.println("2. Lecturers");
        System.out.println("3. Students");
        System.out.println("4. Scores");
        System.out.println("5. Events\n");

        System.out.println("Select an option");
        String option = scanner.next().toUpperCase();

        switch (option) {
            case "1":
                observeChoiceEmployee();
                break;
            case "2":
                observeChoiceLecturers();
                break;
            case "3":
                observeChoiceStudents();
                break;
            case "4":
                observeChoiceScores();
                break;
            case "5":
                observeChoiceEvents();
                observeData();
                break;
            case "X":
                System.out.println("End of session. User logout.");
                break;
            default:
                System.out.println("Invalid option, try again\n");
                observeData();
        }
    }

    public static void observeChoiceEmployee() {

        System.out.println("What do you want to see?\n");

        System.out.println("1. Get employee by id");
        System.out.println("2. Get employee by surname");
        System.out.println("3. Get employees list by position\n");
        System.out.println("Select an option");
        String option = scanner.next().toUpperCase();

        switch (option) {
            case "1":
                EmployeesController.getEmployeeByID();
                break;
            case "2":
                EmployeesController.selectEmployeeBySurname();
                break;
            case "3":
                EmployeesController.selectEmployeeByPosition();
                break;
            case "X":
                System.out.println("End of session. User logout.");
                break;
            default:
                System.out.println("Invalid option, try again\n");
                observeChoiceEmployee();
        }
    }

    public static void observeChoiceLecturers() {
        System.out.println("What do you want to see?\n");

        System.out.println("1. Get lecturer by id");
        System.out.println("2. Get lecturer surname");
        System.out.println("3. Get lecturers by subject");
        System.out.println("4. Get lecturers by student group\n");
        System.out.print("\nSelect an option");
        String option = scanner.next().toUpperCase();

        switch (option) {
            case "1":
                EmployeesController.getEmployeeByID();
                break;
            case "2":
                EmployeesController.selectEmployeeBySurname();
                break;
            case "3":
                EmployeesController.selectLecturersBySubject();
                break;
            case "4":
                EmployeesController.selectLecturersByStudentGroup();
                break;
            case "X":
                System.out.println("End of session. User logout.");
                break;
            default:
                System.out.println("Invalid option, try again\n");
                observeChoiceLecturers();
        }
    }

    public static void observeChoiceStudents() {

        System.out.println("What do you want to see?\n");

        System.out.println("1. Get student by id");
        System.out.println("2. Get student by surname");
        System.out.println("3. Get students list by group");
        System.out.println("4. Get students list by faculty\n");
        System.out.print("\nSelect an option");
        String option = scanner.next().toUpperCase();

        switch (option) {
            case "1":
                StudentsController.getStudentByID();
                break;
            case "2":
                StudentsController.selectStudentsBySurname();
                break;
            case "3":
                StudentsController.selectStudentsByGroup();
                break;
            case "4":
                StudentsController.selectStudentsByFaculty();
                break;
            case "X":
                System.out.println("End of session. User logout.");
                break;
            default:
                System.out.println("Invalid option, try again\n");
                observeChoiceStudents();
        }
    }

    public static void observeChoiceScores() {
        System.out.println("What do you want to see?\n");

        System.out.println("1. Get scores by subject");
        System.out.println("2. Get final score by subjects");
        System.out.println("3. Get final student score\n");
        System.out.println("Select an option");
        String option = scanner.next().toUpperCase();

        switch (option) {
            case "1":
                ScoresController.selectStudentScoresBySubject();
                break;
            case "2":
                System.out.println("this option still developing");
                break;
            case "3":
                System.out.println("this option is not ready");
                break;
            case "X":
                System.out.println("End of session. User logout.");
                break;
            default:
                System.out.println("Invalid option, try again\n");
                observeChoiceScores();
        }
    }

    public static void observeChoiceEvents() {

        System.out.println("What do you want to see?\n");

        System.out.println("1. Get event by id");
        System.out.println("2. Get event by date");
        System.out.println("3. Get events by month");
        System.out.println("4. Get events by year");
        System.out.println("5. Get event by label\n");
        System.out.print("Select an option");
        String option = scanner.next().toUpperCase();

        switch (option) {
            case "1":
                EventsController.getEventByID();
                break;
            case "2":
                EventsController.selectEventByDate();
                break;
            case "3":
                EventsController.selectEventByMonth();
                break;
            case "4":
                EventsController.selectEventByYear();
                break;
            case "5":
                EventsController.selectEventByLabel();
                break;
            case "X":
                System.out.println("End of session. User logout.");
                break;
            default:
                System.out.println("Invalid option, try again\n");
                observeChoiceEvents();
        }
    }
}
