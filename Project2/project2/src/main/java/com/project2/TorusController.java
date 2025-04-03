package com.project2;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import com.shapes.Torus;

public class TorusController extends BaseController {
    @FXML
    private ComboBox<String> box1;
    @FXML
    private Label minorLabel;
    @FXML
    private Label majorLabel;

    static private Torus torus;

    public void initialize() {
        torus = new Torus();

        box1.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            var measurements = newValue.split("x");
            torus.setMajorRadius(Integer.parseInt(measurements[1]));
            torus.setMinorRadius(Integer.parseInt(measurements[0]));
            setLabel();
        });
        var measurements = box1.getValue().split("x");
        System.out.println("TorusController initialized: " + measurements[0] + " " + measurements[1]);
        torus.setMajorRadius(Integer.parseInt(measurements[1]));
        torus.setMinorRadius(Integer.parseInt(measurements[0]));
        setLabel();
        
        App.shapeType = "torus";
    }

    public void setLabel() {
        minorLabel.setText(String.format("%.2f", torus.getMinorRadius()));
        majorLabel.setText(String.format("%.2f", torus.getMajorRadius()));
    }

    static public String getDimensions() {
        return String.valueOf((int)torus.getMinorRadius()) + "X" + String.valueOf((int)torus.getMajorRadius());
    }
}