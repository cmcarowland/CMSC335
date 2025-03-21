package main;

/**
 * DATE: March 14, 2025
 * AUTHOR: Raymond Rowland
 * PURPOSE: This class represents a Triangle, which is a type of TwoDimensionalShape.
 *          It includes methods to set the base and height of the triangle, and to calculate its area.
 * FILE: Triangle.java
 */

public class Triangle extends TwoDimensionalShape implements IHeight {
    private float base;
    private float height;

    public Triangle() {
        super();
        this.base = 0;
        this.height = 0;
    }

    @Override
    public void calculate() {
        area = (base * height) / 2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(shapeData);
        sb.append("    -Base  : %.2f\n");
        sb.append("    -Height: %.2f\n");
        sb.append("    -Area  : %.2f\n");
        return String.format(sb.toString(), this.getClass().getSimpleName(), base, height, area);
    }

    public void setBase(float base) {
        if (isMeasurementValid(base)) {
            this.base = base;
            System.out.println("The base of the Triangle has been set to " + base);
        } else {
            throw new IllegalArgumentException("Invalid base length");
        }
    }

    public void setHeight(float height) {
        if (isMeasurementValid(height)) {
            this.height = height;
            System.out.println("The height of the Triangle has been set to " + height);
        } else {
            throw new IllegalArgumentException("Invalid height length");
        }
    }
}
