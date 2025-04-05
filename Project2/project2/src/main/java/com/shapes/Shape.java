package com.shapes;
/**
 * DATE: April 1, 2025
 * AUTHOR: Raymond Rowland
 * PURPOSE: This file defines the abstract Shape class, which serves as a base for all shape types.
 * FILE: Shape.java
 */

public abstract class Shape {
    private int numberOfDimensions;
    protected String shapeData = "  -Type: %s\n";

    public Shape(int dimensions) {
        numberOfDimensions = dimensions;
    }

    public int getNumberOfDimensions() {
        return numberOfDimensions;
    }

    public boolean isMeasurementValid(float measurement) {
        return measurement > 0;
    }

    public abstract void calculate();
}