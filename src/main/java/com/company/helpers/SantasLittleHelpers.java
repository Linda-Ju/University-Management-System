package com.company.helpers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class SantasLittleHelpers {
    static Scanner scanner = new Scanner(System.in);

    public static String subjectCases() {


        System.out.println("Choose a subject: ");
        System.out.println("1. Mathematics");
        System.out.println("2. Physics");
        System.out.println("3. Chemistry");
        System.out.println("4. History");
        System.out.println("5. English");
        System.out.println("6. Spanish");
        System.out.println("X. Quit");

        System.out.print("\nSelect an option: \t");
        String subject = scanner.next().toUpperCase();
        String subjectName;

        switch (subject) {
            case "1":
                subjectName = "Mathematics";
                break;
            case "2":
                subjectName = "Physics";
                break;
            case "3":
                subjectName = "Chemistry";
                break;
            case "4":
                subjectName = "History";
                break;
            case "5":
                subjectName = "English";
                break;
            case "6":
                subjectName = "Spanish";
                break;
            case "X":
                subjectName = null;
                OutputMessage.redirecting();
                break;
            default:
                subjectName = null;
                OutputMessage.invalidInput();
                subjectCases();
        }
        return subjectName;
    }

    public static String facultyCases() {

        System.out.println("\nSelect a faculty: ");
        System.out.println("1. Communication Technology");
        System.out.println("2. Geoinformatics");
        System.out.println("3. Economics");

        System.out.print("\nSelect an option: \t");
        String faculty = scanner.next().toUpperCase();
        String facultyName;

        switch (faculty) {
            case "1":
                facultyName = "Communication Technology";
                break;
            case "2":
                facultyName = "Geoinformatics";
                break;
            case "3":
                facultyName = "Economics";
                break;
            case "X":
                facultyName = null;
                OutputMessage.redirecting();
                break;
            default:
                facultyName = null;
                OutputMessage.invalidInput();
                subjectCases();
        }
        return facultyName;
    }

    public static String dateFormat() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
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
