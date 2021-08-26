package com.company.menu;

import com.company.controlers.*;

import java.util.Scanner;

public class SubMenu {
   private static  Scanner scanner = new Scanner(System.in);

    public static void userSubMenu(){
        System.out.println("what do you want to see\n");

        System.out.println("1. Remind password");
        System.out.println("5. Change password\n");
        System.out.println("Select an option");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                UserController.findUserByUsername();
                break;
            case 2:
                UserController.changeUserPassword();
                break;

            default:
                System.out.println("Invalid option\n");

        }
        System.out.println("Do you wish to do another action with users data Y/N");
        String endSession = scanner.next().trim();
        if (endSession.equals("Y")) {

            System.out.println("redirecting to start..\n");
            userSubMenu();
        }
    }

    public static void studentSubMenu(){

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

                }
        System.out.println("Do you wish to do it again Y/N");
        String endSession = scanner.next().trim();
        if (endSession.equals("Y")) {

            System.out.println("redirecting to start..\n");
            studentSubMenu();
        }
    }

    public static void employeeSubMenu(){

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

                }
        System.out.println("Do you wish to do it again Y/N");
        String endSession = scanner.next().trim();
        if (endSession.equals("Y")) {

            System.out.println("redirecting to start..\n");
            employeeSubMenu();
        }
    }

    public static void eventSubMenu(){

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

        }
        System.out.println("Do you wish to do it again Y/N");
        String endSession = scanner.next().trim();
        if (endSession.equals("Y")) {

            System.out.println("redirecting to start..\n");
            eventSubMenu();
        }
    }

    public static void scoreSubMenu(){

        System.out.println("Scores data\n");

        System.out.println("1. Add new score");
        System.out.println("2. Edit score");
        System.out.println("3. Delete score \n");

        System.out.println("Select an option");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                ScoresController.addNewScore();
                break;
            case 2:
                ScoresController.editScore();
                break;
            case 3:
                ScoresController.deleteScore();
                break;


            default:
                System.out.println("Invalid option\n");

        }
        System.out.println("Do you wish to do it again Y/N");
        String endSession = scanner.next().trim();
        if (endSession.equals("Y")) {

            System.out.println("redirecting to start..\n");
            scoreSubMenu();
        }
    }

    public static void observeData(){

        System.out.println("what do you want to see\n");

        System.out.println("1. Employee");
        System.out.println("2. Lecturers");
        System.out.println("3. Students");
        System.out.println("4. Scores");
        System.out.println("5. Events\n");

        System.out.println("Select an option");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
               observeChoiceEmployee();
                break;
            case 2:
                observeChoiceLecturers();
                break;
            case 3:
                observeChoiceStudents();
                break;
            case 4:
                observeChoiceScores();
                break;
            case 5:
               observeChoiceEvents();
                System.out.println("End of this session. Redirecting to start...");
                observeData();
                break;

            default:
                System.out.println("Invalid option\n");


        }
        System.out.println("Do you wish to do it again Y/N");
        String endSession = scanner.next().trim();
        if (endSession.equals("Y")) {

            System.out.println("redirecting to start..\n");
            observeData();
        }
    }

    public static void observeChoiceEmployee(){

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
                EmployeesController.selectEmployeeBySurname();
                break;
            case 3:
                EmployeesController.selectEmployeeByPosition();
                break;


            default:
                System.out.println("Invalid option\n");

        }
        System.out.println("Do you wish to do it again Y/N");
        String endSession = scanner.next().trim();
        if (endSession.equals("Y")) {

            System.out.println("redirecting to start..\n");
            observeChoiceEmployee();
        }

        else{
            System.out.println("End of this session. Redirecting to start...");

        }
    }

    public static void observeChoiceLecturers(){
        System.out.println("what do you want to see\n");

        System.out.println("1. Get lecturer by id");
        System.out.println("2. Get lecturer surname");
        System.out.println("3. Get lecturers by subject");
        System.out.println("4. Get lecturers by student group\n");
        System.out.println("Select an option");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                EmployeesController.getEmployeeByID();
                break;
            case 2:
                EmployeesController.selectEmployeeBySurname();
                break;
            case 3:
                EmployeesController.selectLecturersBySubject();
                break;
            case 4:
                EmployeesController.selectLecturersByStudentGroup();
                break;

            default:
                System.out.println("Invalid option\n");

        }
        System.out.println("Do you wish to do it again Y/N");
        String endSession = scanner.next().trim();
        if (endSession.equals("Y")) {

            System.out.println("redirecting to start..\n");
            observeChoiceEmployee();
        }

        else{
            System.out.println("End of this session. Redirecting to start...");

        }
    }

    public static void observeChoiceStudents(){

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

        }
        System.out.println("Do you wish to do it again Y/N");
        String endSession = scanner.next().trim();
        if (endSession.equals("Y")) {

            System.out.println("redirecting to start..\n");
            observeChoiceStudents();
        }

        else{
            System.out.println("End of this session. Redirecting to start...");
            observeData();
        }
    }

    public static void observeChoiceScores(){
        System.out.println("what do you want to see\n");

        System.out.println("1. Get scores by subject");
        System.out.println("2. Get final score by subjects");
        System.out.println("3. Get final student score\n");
        System.out.println("Select an option");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                ScoresController.selectScoresBySubjectAndStudentID();
                break;
            case 2 :
                System.out.println("this option still developing");
                break;
            case 3:
                System.out.println("this option is not ready");
                break;


            default:
                System.out.println("Invalid option\n");

        }
        System.out.println("Do you wish to do it again Y/N");
        String endSession = scanner.next().trim();
        if (endSession.equals("Y")) {

            System.out.println("redirecting to start..\n");
            observeChoiceStudents();
        }

        else{
            System.out.println("End of this session. Redirecting to start...");
            observeData();
        }
    }

    public static void observeChoiceEvents(){

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

                }
         System.out.println("Do you wish to do it again Y/N");
        String endSession = scanner.next().trim();
        if (endSession.equals("Y")) {

            System.out.println("redirecting to start..\n");
            observeChoiceStudents();
        }

        else{
            System.out.println("End of this session. Redirecting to start...");
            observeData();
        }
    }

}
