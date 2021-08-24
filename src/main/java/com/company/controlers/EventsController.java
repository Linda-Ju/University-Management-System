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

    public static void addNewEvent() {


        System.out.println("\nEnter event: ");
        String label = scanner.next();


        System.out.println("\nEnter event date(format dd.mm.yyyy): ");
        String date = scanner.next();


        System.out.println("\nEnter description: ");
        String description = scanner.nextLine();



        try {
            ps = DbConnection.user().prepareStatement("INSERT INTO events(event_date, label, description)" +
                    "VALUES ('" +  date + "', '" + label + "' , '" + description +  "')");

            ps.execute();
            System.out.println("\nNew event has been added.");

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void editEventLabel(){
        int id = getEventByID().getId();

        System.out.println("\nDo you wish to edit this data Y/N");
        String option = scanner.next().trim();
        if (option.equals("Y")) {


            System.out.println("Enter edited label");
            String update = scanner.next().trim();
            System.out.println("");


            try {

                ps = DbConnection.user().prepareStatement("UPDATE events SET label = '" + update + "' WHERE id =" + id);
                ps.execute();


                System.out.println("successfully updated");
                System.out.println("");


            } catch (Exception e) {
                e.printStackTrace();

            }


        } else {
            System.out.println("Event remains unchanged");
        }

    }

    public static void editEventDate(){
        int id = getEventByID().getId();

        System.out.println("\nDo you wish to edit this data Y/N");
        String option = scanner.next().trim();
        if (option.equals("Y")) {


            System.out.println("Enter edited date(format dd.mm.yyyy):");

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

    }

    //Cannot scan sentence....
    public static void editEventDescription(){
        int id = getEventByID().getId();

        System.out.println("\nDo you wish to edit this data Y/N");
        String option = scanner.next().trim();
        if (option.equals("Y")) {


            System.out.println("Enter edited activity");
            String update = scanner.next();



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

    }

    public static void deleteEvent(){
        System.out.println("\nEnter the events date(format dd.mm.yyyy): ");
        String date = scanner.next().trim();
        System.out.println("\nEnter the event: ");
        String label = scanner.next().trim();

            try {

                ps = DbConnection.user().prepareStatement("DELETE FROM events WHERE event_date ='" + date +"' AND event = '" + label +"'");
                ps.execute();

                System.out.println("successfully removed to database");


            } catch (Exception e) {
                e.printStackTrace();
            }



    }

    public static void selectEventByDate(){
        System.out.println("\nEnter the events date(format dd.mm.yyyy): ");
        String date = scanner.next().trim();


        try {
            ps = DbConnection.user().prepareStatement("SELECT * FROM events WHERE event_date = '" + date +"'");
            rs = ps.executeQuery();

            System.out.println("date \t  event \t description");


            while (rs.next()) {

                System.out.println(rs.getString("event_date") + " \t " +
                        rs.getString("label") + " \t " + rs.getString("description"));
                System.out.println("");

            }

        }


        catch (SQLException throwables) {
            throwables.printStackTrace();

        }

    }

    public static void selectEventByYear(){
        System.out.println("\nEnter the year ");
        String date = scanner.next().trim();


        try {
            ps = DbConnection.user().prepareStatement("SELECT * FROM events WHERE event_date LIKE '%." + date +"'");
            rs = ps.executeQuery();

            System.out.println("date \t  event \t description");


            while (rs.next()) {

                System.out.println(rs.getString("event_date") + " \t " +
                        rs.getString("label") + " \t " + rs.getString("description"));
                System.out.println("");

            }

        }


        catch (SQLException throwables) {
            throwables.printStackTrace();

        }

    }

    public static void selectEventByMonth(){
        System.out.println("\nEnter the month ");
        String date = scanner.next().trim();


        try {
            ps = DbConnection.user().prepareStatement("SELECT * FROM events WHERE event_date LIKE '%." + date +".%'");
            rs = ps.executeQuery();

            System.out.println("date \t  event \t description");


            while (rs.next()) {

                System.out.println(rs.getString("event_date") + " \t " +
                        rs.getString("label") + " \t " + rs.getString("description"));

            }

        }


        catch (SQLException throwables) {
            throwables.printStackTrace();

        }

    }

    public static void selectEventByLabel(){
        System.out.println("\nEnter the event: ");
        String label = scanner.next().trim();


        try {
            ps = DbConnection.user().prepareStatement("SELECT * FROM events WHERE label ='" + label +"'");
            rs = ps.executeQuery();

            System.out.println("date \t  event \t description");

            while (rs.next()) {

                System.out.println(rs.getString("event_date") + " \t " +
                        rs.getString("label") + " \t " + rs.getString("description"));


            }

        }


        catch (SQLException throwables) {
            throwables.printStackTrace();

        }

    }

    public static Objects getEventByID() {
        System.out.println("\nEnter the events id: ");
        int id = scanner.nextInt();


        try {
            ps = DbConnection.user().prepareStatement("SELECT * FROM events WHERE id =" + id);
            rs = ps.executeQuery();

            System.out.println("id \t date \t  event \t description");
            int eventID;
            Objects event = new Objects();
            while (rs.next()) {
                eventID = rs.getInt("id");

                System.out.println( eventID + " \t " + rs.getString("event_date") + " \t " +
                        rs.getString("label") + " \t " + rs.getString("description"));
                event.setId(eventID);

            }

            return event;


        }


        catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

    }
}
