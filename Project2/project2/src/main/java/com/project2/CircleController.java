package com.project2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

import com.shapes.Circle;

public class CircleController extends BaseController {
    @FXML
    private Slider slider1;
    @FXML
    private Label radiusLabel;

    static private Circle circle;

    public void initialize() {
        circle = new Circle();
        slider1.valueProperty().addListener((observable, oldValue, newValue) -> {
            setLabel(newValue.floatValue());
        });

        setLabel((float)slider1.getValue());
        
        App.shapeType = "circle";
    }

    public void setLabel(float newValue) {
        circle.setRadius(newValue);
        radiusLabel.setText(String.format("%.2f", newValue));
    }

    static public double getRadius() {
        return circle.getRadius();
    }
}
