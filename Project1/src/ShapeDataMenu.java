public class ShapeDataMenu extends Menu {
    private Shape shape;
    private int questions;

    public ShapeDataMenu(Menu parent, Shape shape, int questions) {
        this.parentMenu = parent;
        this.shape = shape;
        this.questions = questions;
    }

    @Override
    public boolean validateUserInput(int userInput) {
        return true;
    }

    @Override
    public Menu run() {
        if ((questions & 1) > 0) {
            getRadius();
        }
        if ((questions & 2) > 0) {
            getHeight();
        }
        if ((questions & 4) > 0) {
            getWidth();
        }
        if ((questions & 8) > 0) {
            getBase();
        }

        System.out.println(shape.getClass().getSimpleName() + " has been created with the following data:");
        System.out.println(shape.toString());
        return parentMenu;
    }
    
    private void getRadius() {
        System.out.println("Enter the radius : ");
        float radius = parseUserFloat();
        
        if (shape instanceof Circle) {
            try{
                ((Circle)shape).setRadius(radius);
                System.out.println("The radius of the Circle has been set to " + radius);
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private void getHeight() {
        System.out.println("Enter the Height :");
        float height = parseUserFloat();
        
        try{
            if (shape instanceof Square) {
                ((Square)shape).setSides(height);
                System.out.println("Both sides of the Square have been set to " + height);
            } else if (shape instanceof Rectangle) {
                ((Rectangle)shape).setHeight(height);
                System.out.println("The height of the Rectangle has been set to " + height);
            } else if (shape instanceof Triangle) {
                ((Triangle)shape).setHeight(height);
                System.out.println("The height of the Triangle has been set to " + height);
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    private void getWidth() {
        System.out.println("Enter the Width :");
        float width = parseUserFloat();
        
        if (shape instanceof Rectangle) {
            try{
                ((Rectangle)shape).setWidth(width);
                System.out.println("The width of the Rectangle has been set to " + width);
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        } 
    }
    
    private void getBase() {
        System.out.println("Enter the Base :");
        float base = parseUserFloat();
        
        if (shape instanceof Triangle) {
            try{
                ((Triangle)shape).setBase(base);
                System.out.println("The base of the Triangle has been set to " + base);
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        } 
    }
}
