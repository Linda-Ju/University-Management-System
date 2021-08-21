package com.company.Tables;

import com.company.dbhelper.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Tables {
    private static PreparedStatement ps;
    private static ResultSet rs;
    /*

    ++++USERS+++
    CREATE TABLE users (
	id INT auto_increment NOT NULL,
	username varchar(20) NOT NULL,
	password varchar(10) NOT NULL,
	access varchar(20) NOT NULL,
	PRIMARY KEY (id));
	*/
     public static void getUsersTable() {

         try {
             ps = DbConnection.user().prepareStatement("SELECT * FROM users");
             rs = ps.executeQuery();
             System.out.println("");

             System.out.println("ID \t  Login  \t  Password \t  Access");

             int usersID;
             String login, password, access;


             while (rs.next()) {

                 usersID = rs.getInt("id");
                 login = rs.getString("username");
                 password = rs.getString("password");
                 access = rs.getString("access");


                 System.out.println(usersID + " \t " + login + " \t " + password + " \t " + access);
                 System.out.println("");
             }
         } catch (SQLException throwables) {
             throwables.printStackTrace();
         }
     }
/*
    ++++STUDENTS++++
CREATE TABLE mit_database.students (
	id INT auto_increment NOT NULL,
	name varchar(20) NOT NULL,
	surname varchar(50) NOT NULL,
	user_id INT NOT NULL,
	faculty varchar(100) NULL,
	`group` varchar(100) NULL,
	CONSTRAINT students_PK PRIMARY KEY (id),
	CONSTRAINT students_FK FOREIGN KEY (user_id) REFERENCES mit_database.users(id) ON UPDATE CASCADE
)
*/
 
/*
    ++++EMPLOYEES+++
    CREATE TABLE mit_database.students (
	id INT auto_increment NOT NULL,
	first_name varchar(20) NOT NULL,
	last_name varchar(50) NOT NULL,
	position varchar(50) NOT NULL,
	user_id INT NOT NULL,
	CONSTRAINT students_PK PRIMARY KEY (id),
	CONSTRAINT students_FK FOREIGN KEY (user_id) REFERENCES mit_database.users(id) ON UPDATE CASCADE
)
 */

    /*
    ++++SCORES++++
    CREATE TABLE mit_database.scores (
	subject varchar(100) NOT NULL,
	lectors_id INT NOT NULL,
	student_id INT NOT NULL,
	score INT NULL,
	CONSTRAINT scores_PK PRIMARY KEY (subject,lectors_id,student_id,
	CONSTRAINT scores_FK FOREIGN KEY (student_id) REFERENCES mit_database.students(id) ON UPDATE CASCADE;
    CONSTRAINT scores_FK_1 FOREIGN KEY (lectors_id) REFERENCES mit_database.employees(id) ON UPDATE CASCADE;
)
     */

    /*
    CREATE TABLE mit_database.Events (
	event_date varchar(50) NULL,
	event varchar(100) NOT NULL,
	description varchar(300) NULL
)
     */
}
