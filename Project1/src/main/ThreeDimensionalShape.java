package main;

/**
 * DATE: March 14, 2025
 * AUTHOR: Raymond Rowland
 * PURPOSE: This class represents a ThreeDimensionalShape, which is an abstract base class for all 3D shapes.
 *          It includes a method to calculate the volume of the shape.
 * FILE: ThreeDimensionalShape.java
 */

public abstract class ThreeDimensionalShape extends Shape {
    public ThreeDimensionalShape() {
        super(3);
    }

    public abstract float calculateVolume();
}
