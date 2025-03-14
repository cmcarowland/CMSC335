package main;

/**
 * DATE: March 14, 2025
 * AUTHOR: Raymond Rowland
 * PURPOSE: This class represents a Cylinder, which is a type of ThreeDimensionalShape.
 *          It includes methods to set the radius and height of the cylinder, and to calculate its volume.
 * FILE: Cylinder.java
 */

public class Cylinder extends ThreeDimensionalShape {
    protected float radius;
    protected float height;

    public Cylinder() {
        super();
    }

    public void setRadius(float radius) {
        if (isMeasurementValid(radius)) {
            this.radius = radius;
            System.out.println("Radius of the " + getClass().getSimpleName() + " have been set to " + radius);
        } else {
            throw new IllegalArgumentException("Radius must be greater than 0");
        }
    }

    public void setHeight(float height) {
        if (isMeasurementValid(height)) {
            this.height = height;
            System.out.println("Height of the " + getClass().getSimpleName() + " have been set to " + height);
        } else {
            throw new IllegalArgumentException("Height must be greater than 0");
        }
    }

    @Override
    public float calculateVolume() {
        return (float) (Math.PI * Math.pow(radius, 2) * height);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(shapeData);
        sb.append("    -Radius : %.2f\n");
        sb.append("    -Height : %.2f\n");
        sb.append("    -Volume : %.2f\n");
        return String.format(sb.toString(), this.getClass().getSimpleName(), radius, height, calculateVolume());
    }
    
}
