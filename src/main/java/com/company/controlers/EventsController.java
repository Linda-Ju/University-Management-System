package com.company.controlers;

import com.company.dbhelper.DbConnection;
import com.company.helpers.OutputMessage;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EventsController {
    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    //selection/edition can be done in single method by case option
    public static void addNewEvent() {

        System.out.print("\nEnter event's name: ");
        String label = scanner.nextLine();

        System.out.print("\nEnter event's date(format dd.mm.yyyy): ");
        String date = scanner.next();

        System.out.print("\nEnter event's description: ");
        scanner.nextLine();
        String description = scanner.nextLine();

        try {
            ps = DbConnection.user().prepareStatement("INSERT INTO events(event_date, label, description)" +
                    "VALUES ('" + date + "', '" + label + "' , '" + description + "')");
            ps.execute();
            System.out.println("\nNew event has been added.");
        } catch (Exception e) {
//            e.printStackTrace();
            OutputMessage.error();

        }
    }

    public static void editEventLabel() {
        int id = getEventByID();
        if (id != 0) {
            System.out.print("\nDo you wish to edit this data? Y/N : ");
            String option = scanner.next().trim().toUpperCase();
            if (option.equals("Y")) {

                System.out.print("\nEnter new event's label: ");
                String update = scanner.next().trim();

                try {
                    ps = DbConnection.user().prepareStatement("UPDATE events SET label = '" + update + "' WHERE id =" + id);
                    ps.execute();

                    System.out.println("\nSuccessfully updated event's label.");
                } catch (Exception e) {
//                    e.printStackTrace();
                    OutputMessage.error();

                }
            } else {
                System.out.println("The event's data remained unchanged.");
            }
        } else {
            System.out.println("There is no such event.");
            System.out.print("\nTry again? Y/N : ");
            String choice = scanner.next().trim().toUpperCase();
            if (choice.equals("Y")) {
                editEventLabel();
            } else {
                OutputMessage.redirecting();
            }
        }
    }

    public static void editEventDate() {
        int id = getEventByID();
        if (id != 0) {
            System.out.print("\nDo you wish to edit this data? Y/N : ");
            String option = scanner.next().trim().toUpperCase();
            if (option.equals("Y")) {

                System.out.print("\nEnter edited date(format dd.mm.yyyy): ");
                String update = scanner.next().trim();
                try {
                    ps = DbConnection.user().prepareStatement("UPDATE events SET event_date = '" + update + "' WHERE id =" + id);
                    ps.execute();
                    System.out.println("\nSuccessfully updated event's data.");
                } catch (Exception e) {
//                    e.printStackTrace();
                    OutputMessage.error();

                }
            } else {
                System.out.println("The event's data remained unchanged.");
            }
        } else {
            System.out.println("There is no such event.");
            System.out.println("Try again? Y/N : ");
            String choice = scanner.next().trim().toUpperCase();
            if (choice.equals("Y")) {
                editEventLabel();
            } else {
                OutputMessage.redirecting();
            }
        }
    }

    public static void editEventDescription() {
        int id = getEventByID();
        if (id != 0) {
            System.out.print("\nDo you wish to edit this data? Y/N : ");
            String option = scanner.next().trim().toUpperCase();

            if (option.equals("Y")) {

                System.out.print("\nEnter new event's description: ");
                scanner.nextLine();
                String update = scanner.nextLine();
                try {
                    ps = DbConnection.user().prepareStatement("UPDATE events SET description = '" + update + "' WHERE id =" + id);
                    ps.execute();
                    System.out.println("\nSuccessfully updated event's description.");
                } catch (Exception e) {
//                    e.printStackTrace();
                    OutputMessage.error();
                }
            } else {
                System.out.println("The event's data remained unchanged.");
            }
        } else {
            System.out.println("There is no such event.");
            System.out.print("\nTry again? Y/N : ");
            String choice = scanner.next().trim().toUpperCase();
            if (choice.equals("Y")) {
                editEventLabel();
            } else {
                OutputMessage.redirecting();
            }
        }
    }

    public static void deleteEvent() {
        System.out.print("\nEnter the event's date(format dd.mm.yyyy): ");
        String date = scanner.next().trim();
        System.out.print("\nEnter the event's name: ");
        String label = scanner.next().trim();

        try {
            ps = DbConnection.user().prepareStatement("DELETE FROM events WHERE event_date ='" + date + "' AND label = '" + label + "'");
            ps.execute();
            System.out.println("\nThe event was successfully removed from the database.");
        } catch (Exception e) {
//            e.printStackTrace();
            OutputMessage.error();
        }
    }

    public static void selectEventByDate() {
        System.out.print("\nEnter the event's date(format dd.mm.yyyy): ");
        String date = scanner.next().trim();

        try {
            ps = DbConnection.user().prepareStatement("SELECT * FROM events WHERE event_date = '" + date + "' ORDER BY event_date");
            rs = ps.executeQuery();


            while (rs.next()) {
                System.out.printf("\n%-12.12s %-25.25s%n", rs.getString("event_date"),
                        rs.getString("label"));
                System.out.println("\t\t" + rs.getString("description") + "\n");
            }
        } catch (SQLException throwables) {
//            throwables.printStackTrace();
            OutputMessage.error();

        }
    }

    public static void selectEventByYear() {
        System.out.print("\nEnter the event's year: ");
        String date = scanner.next().trim();

        try {
            ps = DbConnection.user().prepareStatement("SELECT * FROM events WHERE event_date LIKE '%." + date + "' ORDER BY event_date");
            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.printf("\n%-12.12s %-25.25s%n", rs.getString("event_date"),
                        rs.getString("label"));
                System.out.println("\t\t" + rs.getString("description") + "\n");
            }
        } catch (SQLException throwables) {
//            throwables.printStackTrace();
            OutputMessage.error();

        }
    }

    public static void selectEventByMonth() {
        System.out.print("\nEnter the event's month: ");
        String date = scanner.next().trim();
        try {
            ps = DbConnection.user().prepareStatement("SELECT * FROM events WHERE event_date LIKE '%." + date + ".%' ORDER BY event_date");
            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.printf("\n%-12.12s %-25.25s%n", rs.getString("event_date"),
                        rs.getString("label"));
                System.out.println("\t\t" + rs.getString("description") + "\n");
            }
        } catch (SQLException throwables) {
//            throwables.printStackTrace();
            OutputMessage.error();

        }
    }

    public static void selectEventByLabel() {
        System.out.print("\nEnter the event's name: ");
        String label = scanner.next().trim();

        try {
            ps = DbConnection.user().prepareStatement("SELECT * FROM events WHERE label ='" + label + "'  ORDER BY event_date");
            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.printf("%-12.12s %-25.25s%n", rs.getString("event_date"),
                        rs.getString("label"));
                System.out.println("\t\t" + rs.getString("description"));
            }
        } catch (SQLException throwables) {
//            throwables.printStackTrace();
            OutputMessage.error();

        }
    }


    public static int getEventByID() {
        System.out.print("\nEnter the events id: ");
        int check = 0;
        try {
            check = scanner.nextInt();

        } catch (InputMismatchException e) {
            System.err.println("Wrong input! Input only integer numbers please...");

        }

        int id = 0;

        try {
            ps = DbConnection.user().prepareStatement("SELECT * FROM events WHERE id =" + check);
            rs = ps.executeQuery();

            while (rs.next()) {
                id = rs.getInt("id");
                System.out.printf("\n%-3.5s %-12.12s %-25.25s%n", id, rs.getString("event_date"),
                        rs.getString("label"));
                System.out.println("\t\t" + rs.getString("description"));
            }
        } catch (SQLException throwables) {
//            throwables.printStackTrace();
            OutputMessage.error();

        }
        return id;
    }
}
