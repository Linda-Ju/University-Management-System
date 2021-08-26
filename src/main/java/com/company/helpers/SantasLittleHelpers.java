package com.company.helpers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class SantasLittleHelpers {

    public static String subjectCases(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a subject");
        System.out.println("1. Mathematics");
        System.out.println("2. Physics");
        System.out.println("3. Chemistry");
        System.out.println("4. History");
        System.out.println("5. English");
        System.out.println("6. Spanish");

        System.out.print("Select an option: ");
        int subject = scanner.nextInt();
        String subjectName = "";

        switch (subject) {
            case 1:
                subjectName = "Mathematics";
                break;
            case 2:
                subjectName = "Physics";
                break;
            case 3:
                subjectName = "Chemistry";
                break;
            case 4:
                subjectName = "History";
                break;
            case 5:
                subjectName = "English";
                break;
            case 6:
                subjectName = "Spanish";
                break;
            default:
                subjectName = null;
                System.out.println("Invalid input, try again!");
        }

        return subjectName;
    }


    public static String dateFormat() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(date);
    }

    public static String getRandomNumberString() {
        //Password generator
        // It will generate 6 digit random Number.
        // from 0 to 999999
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        // this will convert any number sequence into 6 character.
        return String.format("%06d", number);
    }
}
