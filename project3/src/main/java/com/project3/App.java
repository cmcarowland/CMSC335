package com.project3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    public static IState currentState = new Stopped();
    public static GridPane mainLayout;

    public static List<Intersection> intersections = new ArrayList<>();

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
        stage.setResizable(false);
        setCurrentState(new Running());
        stage.show();
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            Intersection in = new Intersection(i * 1000, 10);
            in.enable();
            intersections.add(in);
            try {
            Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        launch();
        currentState = null;
    }

    public static Intersection findNextIntersection(Car c) {
        Intersection nextIntersection = null;
        float nextDist = Float.MAX_VALUE;
        for (Intersection i : intersections) {
            if(c.isToRight() && i.getState() != LightState.OFF) {
                if (i.getX() > c.getX() && i.getX() - c.getX() < nextDist) {
                    nextDist = i.getX() - c.getX();
                    nextIntersection = i;
                }
            } else if (!c.isToRight() && i.getState() != LightState.OFF) {
                if (c.getX() > i.getX() && c.getX() - i.getX() < nextDist) {
                    nextDist = c.getX() - i.getX();
                    nextIntersection = i;
                }
            }
        }

        return nextIntersection;
    }
}