import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Project1 {

    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        while(true) {
            printMainMenu();
            var userInput = parseUserInt();
            System.out.println(userInput);
            if(userInput == 0) {
                break;
            }
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

    public static void printMainMenu() {
        System.out.println("\nWelcome to the Java OO Shape Tool");
        System.out.println("-----------------------------------");
        System.out.println("Please select a shape:");
        System.out.println("1. Construct a Circle");
        System.out.println("2. Construct a Rectangle");
        System.out.println("3. Construct a Square");
        System.out.println("4. Construct a Triangle");
        System.out.println("5. Construct a Sphere");
        System.out.println("6. Construct a Cube");
        System.out.println("7. Construct a Cone");
        System.out.println("8. Construct a Cylinder");
        System.out.println("9. Construct a Torus");
        System.out.println("0. Exit the program");
    }

    public static int parseUserInt() {
        while (true) {
            String input = scanner.nextLine();
            try {
                int intNum = Integer.parseInt(input);
                return intNum;
            } catch (NumberFormatException e) {
                System.err.println("Invalid string format. Cannot convert to integer.");
            }
        }
    }
}