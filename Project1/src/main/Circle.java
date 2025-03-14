package main;

/**
 * DATE: March 14, 2025
 * AUTHOR: Raymond Rowland
 * PURPOSE: This class represents a Circle, which is a type of TwoDimensionalShape.
 *          It includes methods to calculate the area of the circle and to set its radius.
 * FILE: Circle.java
 */

public class Circle extends TwoDimensionalShape {
    private float radius;

    public Circle() {
        super();
        this.radius = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(shapeData);
        sb.append("    -Radius: %.2f\n");
        sb.append("    -Area  : %.2f\n");
        return String.format(sb.toString(), this.getClass().getSimpleName(), radius, calculateArea());
    }

    public float calculateArea() {
        return (float)(Math.PI * Math.pow(radius, 2));
    }
    
    public void setRadius(float r) {
        if(isMeasurementValid(r)) {
            radius = r;
            System.out.println("The radius of the Circle has been set to " + radius);
        } else {
            throw new IllegalArgumentException("Invalid radius");
        }
    }
}
