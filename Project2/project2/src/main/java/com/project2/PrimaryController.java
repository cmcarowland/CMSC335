package com.project2;
/**
 * DATE: April 1, 2025
 * AUTHOR: Raymond Rowland
 * PURPOSE: This file serves as the primary controller for handling user interactions 
 *          and dynamically loading additional FXML components into the main layout 
 *          based on user actions.
 * FILE: PrimaryController.java
 */

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;

public class PrimaryController {

    Node getNode(String fxml) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Node additionalContent;
        try {
            additionalContent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading " + fxml);
            return null;
        }

        return additionalContent;
    }

    @FXML
    void shapeClicked(ActionEvent ae) {
        // Load an additional FXML file
        if (App.mainLayout.getChildren().size() > 1) {
            App.mainLayout.getChildren().removeIf(x -> x == App.additionalContent);
        }

        App.additionalContent = getNode(((Button)ae.getSource()).getText().split(" ")[1].toLowerCase() + ".fxml");
        App.mainLayout.getChildren().add(App.additionalContent);
    }

    @FXML
    void clearClicked(ActionEvent ae) {
        MyPane mp = (MyPane)((Node)ae.getSource()).getScene().lookup("#myPane");
        mp.clear();
    }
}
