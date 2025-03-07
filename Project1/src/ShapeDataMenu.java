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
        try{
            if (shape instanceof Circle) {
                ((Circle)shape).setRadius(radius);
            } else if (shape instanceof Sphere) {
                ((Sphere)shape).setRadius(radius);
            } else if (shape instanceof Cone) {
                ((Cone)shape).setRadius(radius);
            } 
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    private void getHeight() {
        System.out.println("Enter the height :");
        float height = parseUserFloat();
        
        try{
            if (shape instanceof Square) {
                ((Square)shape).setSides(height);
            } else if (shape instanceof Rectangle) {
                ((Rectangle)shape).setHeight(height);
            } else if (shape instanceof Triangle) {
                ((Triangle)shape).setHeight(height);
            } else if (shape instanceof Cube) {
                ((Cube)shape).setSide(height);
            } else if (shape instanceof Cone) {
                ((Cone)shape).setHeight(height);
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    private void getWidth() {
        System.out.println("Enter the Width :");
        float width = parseUserFloat();
        try{
            if (shape instanceof Rectangle) {
                ((Rectangle)shape).setWidth(width);
            } 
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
    
    private void getBase() {
        System.out.println("Enter the Base :");
        float base = parseUserFloat();
        try{
            if (shape instanceof Triangle) {
                ((Triangle)shape).setBase(base);
            } 
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
