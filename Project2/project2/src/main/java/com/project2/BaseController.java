package com.project2;
/**
 * DATE: April 1, 2025
 * AUTHOR: Raymond Rowland
 * PURPOSE: This file contains the base controller class for handling common UI actions.
 * FILE: BaseController.java
 */
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

abstract class BaseController {
    @FXML
    protected void cancelClicked(ActionEvent ae) {
        // Load an additional FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("baseSettings.fxml"));
        Node additionalContent;
        try {
            additionalContent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        if (App.mainLayout.getChildren().size() > 1) {
            App.mainLayout.getChildren().removeIf(x -> x == App.additionalContent);
        }

        // Add the additional content to the main layout
        App.additionalContent = additionalContent;
        App.mainLayout.getChildren().add(App.additionalContent);
        App.shapeType = "";
    }
}