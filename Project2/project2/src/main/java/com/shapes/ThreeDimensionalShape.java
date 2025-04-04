package com.shapes;
/**
 * DATE: April 1, 2025
 * AUTHOR: Raymond Rowland
 * PURPOSE: This file defines an abstract class for three-dimensional shapes.
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
