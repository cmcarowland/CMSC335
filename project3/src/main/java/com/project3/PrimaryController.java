package com.project3;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

    @Override
    public void onTimeTicked(String time) {
        Platform.runLater(() -> {
            updateTimeLabel(time);
        });
    }

    private void updateTimeLabel(String time) {
        timeLabel.setText(time);
    }

    public void processCars(List<PhysicsTickListener> cars) {
        leftLane.getChildren().clear();
        rightLane.getChildren().clear();
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
    private void addCar(ActionEvent ae) {
        Car car = new Car();
        App.mainLayout.add(car.getCircle(), 0, 2 + (car.isToRight() ? 2 : 0));
        Physics.getCarsGoingX(car);
        Physics.addListener(car);
    }

    @FXML
    private void addIntersection(ActionEvent ae) {
        for (Intersection i : App.intersectionList) {
            if(i.getState() == LightState.OFF) {
                i.enable();
                break;
            }
        }
    }
}
