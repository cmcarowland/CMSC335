package com.project3;

import javafx.fxml.FXML;
import javafx.scene.shape.Circle;
import javafx.application.Platform;

public class IntersectionController {
    @FXML
    private Circle redLight;

    @FXML
    private Circle yellowLight;

    @FXML
    private Circle greenLight;

    public void setRedLightVisible(boolean visible) {
        Platform.runLater(() -> redLight.setOpacity(visible ? 1 : 0.2));
    }
   
    public void setYellowLightVisible(boolean visible) {
        Platform.runLater(() -> yellowLight.setOpacity(visible ? 1 : 0.2));
    }

    public void setGreenLightVisible(boolean visible) {
        Platform.runLater(() -> greenLight.setOpacity(visible ? 1 : 0.2));
    }
}
