package main;

/**
 * DATE: March 14, 2025
 * AUTHOR: Raymond Rowland
 * PURPOSE: This class represents a Shape, which is an abstract base class for all shapes.
 *          It includes methods to get the number of dimensions and to validate measurements.
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