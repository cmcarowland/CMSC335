package com.project2;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import com.shapes.Sphere;

public class SphereController {
    @FXML
    private ComboBox<String> box1;
    @FXML
    private Label radiusLabel;

    static private Sphere sphere;

    public void initialize() {
        sphere = new Sphere();

        box1.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            sphere.setRadius(Integer.parseInt(newValue));
            setLabel();
        });

        sphere.setRadius(Integer.parseInt(box1.getValue()));
        setLabel();
        App.shapeType = "sphere";
    }

    public void setLabel() {
        radiusLabel.setText(String.format("%.2f", sphere.getRadius()));
    }

    static public double getRadius() {
        return sphere.getRadius();
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
