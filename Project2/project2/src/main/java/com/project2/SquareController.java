package com.project2;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;

import com.shapes.Square;

public class SquareController {
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
