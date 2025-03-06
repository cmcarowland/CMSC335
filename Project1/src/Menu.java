public abstract class Menu {
    public Menu parentMenu;
    protected String menuName;

    public Menu() {
        this.parentMenu = null;
    }

    public abstract boolean validateUserInput(int userInput);
    
    public abstract Menu run();

    public static int parseUserInt() {
        System.out.print(">> ");
        while (true) {
            String input = Project1.scanner.nextLine();
            try {
                int intNum = Integer.parseInt(input);
                return intNum;
            } catch (NumberFormatException e) {
                System.err.print("Invalid string format. Cannot convert to integer.\n>>");
            }
        }
    }
}
