package com.shapes;

/**
 * DATE: April 1, 2025
 * AUTHOR: Raymond Rowland
 * PURPOSE: This file defines the Cube class, which represents a three-dimensional cube shape.
 * FILE: Cube.java
 */

public class Cube extends ThreeDimensionalShape implements ISides {
    private float side;

    public Cube() {
        super();
        side = 0;
    }

    @Override
    public void setSides(float side) {
        if(isMeasurementValid(side)) {
            this.side = side;
            System.out.println("All sides of the Cube have been set to " + side);
        } else {
            throw new IllegalArgumentException("Invalid side");
        }
    }

    public float getSide() {
        return side;
    }

    @Override
    public void calculate() {
        volume = (float) Math.pow(side, 3);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(shapeData);
        sb.append("    -Side   : %.2f\n");
        sb.append("    -Volume : %.2f\n");
        return String.format(sb.toString(), this.getClass().getSimpleName(), side, volume);
    }

    @Override
    public void setHeight(float h) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setHeight'");
    }
}
