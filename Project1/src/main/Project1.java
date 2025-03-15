package main;

/**
 * DATE: March 14, 2025
 * AUTHOR: Raymond Rowland
 * PURPOSE: This class represents the main entry point for the Java OO Shape Tool application.
 *          It includes the main method to run the application and a method to create a formatted date string.
 * FILE: Project1.java
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Project1 {
    private Menu currentMenu;
    
    public Project1() {
        MainMenu mainMenu = new MainMenu();
        currentMenu = mainMenu;
    }

    public static void main(String[] args) {
        Project1 project1 = new Project1();
        project1.run();
    }

    private void run() {
        MainMenu mainMenu = new MainMenu();
        currentMenu = mainMenu;
        while(currentMenu != null) {
            currentMenu = currentMenu.run();
        }

        System.out.println("\n\nThank you for using the Java OO Shape Tool.");
        System.out.println(createDateString());
    }

    public static String createDateString() {
        var localDateTime = LocalDateTime.now();
        StringBuilder sb = new StringBuilder();
        sb.append("Today is ");
        sb.append(localDateTime.format(DateTimeFormatter.ofPattern("MMM dd")));
        sb.append(" at ");
        sb.append(localDateTime.format(DateTimeFormatter.ofPattern("HH:mm a")));
        return sb.toString();
    }
}