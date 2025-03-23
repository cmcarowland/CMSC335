package com.project2;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;

public class RectangleController {
    @FXML
    private Slider slider1;
    @FXML
    private Label heightLabel;
    @FXML
    private Slider slider2;
    @FXML
    private Label widthLabel;

    private static float height;
    private static float width;

    public void initialize() {
        slider1.valueProperty().addListener((observable, oldValue, newValue) -> {
            heightLabel.setText(String.format("%.2f", newValue));
            height = newValue.floatValue();
        });
        
        slider2.valueProperty().addListener((observable, oldValue, newValue) -> {
            widthLabel.setText(String.format("%.2f", newValue));
            width = newValue.floatValue();
        });

        height = (float)slider1.getValue();
        heightLabel.setText(String.format("%.2f", height));
        width = (float)slider2.getValue();
        widthLabel.setText(String.format("%.2f", width));
        App.shapeType = "rectangle";
    }

    static public float getWidth() {
        return width;
    }

    static public float getHeight() {
        return height;
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
