package main;

/**
 * DATE: March 14, 2025
 * AUTHOR: Raymond Rowland
 * PURPOSE: This class represents a Square, which is a type of Rectangle.
 *          It includes methods to set the sides of the square and to provide a string representation of the square.
 * FILE: Square.java
 */

public class Square extends Rectangle implements ISides {
    @Override
    public void setHeight(float side) {
        try{
            setSides(side);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public void setSides(float side) {
        try {
            super.setHeight(side);
            super.setWidth(side);
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
