package com.project3;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import java.util.List;

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

    public void processCars(List<PhysicsTickListener> cars) {
        fpsLabel.setText("FPS: " + Physics.getFPS());
        clearCars();
        for (PhysicsTickListener ptl : cars) {
            if (!(ptl instanceof Car)) {
                continue;
            }
            Car car = (Car) ptl;
            Label carText = new Label(car.toString());
            if (car.isToRight()) {
                rightLane.getChildren().add(carText);
            } else {
                leftLane.getChildren().add(carText);
            }
        }
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
    }

    @FXML
    private void play(ActionEvent ae) {
        playBtn.setDisable(true);
        stopBtn.setDisable(false);
        contBtn.setDisable(true);
        pauseBtn.setDisable(false);
        App.setCurrentState(SimulationState.RUNNING);
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

        Car car = new Car(true);
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

        Car car = new Car(false);
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
}
