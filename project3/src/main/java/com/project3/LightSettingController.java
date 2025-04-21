package com.project3;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

public class LightSettingController {
    @FXML
    private Slider redSlider;
    @FXML
    private Slider yellowSlider;
    @FXML
    private Slider greenSlider;
    @FXML
    private Label redLabel;
    @FXML
    private Label yellowLabel;
    @FXML
    private Label greenLabel;

    private Intersection intersection;

    public void setIntersection(Intersection intersection) {
        this.intersection = intersection;
        redSlider.setValue(intersection.getRedLightTime());
        yellowSlider.setValue(intersection.getYellowLightTime());
        greenSlider.setValue(intersection.getGreenLightTime());
        setLabel(redLabel, intersection.getRedLightTime());
        setLabel(yellowLabel, intersection.getYellowLightTime());
        setLabel(greenLabel, intersection.getGreenLightTime());
    }

    @FXML
    private void initialize() {
        redSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            setLabel(redLabel, newValue.floatValue());
        });

        yellowSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            setLabel(yellowLabel, newValue.floatValue());
        });

        greenSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            setLabel(greenLabel, newValue.floatValue());
        });

    }

    private void setLabel(Label label, float newValue) {
        label.setText(String.format("%.1f", newValue));
    }

    @FXML
    private void onSave() {
        intersection.setRedLightTime((float) redSlider.getValue());
        intersection.setYellowLightTime((float) yellowSlider.getValue());
        intersection.setGreenLightTime((float) greenSlider.getValue());
        onCancel();
    }

    @FXML
    private void onCancel() {
        ((Stage) redSlider.getScene().getWindow()).close();
    }
    
    @FXML
    private void onRemove() {
        intersection.disable();
        onCancel();
    }
}
