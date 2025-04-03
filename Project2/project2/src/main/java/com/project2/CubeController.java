package com.project2;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import com.shapes.Cube;

public class CubeController {
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
