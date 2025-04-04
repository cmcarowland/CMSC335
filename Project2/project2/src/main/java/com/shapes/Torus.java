package com.shapes;
/**
 * DATE: April 1, 2025
 * AUTHOR: Raymond Rowland
 * PURPOSE: This file defines the Torus class, which represents a three-dimensional torus shape
 *          and provides methods to calculate its volume and manage its dimensions.
 * FILE: Torus.java
 */

public class Torus extends ThreeDimensionalShape {
    private float majorRadius;
    private float minorRadius;

    public Torus() {
        super();
    }

    public void setMajorRadius(float majorRadius) {
        if (isMeasurementValid(majorRadius)) {
            this.majorRadius = majorRadius;
            System.out.println("Major Radius of the Torus have been set to " + majorRadius);
        } else {
            throw new IllegalArgumentException("Major Radius must be greater than 0");
        }
    }
    
    public float getMajorRadius() {
        return majorRadius;
    }

    public void setMinorRadius(float minorRadius) {
        if (isMeasurementValid(minorRadius)) {
            if(minorRadius >= majorRadius) {
                throw new IllegalArgumentException("Minor Radius must be less than Major Radius");
            }
            this.minorRadius = minorRadius;
            System.out.println("Minor Radius of the Torus have been set to " + minorRadius);
        } else {
            throw new IllegalArgumentException("Minor Radius must be greater than 0");
        }
    }

    public float getMinorRadius() {
        return minorRadius;
    }

    @Override
    public void calculate() {
        volume = (float) (2 * Math.PI * Math.PI * majorRadius * Math.pow(minorRadius, 2));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(shapeData);
        sb.append("    -Major Radius : %.2f\n");
        sb.append("    -Minor Radius : %.2f\n");
        sb.append("    -Volume       : %.2f\n");
        return String.format(sb.toString(), this.getClass().getSimpleName(), majorRadius, minorRadius, volume);
    }
    
}
