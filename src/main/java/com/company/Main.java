package com.company;


import com.company.controlers.*;
import com.company.dbhelper.DbConnection;
import com.company.login.Login;
import com.company.menu.Menu;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static void main(String[] args) {
        //Test
        EmployeesController.getLecturerByStudentGroup();


//END OF TEST
    }

}
