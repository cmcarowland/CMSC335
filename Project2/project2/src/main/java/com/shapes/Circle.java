package com.shapes;
/**
 * DATE: April 1, 2025
 * AUTHOR: Raymond Rowland
 * PURPOSE: This file defines the Circle class, which represents a two-dimensional 
 *          circular shape. It includes methods for setting and validating the radius, 
 *          calculating the area, and generating a string representation of the circle.
 * FILE: Circle.java
 */

public class Circle extends TwoDimensionalShape implements IRadius{
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
        return String.format(sb.toString(), this.getClass().getSimpleName(), radius, area);
    }

    public void calculate() {
        area = (float)(Math.PI * Math.pow(radius, 2));
    }
    
    public void setRadius(float r) {
        if(isMeasurementValid(r)) {
            radius = r;
            System.out.println("The radius of the Circle has been set to " + radius);
        } else {
            throw new IllegalArgumentException("Invalid radius");
        }
    }

    public float getRadius() {
        return radius;
    }
}
