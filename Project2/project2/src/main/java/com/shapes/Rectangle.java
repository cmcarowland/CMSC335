package com.shapes;

/**
 * DATE: March 14, 2025
 * AUTHOR: Raymond Rowland
 * PURPOSE: This class represents a Rectangle, which is a type of TwoDimensionalShape.
 *          It includes methods to set the height and width of the rectangle, and to calculate its area.
 * FILE: Rectangle.java
 */

public class Rectangle extends TwoDimensionalShape {
    protected float height;
    protected float width;
  
    public Rectangle() {
        super();
    }

    @Override
    public void calculate() {
        area = height * width;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(shapeData);
        sb.append("    -Height: %.2f\n");
        sb.append("    -Width : %.2f\n");
        sb.append("    -Area  : %.2f\n");
        return String.format(sb.toString(), this.getClass().getSimpleName(), width, height, area);
    }

    public void setHeight(float side) {
        if (isMeasurementValid(side)) {
            this.height = side;
            System.out.println("The height of the " + getClass().getSimpleName() + " has been set to " + height);
        } else {
            throw new IllegalArgumentException("Invalid side length");
        }
    }

    public float getHeight() {
        return height;
    }

    public void setWidth(float side) {
        if (isMeasurementValid(side)) {
            this.width = side;
            System.out.println("The width of the " + getClass().getSimpleName() + " has been set to " + width);
        } else {
            throw new IllegalArgumentException("Invalid side length");
        }
    }

    public float getWidth() {
        return width;
    }   
}
