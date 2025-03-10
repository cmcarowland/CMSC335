package main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Project1 {
    static Menu currentMenu;
    
    public static void main(String[] args) {
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