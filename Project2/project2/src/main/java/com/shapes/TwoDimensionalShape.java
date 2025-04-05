package com.shapes;
/**
 * DATE: April 1, 2025
 * AUTHOR: Raymond Rowland
 * PURPOSE: This file defines an abstract class for two-dimensional shapes.
 * FILE: TwoDimensionalShape.java
 */

public abstract class TwoDimensionalShape extends Shape {
    protected float area;

    public TwoDimensionalShape() {
        super(2);
    }
    
    public abstract void calculate();
    public float getArea() {
        return area;
    }
}
