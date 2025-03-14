package main;

/**
 * DATE: March 14, 2025
 * AUTHOR: Raymond Rowland
 * PURPOSE: This enum represents the different types of questions that can be asked for shape data collection.
 *          It includes a method to get the status flag value for each question.
 * FILE: Questions.java
 */

public enum Questions {
    Radius,
    Height,
    Width,
    Base,
    MajorMinorRadius;

    public int getStatusFlagValue(){
        return 1 << this.ordinal();
    } 
}
