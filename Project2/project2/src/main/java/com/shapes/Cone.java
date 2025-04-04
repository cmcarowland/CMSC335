package com.shapes;
/**
 * DATE: April 1, 2025
 * AUTHOR: Raymond Rowland
 * PURPOSE: This class represents a Cone shape, which is a subclass of Cylinder.
 *          It overrides the calculate method to compute the volume of a cone
 *          and provides a custom string representation of the cone's properties.
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
