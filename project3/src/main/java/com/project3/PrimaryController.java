package com.project3;

import javafx.application.Platform;
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
}
