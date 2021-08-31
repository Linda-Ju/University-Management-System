package com.company.menu;


import com.company.controlers.EmployeesController;
import com.company.helpers.OutputMessage;

import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);

    public static void adminMainMenu() {
        //access to every menu + some extras like getting password for user
        System.out.println("Admin panel\n");

        System.out.println("1. User data");
        System.out.println("2. Employees data");
        System.out.println("3. Students data");
        System.out.println("4. Scores data");
        System.out.println("5. Events data");
        System.out.println("6. Observe data");
        System.out.println("X. Exit");

        System.out.print("\nSelect an option: \t");
        String option = scanner.next().toUpperCase();

        switch (option) {
            case "1":
                SubMenu.userSubMenu();
                break;
            case "2":
                SubMenu.employeeSubMenu();
                break;
            case "3":
                SubMenu.studentSubMenu();
                break;
            case "4":
                SubMenu.scoreSubMenu();
                break;
            case "5":
                SubMenu.eventSubMenu();
                break;
            case "6":
                SubMenu.observeData();
                break;
            case "X":
                OutputMessage.logout();
                break;
            default:
                OutputMessage.invalidInput();
                adminMainMenu();

        }

    }

    public static void administrationMainMenu() {
        //add/edit/delete events, users, students, scores, observe those

        System.out.println("Administration menu\n");

        System.out.println("1. Add/Change/Delete employee data");
        System.out.println("2. Add/Change/Delete student data");
        System.out.println("3. Add/Change/Delete score data");
        System.out.println("4. Add/Change/Delete event data");
        System.out.println("5. Observe data");
        System.out.println("X. Exit");

        System.out.print("\nSelect an option: \t");
        String option = scanner.next().toUpperCase();

        switch (option) {
            case "1":
                SubMenu.employeeSubMenu();
                break;
            case "2":
                SubMenu.studentSubMenu();
                break;
            case "3":
                SubMenu.scoreSubMenu();
                break;
            case "4":
                SubMenu.eventSubMenu();
                break;
            case "5":
                SubMenu.observeData();
                break;
            case "X":
                OutputMessage.logout();
                break;
            default:
                OutputMessage.invalidInput();
                administrationMainMenu();
        }
    }

    public static void lecturerAccessMenu() {

        System.out.println("Lecturers menu\n");

        System.out.println("1. Add/Change/Delete score data");
        System.out.println("2. Observe students scores");
        System.out.println("3. Observe events");
        System.out.println("X. Exit");

        System.out.print("\nSelect an option: \t");
        String option = scanner.next().toUpperCase();

        switch (option) {
            case "1":
                SubMenu.scoreSubMenu();
                break;
            case "2":
                SubMenu.observeChoiceScores();
                break;
            case "3":
                SubMenu.observeChoiceEvents();
                break;
            case "X":
                OutputMessage.logout();
                break;
            default:
                OutputMessage.invalidInput();
                lecturerAccessMenu();
        }
    }

    public static void studentAccessMenu() {
        // observe his data, events
        System.out.println("Students menu\n");

        System.out.println("1. Observe your lecturers");
        System.out.println("2. Observe scores");
        System.out.println("3. Observe events");
        System.out.println("X. Exit");

        System.out.print("\nSelect an option: \t");
        String option = scanner.next().toUpperCase();

        switch (option) {
            case "1":
                EmployeesController.selectLecturersByStudentGroup();
                break;
            case "2":
                SubMenu.observeChoiceScores();
                break;
            case "3":
                SubMenu.observeChoiceEvents();
                break;
            case "X":
                OutputMessage.logout();
                break;
            default:
                OutputMessage.invalidInput();
                studentAccessMenu();
        }
    }
}
