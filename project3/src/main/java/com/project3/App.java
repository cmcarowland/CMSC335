package com.project3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    public static IState currentState = new Stopped();
    public static GridPane mainLayout;

    public static void setCurrentState(IState state) {
        if(currentState != null) {
            currentState.onExit();
        }
        currentState = state;

        if(currentState != null) {
            currentState.onEnter();
        }
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("primary.fxml"));
        TimeTickedListener listener = new PrimaryController();
        Time.addListener(listener);
        fxmlLoader.setController(listener);
        
        mainLayout = (GridPane)fxmlLoader.load();
        scene = new Scene(mainLayout, 640, 640);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setTitle("Project 3");
        stage.setScene(scene);
        setCurrentState(new Running());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
        currentState = null;
    }
}