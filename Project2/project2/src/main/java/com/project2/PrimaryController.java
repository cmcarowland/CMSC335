package com.project2;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PrimaryController {
    @FXML  
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
    }

    @FXML
    void circleClicked(ActionEvent ae) {
        System.out.println(ae);
        // Load an additional FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("circle.fxml"));
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
    }

    @FXML
    void cancelClicked(ActionEvent ae) {
        System.out.println(ae);
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
    }
}
