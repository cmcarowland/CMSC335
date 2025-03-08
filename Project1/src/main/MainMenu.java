package main;

public class MainMenu extends Menu {

    public MainMenu() {
        super();
        menuName = "Main Menu";
    }

    public MainMenu(Menu parent) {
        parentMenu = parent;
        menuName = "Main Menu";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nWelcome to the Java OO Shape Tool\n");
        sb.append("-----------------------------------\n");
        sb.append("Please select a shape type:\n");        

        sb.append("1) 2D Shapes\n");
        sb.append("2) 3D Shapes\n");
        sb.append("0) Exit the program\n");

        return sb.toString();
    }

    public boolean validateUserInput(int userInput) {
        return userInput >= 0 && userInput <= 2;
    }

    @Override
    public Menu run()  {
        System.out.println(toString());
        var userInput = parseUserInt();
        if(!validateUserInput(userInput)) {
            System.err.println("Invalid input. Please select an appropriate option.");
        }

        switch(userInput) {
            case 1:
                return new TwoDShapeMenu(this);
            case 2:
                return new ThreeDShapeMenu(this);
            case 0:
                return null;
            default:
                return this;
        }
    }
}
