package com.project2;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import com.shapes.Cube;

public class CubeController extends BaseController {
    @FXML
    private ComboBox<String> box1;
    @FXML
    private Label sideLabel;

    static private Cube cube;

    public void initialize() {
        cube = new Cube();

        box1.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            cube.setSides(Integer.parseInt(newValue));
            setLabel();
        });

        cube.setSides(Integer.parseInt(box1.getValue()));
        setLabel();
        App.shapeType = "cube";
    }

    public void setLabel() {
        sideLabel.setText(String.format("%.2f", cube.getSide()));
    }

    static public double getSide() {
        return cube.getSide();
    }
}
