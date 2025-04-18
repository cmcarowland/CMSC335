package main;

/**
 * FILE: Cube.java
 * DATE: March 14, 2025
 * AUTHOR: Raymond Rowland
 * 
 * PURPOSE:
 * This class represents a Cube, which is a type of ThreeDimensionalShape.
 * It includes methods to set the side length of the cube, calculate its volume,
 * and provide a string representation of the cube's properties.
 */

public class Cube extends ThreeDimensionalShape implements ISides {
    private float side;

    public Cube() {
        super();
        side = 0;
    }

    @Override
    public void setHeight(float side) {
        setSides(side);
    }

    public void setSides(float side) {
        if(isMeasurementValid(side)) {
            this.side = side;
            System.out.println("All sides of the Cube have been set to " + side);
        } else {
            throw new IllegalArgumentException("Invalid side");
        }
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
    
}
