package com.project2;
/**
 * DATE: April 1, 2025
 * AUTHOR: Raymond Rowland
 * PURPOSE: This file contains the controller logic for managing the Cone shape in the application.
 * FILE: ConeController.java
 */
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import com.shapes.Cone;

public class ConeController extends BaseController {
    @FXML
    private ComboBox<String> box1;
    @FXML
    private Label baseLabel;
    @FXML
    private Label heightLabel;

    static private Cone cone;

    public void initialize() {
        cone = new Cone();

        box1.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            var measurements = newValue.split("x");
            cone.setRadius(Integer.parseInt(measurements[0]));
            cone.setHeight(Integer.parseInt(measurements[1]));
            setLabel();
        });

        var measurements = box1.getValue().split("x");
        System.out.println(measurements[0]);
        System.out.println(measurements[1]);
        cone.setRadius(Integer.parseInt(measurements[0]));
        cone.setHeight(Integer.parseInt(measurements[1]));
        setLabel();
        App.shapeType = "cone";
    }

    public void setLabel() {
        baseLabel.setText(String.format("%.2f", cone.getRadius()));
        heightLabel.setText(String.format("%.2f", cone.getHeight()));
    }

    static public String getDimensions() {
        return String.valueOf((int)cone.getRadius()) + "X" + String.valueOf((int)cone.getHeight());
    }
}
