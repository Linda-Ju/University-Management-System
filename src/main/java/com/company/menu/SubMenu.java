package com.company.menu;

import com.company.controlers.*;
import com.company.helpers.OutputMessage;

import java.util.Scanner;

public class SubMenu {
    private static Scanner scanner = new Scanner(System.in);

    public static void userSubMenu() {
        System.out.println("User DATA\n");

        System.out.println("1. Remind password");
        System.out.println("2. Change password");
        System.out.println("3. Observe users by access level");
        System.out.println("X. Exit\n");
        System.out.print("Select an option: \t");
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
                OutputMessage.redirecting();
                break;
            default:
                OutputMessage.invalidInput();
                userSubMenu();
        }
        if(!option.equals("X")){
            userSubMenu();
        }
    }

    public static void studentSubMenu() {

        System.out.println("Student  DATA:\n");

        System.out.println("1. Add new student");
        System.out.println("2. Edit name ");
        System.out.println("3. Edit surname");
        System.out.println("4. Change faculty");
        System.out.println("5. Change group");
        System.out.println("6. Delete student");
        System.out.println("X. Exit\n");

        System.out.print("Select an option: \t");
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
                OutputMessage.redirecting();
                break;
            default:
                OutputMessage.invalidInput();
                studentSubMenu();
        }
        if(!option.equals("X")){
            studentSubMenu();
        }
    }

    public static void employeeSubMenu() {

        System.out.println("Employee  DATA:\n");

        System.out.println("1. Add new employee");
        System.out.println("2. Edit name ");
        System.out.println("3. Edit surname");
        System.out.println("4. Change position");
        System.out.println("5. Delete employee");
        System.out.println("X. Exit\n");

        System.out.print("Select an option: \t");
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
                OutputMessage.redirecting();
                break;
            default:
                OutputMessage.invalidInput();
                employeeSubMenu();
        }
        if(!option.equals("X")){
            employeeSubMenu();
        }
    }

    public static void eventSubMenu() {

        System.out.println("Event  DATA:\n");

        System.out.println("1. Add new event");
        System.out.println("2. Edit label ");
        System.out.println("3. Change date");
        System.out.println("4. Edit description");
        System.out.println("5. Delete event");
        System.out.println("X. Exit\n");
        System.out.println("Select an option: \t");
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
                OutputMessage.redirecting();
                break;
            default:
                OutputMessage.invalidInput();
                eventSubMenu();
        }
        if(!option.equals("X")){
           eventSubMenu();
        }
    }

    public static void scoreSubMenu() {

        System.out.println("Scores  DATA:\n");

        System.out.println("1. Add new score");
        System.out.println("2. Edit score");
        System.out.println("3. Delete score");
        System.out.println("X. Exit\n");

        System.out.print("Select an option: \t");
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
                OutputMessage.redirecting();
                break;
            default:
                OutputMessage.invalidInput();
                scoreSubMenu();
        }
        if(!option.equals("X")){
            scoreSubMenu();
        }
    }

    public static void observeData() {

        System.out.println("What do you want to observe?\n");

        System.out.println("1. Employee");
        System.out.println("2. Lecturers");
        System.out.println("3. Students");
        System.out.println("4. Scores");
        System.out.println("5. Events");
        System.out.println("X. Exit\n");

        System.out.print("Select an option: \t");
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
                OutputMessage.redirecting();
                break;
            default:
                OutputMessage.invalidInput();
                observeData();
        }
        if(!option.equals("X")){
            observeData();
        }
    }

    public static void observeChoiceEmployee() {

        System.out.println("What do you want to observe?\n");

        System.out.println("1. Select employee by id");
        System.out.println("2. Select employee by surname");
        System.out.println("3. Select employees list by position");
        System.out.println("X. Exit\n");
        System.out.print("Select an option: \t");
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
                OutputMessage.redirecting();
                break;
            default:
                OutputMessage.invalidInput();
                observeChoiceEmployee();
        }
        if(!option.equals("X")){
            observeChoiceEmployee();
        }
    }

    public static void observeChoiceLecturers() {
        System.out.println("What do you want to observe?\n");

        System.out.println("1. Select lecturer by id");
        System.out.println("2. Select lecturer surname");
        System.out.println("3. Select lecturers by subject");
        System.out.println("4. Select lecturers by student group");
        System.out.println("X. Exit\n");
        System.out.print("Select an option: \t");
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
                OutputMessage.redirecting();
                break;
            default:
                OutputMessage.invalidInput();
                observeChoiceLecturers();
        }
        if(!option.equals("X")){
            observeChoiceLecturers();
        }
    }

    public static void observeChoiceStudents() {

        System.out.println("What do you want to observe?\n");

        System.out.println("1. Select student by id");
        System.out.println("2. Select student by surname");
        System.out.println("3. Select students list by group");
        System.out.println("4. Select students list by faculty");
        System.out.println("X. Exit\n");
        System.out.print("Select an option: \t");
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
                OutputMessage.redirecting();
                break;
            default:
                OutputMessage.invalidInput();
                observeChoiceStudents();
        }
        if(!option.equals("X")){
            observeChoiceStudents();
        }

    }

    public static void observeChoiceScores() {
        System.out.println("What do you want to observe?\n");

        System.out.println("1. Select scores by subject");
        System.out.println("2. Select final score by subjects");
        System.out.println("3. Select final student score");
        System.out.println("X. Exit\n");
        System.out.println("Select an option: \t");
        String option = scanner.next().toUpperCase();

        switch (option) {
            case "1":
                ScoresController.selectStudentScoresBySubject();
                break;
            case "2":
                System.out.println("this option still developing");
                OutputMessage.redirecting();
                break;
            case "3":
                System.out.println("this option is not ready");
                OutputMessage.redirecting();
                break;
            case "X":
                OutputMessage.redirecting();
                break;
            default:
                OutputMessage.invalidInput();
                observeChoiceScores();
        }
        if(!option.equals("X")){
            observeChoiceScores();
        }
    }

    public static void observeChoiceEvents() {

        System.out.println("What do you want to observe?\n");

        System.out.println("1. Select event by id");
        System.out.println("2. Select event by date");
        System.out.println("3. Select events by month");
        System.out.println("4. Select events by year");
        System.out.println("5. Select event by label");
        System.out.println("X. Exit\n");
        System.out.print("Select an option: \t");
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
                OutputMessage.redirecting();
                break;
            default:
                OutputMessage.invalidInput();
                observeChoiceEvents();
        }
        if(!option.equals("X")){
            observeChoiceEvents();
        }
    }
}
