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
import javafx.scene.layout.GridPane;

public class PrimaryController {
    /* @FXML  
    void Clicked(ActionEvent event) {
        System.out.println(event);

        Pane p = new Pane();
        BackgroundFill bgf = new BackgroundFill(Color.valueOf("#141414"), null, p.getInsets());
        Background bg = new Background(bgf);
        p.setBackground(bg);

        Scene scene = new Scene(p, 200, 200);
        scene.getRoot().setStyle("-fx-font-family: 'serif'");
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(((Button)event.getSource()).textProperty().getValue());
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node)event.getSource()).getScene().getWindow());
        stage.show();
    } */

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
    void circleClicked(ActionEvent ae) {
        // Load an additional FXML file
        GridPane mainLayout = (GridPane) ((Node) ae.getSource()).getScene().getRoot();
        mainLayout.getChildren().add(getNode("circle.fxml"));
    }
    
    @FXML
    void rectClicked(ActionEvent ae) {
        // Load an additional FXML file
        GridPane mainLayout = (GridPane) ((Node) ae.getSource()).getScene().getRoot();
        mainLayout.getChildren().add(getNode("rectangle.fxml"));
    }
    
    @FXML
    void squareClicked(ActionEvent ae) {
        // Load an additional FXML file
        GridPane mainLayout = (GridPane) ((Node) ae.getSource()).getScene().getRoot();
        mainLayout.getChildren().add(getNode("square.fxml"));
    }

    @FXML
    void triClicked(ActionEvent ae) {
        // Load an additional FXML file
        GridPane mainLayout = (GridPane) ((Node) ae.getSource()).getScene().getRoot();
        mainLayout.getChildren().add(getNode("triangle.fxml"));
    }

    @FXML
    void sphereClicked(ActionEvent ae) {
        // Load an additional FXML file
        GridPane mainLayout = (GridPane) ((Node) ae.getSource()).getScene().getRoot();
        mainLayout.getChildren().add(getNode("sphere.fxml"));
    }

    @FXML
    void cubeClicked(ActionEvent ae) {
        // Load an additional FXML file
        GridPane mainLayout = (GridPane) ((Node) ae.getSource()).getScene().getRoot();
        mainLayout.getChildren().add(getNode("cube.fxml"));
    }

    @FXML
    void coneClicked(ActionEvent ae) {
        // Load an additional FXML file
        GridPane mainLayout = (GridPane) ((Node) ae.getSource()).getScene().getRoot();
        mainLayout.getChildren().add(getNode("cone.fxml"));
    }

    @FXML
    void cylinderClicked(ActionEvent ae) {
        // Load an additional FXML file
        GridPane mainLayout = (GridPane) ((Node) ae.getSource()).getScene().getRoot();
        mainLayout.getChildren().add(getNode("cylinder.fxml"));
    }

    @FXML
    void torusClicked(ActionEvent ae) {
        // Load an additional FXML file
        GridPane mainLayout = (GridPane) ((Node) ae.getSource()).getScene().getRoot();
        mainLayout.getChildren().add(getNode("torus.fxml"));
    }

    @FXML
    void clearClicked(ActionEvent ae) {
        MyPane mp = (MyPane)((Node)ae.getSource()).getScene().lookup("#myPane");
        mp.clear();
    }
}
