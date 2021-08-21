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



    public static void deleteEvent(){
        System.out.println("\nEnter the events date(format dd.mm.yyyy): ");
        String date = scanner.next().trim();
        System.out.println("\nEnter the event: ");
        String label = scanner.next().trim();

            try {

                ps = DbConnection.user().prepareStatement("DELETE FROM events WHERE event_date ='" + date +"' AND event = '" + label +"'");
                ps.execute();

                System.out.println("successfully removed to database");
                System.out.println("");


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
                System.out.println("");

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
                System.out.println("");

            }

        }


        catch (SQLException throwables) {
            throwables.printStackTrace();

        }

    }

    public static Objects getEventByID() {
        System.out.println("\nEnter the events id: ");
        int id = scanner.nextInt();
        System.out.println("");

        try {
            ps = DbConnection.user().prepareStatement("SELECT * FROM events WHERE id =" + id);
            rs = ps.executeQuery();

            System.out.println("date \t  event \t description");
            int eventID;
            Objects event = new Objects();
            while (rs.next()) {
                eventID = rs.getInt("id");

                System.out.println( eventID + " \t " + rs.getString("event_date") + " \t " +
                        rs.getString("label") + " \t " + rs.getString("description"));
                System.out.println("");
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
