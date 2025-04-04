package com.project2;
/**
 * DATE: April 1, 2025
 * AUTHOR: Raymond Rowland
 * PURPOSE: Controller class for managing Cylinder shape data and UI interactions.
 * FILE: CylinderController.java
 */
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import com.shapes.Cylinder;

public class CylinderController extends BaseController {
    @FXML
    private ComboBox<String> box1;
    @FXML
    private Label baseLabel;
    @FXML
    private Label heightLabel;

    static private Cylinder cylinder;

    public void initialize() {
        cylinder = new Cylinder();

        box1.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            var measurements = newValue.split("x");
            cylinder.setRadius(Integer.parseInt(measurements[0]));
            cylinder.setHeight(Integer.parseInt(measurements[1]));
            setLabel();
        });

        var measurements = box1.getValue().split("x");
        cylinder.setRadius(Integer.parseInt(measurements[0]));
        cylinder.setHeight(Integer.parseInt(measurements[1]));
        setLabel();
        App.shapeType = "cylinder";
    }

    public void setLabel() {
        baseLabel.setText(String.format("%.2f", cylinder.getRadius()));
        heightLabel.setText(String.format("%.2f", cylinder.getHeight()));
    }

    static public String getDimensions() {
        return String.valueOf((int)cylinder.getRadius()) + "X" + String.valueOf((int)cylinder.getHeight());
    }
}
