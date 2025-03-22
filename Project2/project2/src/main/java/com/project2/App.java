package com.project2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private Stage stage;
    private static Scene scene;
    private static MyPane mp;

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("primary.fxml"));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("baseSettings.fxml"));
        Node additionalContent;
        try {
            additionalContent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        ((GridPane)root).getChildren().add(additionalContent);

        scene = new Scene(root, 500, 600);
        //scene.getRoot().setStyle("-fx-font-family: 'serif'");
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setMinWidth(500);
        stage.setMinHeight(600);
        this.stage = stage;
        stage.setTitle("Raymond Rowland Project 2");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}