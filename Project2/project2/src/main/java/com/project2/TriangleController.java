package com.project2;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;

import com.shapes.Triangle;

public class TriangleController {
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
        
        App.shapeType = "triangle";
    }

    static public float getHeight() {
        return triangle.getHeight();
    }

    static public float getBase() {
        return triangle.getBase();
    }

    @FXML
    void cancelClicked(ActionEvent ae) {
        // Load an additional FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("baseSettings.fxml"));
        Node additionalContent;
        try {
            additionalContent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Add the additional content to the main layout
        GridPane mainLayout = (GridPane) ((Node) ae.getSource()).getScene().getRoot();
        mainLayout.getChildren().add(additionalContent);
        App.shapeType = "";
    }
}
