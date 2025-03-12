package main;

import java.util.Scanner;

public abstract class Menu {
    protected static Scanner scanner;
    public Menu parentMenu;
    protected String menuName;

    public Menu() {
        this.parentMenu = null;
        scanner = new Scanner(System.in);
    }

    public abstract boolean validateUserInput(int userInput);
    
    public abstract Menu run();

    public static int parseUserInt() {
        System.out.print(">> ");
        while (true) {
            String input = scanner.nextLine();
            try {
                int intNum = Integer.parseInt(input);
                return intNum;
            } catch (NumberFormatException e) {
                System.err.print("Invalid string format. Cannot convert to integer.\n>> ");
            }
        }
    }
    
    public static Float parseUserFloat() {
        System.out.print(">> ");
        while (true) {
            String input = scanner.nextLine();
            try {
                Float intNum = Float.parseFloat(input);
                return intNum;
            } catch (NumberFormatException e) {
                System.err.print("Invalid string format. Cannot convert to float.\n>> ");
            }
        }
    }
}
