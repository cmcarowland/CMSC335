package com.project2;
/**
 * DATE: April 1, 2025
 * AUTHOR: Raymond Rowland
 * PURPOSE: This file serves as the main entry point for the JavaFX application.
 * FILE: App.java
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    // private Stage stage;
    public static String shapeType = "";
    public static GridPane mainLayout;
    public static Node additionalContent;

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("primary.fxml"));
        mainLayout = (GridPane) root;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("baseSettings.fxml"));
        try {
            additionalContent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        ((GridPane)root).getChildren().add(additionalContent);

        var scene = new Scene(root, 500, 600);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setMinWidth(500);
        stage.setMinHeight(600);
        // this.stage = stage;
        stage.setTitle("Raymond Rowland Project 2");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}