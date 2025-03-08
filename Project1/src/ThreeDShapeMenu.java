public class ThreeDShapeMenu extends Menu {

    public ThreeDShapeMenu() {
        super();
        menuName = "3D Shape Menu";
    }

    public ThreeDShapeMenu(Menu parent) {
        parentMenu = parent;
        menuName = "3D Shape Menu";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n" + menuName + "\n");
        sb.append("---------------------\n");
        sb.append("1) Construct a Sphere\n");
        sb.append("2) Construct a Cube\n");
        sb.append("3) Construct a Cone\n");
        sb.append("4) Construct a Cylinder\n");
        sb.append("5) Construct a Torus\n");
        sb.append("0) Return to main\n");
        return sb.toString();
    }

    public boolean validateUserInput(int userInput) {
        return userInput >= 0 && userInput <= 5;
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
                return new ShapeDataMenu(this, new Sphere(), Questions.Radius.getStatusFlagValue());
            case 2:
                return new ShapeDataMenu(this, new Cube(), Questions.Height.getStatusFlagValue());
            case 3:
                return new ShapeDataMenu(this, new Cone(), Questions.Radius.getStatusFlagValue() | Questions.Height.getStatusFlagValue());
            case 4:
                return new ShapeDataMenu(this, new Cylinder(), Questions.Radius.getStatusFlagValue() | Questions.Height.getStatusFlagValue());
            case 5:
                return new ShapeDataMenu(this, new Torus(), Questions.MajorMinorRadius.getStatusFlagValue());
            case 0:
                return parentMenu;
            default:
                return this;
        }
    }
}
