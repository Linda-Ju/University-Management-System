package com.company.controlers;

import com.company.dbhelper.DbConnection;

import com.company.objects.Objects;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EventsController {
    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    //selection/edition can be done in single method by case option
    public static void addNewEvent() {

        System.out.print("\nEnter event: ");
        String label = scanner.next();

        System.out.print("\nEnter event date(format dd/mm/yyyy): ");
        String date = scanner.next();

        System.out.print("\nEnter description: ");
        scanner.nextLine();
        String description = scanner.nextLine();

        try {
            ps = DbConnection.user().prepareStatement("INSERT INTO events(event_date, label, description)" +
                    "VALUES ('" + date + "', '" + label + "' , '" + description + "')");
            ps.execute();
            System.out.println("\nNew event has been added.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void editEventLabel() {
        int id = getEventByID().getId();
        if (id != 0) {
            System.out.print("\nDo you wish to edit this data Y/N");
            String option = scanner.next().trim();
            if (option.equals("Y")) {

                System.out.print("\nEnter edited label");
                String update = scanner.next().trim();

                try {
                    ps = DbConnection.user().prepareStatement("UPDATE events SET label = '" + update + "' WHERE id =" + id);
                    ps.execute();

                    System.out.println("\nsuccessfully updated");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Event remains unchanged");
            }
        } else {
            System.out.println("There is no such event.");
            System.out.print("\nTry again? Y/N");
            String choice = scanner.next();
            if (choice.equals("Y")) {
                editEventLabel();
            } else {
                System.out.println("redirecting to start menu..\n");
            }
        }
    }

    public static void editEventDate() {
        int id = getEventByID().getId();
        if (id != 0) {
            System.out.print("\nDo you wish to edit this data Y/N");
            String option = scanner.next().trim();
            if (option.equals("Y")) {

                System.out.print("\nEnter edited date(format dd/mm/yyyy):");
                String update = scanner.next().trim();

                try {
                    ps = DbConnection.user().prepareStatement("UPDATE events SET event_date = '" + update + "' WHERE id =" + id);
                    ps.execute();
                    System.out.println("successfully updated");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Event remains unchanged");
            }
        } else {
            System.out.println("There is no such event.");
            System.out.println("Try again? Y/N");
            String choice = scanner.next();
            if (choice.equals("Y")) {
                editEventLabel();
            } else {
                System.out.println("redirecting to start menu..\n");
            }
        }
    }

    public static void editEventDescription() {
        int id = getEventByID().getId();
        if (id != 0) {
            System.out.print("\nDo you wish to edit this data Y/N");
            String option = scanner.next().trim().toUpperCase();

            if (option.equals("Y")) {

                System.out.print("\nEnter edited description");
                scanner.nextLine();
                String update = scanner.nextLine();

                try {
                    ps = DbConnection.user().prepareStatement("UPDATE events SET description = '" + update + "' WHERE id =" + id);
                    ps.execute();
                    System.out.println("successfully updated");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Event remains unchanged");
            }
        } else {
            System.out.println("There is no such event.");
            System.out.print("\nTry again? Y/N");
            String choice = scanner.next().toUpperCase();
            if (choice.equals("Y")) {
                editEventLabel();
            } else {
                System.out.println("redirecting to start menu..\n");
            }
        }
    }

    public static void deleteEvent() {
        System.out.print("\nEnter the events date(format dd/mm/yyyy): ");
        String date = scanner.next().trim();
        System.out.print("\nEnter the event: ");
        String label = scanner.next().trim();

        try {
            ps = DbConnection.user().prepareStatement("DELETE FROM events WHERE event_date ='" + date + "' AND event = '" + label + "'");
            ps.execute();
            System.out.println("successfully removed to database");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void selectEventByDate() {
        System.out.print("\nEnter the events date(format dd/mm/yyyy): ");
        String date = scanner.next().trim();

        try {
            ps = DbConnection.user().prepareStatement("SELECT * FROM events WHERE event_date = '" + date + "'");
            rs = ps.executeQuery();

            System.out.println("date \t  event \t description");
            while (rs.next()) {
                System.out.println(rs.getString("event_date") + " \t " +
                        rs.getString("label") + " \t " + rs.getString("description"));
                System.out.println("");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void selectEventByYear() {
        System.out.println("\nEnter the year ");
        String date = scanner.next().trim();


        try {
            ps = DbConnection.user().prepareStatement("SELECT * FROM events WHERE event_date LIKE '%." + date + "'");
            rs = ps.executeQuery();

            System.out.println("date \t  event \t description");
            while (rs.next()) {
                System.out.println(rs.getString("event_date") + " \t " +
                        rs.getString("label") + " \t " + rs.getString("description"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void selectEventByMonth() {
        System.out.print("\nEnter the month ");
        String date = scanner.next().trim();
        try {
            ps = DbConnection.user().prepareStatement("SELECT * FROM events WHERE event_date LIKE '%." + date + ".%'");
            rs = ps.executeQuery();

            System.out.println("date \t  event \t description");
            while (rs.next()) {
                System.out.println(rs.getString("event_date") + " \t " +
                        rs.getString("label") + " \t " + rs.getString("description"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void selectEventByLabel() {
        System.out.print("\nEnter the event: ");
        String label = scanner.next().trim();

        try {
            ps = DbConnection.user().prepareStatement("SELECT * FROM events WHERE label ='" + label + "'");
            rs = ps.executeQuery();

            System.out.println("date \t  event \t description");
            while (rs.next()) {
                System.out.println(rs.getString("event_date") + " \t " +
                        rs.getString("label") + " \t " + rs.getString("description"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static Objects getEventByID() {
        System.out.print("\nEnter the events id: ");
        int id = scanner.nextInt();

        try {
            ps = DbConnection.user().prepareStatement("SELECT * FROM events WHERE id =" + id);
            rs = ps.executeQuery();

            System.out.println("id \t date \t  event \t description");
            int eventID;
            Objects event = new Objects();
            while (rs.next()) {
                eventID = rs.getInt("id");
                System.out.println(eventID + " \t " + rs.getString("event_date") + " \t " +
                        rs.getString("label") + " \t " + rs.getString("description"));
                event.setId(eventID);
            }
            return event;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
