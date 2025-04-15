package com.project3;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PrimaryController implements TimeTickedListener {
    @FXML
    private Label timeLabel;

    @Override
    public void onTimeTicked(String time) {
        Platform.runLater(() -> {
            updateTimeLabel(time);
        });
    }

    private void updateTimeLabel(String time) {
        timeLabel.setText(time);
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
        for (Intersection i : App.intersections) {
            if(i.getState() == LightState.OFF) {
                i.enable();
                break;
            }
        }
    }
}
