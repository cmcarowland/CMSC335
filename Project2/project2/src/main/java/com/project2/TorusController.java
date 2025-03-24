package com.project2;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import com.shapes.Torus;

public class TorusController {
    @FXML
    private ComboBox<String> box1;
    @FXML
    private Label minorLabel;
    @FXML
    private Label majorLabel;

    static private Torus torus;

    public void initialize() {
        torus = new Torus();

        box1.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            var measurements = newValue.split("x");
            torus.setMajorRadius(Integer.parseInt(measurements[1]));
            torus.setMinorRadius(Integer.parseInt(measurements[0]));
            setLabel();
        });
        var measurements = box1.getValue().split("x");
        System.out.println("TorusController initialized: " + measurements[0] + " " + measurements[1]);
        torus.setMajorRadius(Integer.parseInt(measurements[1]));
        torus.setMinorRadius(Integer.parseInt(measurements[0]));
        setLabel();
        
        App.shapeType = "torus";
    }

    public void setLabel() {
        minorLabel.setText(String.format("%.2f", torus.getMinorRadius()));
        majorLabel.setText(String.format("%.2f", torus.getMajorRadius()));
    }

    static public String getDimensions() {
        return String.valueOf((int)torus.getMinorRadius()) + "X" + String.valueOf((int)torus.getMajorRadius());
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
