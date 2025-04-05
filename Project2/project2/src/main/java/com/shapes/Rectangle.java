package com.shapes;
/**
 * DATE: April 1, 2025
 * AUTHOR: Raymond Rowland
 * PURPOSE: This file defines the Rectangle class, which represents a two-dimensional rectangle shape.
 * FILE: Rectangle.java
 */

public class Rectangle extends TwoDimensionalShape implements IHeight {
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
        return String.format(sb.toString(), this.getClass().getSimpleName(), height, width, area);
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
