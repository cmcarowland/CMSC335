/**
 * CMSC 335
 * PrimaryController.java
 * DATE: 22 APR 25
 * AUTHOR: Raymond Rowland
 * 
 * This class serves as the controller for the main GUI of the application.
 * It handles user interactions, manages the simulation state,
 * and updates the display of cars and intersections.
 * It also implements the TimeTickedListener interface to respond to time ticks.
 */
package com.project3;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class PrimaryController implements TimeTickedListener {
    @FXML
    private Label timeLabel;
    @FXML
    private VBox leftLane;
    @FXML
    private VBox rightLane;
    @FXML
    private Button stopBtn;
    @FXML
    private Button playBtn;
    @FXML
    private Button contBtn;
    @FXML
    private Button pauseBtn;
    @FXML
    private Label fpsLabel;
    @FXML
    private CheckBox autoAddCheckbox;

    private float lastCarAdded = 0;
    private int nextCar = 5;

    @Override
    public void onTimeTicked(String time) {
        Platform.runLater(() -> {
            updateTimeLabel(time);
        });

        if(autoAddCheckbox.isSelected()) { 
            if(lastCarAdded > nextCar) {
                lastCarAdded = 0;
                nextCar = (int) (2 + Math.random() * (5 - 2));
                Platform.runLater(() -> {
                    if(Math.random() > 0.5) {
                        addCarTop(new ActionEvent());
                    } else {
                        addCarBottom(new ActionEvent());
                    }                
                });
            } else {
                lastCarAdded++;
            }
        }
    }

    private void updateTimeLabel(String time) {
        timeLabel.setText(time);
    }

    public void clearCars() {
        leftLane.getChildren().clear();
        rightLane.getChildren().clear();
    }

    @FXML
    private void stop(ActionEvent ae) {
        contBtn.setDisable(true);
        stopBtn.setDisable(true);
        pauseBtn.setDisable(true);
        playBtn.setDisable(false);
        App.setCurrentState(SimulationState.STOPPED);
        Physics.reset();
        App.resetScene();
        Time.resetTimer();
    }

    @FXML
    private void play(ActionEvent ae) {
        playBtn.setDisable(true);
        stopBtn.setDisable(false);
        contBtn.setDisable(true);
        pauseBtn.setDisable(false);
        App.setCurrentState(SimulationState.RUNNING);
        Thread thread = new Thread(Time::tick);
        thread.setDaemon(true);
        thread.start();
    }

    @FXML
    private void pause(ActionEvent ae) {
        playBtn.setDisable(true);
        stopBtn.setDisable(false);
        contBtn.setDisable(false);
        pauseBtn.setDisable(true);
        App.setCurrentState(SimulationState.PAUSED);
    }

    @FXML
    private void continueClicked(ActionEvent ae) {
        playBtn.setDisable(true);
        stopBtn.setDisable(false);
        contBtn.setDisable(true);
        pauseBtn.setDisable(false);
        App.setCurrentState(SimulationState.RUNNING);
    }

    private void showDialog(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void addCarBottom(ActionEvent ae) {
        if(App.currentState != SimulationState.RUNNING) {
            showDialog("Error", "Simulation is not running, press play to start it and then add cars.");
            return;
        }

        Label carText = new Label();
        rightLane.getChildren().add(carText);
        
        Car car = new Car(true, carText);
        App.mainLayout.add(car.getCircle(), 0, 2 + (car.isToRight() ? 2 : 0));
        Physics.getCarsGoingX(car);
        Physics.addListener(car);
    }

    @FXML
    private void addCarTop(ActionEvent ae) {
        if(App.currentState != SimulationState.RUNNING) {
            showDialog("Error", "Simulation is not running, press play to start it and then add cars.");
            return;
        }
            
        Label carText = new Label();
        leftLane.getChildren().add(carText);
        Car car = new Car(false, carText);
        App.mainLayout.add(car.getCircle(), 0, 2 + (car.isToRight() ? 2 : 0));
        Physics.getCarsGoingX(car);
        Physics.addListener(car);
    }

    @FXML
    private void addIntersection(ActionEvent ae) {
        if(App.currentState != SimulationState.RUNNING) {
            showDialog("Error", "Simulation is not running, press play to start it and then add intersections.");
            return;
        }

        for (Intersection i : App.intersectionList) {
            if(i.getState() == LightState.OFF) {
                i.enable();
                break;
            }
        }
    }

    public void updateFPSLabel() {
        fpsLabel.setText("FPS: " + Physics.getFPS());
    }

    public void removeCar(Car car) {    
        App.mainLayout.getChildren().remove(car.getCircle());
        if(car.isToRight()) {
            rightLane.getChildren().remove(car.getLabel());
        } else {
            leftLane.getChildren().remove(car.getLabel());
        }
    }
}
