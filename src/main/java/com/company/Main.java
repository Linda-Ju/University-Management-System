package com.company;



import com.company.controlers.StudentsController;
import com.company.login.Login;


public class Main {
   
public static void main(String[] args){


int personID = StudentsController.getStudentByID();
    System.out.println(personID);



    }

}
