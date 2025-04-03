package com.project2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

import com.shapes.Square;

public class SquareController extends BaseController {
    @FXML
    private Slider slider1;
    @FXML
    private Label sideLabel;
    
    private static Square square;

    public void initialize() {
        square = new Square();
        slider1.valueProperty().addListener((observable, oldValue, newValue) -> {
            sideLabel.setText(String.format("%.2f", newValue));
            square.setSides(newValue.floatValue());
        });

        square.setSides((float)slider1.getValue());
        sideLabel.setText(String.format("%.2f", square.getHeight()));
        
        App.shapeType = "square";
    }

    static public float getSides() {
        return square.getWidth();
    }
}