package com.project2;
/**
 * DATE: April 1, 2025
 * AUTHOR: Raymond Rowland
 * PURPOSE: This file serves as the controller for handling the logic and interactions 
 *          related to the Sphere component in the application.
 * FILE: SphereController.java
 */
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import com.shapes.Sphere;

public class SphereController extends BaseController {
    @FXML
    private ComboBox<String> box1;
    @FXML
    private Label radiusLabel;

    static private Sphere sphere;

    public void initialize() {
        sphere = new Sphere();

        box1.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            sphere.setRadius(Integer.parseInt(newValue));
            setLabel();
        });

        sphere.setRadius(Integer.parseInt(box1.getValue()));
        setLabel();
        App.shapeType = "sphere";
    }

    public void setLabel() {
        radiusLabel.setText(String.format("%.2f", sphere.getRadius()));
    }

    static public double getRadius() {
        return sphere.getRadius();
    }
}
