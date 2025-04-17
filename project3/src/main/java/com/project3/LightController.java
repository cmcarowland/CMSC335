package com.project3;

import javafx.fxml.FXML;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.application.Platform;

public class LightController {
    @FXML
    private CustomGroup group;
    @FXML
    private Circle redLight;
    @FXML
    private Circle yellowLight;
    @FXML
    private Circle greenLight;
    @FXML
    private Text idLabel;

    public Intersection intersection;


    @FXML
    public void initialize() {
        idLabel.textProperty().bind(group.customTextProperty());
    }

    @FXML
    public void onClicked(MouseEvent me) {
        if(me.getButton() == MouseButton.SECONDARY) {
            intersection.disable();
        }
    }

    public void setRedLightVisible(boolean visible) {
        Platform.runLater(() -> redLight.setOpacity(visible ? 1 : 0.2));
    }
   
    public void setYellowLightVisible(boolean visible) {
        Platform.runLater(() -> yellowLight.setOpacity(visible ? 1 : 0.2));
    }

    public void setGreenLightVisible(boolean visible) {
        Platform.runLater(() -> greenLight.setOpacity(visible ? 1 : 0.2));
    }
    
    public void setVisible(boolean visible) {
        Platform.runLater(() -> group.setVisible(visible));
    }

    public void setIDLabel(String id) {
        Platform.runLater(() -> {
            idLabel.setText(id);
        });
    }
}
