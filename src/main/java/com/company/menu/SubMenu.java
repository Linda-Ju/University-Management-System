package com.company.menu;

import com.company.controlers.EmployeesController;
import com.company.controlers.EventsController;
import com.company.controlers.StudentsController;

import java.awt.*;
import java.util.Scanner;

public class SubMenu {

    public static void studentSubMenu(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Student data\n");

        System.out.println("1. Add new student");
        System.out.println("2. Edit name ");
        System.out.println("3. Edit surname");
        System.out.println("4. Change faculty");
        System.out.println("5. Change group");
        System.out.println("6. Delete student\n");

        System.out.println("Select an option");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                StudentsController.addNewStudent();
                break;
            case 2:
                StudentsController.editStudentName();
                break;
            case 3:
                StudentsController.editStudentSurname();
                break;
            case 4:
                StudentsController.editStudentFaculty();
                break;
            case 5:
                StudentsController.editStudentGroup();
                break;
            case 6:
                StudentsController.deleteStudent();
                break;
            default:
                System.out.println("Invalid option\n");
                System.out.println("Do you wish to try again Y/N");
                String endSession = scanner.next().trim();
                if (endSession.equals("Y")) {

                    System.out.println("redirecting to start..\n");
                    studentSubMenu();
                }

                else{
                    System.out.println("End of this session. Redirecting to start...");
                    Menu.administrationMainMenu();
                }
        }
    }

    public static void employeeSubMenu(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Employee data\n");

        System.out.println("1. Add new employee");
        System.out.println("2. Edit name ");
        System.out.println("3. Edit surname");
        System.out.println("4. Change position");
        System.out.println("5. Delete employee\n");

        System.out.println("Select an option");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                EmployeesController.addNewEmployee();
                break;
            case 2:
                EmployeesController.editEmployeeName();
                break;
            case 3:
               EmployeesController.editEmployeeSurname();
                break;
            case 4:
               EmployeesController.editEmployeePosition();
                break;
            case 5:
                EmployeesController.deleteEmployee();
                break;

            default:
                System.out.println("Invalid option\n");
                System.out.println("Do you wish to try again Y/N");
                String endSession = scanner.next().trim();
                if (endSession.equals("Y")) {

                    System.out.println("redirecting to start..\n");
                    employeeSubMenu();
                }

                else{
                    System.out.println("End of this session. Redirecting to start...");
                    Menu.administrationMainMenu();
                }
        }
    }

    public static void eventSubMenu(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Event data\n");

        System.out.println("1. Add new event");
        System.out.println("2. Edit label ");
        System.out.println("3. Change date");
        System.out.println("4. Edit description");
        System.out.println("5. Delete student\n");
        System.out.println("Select an option");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                EventsController.addNewEvent();
                break;
            case 2:
                EventsController.editEventLabel();
                break;
            case 3:
                EventsController.editEventDate();
                break;
            case 4:
               EventsController.editEventDescription();
                break;
            case 5:
                EventsController.deleteEvent();
                break;

            default:
                System.out.println("Invalid option\n");
                System.out.println("Do you wish to try again Y/N");
                String endSession = scanner.next().trim();
                if (endSession.equals("Y")) {

                    System.out.println("redirecting to start..\n");
                    eventSubMenu();
                }

                else{
                    System.out.println("End of this session. Redirecting to start...");
                    Menu.administrationMainMenu();
                }
        }
    }

    public static void scoreSubMenu(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Scores data\n");

        System.out.println("1. ");
        System.out.println("2. ");
        System.out.println("3. ");
        System.out.println("4. ");
        System.out.println("5. ");
        System.out.println("6. \n");

        System.out.println("Select an option");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                System.out.println("Not ready yet");
                break;
            case 2:
                System.out.println("Not ready yet");
                break;
            case 3:
                System.out.println("Not ready yet");
                break;
            case 4:
                System.out.println("Not ready yet");
                break;
            case 5:
                System.out.println("Not ready yet");
                break;

            default:
                System.out.println("Invalid option\n");
                System.out.println("Do you wish to try again Y/N");
                String endSession = scanner.next().trim();
                if (endSession.equals("Y")) {

                    System.out.println("redirecting to start..\n");
                    scoreSubMenu();
                }

                else{
                    System.out.println("End of this session. Redirecting to start...");
                    Menu.administrationMainMenu();
                }
        }
    }

    public static void observeData(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("what do you want to see\n");

        System.out.println("1. Employee");
        System.out.println("2. Lectors");
        System.out.println("3. Students");
        System.out.println("4. Scores");
        System.out.println("5. Events\n");

        System.out.println("Select an option");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
               observeEmployee();
                break;
            case 2:
                observeLectors();
                break;
            case 3:
                observeStudents();
                break;
            case 4:
                observeScores();
                break;
            case 5:
               observeEvents();
                System.out.println("End of this session. Redirecting to start...");
                observeData();
                break;

            default:
                System.out.println("Invalid option\n");
                System.out.println("Do you wish to try again Y/N");
                String endSession = scanner.next().trim();
                if (endSession.equals("Y")) {

                    System.out.println("redirecting to start..\n");
                    observeData();
                }

                else{
                    System.out.println("End of this session. Redirecting to start...");
                    Menu.administrationMainMenu();
                }
        }
    }

    public static void observeEmployee(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("what do you want to see\n");

        System.out.println("1. Get employee by id");
        System.out.println("2. Get employee by surname");
        System.out.println("3. Get employees list by position\n");
        System.out.println("Select an option");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                EmployeesController.getEmployeeByID();
                break;
            case 2:
                EmployeesController.getEmployeeBySurname();
                break;
            case 3:
                EmployeesController.getEmployeeByPosition();
                break;


            default:
                System.out.println("Invalid option\n");
                System.out.println("Do you wish to try again Y/N");
                String endSession = scanner.next().trim();
                if (endSession.equals("Y")) {

                    System.out.println("redirecting to start..\n");
                    observeEmployee();
                }

                else{
                    System.out.println("End of this session. Redirecting to start...");
                    observeData();
                }
        }
    }

    public static void observeLectors(){}

    public static void observeStudents(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("what do you want to see\n");

        System.out.println("1. Get student by id");
        System.out.println("2. Get student by surname");
        System.out.println("3. Get students list by group");
        System.out.println("4. Get students list by faculty\n");
        System.out.println("Select an option");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                StudentsController.getStudentByID();
                break;
            case 2:
                StudentsController.selectStudentsBySurname();
                break;
            case 3:
                StudentsController.selectStudentsByGroup();
                break;
            case 4:
                StudentsController.selectStudentsByFaculty();
                break;

            default:
                System.out.println("Invalid option\n");
                System.out.println("Do you wish to try again Y/N");
                String endSession = scanner.next().trim();
                if (endSession.equals("Y")) {

                    System.out.println("redirecting to start..\n");
                    observeStudents();
                }

                else{
                    System.out.println("End of this session. Redirecting to start...");
                    observeData();
                }
        }

    }

    public static void observeScores(){}

    public static void observeEvents(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("what do you want to see\n");

        System.out.println("1. Get event by id");
        System.out.println("2. Get event by date");
        System.out.println("3. Get events by month");
        System.out.println("4. Get events by year");
        System.out.println("5. Get event by label\n");
        System.out.println("Select an option");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                EventsController.getEventByID();
                break;
            case 2:
                EventsController.selectEventByDate();
                break;
            case 3:
                EventsController.selectEventByMonth();
                break;
            case 4:
                EventsController.selectEventByYear();
                break;
            case 5:
                EventsController.selectEventByLabel();
                break;

            default:
                System.out.println("Invalid option\n");
                System.out.println("Do you wish to try again Y/N");
                String endSession = scanner.next().trim();
                if (endSession.equals("Y")) {

                    System.out.println("redirecting to start..\n");
                    observeEvents();
                }

                else{
                    break;
                }
        }
    }
}
