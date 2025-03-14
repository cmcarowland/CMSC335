package main;

/**
 * DATE: March 14, 2025
 * AUTHOR: Raymond Rowland
 * PURPOSE: This class represents the Shape Data Menu of the Java OO Shape Tool application.
 *          It includes methods to display the menu, validate user input, and collect data for shape construction.
 * FILE: ShapeDataMenu.java
 */

public class ShapeDataMenu extends Menu {
    private Shape shape;
    private int questions;

    public ShapeDataMenu(Menu parent, Shape shape, int questions) {
        this.parentMenu = parent;
        this.shape = shape;
        this.questions = questions;
    }

    public int getQuestions() {
        return questions;
    }

    @Override
    public boolean validateUserInput(int userInput) {
        return true;
    }

    @Override
    public Menu run() {
        boolean success = true;
        System.out.println("\nYou are creating a " + shape.getClass().getSimpleName() + ".\nPlease enter the following information\n");
        if ((questions & 1) > 0) {
            success = getRadius();
        }
        if ((questions & 2) > 0 && success) {
            success = getHeight();
        }
        if ((questions & 4) > 0 && success) {
            success = getWidth();
        }
        if ((questions & 8) > 0 && success) {
            success = getBase();
        }
        if ((questions & 16) > 0 && success) {
            success = getRadius("Major");
            success = getRadius("Minor");
        }

        if(success) {
            System.out.println(shape.getClass().getSimpleName() + " has been created with the following data:");
            System.out.println(shape.toString());
        } else {
            System.err.println("Error Creating " + shape.getClass().getSimpleName() + ".\nPlease try again.\n");
        }
        
        return parentMenu;
    }
    
    private boolean getRadius() {
        System.out.println("Enter the radius : ");
        float radius = parseUserFloat();
        try{
            if (shape instanceof Circle) {
                ((Circle)shape).setRadius(radius);
            } else if (shape instanceof Sphere) {
                ((Sphere)shape).setRadius(radius);
            } else if (shape instanceof Cone) {
                ((Cone)shape).setRadius(radius);
            } else if (shape instanceof Cylinder) {
                ((Cylinder)shape).setRadius(radius);
            } 
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return false;
        }

        return true;
    }

    private boolean getRadius(String radiusType) {
        System.out.printf("Enter the %s radius : ", radiusType);
        float radius = parseUserFloat();
        try{
            Torus t = (Torus)shape;
            if (radiusType.equals("Major")) {
                t.setMajorRadius(radius);
            } else if (radiusType.equals("Minor")) {
                if (t.getMajorRadius() < radius) {
                    throw new IllegalArgumentException("Minor radius must be less than Major radius");
                }
                t.setMinorRadius(radius);
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return false;
        }

        return true;
    }

    private boolean getHeight() {
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
            } else if (shape instanceof Cylinder) {
                ((Cylinder)shape).setHeight(height);
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return false;
        }

        return true;
    }

    private boolean getWidth() {
        System.out.println("Enter the Width :");
        float width = parseUserFloat();
        try{
            if (shape instanceof Rectangle) {
                ((Rectangle)shape).setWidth(width);
            } 
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return false;
        }

        return true;
    }
    
    private boolean getBase() {
        System.out.println("Enter the Base :");
        float base = parseUserFloat();
        try{
            if (shape instanceof Triangle) {
                ((Triangle)shape).setBase(base);
            } 
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return false;
        }

        return true;
    }
}
