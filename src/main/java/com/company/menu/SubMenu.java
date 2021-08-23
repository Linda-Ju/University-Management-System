package com.company.menu;

import com.company.controlers.EmployeesController;
import com.company.controlers.EventsController;
import com.company.controlers.StudentsController;

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

    }
}
