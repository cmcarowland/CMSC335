package com.shapes;

/**
 * DATE: April 1, 2025
 * AUTHOR: Raymond Rowland
 * PURPOSE: This file defines the Cylinder class, which represents a three-dimensional shape with a circular base and height.
 * FILE: Cylinder.java
 */

public class Cylinder extends ThreeDimensionalShape implements IRadius, IHeight {
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

    public float getRadius() {
        return radius;
    }

    public void setHeight(float height) {
        if (isMeasurementValid(height)) {
            this.height = height;
            System.out.println("Height of the " + getClass().getSimpleName() + " have been set to " + height);
        } else {
            throw new IllegalArgumentException("Height must be greater than 0");
        }
    }

    public float getHeight() {
        return height;
    }

    @Override
    public void calculate() {
        volume = (float) (Math.PI * Math.pow(radius, 2) * height);
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
