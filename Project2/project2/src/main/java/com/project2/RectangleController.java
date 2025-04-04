package com.project2;
/**
 * DATE: April 1, 2025
 * AUTHOR: Raymond Rowland
 * PURPOSE: This file defines the RectangleController class, which manages the interaction 
 *          between the user interface and the Rectangle model. It handles user input 
 *          through sliders to dynamically update the dimensions of a rectangle and 
 *          displays the updated values in the UI.
 * FILE: RectangleController.java
 */

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

import com.shapes.Rectangle;

public class RectangleController extends BaseController {
    @FXML
    private Slider slider1;
    @FXML
    private Label heightLabel;
    @FXML
    private Slider slider2;
    @FXML
    private Label widthLabel;

    private static Rectangle rectangle;

    public void initialize() {
        rectangle = new Rectangle();
        slider1.valueProperty().addListener((observable, oldValue, newValue) -> {
            heightLabel.setText(String.format("%.2f", newValue));
            rectangle.setHeight(newValue.floatValue());
        });
        
        slider2.valueProperty().addListener((observable, oldValue, newValue) -> {
            widthLabel.setText(String.format("%.2f", newValue));
            rectangle.setWidth(newValue.floatValue());
        });

        rectangle.setHeight((float)slider1.getValue());
        heightLabel.setText(String.format("%.2f", rectangle.getHeight()));
        rectangle.setWidth((float)slider2.getValue());
        widthLabel.setText(String.format("%.2f", rectangle.getWidth()));
        App.shapeType = "rectangle";
    }

    static public float getWidth() {
        return rectangle.getWidth();
    }

    static public float getHeight() {
        return rectangle.getHeight();
    }
}
