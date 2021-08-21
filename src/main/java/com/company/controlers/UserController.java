package com.company.controlers;
///THIS IS COPY FROM OTHER PROJECT, NEEDS TO BE UPDATED

import com.company.dbhelper.DbConnection;
import com.company.objects.Objects;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserController {
    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;
    //since users are automatically generated we don't need user add option
    //also it's deleting on cascade with person(employee ar student),there will be no delete option


    public static void editUserPassword(){//not sure that that correct way
        int id = getUserByID().getId();

        System.out.println("\nDo you wish to edit this data Y/N");
        String option = scanner.next().trim();
        if (option.equals("Y")) {


            System.out.println("Enter new password: ");
            String password1 = scanner.next().trim();
            System.out.println("");

            System.out.println("Retype new password: ");
            String password2 = scanner.next().trim();
            System.out.println("");

            //check if user is able to type password twice correctly
            if(password1.equals(password2)){
                try {
                    ps = DbConnection.user().prepareStatement("UPDATE users SET password = '" + password1 + "' WHERE id =" + id);
                    ps.execute();


                    System.out.println("successfully updated");
                    System.out.println("");

                } catch (Exception e) {
                    e.printStackTrace();

                }
            } else {
                System.out.println("Password doesn't match");
                //some action here
            }



        } else {
            System.out.println("Users data remains unchanged");
        }

    }

    public static Objects getUserByID() {
        System.out.println("\nEnter the user's id: ");
        int id = scanner.nextInt();
        System.out.println("");

        try {
            ps = DbConnection.user().prepareStatement("SELECT * FROM employees WHERE id =" + id);
            rs = ps.executeQuery();

            System.out.println("id \t  username  \t access \t password");//password field must be deleted on last stage of project

            int userID;

            Objects user = new Objects();
            while (rs.next()) {
                userID = rs.getInt("id");
                ;

                System.out.println(userID + " \t " + rs.getString("username") + " \t " + rs.getString("access") + " \t " + rs.getString("password"));
                System.out.println("");

            }
            return user;


        }


        catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

    }

}//end of class
