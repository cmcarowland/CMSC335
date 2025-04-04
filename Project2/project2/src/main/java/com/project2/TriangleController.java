package com.project2;
/**
 * DATE: April 1, 2025
 * AUTHOR: Raymond Rowland
 * PURPOSE: This file serves as the controller for handling the logic and interactions 
 *          related to the Triangle view in the JavaFX application.
 * FILE: TriangleController.java
 */
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

import com.shapes.Triangle;

public class TriangleController extends BaseController {
    @FXML
    private Slider slider1;
    @FXML
    private Label heightLabel;
    @FXML
    private Slider slider2;
    @FXML
    private Label baseLabel;

    static private Triangle triangle;

    public void initialize() {
        triangle = new Triangle();
        slider1.valueProperty().addListener((observable, oldValue, newValue) -> {
            heightLabel.setText(String.format("%.2f", newValue));
            triangle.setHeight(newValue.floatValue());
        });
        
        slider2.valueProperty().addListener((observable, oldValue, newValue) -> {
            baseLabel.setText(String.format("%.2f", newValue));
            triangle.setBase(newValue.floatValue());
        });

        triangle.setHeight((float)slider1.getValue());
        triangle.setBase((float)slider2.getValue());
        heightLabel.setText(String.format("%.2f", triangle.getHeight()));
        baseLabel.setText(String.format("%.2f", triangle.getBase()));
        
        App.shapeType = "triangle";
    }

    static public float getHeight() {
        return triangle.getHeight();
    }

    static public float getBase() {
        return triangle.getBase();
    }
}