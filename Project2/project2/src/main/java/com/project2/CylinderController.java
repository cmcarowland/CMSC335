package com.project2;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import com.shapes.Cylinder;

public class CylinderController {
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
