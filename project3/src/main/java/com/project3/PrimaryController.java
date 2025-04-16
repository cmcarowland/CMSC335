package com.project3;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

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
                VBox vbox = (VBox)App.mainLayout.lookup("#intersections");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Intersection.fxml"));
                try {
                    vbox.getChildren().add(loader.load());
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
                i.setIntersectionData(loader.getController());
                i.enable();
                break;
            }
        }
    }
}
