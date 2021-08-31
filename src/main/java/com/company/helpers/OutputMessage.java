package com.company.helpers;
//please add frenquently used messages here as methods, like "Redirecting..." and others.
public class OutputMessage {

    //User logout message in Main menu case X
    public static void logout(){
        System.out.println("End of session. User logout.");
    }


//Message for case X in subMenu and Controllers
    public static void redirecting(){
        System.out.println("Redirecting to main menu\n");
    }

//Message for invalid choice, looping method
    public static void invalidInput(){
        System.out.println("Invalid input. Try again\n");
    }
}

