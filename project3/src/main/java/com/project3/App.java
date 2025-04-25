/**
 * CMSC 335
 * App.java
 * DATE: 22 APR 2025
 * AUTHOR: Raymond Rowland
 * 
 * This JavaFX application serves as the main entry point for Project 3. 
 * It initializes the primary user interface, sets up the simulation state, 
 * and manages the creation and interaction of intersections and traffic lights. 
 * The application also provides utility methods for finding the next intersection 
 * for a car and resetting the simulation scene.
 */
package com.project3;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App extends Application {

    private static Scene scene;
    public static SimulationState currentState = SimulationState.STOPPED;
    public static GridPane mainLayout;
    public static PrimaryController primaryController;

    public static List<Intersection> intersectionList = new ArrayList<>();

    public static void setCurrentState(SimulationState state) {
        currentState = state;
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("primary.fxml"));
        primaryController = new PrimaryController();
        Time.addListener(primaryController);
        fxmlLoader.setController(primaryController);
        
        mainLayout = (GridPane)fxmlLoader.load();
        scene = new Scene(mainLayout, 640, 640);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setTitle("Project 3");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        int[] intersectionMap = {5, 1, 9, 3, 7, 4, 6, 2, 8};
        Pane pane = (Pane)scene.lookup("#lights");
        for (int i : intersectionMap) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("light.fxml"));
            LightController lc = new LightController();
            loader.setController(lc);
            Intersection intersection = new Intersection(i, lc);
            lc.intersection = intersection;
            intersectionList.add(intersection);
            try {
                CustomGroup cg = (CustomGroup)loader.load();
                cg.setId("#i" + i);
                cg.setLayoutX(i * 1000 * 0.064);
                cg.setLayoutY(14);
                cg.setCustomText(String.valueOf(i));
                cg.setOnMouseClicked(e -> lc.onClicked(e));
                pane.getChildren().add(cg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        launch();
        currentState = null;
    }

    public static Intersection findNextIntersection(Car c) {
        Intersection nextIntersection = null;
        float nextDist = Float.MAX_VALUE;
        for (Intersection i : intersectionList) {
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

    public static void resetScene() {
        for(Intersection i : intersectionList) {
            i.disable();
        }

        Platform.runLater(() -> primaryController.clearCars());
        Car.resetCounter();
    }
}