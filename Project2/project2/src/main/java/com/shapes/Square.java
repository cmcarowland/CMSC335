package com.shapes;
/**
 * DATE: April 1, 2025
 * AUTHOR: Raymond Rowland
 * PURPOSE: This class represents a Square, which is a specific type of Rectangle
 *          where all sides are of equal length. It provides functionality to set
 *          the sides of the square and overrides the toString method to display
 *          square-specific details.
 * FILE: Square.java
 */


public class Square extends Rectangle implements ISides {
    public void setSides(float side) {
        try {
            setHeight(side);
            setWidth(side);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(shapeData);
        sb.append("    -Sides : %.2f\n");
        sb.append("    -Area  : %.2f\n");
        return String.format(sb.toString(), this.getClass().getSimpleName(), width, area);
    }
}
