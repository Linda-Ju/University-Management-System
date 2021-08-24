package com.company.menu;

import com.company.controlers.StudentsController;

import java.util.Scanner;

public class Menu {

    public static void adminMainMenu(){
        //access to every menu + some extras like getting password for user

    }

    public static void administrationMainMenu(){
        //add/edit/delete events, users, students, scores, observe those
        Scanner scanner = new Scanner(System.in);

        System.out.println("Administration menu\n");

        System.out.println("1. Add/Change/Delete employee data");
        System.out.println("2. Add/Change/Delete student data");
        System.out.println("3. Add/Change/Delete score data");
        System.out.println("4. Add/Change/Delete event data");
        System.out.println("5. Observe data\n");

        System.out.println("Select an option");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                SubMenu.employeeSubMenu();
                break;
            case 2:
                SubMenu.studentSubMenu();
                break;
            case 3:
                SubMenu.scoreSubMenu();
                break;
            case 4:
                SubMenu.eventSubMenu();
                break;
            case 5:
                SubMenu.observeData();
                break;

            default:
                System.out.println("Invalid option\n");
                System.out.println("Do you wish to try again Y/N");
                String endSession = scanner.next().trim();
                if (endSession.equals("Y")) {

                    System.out.println("redirecting to start..\n");
                    administrationMainMenu();
                }

                else{
                    System.out.println("End of session. User logout.");

                }
        }
    }

    public static void lecturerAccessMenu(){
        //add/edit/delete scores, observe students, groups
    }

    public static void studentAccessMenu() {
        // observe his data, events
    }
}
