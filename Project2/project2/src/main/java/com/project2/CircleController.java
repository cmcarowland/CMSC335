package com.project2;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;

public class CircleController {
    @FXML
    private Slider slider1;
    @FXML
    private Label radiusLabel;

    private static double radius;

    public void initialize() {
        slider1.valueProperty().addListener((observable, oldValue, newValue) -> {
            radiusLabel.setText(String.format("%.2f", newValue));
            radius = newValue.doubleValue();
        });

        radius = slider1.getValue();
        App.shapeType = "circle";
    }

    static public double getRadius() {
        return radius;
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
