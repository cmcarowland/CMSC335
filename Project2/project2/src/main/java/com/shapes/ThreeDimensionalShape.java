package com.shapes;

/**
 * DATE: March 14, 2025
 * AUTHOR: Raymond Rowland
 * PURPOSE: This class represents a ThreeDimensionalShape, which is an abstract base class for all 3D shapes.
 *          It includes a method to calculate the volume of the shape.
 * FILE: ThreeDimensionalShape.java
 */

public abstract class ThreeDimensionalShape extends Shape {
    protected float volume;

    public ThreeDimensionalShape() {
        super(3);
    }

    public abstract void calculate();
    public float getVolume() {
        return volume;
    }
}
