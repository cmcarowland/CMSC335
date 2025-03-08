package main;

public class TwoDShapeMenu extends Menu {     

    public TwoDShapeMenu() {
        super();
        menuName = "2D Shape Menu";
    }

    public TwoDShapeMenu(Menu parent) {
        parentMenu = parent;
        menuName = "2D Shape Menu";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n" + menuName + "\n");
        sb.append("---------------------\n");
        sb.append("1) Construct a Circle\n");
        sb.append("2) Construct a Rectangle\n");
        sb.append("3) Construct a Square\n");
        sb.append("4) Construct a Triangle\n");
        sb.append("0) Return to Main\n");
        return sb.toString();
    }

    public boolean validateUserInput(int userInput) {
        return userInput >= 0 && userInput <= 4;
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
                return new ShapeDataMenu(this, new Circle(), Questions.Radius.getStatusFlagValue());
            case 2:
                return new ShapeDataMenu(this, new Rectangle(), Questions.Height.getStatusFlagValue() | Questions.Width.getStatusFlagValue());
            case 3:
                return new ShapeDataMenu(this, new Square(), Questions.Height.getStatusFlagValue());
            case 4:
                return new ShapeDataMenu(this, new Triangle(), Questions.Base.getStatusFlagValue() | Questions.Height.getStatusFlagValue());
            case 0:
                return parentMenu;
            default:
                return this;
        }
    }
}
