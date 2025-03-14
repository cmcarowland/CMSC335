package main;

/**
 * DATE: March 14, 2025
 * AUTHOR: Raymond Rowland
 * PURPOSE: This class represents a TwoDimensionalShape, which is an abstract base class for all 2D shapes.
 *          It includes a method to calculate the area of the shape.
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
