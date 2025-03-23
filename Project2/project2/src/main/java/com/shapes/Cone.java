package com.shapes;

/**
 * DATE: March 14, 2025
 * AUTHOR: Raymond Rowland
 * PURPOSE: This class represents a Cone, which is a type of Cylinder.
 *          It includes methods to calculate the volume of the cone and to provide a string representation of the cone.
 * FILE: Cone.java
 */

public class Cone extends Cylinder {

    public Cone() {
        super();
    }

    @Override
    public void calculate() {
        volume = (float) (1.0 / 3.0 * Math.PI * Math.pow(radius, 2) * height);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(shapeData);
        sb.append("    -Radius : %.2f\n");
        sb.append("    -Height : %.2f\n");
        sb.append("    -Volume : %.2f\n");
        return String.format(sb.toString(), this.getClass().getSimpleName(), radius, height, volume);
    }
    
}
